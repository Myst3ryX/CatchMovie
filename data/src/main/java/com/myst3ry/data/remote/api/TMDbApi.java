package com.myst3ry.data.remote.api;

import com.myst3ry.data.remote.pojo.movie.detail.MovieDetail;
import com.myst3ry.data.remote.pojo.movie.find.MovieFindResponse;
import com.myst3ry.data.remote.pojo.person.detail.PersonDetail;
import com.myst3ry.data.remote.pojo.person.find.PersonFindResponse;
import com.myst3ry.data.remote.pojo.tvshow.detail.TvShowDetail;
import com.myst3ry.data.remote.pojo.tvshow.find.TvShowFindResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface TMDbApi {

    String BASE_URL = "https://api.themoviedb.org/";
    String IMAGES_URL = "https://image.tmdb.org/t/p/";

    @GET("{api_version}/movie/{movie_id}")
    Single<MovieDetail> getMovieDetails(@Path("api_version") final int apiVersion,
                                        @Path("movie_id") final int movieId,
                                        @Query("api_key") final String key,
                                        @Query("language") final String language,
                                        @Query("append_to_response") final String... additional);

    @GET("{api_version}/tv/{tv_id}")
    Single<TvShowDetail> getTvShowDetails(@Path("api_version") final int apiVersion,
                                          @Path("tv_id") final int tvShowId,
                                          @Query("api_key") final String key,
                                          @Query("language") final String language,
                                          @Query("append_to_response") final String... additional);

    @GET("{api_version}/person/{person_id}")
    Single<PersonDetail> getPersonDetails(@Path("api_version") final int apiVersion,
                                          @Path("person_id") final int personId,
                                          @Query("api_key") final String key,
                                          @Query("language") final String language,
                                          @Query("append_to_response") final String... additional);

    @GET("{api_version}/search/movie")
    Single<MovieFindResponse> searchMovies(@Path("api_version") final int apiVersion,
                                           @Query("api_key") final String key,
                                           @Query("language") final String language,
                                           @Query("query") final String query,
                                           @Query("page") final int page,
                                           @Query("include_adult") final boolean isAdult);

    @GET("{api_version}/search/tv")
    Single<TvShowFindResponse> searchTvShows(@Path("api_version") final int apiVersion,
                                             @Query("api_key") final String key,
                                             @Query("language") final String language,
                                             @Query("query") final String query,
                                             @Query("page") final int page,
                                             @Query("include_adult") final boolean isAdult);

    @GET("{api_version}/search/person")
    Single<PersonFindResponse> searchPersons(@Path("api_version") final int apiVersion,
                                             @Query("api_key") final String key,
                                             @Query("language") final String language,
                                             @Query("query") final String query,
                                             @Query("page") final int page,
                                             @Query("include_adult") final boolean isAdult);

    //+ more args
    @GET("{api_version}/discover/movie")
    Single<MovieFindResponse> catchMovie(@Path("api_version") final int apiVersion,
                                         @Query("api_key") final String key,
                                         @Query("language") final String language,
                                         @Query("page") final int page,
                                         @Query("include_adult") final boolean isAdult,
                                         @Query("sort_by") final String sortBy);

    //+ more args
    @GET("{api_version}/discover/tv")
    Single<TvShowFindResponse> catchTvShow(@Path("api_version") final int apiVersion,
                                           @Query("api_key") final String key,
                                           @Query("language") final String language,
                                           @Query("page") final int page,
                                           @Query("include_adult") final boolean isAdult,
                                           @Query("sort_by") final String sortBy);
}
