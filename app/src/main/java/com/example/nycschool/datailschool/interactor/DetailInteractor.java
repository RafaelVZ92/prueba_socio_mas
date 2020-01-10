package com.example.nycschool.datailschool.interactor;

import com.example.nycschool.datailschool.DetailMvp;
import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.datailschool.repository.Repository;
import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;


import java.util.List;

public class DetailInteractor implements DetailMvp.Interactor {

    private Repository repository;
    private DetailMvp.Presenter presenter;

    public DetailInteractor(Repository repository) {
        this.repository = repository;
        repository.setInteractor(this);
    }



    @Override
    public void result(String dbn) {
        repository.getResultFromNetwork(dbn);
    }

    @Override
    public void setPresenter(DetailMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResponse(List<Detail> data) {
        presenter.onResponse(data);
    }


    @Override
    public void onFailure(String errorMessage) {
        presenter.onFailure(errorMessage);
    }
}
