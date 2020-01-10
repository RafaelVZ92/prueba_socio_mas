package com.example.nycschool.datailschool;

import com.example.nycschool.datailschool.interactor.DetailInteractor;
import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.datailschool.presenter.DetailPresenter;
import com.example.nycschool.datailschool.repository.DetailRepository;
import com.example.nycschool.datailschool.repository.Repository;
import com.example.nycschool.http.SchoolDataAPIservice;
import com.example.nycschool.http.SchoolDetailAPIService;
import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.interactor.SchoolsInteractor;
import com.example.nycschool.schools.presenter.SchoolsPresenter;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailModule {

    @Provides
    public DetailMvp.Presenter provideDetailPresenter(DetailMvp.Interactor interactor){
        return new DetailPresenter(interactor);
    }

    @Provides
    public DetailMvp.Interactor provideDetailInteractor(Repository repository){
        return new DetailInteractor(repository);
    }

    @Singleton
    @Provides
    public Repository provideDetailRepository(SchoolDetailAPIService schoolDetailAPIService){
        return new DetailRepository(schoolDetailAPIService);
    }
}
