package com.example.admin.savingdata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "SecondActivity";
    TextView tvPeron;
    TextView tvGender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvPeron = (TextView) findViewById(R.id.tvPerson);
        tvGender = (TextView) findViewById(R.id.tvGender);

        Intent intent = getIntent();
        Person person = (Person) intent.getParcelableExtra("person");
        tvPeron.setText(person.getName().toString());
        tvGender.setText(person.getGender().toString());
        Log.d(TAG, tvPeron.toString());
        if(tvPeron.toString() == ""){
            Toast.makeText(this, "Error Message", Toast.LENGTH_SHORT).show();}
    }
}
