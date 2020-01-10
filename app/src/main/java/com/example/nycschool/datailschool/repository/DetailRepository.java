package com.example.nycschool.datailschool.repository;

import android.util.Log;

import com.example.nycschool.datailschool.DetailMvp;
import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.http.SchoolDetailAPIService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailRepository implements Repository {

    private static final String TAG = DetailRepository.class.getSimpleName();

    private SchoolDetailAPIService schoolDetail;
    private List<Detail> data = null;
    private DetailMvp.Interactor interactor;

    public DetailRepository(SchoolDetailAPIService schoolDetail) {
        this.schoolDetail = schoolDetail;
    }

    @Override
    public void getResultFromNetwork(String dbn) {
        schoolDetail.getSchoolDetail(dbn).enqueue(new Callback<List<Detail>>() {
            @Override
            public void onResponse(Call<List<Detail>> call, Response<List<Detail>> response) {
                data = response.body();
                Log.d(TAG, "onResponse: " + response.body());
                interactor.onResponse(data);
            }

            @Override
            public void onFailure(Call<List<Detail>> call, Throwable t) {
                interactor.onFailure(t.getMessage());
            }
        });

    }

    @Override
    public void setInteractor(DetailMvp.Interactor interactor) {
        {
            this.interactor = interactor;
        }

    }

}

