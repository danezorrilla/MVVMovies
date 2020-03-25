package com.bb.mvvmovies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.mvvmovies.R;
import com.bb.mvvmovies.model.MovieListResult;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder> {

    private MovieListResult movieListResult;

    public MovieListAdapter(MovieListResult movieListResult) {
        this.movieListResult = movieListResult;
    }

    @NonNull
    @Override
    public MovieListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_layout, parent, false);
        return new MovieListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MovieListViewHolder holder, int position) {
        holder.movieListMovieTitle.setText(movieListResult.getResults().get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return movieListResult.getResults().size();
    }

    public class MovieListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movie_list_movie_title)
        TextView movieListMovieTitle;

        public MovieListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
