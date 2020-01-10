package com.example.nycschool.schools;

import com.example.nycschool.http.SchoolDataAPIservice;
import com.example.nycschool.schools.presenter.SchoolsPresenter;
import com.example.nycschool.schools.repository.Repository;
import com.example.nycschool.schools.repository.SchoolsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SchoolsModule {

    @Provides
    public SchoolsMvp.Presenter provideMoviesPresenter(Repository repository){
        return new SchoolsPresenter(repository);
    }

    @Singleton
    @Provides
    public Repository provideMovieRepository(SchoolDataAPIservice schoolApiService){
        return new SchoolsRepository(schoolApiService);
    }
}
