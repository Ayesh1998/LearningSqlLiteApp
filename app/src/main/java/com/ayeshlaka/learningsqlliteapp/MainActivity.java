package com.ayeshlaka.learningsqlliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText age,name,address;
    Button add,delete,update,view;
    String age1,name1,address1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DatabaseHelper db = new DatabaseHelper(this);

        age = (EditText) findViewById(R.id.etAge);
        name = (EditText) findViewById(R.id.etName);
        address = (EditText) findViewById(R.id.etAddress);
        add = (Button)findViewById(R.id.add);
        delete = (Button)findViewById(R.id.delete);
        view = (Button)findViewById(R.id.view);
        update = (Button)findViewById(R.id.update);




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name1 = name.getText().toString();
                age1 = age.getText().toString();
                address1 = address.getText().toString();

                Boolean res = db.insertStudent(name1,age1,address1);

                if (res){
                    Toast.makeText(MainActivity.this, "Student inserted successfully", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Student inserted unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name1 = name.getText().toString();
                Boolean res = db.deleteStudent(name1);

                if (res){
                    Toast.makeText(MainActivity.this, "Student deleted successfully", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Student deleted unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name1 = name.getText().toString();
                age1 = age.getText().toString();

                Boolean res =  db.updateStudent(name1,age1);

                if (res){
                    Toast.makeText(MainActivity.this, "Student updated successfully", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this, "Student updated unsuccessful", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
