package com.example.nycschool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;

import com.example.nycschool.http.SchoolDataAPIModule;
import com.example.nycschool.http.SchoolDataAPIservice;
import com.example.nycschool.root.App;
import com.example.nycschool.schools.SchoolsMvp;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements SchoolsMvp.View{

    public static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.activity_root_view)
    ViewGroup viewGroup;

    @BindView(R.id.recycler_view_schools)
    RecyclerView recyclerView;

    @Inject
    SchoolsMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((App) getApplication()).getComponent().inject(this);
        ButterKnife.bind(this);


    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData();
    }

}
