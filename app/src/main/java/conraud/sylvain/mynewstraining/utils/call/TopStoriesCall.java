package conraud.sylvain.mynewstraining.utils.call;

import java.lang.ref.WeakReference;

import conraud.sylvain.mynewstraining.data.RootArticle;
import conraud.sylvain.mynewstraining.utils.NewYorkTimesService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopStoriesCall  {

    public interface CallBackTopStories{
        void onResponse(RootArticle rootArticle, int id);
        void onFailure();
    }

    public static void callTopStories(CallBackTopStories callBack, String section,final int id){

        final WeakReference<CallBackTopStories> rootArticleWeakReference = new WeakReference<>(callBack);
        NewYorkTimesService newYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);
        Call<RootArticle> call = newYorkTimesService.callTopStories(section);
        call.enqueue(new Callback<RootArticle>() {
            @Override
            public void onResponse(Call<RootArticle> call, Response<RootArticle> response) {
                rootArticleWeakReference.get().onResponse(response.body(), id);
            }

            @Override
            public void onFailure(Call<RootArticle> call, Throwable t) {
                rootArticleWeakReference.get().onFailure();
            }
        });

    }

    public static void callMostPopular(CallBackTopStories callBack, String section,final int id){

        final WeakReference<CallBackTopStories> rootArticleWeakReference = new WeakReference<>(callBack);
        NewYorkTimesService newYorkTimesService = NewYorkTimesService.retrofit.create(NewYorkTimesService.class);
        Call<RootArticle> call = newYorkTimesService.callMostPopular(section);
        call.enqueue(new Callback<RootArticle>() {
            @Override
            public void onResponse(Call<RootArticle> call, Response<RootArticle> response) {
                rootArticleWeakReference.get().onResponse(response.body(), id);
            }

            @Override
            public void onFailure(Call<RootArticle> call, Throwable t) {
                rootArticleWeakReference.get().onFailure();
            }
        });

    }
}
