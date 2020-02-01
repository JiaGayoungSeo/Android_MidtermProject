package com.comp259.Seo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    private TextView txtSurcharge;
    private TextView txtTotal;
    private EditText et_netInvoice;
    private Data data;
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        txtSurcharge= findViewById(R.id.txt_surcharge);
        txtTotal = findViewById(R.id.txt_total);
        et_netInvoice = findViewById(R.id.et_net);

        intent =new Intent(this.getIntent());
        bundle = new Bundle();
        bundle = intent.getExtras();

        data = new Data();

        int deptNumber = bundle.getInt("deptNumber");
        double netInvoice = Double.parseDouble(et_netInvoice.getText().toString());


        et_netInvoice.addTextChangedListener(netChangeWatcher);
    }

    private TextWatcher netChangeWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
           try{
                data.setNetInvoice(Double.parseDouble(s.toString()));
           }catch (NumberFormatException e){

           }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
