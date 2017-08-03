package com.example.admin.savingdata;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName,etPerson,etGender;
    Button btnName;
    TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText) findViewById(R.id.etName);
        tvName = (TextView) findViewById(R.id.tvName);
        etPerson = (EditText) findViewById(R.id.etPerson);
        etGender = (EditText) findViewById(R.id.etGender);
    }

    public void changeText(View view) {
        switch (view.getId()){
            case R.id.btnName:
                String data = etName.getText().toString();
                tvName.setText(data);
                break;
            case R.id.btnGoToSecong:
                String personName = etPerson.getText().toString();
                String personGender = etGender.getText().toString();
                Person person = new Person(personName, personGender);
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("person", person);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.btnShareData:
                Intent sendIntent = new Intent();//implicit intent if you dont pass anything
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,"This is a message");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data = tvName.getText().toString();
        outState.putString("data", data);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tvName.setText(savedInstanceState.getString("data"));
    }
}
