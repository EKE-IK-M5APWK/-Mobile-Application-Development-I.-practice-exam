package ai.kormanymilan.fiveapplication;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{
    TextView txtb, txta;
    Button btn, multibtn, sumbtn, subbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txta = findViewById(R.id.editTextAMainActivity);
        txtb = findViewById(R.id.editTextBMainActivity);
        btn = findViewById(R.id.buttonDialMainActivity);
        sumbtn = findViewById(R.id.buttonSumMainActivity);
        multibtn = findViewById(R.id.buttonMultipMainActivity);
        subbtn = findViewById(R.id.buttonSubMainActivity);

        //Dial Action
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String number = txtb.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL);
                dialIntent.setData(Uri.parse("tel:" + number));
                startActivity(dialIntent);
            }
        });

        // --- SUM ---
        sumbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(txta.getText().toString());
                int b = Integer.valueOf(txtb.getText().toString());

                int sum = (a + b);
                int number = 1;

                Intent getSumIntent = new Intent(MainActivity.this, SecondActivity.class);
                getSumIntent.putExtra("number", sum);
                getSumIntent.putExtra("identifier", number);

                startActivity(getSumIntent);
            }
        });

        // --- MULTIP ---
        multibtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(txta.getText().toString());
                int b = Integer.valueOf(txtb.getText().toString());

                int multip = (a * b);
                int number = 2;

                Intent getMultipIntent = new Intent(MainActivity.this, SecondActivity.class);
                getMultipIntent.putExtra("number", multip);
                getMultipIntent.putExtra("identifier", number);

                startActivity(getMultipIntent);
            }
        });

        // --- SUB ---
        subbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                int a = Integer.valueOf(txta.getText().toString());
                int b = Integer.valueOf(txtb.getText().toString());

                int sub = (a - b);
                int number = 3;

                Intent getSubIntent = new Intent(MainActivity.this, SecondActivity.class);
                getSubIntent.putExtra("number", sub);
                getSubIntent.putExtra("identifier", number);

                startActivity(getSubIntent);
            }
        });

        //Next aka BACK - intent catch
        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        txta.setText(result);
    }
}