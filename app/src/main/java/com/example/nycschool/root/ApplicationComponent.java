package com.example.nycschool.root;

import com.example.nycschool.MainActivity;
import com.example.nycschool.http.SchoolDataAPIModule;
import com.example.nycschool.schools.SchoolsModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, SchoolsModule.class, SchoolDataAPIModule.class})
public interface ApplicationComponent {
    void inject(MainActivity target);
}
