
package de.bisquallisoft.twitch.json.stream;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "_total",
        "_links",
        "streams"
})
public class StreamResource {

    @JsonProperty("_total")
    private Integer _total;
    @JsonProperty("_links")
    private de.bisquallisoft.twitch.json.stream._links _links;
    @JsonProperty("streams")
    private List<StreamJson> streams = new ArrayList<StreamJson>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("_total")
    public Integer get_total() {
        return _total;
    }

    @JsonProperty("_total")
    public void set_total(Integer _total) {
        this._total = _total;
    }

    @JsonProperty("_links")
    public de.bisquallisoft.twitch.json.stream._links get_links() {
        return _links;
    }

    @JsonProperty("_links")
    public void set_links(de.bisquallisoft.twitch.json.stream._links _links) {
        this._links = _links;
    }

    @JsonProperty("streams")
    public List<StreamJson> getStreams() {
        return streams;
    }

    @JsonProperty("streams")
    public void setStreams(List<StreamJson> streams) {
        this.streams = streams;
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
