package com.example.nycschool.root;

import com.example.nycschool.MainActivity;
import com.example.nycschool.datailschool.DetailModule;
import com.example.nycschool.datailschool.DetailSchool;
import com.example.nycschool.http.SchoolDataAPIModule;
import com.example.nycschool.http.SchoolDetailAPIModule;
import com.example.nycschool.schools.SchoolsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, SchoolsModule.class, SchoolDataAPIModule.class, SchoolDetailAPIModule.class, DetailModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
    void inject(DetailSchool target);
}
