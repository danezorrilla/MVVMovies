package com.bb.mvvmovies.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.bb.mvvmovies.model.MovieListResult;
import com.bb.mvvmovies.network.MovieListRetrofit;
import com.bb.mvvmovies.util.Constants;
import com.bb.mvvmovies.util.DebugLogger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MovieListRetrofit movieListRetrofit = new MovieListRetrofit();
    private MutableLiveData<MovieListResult> movieListResultMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<MovieListResult> getMovieList(String movieTitle){
        movieListRetrofit.getMovieTitle(movieTitle)
                .enqueue(new Callback<MovieListResult>() {
                    @Override
                    public void onResponse(Call<MovieListResult> call, Response<MovieListResult> response) {
                        if(response.isSuccessful() && response.body() != null){
                            movieListResultMutableLiveData.setValue(response.body());
                        } else {
                            DebugLogger.logError(new Throwable(Constants.RESULT_NULL));
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieListResult> call, Throwable t) {
                        DebugLogger.logError(t);
                    }
                });

        return  movieListResultMutableLiveData;

    }

}
