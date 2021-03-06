package conraud.sylvain.mynewstraining.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import conraud.sylvain.mynewstraining.R;
import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.ui.activity.WebViewArticleActivity;
import conraud.sylvain.mynewstraining.ui.adapter.RecyclerViewAdapter;
import conraud.sylvain.mynewstraining.utils.ItemClickSupport;


public class MainFragment extends Fragment {

public List<Article> lstArticle = new ArrayList<>();
public RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(lstArticle);
    RecyclerView recyclerView;
    public MainFragment() {
        // Required empty public constructor
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = result.findViewById(R.id.fragment_main_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(recyclerViewAdapter);
        configureOnClickrecycler();
        return result;
    }

    void configureOnClickrecycler(){
        ItemClickSupport.addTo(recyclerView,R.layout.fragment_main_item)
                .setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                        openArticle(lstArticle.get(position));
                    }
                });
    }
    void openArticle(Article article){
        Intent intent = new Intent(getContext(), WebViewArticleActivity.class);
        intent.putExtra("url", article.getUrl());
        startActivity(intent);
    }
}
