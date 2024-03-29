package com.example.shikroot.Controleur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.*;

import com.example.shikroot.Model.User;
import com.example.shikroot.R;
import com.example.shikroot.*;


public class MainActivity extends AppCompatActivity {
    private TextView mGreetingTextView;
    private EditText mNameEditText;
    private Button mPlayButton;
    private CheckBox chk;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///////////////////////////////////////////////////////////
      /*  mUser.setFirstName(mNameEditText.getText().toString());*/
        mGreetingTextView = findViewById(R.id.main_textview_greeting);
        mNameEditText = findViewById(R.id.main_edittext_name);
        mPlayButton = findViewById(R.id.main_button_play);
        mPlayButton.setEnabled(false);
        chk=findViewById(R.id.chk);
        mNameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                mPlayButton.setEnabled(!editable.toString().isEmpty());
            }
        });
      mPlayButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
              if(chk.isChecked()){
              startActivity(gameActivityIntent);
              chk.setChecked(false);
              mNameEditText.setText("");
              }else{
                  Toast.makeText(chk.getContext(), "No Checked!", Toast.LENGTH_SHORT).show();
                //  mPlayButton.setText("No Checked");
              }
          }
      });
    }

}