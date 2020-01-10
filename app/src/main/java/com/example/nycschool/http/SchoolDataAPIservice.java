package com.example.nycschool.http;

import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolDataAPIservice {

    @GET("s3k6-pzi2.json")
    Call<List<SchoolsData>> getHighSchools(@Query("$limit") Integer limit);
}
