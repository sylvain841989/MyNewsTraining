package conraud.sylvain.mynewstraining.ui.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.ui.adapter.ViewPagerAdapter;
import conraud.sylvain.mynewstraining.utils.CallBack;
import conraud.sylvain.mynewstraining.utils.call.CallNewYorkTimes;

public class MainActivity extends AppCompatActivity  {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public static CallBack callBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        configureViewPagerAndCallBack();
        configureToolBar();
        configureTabLayout();
        callTopStories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main,menu);
        return true;
    }
    void configureToolBar(){
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    void configureViewPagerAndCallBack(){
        viewPager = findViewById(R.id.activity_main_view_pager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        callBack = new CallBack();
        callBack.viewPagerAdapter = viewPagerAdapter;
        callBack.context = this;
        viewPager.setAdapter(viewPagerAdapter);
    }

    void configureTabLayout(){
        TabLayout tabLayout = findViewById(R.id.activity_main_tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
    }


     void callTopStories(){
        CallNewYorkTimes.callTopStories(callBack, "home", callBack.KEY_TOP_STORIES);
        CallNewYorkTimes.callMostPopular(callBack,"viewed",callBack.KEY_MOST_POPULAR);
        CallNewYorkTimes.callTopStories(callBack, "science",callBack.KEY_SCIENCE);

    }
}
