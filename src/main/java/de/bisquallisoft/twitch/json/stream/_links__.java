
package de.bisquallisoft.twitch.json.stream;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "self",
        "follows",
        "commercial",
        "stream_key",
        "chat",
        "features",
        "subscriptions",
        "editors",
        "teams",
        "videos"
})
public class _links__ {

    @JsonProperty("self")
    private String self;
    @JsonProperty("follows")
    private String follows;
    @JsonProperty("commercial")
    private String commercial;
    @JsonProperty("stream_key")
    private String stream_key;
    @JsonProperty("chat")
    private String chat;
    @JsonProperty("features")
    private String features;
    @JsonProperty("subscriptions")
    private String subscriptions;
    @JsonProperty("editors")
    private String editors;
    @JsonProperty("teams")
    private String teams;
    @JsonProperty("videos")
    private String videos;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("self")
    public String getSelf() {
        return self;
    }

    @JsonProperty("self")
    public void setSelf(String self) {
        this.self = self;
    }

    @JsonProperty("follows")
    public String getFollows() {
        return follows;
    }

    @JsonProperty("follows")
    public void setFollows(String follows) {
        this.follows = follows;
    }

    @JsonProperty("commercial")
    public String getCommercial() {
        return commercial;
    }

    @JsonProperty("commercial")
    public void setCommercial(String commercial) {
        this.commercial = commercial;
    }

    @JsonProperty("stream_key")
    public String getStream_key() {
        return stream_key;
    }

    @JsonProperty("stream_key")
    public void setStream_key(String stream_key) {
        this.stream_key = stream_key;
    }

    @JsonProperty("chat")
    public String getChat() {
        return chat;
    }

    @JsonProperty("chat")
    public void setChat(String chat) {
        this.chat = chat;
    }

    @JsonProperty("features")
    public String getFeatures() {
        return features;
    }

    @JsonProperty("features")
    public void setFeatures(String features) {
        this.features = features;
    }

    @JsonProperty("subscriptions")
    public String getSubscriptions() {
        return subscriptions;
    }

    @JsonProperty("subscriptions")
    public void setSubscriptions(String subscriptions) {
        this.subscriptions = subscriptions;
    }

    @JsonProperty("editors")
    public String getEditors() {
        return editors;
    }

    @JsonProperty("editors")
    public void setEditors(String editors) {
        this.editors = editors;
    }

    @JsonProperty("teams")
    public String getTeams() {
        return teams;
    }

    @JsonProperty("teams")
    public void setTeams(String teams) {
        this.teams = teams;
    }

    @JsonProperty("videos")
    public String getVideos() {
        return videos;
    }

    @JsonProperty("videos")
    public void setVideos(String videos) {
        this.videos = videos;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
