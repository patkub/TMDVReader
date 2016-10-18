package com.antuple.tmdvreader;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

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
        txtHex.setImeOptions(EditorInfo.IME_ACTION_DONE);

        // on convert button
        btnConvert.setOnClickListener( new OnClickListener() {
            public void onClick(View v) {
                convert(txtHex, txtVersion);
            }
        });

        // on keyboard enter
        txtHex.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    System.out.println("keyboard enter pressed!");
                    convert(txtHex, txtVersion);
                    return true;
                }
                return false;
            }
        });
    }

    private void convert(EditText txtHex, EditText txtVersion) {
        String strHex = txtHex.getText().toString();

        try {
            MajorMinorMacro mmm = Converter.convert(strHex);
            String strVersion = mmm.getMajor() + "." + mmm.getMinor() + "." + mmm.getMacro();
            txtVersion.setText(strVersion);
        } catch (Exception e) {
            txtVersion.setText("Conversion Error");
        }
    }
}
