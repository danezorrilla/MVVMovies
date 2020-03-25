package com.bb.mvvmovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bb.mvvmovies.R;
import com.bb.mvvmovies.adapter.MovieListAdapter;
import com.bb.mvvmovies.model.MovieListResult;
import com.bb.mvvmovies.util.DebugLogger;
import com.bb.mvvmovies.viewmodel.MovieListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private MovieListViewModel movieListViewModel;
    private Observer<MovieListResult> movieListResultObserver;

    @BindView(R.id.movie_list_recyclerView)
    RecyclerView movieTitleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        movieListViewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        movieListResultObserver = movieList -> showMovieList(movieList);
        movieListViewModel.getMovieList("James Bond").observe(this, movieListResultObserver);

        //initAdapter();
    }

    private void showMovieList(MovieListResult movieListResult){
        for(int i = 0; i < movieListResult.getResults().size(); i++){
            DebugLogger.logDebug(movieListResult.getResults().get(i).getTitle());
        }
        MovieListAdapter movieListAdapter = new MovieListAdapter(movieListResult);
        movieTitleList.setLayoutManager(new LinearLayoutManager(this));
        movieTitleList.setAdapter(movieListAdapter);
    }

    private void initAdapter(){
        MovieListAdapter movieListAdapter = new MovieListAdapter(
                movieListViewModel.getMovieList("Jaws").getValue());
        movieTitleList.setLayoutManager(new LinearLayoutManager(this));
        movieTitleList.setAdapter(movieListAdapter);
    }

}
