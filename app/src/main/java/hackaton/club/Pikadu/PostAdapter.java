package hackaton.club.Pikadu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    private List<Post> posts;

    public PostAdapter(List<Post> posts) {
        this.posts = posts;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout, parent, false);
        return new PostHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int i) {
        holder.bind(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostHolder extends RecyclerView.ViewHolder {

        private final TextView nameTextView;
        private final TextView timeTextView;
        private final TextView descriptionTextView;
        private final ImageView pictureImageView;

        public PostHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.post_item_tv_name);
            timeTextView = itemView.findViewById(R.id.post_item_tv_time);
            descriptionTextView = itemView.findViewById(R.id.post_item_tv_description);
            pictureImageView = itemView.findViewById(R.id.post_item_iv_picture);
        }

        private void bind(@NonNull Post post) {
            nameTextView.setText(post.name);
            descriptionTextView.setText(post.description);
            pictureImageView.setImageResource(post.picture);
            timeTextView.setText(post.time);
        }

    }
}
