package com.example.user.spinner;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    String[] fruit = new String[]{"香蕉","蘋果","鳳梨"};
    TextView textView;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.spinner);
        textView = (TextView)findViewById(R.id.textView);
        checkBox = (CheckBox)findViewById(R.id.checkBox);


        ArrayAdapter<String> adapterFruit = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,fruit);

        adapterFruit.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapterFruit);//把adapterFruit丟給spinner變數就可以完成選取的動作

        //監聽選項內容何者被選取
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //透過Spinner本身所提供setOnItemSelectedListener的方式使用
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(parent.getSelectedItem().toString());//讀到選項內容,getSelectedItem取得Object再轉換成String
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {//未選擇執行時

            }
        });

        //增加一個CheckBox
        checkBox.setOnCheckedChangeListener (new CompoundButton.OnCheckedChangeListener(){
            public void  onCheckedChanged(CompoundButton buttonView,boolean isCheck) {
                if (checkBox.isChecked())
                    Toast.makeText(MainActivity.this,"已選取",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"未選取",Toast.LENGTH_SHORT).show();
            }
        });

    }
}