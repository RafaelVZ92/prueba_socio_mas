package com.example.nycschool.root;

import android.app.Application;

import com.example.nycschool.http.SchoolDataAPIModule;
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
                .build();
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
