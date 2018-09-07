package hr.ferit.vedran.restapp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vedra on 23.8.2018..
 */

public class ServiceGenerator {

    private final static String API_BASE_URL = "";

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    //serviceClass (<Pass your retrofit "interface" Service/s>)
    public static <S> S createService(Class<S> serviceClass) {

        httpClient = new OkHttpClient.Builder();
        httpClient.authenticator(new NTLMAuthenticator("<Your Username>", "<Your Password>"));
        builder.client(httpClient.build());
        Retrofit retrofit = builder.build();

        return retrofit.create(serviceClass);
    }
}
