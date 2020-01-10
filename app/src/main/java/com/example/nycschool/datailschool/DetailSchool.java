package com.example.nycschool.datailschool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nycschool.R;
import com.example.nycschool.datailschool.model.Detail;
import com.example.nycschool.root.App;
import com.example.nycschool.schools.SchoolsMvp;

import java.time.LocalDate;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailSchool extends AppCompatActivity implements DetailMvp.View{
    public static final String TAG = DetailSchool.class.getSimpleName();
    private String dbn;

    @BindView(R.id.text_view_id)
    public TextView id;

    @BindView(R.id.text_view_cantidad)
    public TextView cant;

    @BindView(R.id.text_view_lectura_critica)
    public TextView lectura;

    @BindView(R.id.text_view_math_puntuaje)
    public TextView math;

    @BindView(R.id.text_view_writing_puntaje)
    public TextView writing;

    @BindView(R.id.text_view_name)
    public TextView view_name;

    @Inject
    DetailMvp.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_school);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);
        Bundle extras = getIntent().getExtras();
        dbn = extras.getString("id");
        id.setText(extras.getString("id"));
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadData(dbn);
    }

    @Override
    public void updateData(List<Detail> data) {
        Log.d(TAG, "updateData: " + data);
        if (data.toString().equals("[]")){
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        }else {
            id.setText(data.get(0).getDbn());
            view_name.setText(data.get(0).getSchoolName());
            cant.setText(data.get(0).getNumOfSatTestTakers());
            lectura.setText(data.get(0).getSatCriticalReadingAvgScore());
            math.setText(data.get(0).getSatMathAvgScore());
            writing.setText(data.get(0).getSatWritingAvgScore());
        }
    }
}
