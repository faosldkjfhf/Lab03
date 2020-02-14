package com.liukevin.lab03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView bottomLeft;
    TextView bottomRight;
    TextView topRight;
    TextView topLeft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sharedPreferences = getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        bottomLeft = findViewById(R.id.bottomLeft);
        topLeft = findViewById(R.id.topLeft);
        topRight = findViewById(R.id.topRight);
        bottomRight = findViewById(R.id.bottomRight);
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                TextView temp = (TextView)v;
                int settings = sharedPreferences.getInt(temp.getText().toString(), 0);
                editor.putInt(temp.getText().toString(), settings + 1);
                Log.i("buttonPressed", String.valueOf(settings + 1) + " " + temp.getText().toString());
                editor.apply();

                Context context = getApplicationContext();
                Toast toast = Toast.makeText(context, temp.getText().toString() + ": " + String.valueOf(settings + 1), Toast.LENGTH_SHORT);
                toast.show();
            }
        };
        bottomLeft.setOnClickListener(click);
        bottomRight.setOnClickListener(click);
        topLeft.setOnClickListener(click);
        topRight.setOnClickListener(click);

    }
}
