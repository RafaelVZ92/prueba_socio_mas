package com.example.nycschool.schools.repository;

import android.util.Log;

import com.example.nycschool.http.SchoolDataAPIservice;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SchoolsRepository implements Repository{

    public static final String TAG = SchoolsRepository.class.getSimpleName();

    private SchoolDataAPIservice schoolData;

    public SchoolsRepository(SchoolDataAPIservice schoolData) {
        this.schoolData = schoolData;
    }

    @Override
    public void getResultFromNetwork() {
        schoolData.getHighSchools(10).enqueue(new Callback<List<SchoolsData>>() {
            @Override
            public void onResponse(Call<List<SchoolsData>> call, Response<List<SchoolsData>> response) {
                List<SchoolsData> data = response.body();
                for (SchoolsData datos : data) {
                    Log.d(TAG, "Response2: "+ datos.getSchoolName());
                }
            }

            @Override
            public void onFailure(Call<List<SchoolsData>> call, Throwable t) {
                Log.d(TAG, "Response: "+ t.getMessage());
            }
        });

    }
}
