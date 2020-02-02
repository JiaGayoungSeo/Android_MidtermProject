package com.comp259.Seo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView txtSurcharge,txtTotal,txtDepart;
    private EditText et_netInvoice;
    private Data data;
    private Button btnReturn;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txtDepart = findViewById(R.id.txt_department);
        txtSurcharge= findViewById(R.id.txt_surcharge);
        txtTotal = findViewById(R.id.txt_total);
        et_netInvoice = findViewById(R.id.et_net);
        btnReturn = findViewById(R.id.btn_return);

        intent =new Intent(this.getIntent());

        bundle = intent.getExtras();

        data = new Data();

        int deptNumber = bundle.getInt("deptNumber");
        data.setDeptNumber(deptNumber);

        txtDepart.setText(String.valueOf(deptNumber));
        et_netInvoice.addTextChangedListener(netChangeWatcher);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("total",data.getTotalInvoice());
                setResult(1,returnIntent);
                finish();
            }
        });
    }

    private TextWatcher netChangeWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
           try{
                data.setNetInvoice(Double.parseDouble(s.toString()));
                display();
           }catch (NumberFormatException e){

           }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void display(){
        txtSurcharge.setText("$"+ String.format("%.02f", data.getSurcharge()));
        txtTotal.setText("$"+ String.format("%.02f", data.getTotalInvoice()));
    }


}
