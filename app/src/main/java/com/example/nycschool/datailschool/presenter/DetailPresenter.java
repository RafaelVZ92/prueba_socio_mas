package com.example.nycschool.datailschool.presenter;

import com.example.nycschool.datailschool.DetailMvp;
import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

public class DetailPresenter implements DetailMvp.Presenter {

    private DetailMvp.View view;
    private DetailMvp.Interactor interactor;

    public DetailPresenter(DetailMvp.Interactor interactor) {
        this.interactor = interactor;
        interactor.setPresenter(this);
    }


    @Override
    public void loadData(String dbn) {
        interactor.result(dbn);
    }

    @Override
    public void setView(DetailMvp.View view) {
        this.view =  view;
    }

    @Override
    public void onResponse(List<Detail> data) {
        view.updateData(data);
    }

    @Override
    public void onFailure(String errorMessage) {

    }
}
