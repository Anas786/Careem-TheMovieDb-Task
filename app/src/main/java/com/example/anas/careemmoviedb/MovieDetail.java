package com.example.anas.careemmoviedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class MovieDetail extends AppCompatActivity {

    private ImageView image;
    private TextView title, date, rating, overview;
    private String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        initViews();
        populateView();
//        MovieResult details = (MovieResult) getIntent().getExtras().getSerializable("MOVIE_DETAILS");
    }

    private void initViews(){
        image = findViewById(R.id.imageView);
        title = findViewById(R.id.title);
        date = findViewById(R.id.date);
        rating = findViewById(R.id.rating);
        overview = findViewById(R.id.overview);
    }

    private void populateView(){
        final Bundle bundle = getIntent().getExtras();
        if(bundle.get("image") == null){
            imagePath = "";
        }else {
            imagePath = bundle.get("image").toString();
        }
        title.setText(bundle.get("title").toString());
        date.setText(bundle.get("date").toString());
        rating.setText(getPopularityString((Float) bundle.get("rating")));
        overview.setText(bundle.get("overview").toString()
                .isEmpty()?getString(R.string.no_overview):bundle.get("overview").toString());
        if (!imagePath.isEmpty()) {
            Glide.with(this)
                    .load(getString(R.string.image_url)+imagePath)
                    .apply(RequestOptions.centerCropTransform())
                    .transition(withCrossFade())
                    .into(image);
        }else {
            image.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    private String getPopularityString(float popularity) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.#");
        return decimalFormat.format(popularity);
    }
}
