package com.example.nycschool.schools;

import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

public interface SchoolsMvp {

    interface View{
        void updateData(List<SchoolsData> data);
    }

    interface Presenter{
        void loadData();
        void setView(SchoolsMvp.View view);
        void onResponse(List<SchoolsData> data);
        void onFailure(String errorMessage);
    }

    interface Interactor{
        void result();
        void setPresenter(SchoolsMvp.Presenter presenter);
        void onResponse(List<SchoolsData> data);
        void onFailure(String errorMessage);
    }

}
