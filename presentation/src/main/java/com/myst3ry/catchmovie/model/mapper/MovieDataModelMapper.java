package com.myst3ry.catchmovie.model.mapper;

import com.myst3ry.catchmovie.model.MovieDataModel;
import com.myst3ry.domain.model.Movie;

import java.util.ArrayList;
import java.util.List;

public final class MovieDataModelMapper {

    public MovieDataModel transform(final Movie movie) {
        return MovieDataModel.newBuilder().build();
    }

    public List<MovieDataModel> transform(final List<Movie> movies) {
        final List<MovieDataModel> moviesDataModels = new ArrayList<>();
        for (final Movie movie : movies) {
            moviesDataModels.add(transform(movie));
        }
        return moviesDataModels;
    }
}
