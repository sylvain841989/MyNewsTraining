package conraud.sylvain.mynewstraining.utils;

import android.content.Context;
import android.widget.Toast;

import java.util.List;

import conraud.sylvain.mynewstraining.data.Article;
import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.ui.activity.MainActivity;
import conraud.sylvain.mynewstraining.ui.adapter.ViewPagerAdapter;
import conraud.sylvain.mynewstraining.utils.call.TopStoriesCall;

public class CallBack implements TopStoriesCall.CallBackTopStories {

    public ViewPagerAdapter viewPagerAdapter;
    public Context context;
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
