package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.PersonDetailModule;
import com.myst3ry.catchmovie.di.module.PersonsModule;
import com.myst3ry.catchmovie.di.module.PersonsPopularModule;
import com.myst3ry.catchmovie.di.module.PersonsSearchModule;
import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.fragment.PersonDetailFragment;
import com.myst3ry.catchmovie.ui.person.fragment.PersonsFragment;
import com.myst3ry.catchmovie.ui.person.fragment.PersonsPopularFragment;
import com.myst3ry.catchmovie.ui.person.fragment.PersonsSearchFragment;

import dagger.Subcomponent;

@PersonsScope
@Subcomponent(modules = {PersonsModule.class, PersonDetailModule.class, PersonsSearchModule.class, PersonsPopularModule.class})
public interface PersonsSubComponent {

    void inject(final PersonsFragment personsFragment);

    void inject(final PersonDetailFragment personDetailFragment);

    void inject(final PersonsSearchFragment personsSearchFragment);

    void inject(final PersonsPopularFragment personsPopularFragment);
}
