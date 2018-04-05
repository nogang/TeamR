package com.samsung.hackerton18.teamr.belive;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


public class createContractActivity extends AppCompatActivity {

    Button transferButton;
    Button writeOnBlockButton;
    Button playMusicButton;
    Button turnOnBulbButton;

    LinearLayout actionLayout;
    LinearLayout typeEthLayout;
    LinearLayout conditionLayout;

    Button skipButton;
    Button dateButton;
    Button timeButton;
    Button locationButton;

    TextView resultText;
    TextView currentStep;

    EditText editEth;

    private void initButton(){

        String fontBold = "fonts/MyriadPro-Bold.otf";
        String fontRegular = "fonts/MyriadPro-Regular.otf";



        Typeface typeFaceBold = Typeface.createFromAsset(getAssets(), fontBold);

        Button button[] = {
                transferButton, writeOnBlockButton, playMusicButton, turnOnBulbButton,
                skipButton,dateButton,timeButton,locationButton
        };

        final LinearLayout inputLaout[] = {
                actionLayout, typeEthLayout, conditionLayout
        };

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.topMargin = 20;
        params.gravity = Gravity.CENTER;

        for (int i = 0; i < button.length; i++) {
            button[i].setTypeface(typeFaceBold);
            button[i].setTextSize(29);
            button[i].setLayoutParams(params);
            button[i].setPadding(15,0,15,0);
            button[i].setMinWidth(0);
            button[i].setMinHeight(0);
            button[i].setMinimumWidth(0);
            button[i].setMinimumHeight(0);
        }

        resultText.setTypeface(typeFaceBold);
        currentStep.setTypeface(typeFaceBold);

        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionLayout.setVisibility(View.INVISIBLE);
                typeEthLayout.setVisibility(View.VISIBLE);
                resultText.setText("Transfer");
                currentStep.setText("ETH");
            }
        });

        editEth.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    typeEthLayout.setVisibility(View.INVISIBLE);
                    conditionLayout.setVisibility(View.VISIBLE);

                    String result = resultText.getText().toString();
                    String eth = editEth.getText().toString();

                    resultText.setText(result + "\n" + eth +" ETH");
                    currentStep.setText("in this condition");

                    typeEthLayout.setVisibility(View.INVISIBLE);
                    conditionLayout.setVisibility(View.VISIBLE);

                    InputMethodManager imm = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    return true;
                }
                return false;
            }
        });

    }
    private void initResource(){
        transferButton = findViewById(R.id.transfer_button);
        writeOnBlockButton = findViewById(R.id.write_on_block);
        playMusicButton = findViewById(R.id.play_music_button);
        turnOnBulbButton = findViewById(R.id.turn_on_bulb_button);

        skipButton = findViewById(R.id.skip_button);
        dateButton = findViewById(R.id.date_button);
        timeButton = findViewById(R.id.time_button);
        locationButton = findViewById(R.id.location_button);

        actionLayout = findViewById(R.id.action_layout);
        typeEthLayout = findViewById(R.id.type_eth_layout);
        conditionLayout = findViewById(R.id.condition_layout);

        resultText = findViewById(R.id.result_text);
        currentStep = findViewById(R.id.current_step);

        editEth = findViewById(R.id.edit_eth);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contrac);

        initResource();
        initButton();




        //FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), menuActivity.class);
                startActivity(intent);
            }
        });
        */
    }
}
