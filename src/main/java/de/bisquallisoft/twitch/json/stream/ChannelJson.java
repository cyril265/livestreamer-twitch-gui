
package de.bisquallisoft.twitch.json.stream;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "mature",
        "abuse_reported",
        "status",
        "display_name",
        "game",
        "delay",
        "_id",
        "name",
        "created_at",
        "updated_at",
        "logo",
        "banner",
        "video_banner",
        "background",
        "profile_banner",
        "profile_banner_background_color",
        "url",
        "views",
        "followers",
        "_links"
})
public class ChannelJson {

    @JsonProperty("mature")
    private Boolean mature;
    @JsonProperty("abuse_reported")
    private Object abuse_reported;
    @JsonProperty("status")
    private String status;
    @JsonProperty("display_name")
    private String display_name;
    @JsonProperty("game")
    private String game;
    @JsonProperty("delay")
    private Integer delay;
    @JsonProperty("_id")
    private Long _id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("created_at")
    private String created_at;
    @JsonProperty("updated_at")
    private String updated_at;
    @JsonProperty("logo")
    private String logo;
    @JsonProperty("banner")
    private Object banner;
    @JsonProperty("video_banner")
    private String video_banner;
    @JsonProperty("background")
    private Object background;
    @JsonProperty("profile_banner")
    private Object profile_banner;
    @JsonProperty("profile_banner_background_color")
    private Object profile_banner_background_color;
    @JsonProperty("url")
    private String url;
    @JsonProperty("views")
    private Integer views;
    @JsonProperty("followers")
    private Integer followers;
    @JsonProperty("_links")
    private _links__ _links;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("mature")
    public Boolean getMature() {
        return mature;
    }

    @JsonProperty("mature")
    public void setMature(Boolean mature) {
        this.mature = mature;
    }

    @JsonProperty("abuse_reported")
    public Object getAbuse_reported() {
        return abuse_reported;
    }

    @JsonProperty("abuse_reported")
    public void setAbuse_reported(Object abuse_reported) {
        this.abuse_reported = abuse_reported;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("display_name")
    public String getDisplay_name() {
        return display_name;
    }

    @JsonProperty("display_name")
    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    @JsonProperty("game")
    public String getGame() {
        return game;
    }

    @JsonProperty("game")
    public void setGame(String game) {
        this.game = game;
    }

    @JsonProperty("delay")
    public Integer getDelay() {
        return delay;
    }

    @JsonProperty("delay")
    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    @JsonProperty("_id")
    public Long get_id() {
        return _id;
    }

    @JsonProperty("_id")
    public void set_id(Long _id) {
        this._id = _id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("created_at")
    public String getCreated_at() {
        return created_at;
    }

    @JsonProperty("created_at")
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @JsonProperty("updated_at")
    public String getUpdated_at() {
        return updated_at;
    }

    @JsonProperty("updated_at")
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @JsonProperty("logo")
    public String getLogo() {
        return logo;
    }

    @JsonProperty("logo")
    public void setLogo(String logo) {
        this.logo = logo;
    }

    @JsonProperty("banner")
    public Object getBanner() {
        return banner;
    }

    @JsonProperty("banner")
    public void setBanner(Object banner) {
        this.banner = banner;
    }

    @JsonProperty("video_banner")
    public String getVideo_banner() {
        return video_banner;
    }

    @JsonProperty("video_banner")
    public void setVideo_banner(String video_banner) {
        this.video_banner = video_banner;
    }

    @JsonProperty("background")
    public Object getBackground() {
        return background;
    }

    @JsonProperty("background")
    public void setBackground(Object background) {
        this.background = background;
    }

    @JsonProperty("profile_banner")
    public Object getProfile_banner() {
        return profile_banner;
    }

    @JsonProperty("profile_banner")
    public void setProfile_banner(Object profile_banner) {
        this.profile_banner = profile_banner;
    }

    @JsonProperty("profile_banner_background_color")
    public Object getProfile_banner_background_color() {
        return profile_banner_background_color;
    }

    @JsonProperty("profile_banner_background_color")
    public void setProfile_banner_background_color(Object profile_banner_background_color) {
        this.profile_banner_background_color = profile_banner_background_color;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("views")
    public Integer getViews() {
        return views;
    }

    @JsonProperty("views")
    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonProperty("followers")
    public Integer getFollowers() {
        return followers;
    }

    @JsonProperty("followers")
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    @JsonProperty("_links")
    public _links__ get_links() {
        return _links;
    }

    @JsonProperty("_links")
    public void set_links(_links__ _links) {
        this._links = _links;
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
