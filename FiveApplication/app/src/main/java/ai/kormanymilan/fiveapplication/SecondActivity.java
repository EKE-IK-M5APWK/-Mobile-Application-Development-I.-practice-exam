package ai.kormanymilan.fiveapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView resultText, summationText, subtractionTex, multiplicationText, textA, textB;
    Button nextButton;
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        resultText = findViewById(R.id.textViewResultSecondActivity);
        summationText = findViewById(R.id.textViewSumResultSecondActivity);
        multiplicationText = findViewById(R.id.textViewMultipResultSecondActivity);
        subtractionTex = findViewById(R.id.textViewSubResultSecondActivity);
        nextButton  = findViewById(R.id.buttonNextSecondActivity);
        textA = findViewById(R.id.editTextAMainActivity);
        textB = findViewById(R.id.editTextBMainActivity);
        Intent intent = getIntent();
        final String result = String.valueOf(intent.getIntExtra("number", 0));
        resultText.setText(result);

        int identifier = intent.getIntExtra("identifier", 0);
        switch (identifier) {
            case 1:
                summationText.setText(getString(R.string.add));
                break;
            case 2:
                multiplicationText.setText(getString(R.string.withdraw));
                break;
            case 3:
                subtractionTex.setText(getString(R.string.multiply));
                break;
        }
        nextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent intentNextButton = new Intent(SecondActivity.this, MainActivity.class);
                onStart();
                intentNextButton.putExtra("result", result);
                startActivity(intentNextButton);
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
}
