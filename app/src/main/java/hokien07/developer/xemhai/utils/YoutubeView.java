package hokien07.developer.xemhai.utils;

public class YoutubeView {
    private static YoutubeView instance;

    private static final String API_KEY = "AIzaSyDkfSO4xlYyWX0O23y2fJryUE0weH__xdY";
    private static final String LIST_VIDEO_COMEDY = "PLVC0XSxjzdzowoqSQm5PBCIrjCLHuW8ro";
    private static final String BrowserKey = "AIzaSyCsYbY_tqYZkTDNXjyU0LPShX1ZTAl5KBw";
    private static final String ChannelId = "UCadUzhushML2FLvPkd0Zy3w";

    private YoutubeView() {

    }

    public static YoutubeView getInstance() {
        synchronized (YoutubeView.class) {
            if(instance == null) instance = new YoutubeView();
        }
        return instance;
    }

    public String getApiKey() {
        return API_KEY;
    }

    public String getListVideoComedy() {
        return LIST_VIDEO_COMEDY;
    }

    public String getBrowserKey() {
        return BrowserKey;
    }

    public String getChannelId() {
        return ChannelId;
    }
}
