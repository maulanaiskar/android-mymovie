package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {

    TextView title, desc, genre, duration;
    ImageView img;

    public static final String EXTRA_MOVIE = "extra_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        title = findViewById(R.id.tv_title);
        desc = findViewById(R.id.tv_desc);
        img = findViewById(R.id.iv_img);
        genre = findViewById(R.id.tv_genre);
        duration = findViewById(R.id.tv_duration);


        Movie movie = getIntent().getParcelableExtra(EXTRA_MOVIE);
        if (movie != null){
            title.setText(movie.getName());
            desc.setText(movie.getDesc());
            Glide.with(this)
                    .load(movie.getImg())
                    .into(img);
            genre.setText(movie.getGenre());
            duration.setText(movie.getDuration());
//            img.setImageResource(movie.getImg());
//            img.setImageDrawable(movie.getImg());
        }

    }
}
