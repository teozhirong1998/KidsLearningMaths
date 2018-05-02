package com.example.a16022635.kidslearningmaths;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class EasyMathsActivity extends AppCompatActivity {

    private DatabaseReference mEasyQnsDatabase;
    private Button btnChoice1, btnChoice2, btnChoice3, btnChoice4, btnSkip;
    private TextView tvQuestion, tvTimer, tvScore;

    private int score = 0;
    private int qnsNumber = 0;
    private String ans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_maths);

        getSupportActionBar().setTitle("Questions for Easy Maths");

        btnChoice1 = (Button) findViewById(R.id.ansChoice1);
        btnChoice2 = (Button) findViewById(R.id.ansChoice2);
        btnChoice3 = (Button) findViewById(R.id.ansChoice3);
        btnChoice4 = (Button) findViewById(R.id.ansChoice4);
        btnSkip = (Button) findViewById(R.id.skipBtn);

        tvQuestion = (TextView) findViewById(R.id.easyMathsQns);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvTimer = (TextView) findViewById(R.id.tvTimer);

        updateQuestion();

        //Button Choice 1
        btnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnChoice1.getText().equals(ans)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        //Button Choice 1

        //Button Choice 2
        btnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnChoice2.getText().equals(ans)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        //Button Choice 2

        //Button Choice 3
        btnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnChoice3.getText().equals(ans)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        //Button Choice 3

        //Button Choice 4
        btnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btnChoice4.getText().equals(ans)) {
                    score = score + 1;
                    updateScore(score);
                    updateQuestion();
                } else {
                    updateQuestion();
                }
            }
        });
        //Button Choice 4
    }

    private void updateScore(int score) {
        tvScore.setText("Score: " + score + "/10");
    }

    private void updateQuestion() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        mEasyQnsDatabase = db.getReference("easy").child(String.valueOf(qnsNumber));


        mEasyQnsDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.child("question").getValue(String.class);
                String choice1 = dataSnapshot.child("choice1").getValue().toString();
                String choice2 = dataSnapshot.child("choice2").getValue().toString();
                String choice3 = dataSnapshot.child("choice3").getValue().toString();
                String choice4 = dataSnapshot.child("choice4").getValue().toString();
                String answer = dataSnapshot.child("answer").getValue().toString();

                tvQuestion.setText(question);
                btnChoice1.setText(choice1.toString());
                btnChoice2.setText(choice2.toString());
                btnChoice3.setText(choice3.toString());
                btnChoice4.setText(choice4.toString());
                ans = answer;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        qnsNumber++;
    }
}
