package com.example.nishit.assignment_rishabhshetty;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout_id);
        appBarLayout=(AppBarLayout)findViewById(R.id.appbarid);
        viewPager=(ViewPager)findViewById(R.id.viewpager_id);
        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager());


        adapter.AddFragment(new FragmentSpinner(),"Insert");
        //spinner
        adapter.AddFragment(new FragmentMovies(),"Delete");
        //movies
        adapter.AddFragment(new FragmentGallery(),"View");
        //gallery

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

}
