package com.myst3ry.catchmovie.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.constants.IntentConstants;
import com.myst3ry.catchmovie.ui.movie.activity.MovieDetailActivity;
import com.myst3ry.catchmovie.ui.movie.activity.MovieFindActivity;
import com.myst3ry.catchmovie.ui.movie.activity.MoviesActivity;
import com.myst3ry.catchmovie.ui.person.activity.PersonDetailActivity;
import com.myst3ry.catchmovie.ui.person.activity.PersonFindActivity;
import com.myst3ry.catchmovie.ui.person.activity.PersonsActivity;
import com.myst3ry.catchmovie.ui.settings.SettingsStubActivity;
import com.myst3ry.catchmovie.ui.tvshow.activity.TvShowDetailActivity;
import com.myst3ry.catchmovie.ui.tvshow.activity.TvShowFindActivity;
import com.myst3ry.catchmovie.ui.tvshow.activity.TvShowsActivity;

public final class Navigator {

    public void navigateToMoviesScreen(@NonNull final Context context) {
        final Intent moviesIntent = MoviesActivity.newIntent(context);
        context.startActivity(moviesIntent);
    }

    public void navigateToTvShowsScreen(@NonNull final Context context) {
        final Intent tvShowsIntent = TvShowsActivity.newIntent(context);
        context.startActivity(tvShowsIntent);
    }

    public void navigateToPersonsScreen(@NonNull final Context context) {
        final Intent personsIntent = PersonsActivity.newIntent(context);
        context.startActivity(personsIntent);
    }

    public void navigateToMovieDetailScreen(@NonNull final Context context, final int movieId) {
        final Intent movieDetailIntent = MovieDetailActivity.newIntent(context);
        movieDetailIntent.putExtra(IntentConstants.EXTRA_MOVIE_ID, movieId);
        context.startActivity(movieDetailIntent);
    }

    public void navigateToTvShowDetailScreen(@NonNull final Context context, final int tvShowId) {
        final Intent tvShowDetailIntent = TvShowDetailActivity.newIntent(context);
        tvShowDetailIntent.putExtra(IntentConstants.EXTRA_TV_SHOW_ID, tvShowId);
        context.startActivity(tvShowDetailIntent);
    }

    public void navigateToPersonDetailScreen(@NonNull final Context context, final int personId) {
        final Intent personDetailIntent = PersonDetailActivity.newIntent(context);
        personDetailIntent.putExtra(IntentConstants.EXTRA_PERSON_ID, personId);
        context.startActivity(personDetailIntent);
    }

    public void navigateToSettingsScreen(@NonNull final Context context) {
        final Intent settingsIntent = SettingsStubActivity.newIntent(context);
        context.startActivity(settingsIntent);
    }

    public void navigateToMovieFindScreen(@NonNull final Context context) {
        final Intent movieFindIntent = MovieFindActivity.newIntent(context);
        context.startActivity(movieFindIntent);
    }

    public void navigateToTvShowFindScreen(@NonNull final Context context) {
        final Intent tvShowFindIntent = TvShowFindActivity.newIntent(context);
        context.startActivity(tvShowFindIntent);
    }

    public void navigateToPersonSearchScreen(@NonNull final Context context) {
        final Intent personFindIntent = PersonFindActivity.newIntent(context);
        context.startActivity(personFindIntent);
    }

    public void navigateToContactScreen(@NonNull final Context context, final String mailSubject,
                                        final String mailBody, final String mailAddress) {
        final Intent sendToIntent = new Intent(Intent.ACTION_SENDTO);
        final String uriString = "mailto:" + Uri.encode(mailAddress) +
                "?subject=" + Uri.encode(mailSubject) + "&body=" + Uri.encode(mailBody);
        sendToIntent.setData(Uri.parse(uriString));
        context.startActivity(Intent.createChooser(sendToIntent,
                context.getString(R.string.mail_chooser_text)));
    }

    public void navigateToMarketAppRating(@NonNull final Context context) {
        //Open play market rating window
    }
}
