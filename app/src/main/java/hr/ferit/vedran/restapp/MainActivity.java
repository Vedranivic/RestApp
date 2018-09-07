package hr.ferit.vedran.restapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class MainActivity extends Activity implements View.OnClickListener, Callback<SearchResult>
{
    private static final String OMDB_API = "http://www.omdbapi.com/";
    EditText etSearchTerm;
    ImageButton bSearch;
    ListView lvMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setUpUi();
        this.hookUpListeners();
    }
    private void setUpUi() {
        this.bSearch = (ImageButton) this.findViewById(R.id.ibSearch);
        this.etSearchTerm = (EditText) this.findViewById(R.id.etSearchTerm);
        this.lvMovies = (ListView) this.findViewById(R.id.lvMovies);
    }
    private void hookUpListeners() {
        this.bSearch.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        String searchTerm = this.etSearchTerm.getText().toString();
        this.findMovies(searchTerm);
    }

    private void findMovies(String searchTerm) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(OMDB_API)
                .client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MovieAPI api = retrofit.create(MovieAPI.class);
        Call<SearchResult> call = api.getMovies(searchTerm,"b3f632a8");
        call.enqueue(this);
    }
    @Override
    public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
        List<Movie> movies = response.body().getMovies();
        MovieAdapter adapter = new MovieAdapter(movies);
        this.lvMovies.setAdapter(adapter);
    }
    @Override
    public void onFailure(Call<SearchResult> call, Throwable t) {
        Log.d("Fail", t.getMessage());
    }
}
