package hr.ferit.vedran.restapp;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import retrofit2.Retrofit;

/**
 * Created by vedra on 24.8.2018..
 */

public class Movie {
    @SerializedName("Title") private String mTitle;
    @SerializedName("Year") private int mYear;
    @SerializedName("imdbID") private String mImdbID;
    @SerializedName("Type") private String mType;
    @SerializedName("Poster") private String mPosterUrl;
    public String getTitle() { return mTitle; }
    public int getYear() { return mYear; }
    public String getImdbID() { return mImdbID; }
    public String getType() { return mType; }
    public String getPosterUrl() { return mPosterUrl; }
}
