package com.example.nycschool.schools;

public interface SchoolsMvp {

    interface View{

    }

    interface Presenter{
        void loadData();
        void setView(SchoolsMvp.View view);
    }

}
