package hokien07.developer.xemhai.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlaylistResponsiveAPI {
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("pageInfo")
    @Expose
    private PlaylistPageInfo pageInfo;
    @SerializedName("items")
    @Expose
    private List<Playlist> playlists = null;

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

    public PlaylistPageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PlaylistPageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setItems(List<Playlist> playlists) {
        this.playlists = playlists;
    }
}
