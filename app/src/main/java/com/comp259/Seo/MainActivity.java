package com.comp259.Seo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.zip.InflaterInputStream;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private Button btnCalculate;
    private TextView txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalculate = findViewById(R.id.btn_calculate);
        txtTotal = findViewById(R.id.txt_total_invoice);
        final EditText et_dept = findViewById(R.id.ed_department);

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int dept = Integer.parseInt(et_dept.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putInt("deptNumber", dept);

                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                intent.putExtras(bundle);

                startActivityForResult(intent,REQUEST_CODE);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==REQUEST_CODE){
            if(resultCode==1){
                double total = data.getDoubleExtra("total",0);
                txtTotal.setText(String.valueOf(total));
            }
        }
    }

}
