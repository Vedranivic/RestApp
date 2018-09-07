package hr.ferit.vedran.restapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by vedra on 24.8.2018..
 */

public class MovieAdapter extends BaseAdapter {
    List<Movie> mMovies;
    public MovieAdapter(List<Movie> movies) {
        mMovies = movies;
    }
    @Override
    public int getCount() {
        return this.mMovies.size();
    }
    @Override
    public Object getItem(int position) {
        return this.mMovies.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MovieViewHolder movieViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(
                    R.layout.item_movie, parent, false);
            movieViewHolder = new MovieViewHolder(convertView);
            convertView.setTag(movieViewHolder);
        }else{
            movieViewHolder = (MovieViewHolder) convertView.getTag();
        }
        Movie movie = this.mMovies.get(position);
        movieViewHolder.tvMovieTitle.setText(movie.getTitle());
        movieViewHolder.tvMovieYear.setText(String.valueOf(movie.getYear()));
        Picasso.get()
                .load(movie.getPosterUrl())
                .fit()
                .centerCrop()
                .into(movieViewHolder.ivMoviePoster);
        return convertView;
    }
    static class MovieViewHolder{
        TextView tvMovieTitle, tvMovieYear;
        ImageView ivMoviePoster;
        public MovieViewHolder(View movieView) {
            this.tvMovieTitle = (TextView) movieView.findViewById(R.id.tvMovieTitle);
            this.tvMovieYear = (TextView) movieView.findViewById(R.id.tvMovieYear);
            this.ivMoviePoster = (ImageView) movieView.findViewById(R.id.ivMoviePoster);
        }
    }
}