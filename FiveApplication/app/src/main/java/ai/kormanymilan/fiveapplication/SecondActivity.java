package ai.kormanymilan.fiveapplication;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView resultText;
    TextView sumText, subText, multipText;
    Button nextButton;
    TextView txtb, txta;
    private String TAG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultText = findViewById(R.id.textViewResultSecondActivity);

        sumText = findViewById(R.id.textViewSumResultSecondActivity);
        multipText = findViewById(R.id.textViewMultipResultSecondActivity);
        subText = findViewById(R.id.textViewSubResultSecondActivity);

        nextButton  = findViewById(R.id.buttonNextSecondActivity);
        txta = findViewById(R.id.editTextAMainActivity);
        txtb = findViewById(R.id.editTextBMainActivity);

        Intent intent = getIntent();
        final String result = String.valueOf(intent.getIntExtra("number", 0));
        resultText.setText(result);

        int identifier = Integer.valueOf(intent.getIntExtra("identifier", 0));
        if (identifier == 1) {
            sumText.setText("Az összeadás eredménye: ");
        }
        else if (identifier == 2) {
            multipText.setText("A szorzás eredménye:  ");
        }
        else subText.setText("A kivonás eredménye: ");

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
