package com.example.nycschool.schools.presenter;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.repository.Repository;

public class SchoolsPresenter implements SchoolsMvp.Presenter {

    private SchoolsMvp.View view;
    private Repository repository;

    public SchoolsPresenter(Repository repository) {
        this.repository = repository;
    }

    @Override
    public void loadData() {
        repository.getResultFromNetwork();
    }

    @Override
    public void setView(SchoolsMvp.View view) {

    }
}
