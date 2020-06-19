package com.example.mymovie;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private final Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

//    Bikin setter
    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

//    Bikin konstruktor
    public MovieAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return itemView;
    }

    private class ViewHolder{
        private TextView tvName;
        private TextView tvDesc;
        private ImageView ivImg;
//        private TextView tvGenre;
//        private TextView tvDuration;

        ViewHolder(View view){
            tvName = view.findViewById(R.id.tv_name);
            tvDesc = view.findViewById(R.id.tv_desc);
            ivImg = view.findViewById(R.id.iv_img);
//            tvGenre = view.findViewById(R.id.tv_genre);
//            tvDuration = view.findViewById(R.id.tv_duration);
        }

        void bind(Movie movie){
            tvName.setText(movie.getName());
            tvDesc.setText(movie.getDesc());
            ivImg.setImageResource(movie.getImg());
//            tvGenre.setText(movie.getGenre());
//            tvDuration.setText(movie.getDuration());
        }
    }
}
