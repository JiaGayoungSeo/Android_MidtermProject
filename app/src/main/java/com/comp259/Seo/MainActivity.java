package com.comp259.Seo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.InflaterInputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalculate = findViewById(R.id.btn_calculate);
        final EditText et_dept = findViewById(R.id.ed_department);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int dept = Integer.parseInt(et_dept.getText().toString());

                Bundle bundle = new Bundle();
                bundle.putInt("deptNumber", dept);
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent,1);

            }
        });

    }
}
