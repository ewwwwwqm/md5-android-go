package org.golang.md5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.text.Editable;
import android.text.TextWatcher;

import hash.Hash;

public class MainActivity extends Activity {

    private EditText editText = null;
    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        textView = (TextView)findViewById(R.id.textView);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editText.setEnabled(true);
            }
        });

        editText.setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if( keyCode == KeyEvent.KEYCODE_ENTER ) {
                    if( event.getAction() == KeyEvent.ACTION_UP ) {
                        textView.setText(Hash.getMD5(editText.getText().toString()));
                    }
                    return true;
                }
                return false;
            }
        });
    }
}
