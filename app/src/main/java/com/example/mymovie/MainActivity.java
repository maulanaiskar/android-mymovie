package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{

    private MovieAdapter adapter;
    private String[] dataName;
    private String[] dataDesc;
    private TypedArray dataImg;
    private String[] dataGenre;
    private String[] dataDuration;
    private ArrayList<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        adapter = new MovieAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailMovie.class);
                intent.putExtra(DetailMovie.EXTRA_MOVIE, movies.get(position));
                startActivity(intent);
            }
        });
    }

//    Untuk menginisiasi setiap data, manggil array di strings.xml
    private void prepare(){
        dataName = getResources().getStringArray(R.array.data_name);
        dataDesc = getResources().getStringArray(R.array.data_desc);
        dataImg = getResources().obtainTypedArray(R.array.data_img);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDuration = getResources().getStringArray(R.array.data_duration);
    }

//    Untuk memasukkan data ke arraylist agar bisa diproses adapter
    private void addItem(){
        movies = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++){
            Movie movie = new Movie();
            movie.setName(dataName[i]);
            movie.setDesc(dataDesc[i]);
            movie.setImg(dataImg.getResourceId(i, -1));
            movie.setGenre(dataGenre[i]);
            movie.setDuration(dataDuration[i]);

            movies.add(movie);
        }
        adapter.setMovies(movies);
    }
}
