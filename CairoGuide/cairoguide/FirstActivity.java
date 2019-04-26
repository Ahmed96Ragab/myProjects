package com.cairoguide.ragab.cairoguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void button (View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();

    }

}
