package hr.ferit.vedran.restapp;

import android.graphics.Movie;

import com.google.gson.annotations.SerializedName;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by vedra on 24.8.2018..
 */

public class SearchResult {
    @SerializedName("totalResults") private int mTotal;
    @SerializedName("response") private boolean mResponse;
    @SerializedName("Search") private List<hr.ferit.vedran.restapp.Movie> mMovies;
    public int getTotal() {return mTotal;}
    public boolean getResponse() { return mResponse; }
    public List<hr.ferit.vedran.restapp.Movie> getMovies() { return mMovies; }
}
