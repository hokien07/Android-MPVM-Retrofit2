package hokien07.developer.xemhai.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlaylistThumbnails {
    @SerializedName("default")
    @Expose
    private PlaylistDefault _default;
    @SerializedName("medium")
    @Expose
    private PlaylistMedium medium;
    @SerializedName("high")
    @Expose
    private PlaylistHigh high;
    @SerializedName("standard")
    @Expose
    private PlaylistStandard standard;

    public PlaylistDefault getDefault() {
        return _default;
    }

    public void setDefault(PlaylistDefault _default) {
        this._default = _default;
    }

    public PlaylistMedium getMedium() {
        return medium;
    }

    public void setMedium(PlaylistMedium medium) {
        this.medium = medium;
    }

    public PlaylistHigh getHigh() {
        return high;
    }

    public void setHigh(PlaylistHigh high) {
        this.high = high;
    }

    public PlaylistStandard getStandard() {
        return standard;
    }

    public void setStandard(PlaylistStandard standard) {
        this.standard = standard;
    }
}
