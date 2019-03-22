package conraud.sylvain.mynewstraining.ui.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.ui.adapter.RecyclerViewAdapter;
import conraud.sylvain.mynewstraining.utils.CallBack;

public class ResultSearchActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_search);
        configureToolBar();
        configureRecyclerView();
    }
    void configureToolBar(){
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
    }

    void configureRecyclerView(){
        recyclerViewAdapter = new RecyclerViewAdapter(getArticles());
        recyclerView = findViewById(R.id.recycler_view_result_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(recyclerViewAdapter);

    }
    List<Article> getArticles(){
        RootArticle rootArticle =(RootArticle) getIntent().getSerializableExtra("rootArticle");
        return rootArticle.results;
    }
}
