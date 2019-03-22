package conraud.sylvain.mynewstraining.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.ui.adapter.ViewPagerAdapter;
import conraud.sylvain.mynewstraining.utils.call.CallNewYorkTimes;

public class CallBack implements CallNewYorkTimes.CallBack {

    public ViewPagerAdapter viewPagerAdapter;
    public Context context;
    public int KEY_TOP_STORIES = 0, KEY_MOST_POPULAR = 1, KEY_SCIENCE = 2 , KEY_SEARCH = 3;

    @Override
    public void onResponse(RootArticle rootArticle, int id) {
        refreshUi(rootArticle,id);
    }

    @Override
    public void onFailure() {
        Toast.makeText(context, "echec reseau", Toast.LENGTH_LONG).show();
    }

    private void refreshUi( RootArticle rootArticle, int id){
            viewPagerAdapter.arrayFragment[id].lstArticle.clear();
            viewPagerAdapter.arrayFragment[id].lstArticle.addAll(getArticles(rootArticle));
            viewPagerAdapter.arrayFragment[id].recyclerViewAdapter.notifyDataSetChanged();

    }

    private List<Article> getArticles(RootArticle rootArticle){
        return rootArticle.results;
    }
}
