package ai.kormanymilan.fiveapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{
    TextView  textViewA, textViewB;
    Button dialButton, multiplicationButton, summationButton, subtractionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewA = findViewById(R.id.editTextAMainActivity);
        textViewB = findViewById(R.id.editTextBMainActivity);
        dialButton = findViewById(R.id.buttonDialMainActivity);
        summationButton = findViewById(R.id.buttonSumMainActivity);
        multiplicationButton = findViewById(R.id.buttonMultipMainActivity);
        subtractionButton = findViewById(R.id.buttonSubMainActivity);

        summationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(textViewA.getText().toString());
                int b = Integer.valueOf(textViewB.getText().toString());

                int sum = (a + b);
                int number = 1;

                Intent getSumIntent = new Intent(MainActivity.this, SecondActivity.class);
                getSumIntent.putExtra("number", sum);
                getSumIntent.putExtra("identifier", number);

                startActivity(getSumIntent);
            }
        });

        subtractionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(textViewA.getText().toString());
                int b = Integer.valueOf(textViewB.getText().toString());

                int sub = (a - b);
                int number = 3;

                Intent getSubIntent = new Intent(MainActivity.this, SecondActivity.class);
                getSubIntent.putExtra("number", sub);
                getSubIntent.putExtra("identifier", number);

                startActivity(getSubIntent);
            }
        });

        multiplicationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(textViewA.getText().toString());
                int b = Integer.valueOf(textViewB.getText().toString());

                int multip = (a * b);
                int number = 2;

                Intent getMultipIntent = new Intent(MainActivity.this, SecondActivity.class);
                getMultipIntent.putExtra("number", multip);
                getMultipIntent.putExtra("identifier", number);

                startActivity(getMultipIntent);
            }
        });
        dialButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String number = textViewB.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + number));
                startActivity(dialIntent);
            }
        });

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        textViewA.setText(result);
    }
}