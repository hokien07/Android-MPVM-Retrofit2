package hokien07.developer.xemhai.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.models.Snippet;
import hokien07.developer.xemhai.models.Thumbnails;
import hokien07.developer.xemhai.models.VideoModel;

public class VideoAdapter extends ListAdapter<VideoModel, VideoAdapter.VideoHolder> {

    private OnitemClickListenner onitemClickListenner;
    private Context context;

    public VideoAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }


    private static final DiffUtil.ItemCallback<VideoModel> DIFF_CALLBACK = new DiffUtil.ItemCallback<VideoModel>() {
        @Override
        public boolean areItemsTheSame(@NonNull VideoModel oldItem, @NonNull VideoModel newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull VideoModel oldItem, @NonNull VideoModel newItem) {
            return oldItem.getId().equals(newItem.getId()) && oldItem.getEtag().equals(newItem.getEtag())
                    && oldItem.getKind().equals(newItem.getKind());
        }
    };

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_video, parent, false);
        return new VideoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        VideoModel videoModel = getItem(position);
        Snippet snippet = videoModel.getSnippet();
        Thumbnails thumbnails = snippet.getThumbnails();

        holder.txtVideoId.setText(snippet.getTitle());
        if(thumbnails != null) {
            Glide.with(context).load(thumbnails.getHigh().getUrl()).into(holder.thumbnail);
        }
    }


    class VideoHolder extends RecyclerView.ViewHolder{

        private TextView txtVideoId;
        private ImageView thumbnail;
        private ImageButton ibtnPlay;

        VideoHolder(@NonNull View itemView) {
            super(itemView);
            txtVideoId = itemView.findViewById(R.id.txtVideoId);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            ibtnPlay = itemView.findViewById(R.id.ibtnPlay);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(onitemClickListenner != null && position != RecyclerView.NO_POSITION)
                        onitemClickListenner.onVideoClick(getItem(position));
                }
            });
        }
    }

    public interface OnitemClickListenner{
        void onVideoClick(VideoModel videoModel);
    }

    public void setOnItemClickListener(OnitemClickListenner onItemClickListener) {
        this.onitemClickListenner = onItemClickListener;
    }
}
