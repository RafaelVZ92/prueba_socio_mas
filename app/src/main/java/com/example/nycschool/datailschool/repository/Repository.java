package com.example.nycschool.datailschool.repository;

import com.example.nycschool.datailschool.DetailMvp;
import com.example.nycschool.schools.SchoolsMvp;

public interface Repository {
    void getResultFromNetwork(String dbn);
    void setInteractor(DetailMvp.Interactor interactor);
}
