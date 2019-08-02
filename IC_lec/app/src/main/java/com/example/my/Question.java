package com.example.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Question extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec spec= tabHost.newTabSpec("الدرس");
        spec.setContent(R.id.tab1);
        spec.setIndicator("اسئلة الدكتور");
        tabHost.addTab(spec);



        //Tab2

        spec.setContent(R.id.tab2);
        spec.setIndicator("اسئلة الطلاب ");
        tabHost.addTab(spec);

        //Tab3
        spec=tabHost.newTabSpec("اشعارات");
        spec.setContent(R.id.tab3);
        spec.setIndicator("الإجابات");
        tabHost.addTab(spec);
    }
}
