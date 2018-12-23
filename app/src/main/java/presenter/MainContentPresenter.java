package presenter;

import java.util.List;

import model.Api;
import model.Hero;
import view.MainContentView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainContentPresenter {
    MainContentView mainContentView;

    public MainContentPresenter(MainContentView mainContentView) {
        this.mainContentView = mainContentView;
    }

    public void LoadMainContent()
    {
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api=retrofit.create(Api.class);
        Call<List<Hero>> call= api.getHeroes();
        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                if(response!=null && response.body()!=null)
                    mainContentView.OnResponseSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                mainContentView.OnResponseFails();
            }
        });
    }
}
