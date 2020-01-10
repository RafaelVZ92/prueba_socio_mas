package com.example.nycschool.schools.interactor;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;
import com.example.nycschool.schools.repository.Repository;

import java.util.List;

public class SchoolsInteractor implements SchoolsMvp.Interactor {

    private Repository repository;
    private SchoolsMvp.Presenter presenter;

    public SchoolsInteractor(Repository repository) {
        this.repository = repository;
        repository.setInteractor(this);
    }

    @Override
    public void result() {
        repository.getResultFromNetwork();
    }

    @Override
    public void setPresenter(SchoolsMvp.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onResponse(List<SchoolsData> data) {
       presenter.onResponse(data);
    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
