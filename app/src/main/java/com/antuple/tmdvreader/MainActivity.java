package com.antuple.tmdvreader;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtHex = (EditText)findViewById(R.id.editTextHex);
        final EditText txtVersion = (EditText)findViewById(R.id.editTextVersion);
        final Button btnConvert = (Button) findViewById(R.id.button);

        txtVersion.setEnabled(false);
        txtVersion.setTextColor(Color.WHITE);

        btnConvert.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
                String strHex = txtHex.getText().toString();

                try {
                    MajorMinorMacro mmm = Converter.convert(strHex);
                    String strVersion = mmm.getMajor() + "." + mmm.getMinor() + "." + mmm.getMacro();
                    txtVersion.setText(strVersion);
                } catch (Exception e) {
                    txtVersion.setText("Conversion Error");
                }
            }
        });
    }
}
