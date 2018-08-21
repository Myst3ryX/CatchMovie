package com.myst3ry.catchmovie.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;

import com.myst3ry.catchmovie.R;
import com.myst3ry.catchmovie.constants.IntentConstants;
import com.myst3ry.catchmovie.ui.activity.SettingsStubActivity;
import com.myst3ry.catchmovie.ui.activity.actor.ActorDetailActivity;
import com.myst3ry.catchmovie.ui.activity.actor.ActorsActivity;
import com.myst3ry.catchmovie.ui.activity.movie.MovieDetailActivity;
import com.myst3ry.catchmovie.ui.activity.movie.MoviesActivity;
import com.myst3ry.catchmovie.ui.activity.tvshow.TvShowDetailActivity;
import com.myst3ry.catchmovie.ui.activity.tvshow.TvShowsActivity;

public final class Navigator {

    public void navigateToMoviesScreen(@NonNull final Context context) {
        final Intent moviesIntent = MoviesActivity.newIntent(context);
        context.startActivity(moviesIntent);
    }

    public void navigateToTvShowsScreen(@NonNull final Context context) {
        final Intent tvShowsIntent = TvShowsActivity.newIntent(context);
        context.startActivity(tvShowsIntent);
    }

    public void navigateToActorsScreen(@NonNull final Context context) {
        final Intent actorsIntent = ActorsActivity.newIntent(context);
        context.startActivity(actorsIntent);
    }

    public void navigateToMovieDetailScreen(@NonNull final Context context, final long movieId) {
        final Intent movieDetailIntent = MovieDetailActivity.newIntent(context);
        movieDetailIntent.putExtra(IntentConstants.EXTRA_MOVIE_ID, movieId);
        context.startActivity(movieDetailIntent);
    }

    public void navigateToTvShowDetailScreen(@NonNull final Context context, final long tvShowId) {
        final Intent tvShowDetailIntent = TvShowDetailActivity.newIntent(context);
        tvShowDetailIntent.putExtra(IntentConstants.EXTRA_TV_SHOW_ID, tvShowId);
        context.startActivity(tvShowDetailIntent);
    }

    public void navigateToActorDetailScreen(@NonNull final Context context, final long actorId) {
        final Intent actorDetailIntent = ActorDetailActivity.newIntent(context);
        actorDetailIntent.putExtra(IntentConstants.EXTRA_ACTOR_ID, actorId);
        context.startActivity(actorDetailIntent);
    }

    public void navigateToSettingsScreen(@NonNull final Context context) {
        final Intent settingsIntent = SettingsStubActivity.newIntent(context);
        context.startActivity(settingsIntent);
    }

    public void navigateToNewMovieScreen(@NonNull final Context context) {
        //todo implement
    }

    public void navigateToNewTvShowScreen(@NonNull final Context context) {
        //todo implement
    }

    public void navigateToNewActorScreen(@NonNull final Context context) {
        //todo implement
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
