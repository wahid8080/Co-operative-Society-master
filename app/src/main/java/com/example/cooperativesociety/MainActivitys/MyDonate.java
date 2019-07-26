package com.example.cooperativesociety.MainActivitys;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.cooperativesociety.R;

public class MyDonate extends AppCompatActivity {

    Toolbar mActionBarToolbar;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_donate);

        mActionBarToolbar = findViewById(R.id.toolbar_actionbar);
        mActionBarToolbar.setTitle("Your Total Donate");
        mActionBarToolbar.setBackgroundColor(getColor(R.color.colorPrimaryDark));
        mActionBarToolbar.getElevation();
        setSupportActionBar(mActionBarToolbar);


    }

    public void confirm(View view) {
    }
}
