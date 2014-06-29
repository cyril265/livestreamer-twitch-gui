
package de.bisquallisoft.twitch.json.stream;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "_id",
        "game",
        "viewers",
        "preview",
        "_links",
        "channel"
})
public class StreamJson {

    @JsonProperty("_id")
    private Long _id;
    @JsonProperty("game")
    private String game;
    @JsonProperty("viewers")
    private Integer viewers;
    @JsonProperty("preview")
    private PreviewJson preview;
    @JsonProperty("_links")
    private _links_ _links;
    @JsonProperty("channel")
    private ChannelJson channel;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_id")
    public Long get_id() {
        return _id;
    }

    @JsonProperty("_id")
    public void set_id(Long _id) {
        this._id = _id;
    }

    @JsonProperty("game")
    public String getGame() {
        return game;
    }

    @JsonProperty("game")
    public void setGame(String game) {
        this.game = game;
    }

    @JsonProperty("viewers")
    public Integer getViewers() {
        return viewers;
    }

    @JsonProperty("viewers")
    public void setViewers(Integer viewers) {
        this.viewers = viewers;
    }

    @JsonProperty("preview")
    public PreviewJson getPreview() {
        return preview;
    }

    @JsonProperty("preview")
    public void setPreview(PreviewJson preview) {
        this.preview = preview;
    }

    @JsonProperty("_links")
    public _links_ get_links() {
        return _links;
    }

    @JsonProperty("_links")
    public void set_links(_links_ _links) {
        this._links = _links;
    }

    @JsonProperty("channel")
    public ChannelJson getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(ChannelJson channel) {
        this.channel = channel;
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
