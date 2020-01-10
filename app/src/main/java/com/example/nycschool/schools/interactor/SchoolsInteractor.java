package com.example.nycschool.schools.interactor;

import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;
import com.example.nycschool.schools.repository.Repository;

import java.util.List;

public class SchoolsInteractor implements SchoolsMvp.Interactor {

    private Repository repository;

    public SchoolsInteractor(Repository repository) {
        this.repository = repository;
    }

    @Override
    public List<SchoolsData> result() {
        return repository.getResultFromNetwork();
    }
}
