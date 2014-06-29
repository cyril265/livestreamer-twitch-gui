package de.bisquallisoft.twitch;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.bisquallisoft.twitch.json.stream.StreamResource;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author squall
 */
public class TwitchApi {

    public static final String CLIENT_ID = "r4h4mcs056enp6p9cuiytu8p0n5f2qj";
    private String authToken;

    public static final String AUTH_URL = "https://api.twitch.tv/kraken/oauth2/authorize?response_type=token" +
            "&client_id=r4h4mcs056enp6p9cuiytu8p0n5f2qj" +
            "&redirect_uri=http://localhost/twitch_oauth" +
            "&scope=user_read";

    public TwitchApi(String authToken) {
        this.authToken = authToken;
    }

    public List<Stream> getStreams() {
        try {
            String response = Request.Get("https://api.twitch.tv/kraken/streams/followed?limit=100")
                    .addHeader("Accept", "application/vnd.twitchtv.v3+json")
                    .addHeader("Authorization", "OAuth " + authToken)
                    .addHeader("Client-ID", CLIENT_ID)
                    .execute()
                    .returnContent().asString();

            ObjectMapper mapper = new ObjectMapper();
            StreamResource l = mapper.readValue(response, StreamResource.class);

            return l.getStreams().stream()
                    .map(s -> {
                        Stream stream = new Stream();
                        stream.setName(s.getChannel().getName());
                        stream.setUrl(s.getChannel().getUrl());
                        stream.setViewers(s.getViewers());
                        stream.setPreviewImage(s.getPreview().getLarge());

                        return stream;
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("could not request users streams", e);
        }
    }

}
