package com.example.nycschool.schools.presenter;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.repository.Repository;

public class SchoolsPresenter implements SchoolsMvp.Presenter {

    private SchoolsMvp.View view;
    private SchoolsMvp.Interactor interactor;

    public SchoolsPresenter(SchoolsMvp.Interactor interactor) {
        this.interactor = interactor;
    }

    @Override
    public void loadData() {
        view.updateData(interactor.result());
    }

    @Override
    public void setView(SchoolsMvp.View view) {
        this.view = view;
    }
}
