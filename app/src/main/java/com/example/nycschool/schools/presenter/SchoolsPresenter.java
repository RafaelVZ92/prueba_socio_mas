package com.example.nycschool.schools.presenter;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;
import com.example.nycschool.schools.repository.Repository;

import java.util.List;

public class SchoolsPresenter implements SchoolsMvp.Presenter {

    private SchoolsMvp.View view;
    private SchoolsMvp.Interactor interactor;

    public SchoolsPresenter(SchoolsMvp.Interactor interactor) {
        this.interactor = interactor;
        interactor.setPresenter(this);
    }

    @Override
    public void loadData() {
        interactor.result();
    }

    @Override
    public void setView(SchoolsMvp.View view) {
        this.view = view;
    }

    @Override
    public void onResponse(List<SchoolsData> data) {
        view.updateData(data);
    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
