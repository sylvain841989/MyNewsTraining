package conraud.sylvain.mynewstraining.utils;

import conraud.sylvain.mynewstraining.data.RootArticle;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewYorkTimesService {
    @GET("/svc/topstories/v2/{home}.json?api-key=QvXYMDrGQ0TCPo3okaqyuUSp54eQBniA")
    Call<RootArticle> callTopStories (@Path("home")String section);

    @GET("/svc/mostpopular/v2/{viewed}/1.json?api-key=QvXYMDrGQ0TCPo3okaqyuUSp54eQBniA")
    Call<RootArticle> callMostPopular (@Path("viewed")String section);

    @GET("/svc/search/v2/articlesearch.json?q={search}fq={filter}&api-key=QvXYMDrGQ0TCPo3okaqyuUSp54eQBniA")
    Call<RootArticle> callSearch (@Path("search")String search, @Path("filter") String filter);



    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
