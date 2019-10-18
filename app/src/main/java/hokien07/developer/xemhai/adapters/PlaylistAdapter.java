package hokien07.developer.xemhai.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.models.Playlist;
import hokien07.developer.xemhai.models.PlaylistSnippet;

public class PlaylistAdapter extends ListAdapter<Playlist, PlaylistAdapter.PlaylistViewHolder > {

    private OnitemClickListenner onitemClickListenner;
    private Context context;

    public PlaylistAdapter(Context context) {
        super(DIFF_CALLBACK);
        this.context = context;
    }

    private static final DiffUtil.ItemCallback<Playlist> DIFF_CALLBACK = new DiffUtil.ItemCallback<Playlist>() {
        @Override
        public boolean areItemsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem.getId().equals(newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Playlist oldItem, @NonNull Playlist newItem) {
            return oldItem.getId().equals(newItem.getId()) && oldItem.getEtag().equals(newItem.getEtag()) && oldItem.getKind().equals(newItem.getKind());
        }
    };


    @NonNull
    @Override
    public PlaylistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_playlist, parent, false);
        return new PlaylistViewHolder(viewItem);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistViewHolder holder, int position) {
        Playlist playlist = getItem(position);
        PlaylistSnippet snippet = playlist.getSnippet();

        holder.playlistName.setText(snippet.getChannelTitle());
        Glide.with(context).load(snippet.getThumbnails().getMedium().getUrl()).into(holder.thumbnail);
    }

    class PlaylistViewHolder extends RecyclerView.ViewHolder {

        private ImageView thumbnail;
        private TextView playlistName;

        PlaylistViewHolder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            playlistName = itemView.findViewById(R.id.playlistName);

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
        void onVideoClick(Playlist videoModel);
    }

    public void setOnItemClickListener(OnitemClickListenner onItemClickListener) {
        this.onitemClickListenner = onItemClickListener;
    }

}
