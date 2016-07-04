package com.rba.customspinner.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.rba.customspinner.R;
import com.rba.customspinner.model.ItemEntity;
import com.rba.customspinner.util.control.CustomSpinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,
        View.OnClickListener {

    private Button btn;
    private List<ItemEntity> list;
    private CustomSpinner customSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        list = new ArrayList<>();

         customSpinner = (CustomSpinner) findViewById(R.id.spinner2);

        for(int i = 0; i < 5; i++){
            list.add(new ItemEntity(String.valueOf(i), String.valueOf("Data "+i)));
        }

        customSpinner.setDataSource(list);

        customSpinner.setOnItemSelectedListener(this);
        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                Toast.makeText(MainActivity.this,
                        "Selected: "+list.get(customSpinner.getSelectedIndex()).getDescription(),
                        Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        switch (parent.getId()){
            case R.id.spinner2:
                Log.i("x- onItemSelected",""+ list.get(position).getId());
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
