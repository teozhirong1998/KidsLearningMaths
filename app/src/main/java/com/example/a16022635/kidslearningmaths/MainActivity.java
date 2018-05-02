package com.example.a16022635.kidslearningmaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnEasy, btnMedium, btnHard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("KidsLearningMaths");

        btnEasy = (Button) findViewById(R.id.mainBtnEasy);

        btnMedium = (Button) findViewById(R.id.mainBtnMedium);

        btnHard = (Button) findViewById(R.id.mainBtnHard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent easyIntent = new Intent(MainActivity.this, EasyMathsActivity.class);
                startActivity(easyIntent);
                finish();
            }
        });

//        btnEasy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent easyIntent = new Intent();
//                startActivity(easyIntent);
//                finish();
//
//            }
//        });
//
//        btnEasy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent easyIntent = new Intent();
//                startActivity(easyIntent);
//                finish();
//
//            }
//        });
    }
}
