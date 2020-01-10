package com.example.nycschool.datailschool;

import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

public interface DetailMvp {

    interface View{
        void updateData(List<Detail> data);
    }

    interface Presenter{
        void loadData(String dbn);
        void setView(DetailMvp.View view);
        void onResponse(List<Detail> data);
        void onFailure(String errorMessage);
    }

    interface Interactor{
        void result(String dbn);
        void setPresenter(DetailMvp.Presenter presenter);
        void onResponse(List<Detail> data);
        void onFailure(String errorMessage);
    }

}
