package hackaton.club.Pikadu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ScrollFeedsActivity extends AppCompatActivity {

    public List<Post> posts;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        posts= generatedPostList();
        setContentView(R.layout.activity_scroll_feeds);
        RecyclerView recyclerView = findViewById(R.id.activity_main_rv_post);
        final PostAdapter postAdapter = new PostAdapter(posts);
        recyclerView.setAdapter(postAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);

        FloatingActionButton floatingActionButton = findViewById(R.id.activity_main__fb_add);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        posts.add(generatedPost());
        postAdapter.notifyDataSetChanged();
            }
        });


    }

    private Post generatedPost(){
        return new Post("Name", "20:00", "Description", 0 );
    }

    private List<Post> generatedPostList(){
       List<Post> posts = new ArrayList<>();
       posts.add(new Post("Dima", "20:00", "The first post", R.drawable.thefirst ));
       posts.add(new Post("Katya", "20:00", "The second post", R.drawable.thesecond ));
       return generatedPostList();
    }
}