package com.lokesh.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class SecondActivity extends AppCompatActivity {

    TextInputEditText textinput;
        private static final int CAMERA_PERMISSION_REQUEST_CODE = 100;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textinput = (TextInputEditText) findViewById(R.id.textinput);
        submit = (Button) findViewById(R.id.submit);
        requestCameraPermission();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.putExtra("result", textinput.getText().toString());

                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

        private void requestCameraPermission() {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA }, CAMERA_PERMISSION_REQUEST_CODE);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, )
        }


}