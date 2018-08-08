package com.example.sam.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.example.sam.myapplication.fragment.jiajiafragment;
import com.example.sam.myapplication.fragment.naxienianfragment;
import com.example.sam.myapplication.fragment.shouyeFragment;
import com.example.sam.myapplication.fragment.zhurenfragment;
import com.example.sam.myapplication.ui.setting;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton floatingActionButton;
    private List<String> title;
    private List<Fragment> fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);
        initData();
        initView();
    }

    private void initView() {
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        floatingActionButton=(FloatingActionButton)findViewById(R.id.setting);

        floatingActionButton.setOnClickListener(this);


        viewPager.setOffscreenPageLimit(fragment.size());

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragment.get(i);
            }

            @Override
            public int getCount() {
                return fragment.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initData() {
        title = new ArrayList<>();
        title.add(getString(R.string.shouye));
        title.add(getString(R.string.naxienian));
        title.add(getString(R.string.jiajia));
        title.add(getString(R.string.zhuren));

        fragment = new ArrayList<>();
        fragment.add(new shouyeFragment());
        fragment.add(new naxienianfragment());
        fragment.add(new jiajiafragment());
        fragment.add(new zhurenfragment());
    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.setting:
                startActivity(new Intent(this,setting.class));
                break;
        }
    }
}
