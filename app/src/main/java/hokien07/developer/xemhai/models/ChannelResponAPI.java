package hokien07.developer.xemhai.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelResponAPI {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("pageInfo")
    @Expose
    private ChannelPageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private List<Channel> channels = null;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public ChannelPageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(ChannelPageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setItems(List<Channel> channels) {
        this.channels = channels;
    }
}
