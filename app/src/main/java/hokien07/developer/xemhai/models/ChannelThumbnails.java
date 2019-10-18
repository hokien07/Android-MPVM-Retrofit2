package hokien07.developer.xemhai.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChannelThumbnails {
    @SerializedName("default")
    @Expose
    private ChannelDefault _default;
    @SerializedName("medium")
    @Expose
    private ChannelMedium medium;
    @SerializedName("high")
    @Expose
    private ChannelHigh high;
    @SerializedName("standard")
    @Expose
    private ChannelStandard standard;

    public ChannelDefault getDefault() {
        return _default;
    }

    public void setDefault(ChannelDefault _default) {
        this._default = _default;
    }

    public ChannelMedium getMedium() {
        return medium;
    }

    public void setMedium(ChannelMedium medium) {
        this.medium = medium;
    }

    public ChannelHigh getHigh() {
        return high;
    }

    public void setHigh(ChannelHigh high) {
        this.high = high;
    }

    public ChannelStandard getStandard() {
        return standard;
    }

    public void setStandard(ChannelStandard standard) {
        this.standard = standard;
    }
}
