package com.worlds.myteaching;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicSpinner extends AppCompatActivity {
    Spinner SPINNER;
    Button ADD;
    EditText EDITTEXT;
    String[] spinnerItems = new String[]{
            "Java"};
    String text;
    List<String> stringlist;
    ArrayAdapter<String> arrayadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_spinner);
        SPINNER = (Spinner)findViewById(R.id.spinner1);
        ADD = (Button)findViewById(R.id.button1);
        EDITTEXT = (EditText)findViewById(R.id.editText1);
        stringlist = new ArrayList<>(Arrays.asList(spinnerItems));
        arrayadapter = new ArrayAdapter<String>(DynamicSpinner.this,android.R.layout.simple_list_item_1,stringlist );
        arrayadapter.setDropDownViewResource(R.layout.textview);
        SPINNER.setAdapter(arrayadapter);
        ADD.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                text = EDITTEXT.getText().toString();
                stringlist.add(text);
                arrayadapter.notifyDataSetChanged();
                Toast.makeText(DynamicSpinner.this, "Item Added", Toast.LENGTH_LONG).show();
            }
        });
    }
}