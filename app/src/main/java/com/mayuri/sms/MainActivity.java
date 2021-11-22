package com.mayuri.sms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtNum,txtMobile;
    Button sendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNum = findViewById(R.id.txt_number);
        txtMobile = findViewById(R.id.txt_msg);
        sendSms = findViewById(R.id.send_btn);


        sendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SmsManager smgr = SmsManager.getDefault();
                    smgr.sendTextMessage(txtNum.getText().toString(),null,txtMobile.getText().toString(),null,null);
                    Toast.makeText(MainActivity.this,"Sms sent Successfully",Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,"sms failed to send," +
                            "please try again",Toast.LENGTH_SHORT).show();


                }

            }
                                   }

        );
    }
}