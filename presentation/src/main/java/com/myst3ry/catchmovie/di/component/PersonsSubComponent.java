package com.myst3ry.catchmovie.di.component;

import com.myst3ry.catchmovie.di.module.PersonDetailModule;
import com.myst3ry.catchmovie.di.module.PersonSearchModule;
import com.myst3ry.catchmovie.di.module.PersonsModule;
import com.myst3ry.catchmovie.di.scope.PersonsScope;
import com.myst3ry.catchmovie.ui.person.fragment.PersonDetailFragment;
import com.myst3ry.catchmovie.ui.person.fragment.PersonSearchFragment;
import com.myst3ry.catchmovie.ui.person.fragment.PersonsFragment;

import dagger.Subcomponent;

@PersonsScope
@Subcomponent(modules = {PersonsModule.class, PersonDetailModule.class, PersonSearchModule.class})
public interface PersonsSubComponent {

    void inject(final PersonsFragment personsFragment);

    void inject(final PersonDetailFragment personDetailFragment);

    void inject(final PersonSearchFragment personSearchFragment);
}
