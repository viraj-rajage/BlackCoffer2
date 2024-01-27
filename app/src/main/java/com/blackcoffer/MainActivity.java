package com.blackcoffer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this, R.color.widget_color));
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        tableLayout = findViewById(R.id.tabLayout2);
        viewPager = findViewById(R.id.viewpager);

        tableLayout.setupWithViewPager(viewPager);
        viewpagerAdapter VA = new viewpagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        VA.fragmentAdd(new Personal(),"Personal");
        VA.fragmentAdd(new Business(),"Business");
        VA.fragmentAdd(new Merchant(),"Merchant");
        viewPager.setAdapter(VA);

    }
}