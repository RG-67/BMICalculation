package com.example.bmicalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AbotBMI extends AppCompatActivity {

    private TextView url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abot_bmi);

        url = findViewById(R.id.url);
        String link = url.getText().toString();
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent();
                view.setAction(Intent.ACTION_VIEW);
                view.setData(Uri.parse(link));
                startActivity(view);
            }
        });
    }
}