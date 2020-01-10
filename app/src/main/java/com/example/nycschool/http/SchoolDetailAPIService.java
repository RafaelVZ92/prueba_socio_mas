package com.example.nycschool.http;

import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SchoolDetailAPIService {
    @GET("f9bf-2cp4.json")
    Call<List<Detail>> getSchoolDetail(@Query("dbn") String dbn);
}
