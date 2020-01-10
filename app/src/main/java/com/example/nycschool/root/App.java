package com.example.nycschool.root;

import android.app.Application;

import com.example.nycschool.datailschool.DetailModule;
import com.example.nycschool.http.SchoolDataAPIModule;
import com.example.nycschool.http.SchoolDetailAPIModule;
import com.example.nycschool.schools.SchoolsModule;

public class App extends Application {
    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .schoolDataAPIModule(new SchoolDataAPIModule())
                .schoolsModule(new SchoolsModule())
                .schoolDetailAPIModule(new SchoolDetailAPIModule())
                .detailModule(new DetailModule())
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
