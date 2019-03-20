package conraud.sylvain.mynewstraining.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.ui.adapter.RecyclerViewAdapter;
import conraud.sylvain.mynewstraining.ui.adapter.ViewPagerAdapter;
import conraud.sylvain.mynewstraining.utils.CallBack;
import conraud.sylvain.mynewstraining.utils.call.TopStoriesCall;

public class MainActivity extends AppCompatActivity  {

    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    CallBack callBack;

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
        TopStoriesCall.callTopStories(callBack, "home",0);
        TopStoriesCall.callMostPopular(callBack,"viewed",1);
        TopStoriesCall.callTopStories(callBack, "science",2);

    }
}
