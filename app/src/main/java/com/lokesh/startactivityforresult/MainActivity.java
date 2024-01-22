package com.lokesh.startactivityforresult;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ActivityResultLauncher<Intent> launcher;
    TextView textresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textresult = (TextView) findViewById(R.id.textresult);
        launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        textresult.setText(data.getStringExtra("result"));
                    }
                }
        );
        // This is same as we go one activity to another
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);

        // Rathher than calling startActivity(intent) we use this code
        launcher.launch(intent);


    }
}