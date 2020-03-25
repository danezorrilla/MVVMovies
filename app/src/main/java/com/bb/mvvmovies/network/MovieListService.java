package com.bb.mvvmovies.network;

import com.bb.mvvmovies.model.MovieListResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieListService {

    @GET("/3/search/movie")
    public Call<MovieListResult> getMovieTitle(@Query("api_key") String apiKey,
                                               @Query("query") String query);
}
