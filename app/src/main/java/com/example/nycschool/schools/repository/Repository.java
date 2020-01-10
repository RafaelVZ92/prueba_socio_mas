package com.example.nycschool.schools.repository;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

public interface Repository {
    void getResultFromNetwork();
    void setInteractor(SchoolsMvp.Interactor interactor);
}
