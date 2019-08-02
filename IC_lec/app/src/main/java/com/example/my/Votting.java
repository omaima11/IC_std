package com.example.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class Votting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votting);

        TabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup();

        //Tab1
        TabHost.TabSpec spec= tabHost.newTabSpec("الدرس");
        spec.setContent(R.id.tab1);
        spec.setIndicator("سؤال الدكتور");
        tabHost.addTab(spec);

        //Tab2
        spec=tabHost.newTabSpec("عرض المادة المشروحة");
        spec.setContent(R.id.tab2);
        spec.setIndicator("النتيجة");
        tabHost.addTab(spec);
    }
}
