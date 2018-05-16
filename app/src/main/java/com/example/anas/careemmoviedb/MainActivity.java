package com.example.anas.careemmoviedb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anas.careemmoviedb.Adapters.MovieRecyclerViewAdapter;
import com.example.anas.careemmoviedb.Model.MovieCardDataModel;
import com.example.anas.careemmoviedb.Model.MovieListDataModel;
import com.example.anas.careemmoviedb.Model.MovieResult;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Utils.Helper;
import Utils.IWebService;
import Utils.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static Utils.Helper.dialog;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter moviesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Intent intent;
    private TextView tvNoConnection;
    private EditText etSearch;
    private String releaseDate;
    private Boolean isRefresh = false;
    private int page = 1;
    private ArrayList movieData;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Helper.showSpinner("Fetching data.....",this);
        intent = new Intent(this, MovieDetail.class);
        getMovieList(getReleaseDate());
        movieData = new ArrayList<MovieCardDataModel>();
        hideKeyBoard();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.my_recycler_view);
        tvNoConnection = findViewById(R.id.tv_no_connection);
        etSearch = findViewById(R.id.et_search);
        hideKeyBoard();
    }

    private void populateView(final List<MovieResult> movieData) {
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        moviesAdapter = new MovieRecyclerViewAdapter(getDataSet(movieData), this);
        if (isRefresh) {
            moviesAdapter.notifyDataSetChanged();
            isRefresh = false;
        }

        mRecyclerView.setAdapter(moviesAdapter);
        ((MovieRecyclerViewAdapter) moviesAdapter).setOnItemClickListener(new MovieRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                String movieId = movieData.get(position).getId().toString();
                Log.i("movie_id",movieId);
                Bundle bundle = new Bundle();
                bundle.putString("image",movieData.get(position).getPosterPath());
                bundle.putString("title",movieData.get(position).getTitle());
                bundle.putString("date",movieData.get(position).getReleaseDate());
                bundle.putFloat("rating",movieData.get(position).getPopularity());
                bundle.putString("overview",movieData.get(position).getOverview());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private ArrayList<MovieCardDataModel> getDataSet(List<MovieResult> movieResults) {
        if(movieData.size()>0){
            movieData.add(movieResults);
        }else {
            movieData = new ArrayList<MovieCardDataModel>();
        }
        MovieCardDataModel obj = null;
        Float popularity;
        String movieName;
        String imagePath;
        int arrayIndex=0;
        for (int i=0; i<movieResults.size(); i++) {
            popularity = movieResults.get(i).getPopularity();
            movieName = movieResults.get(i).getTitle();
            imagePath = movieResults.get(i).getPosterPath();
            obj = new MovieCardDataModel(popularity,movieName,imagePath);
            movieData.add(arrayIndex, obj);
            arrayIndex++;
        }
        dialog.dismiss();
        return movieData;
    }

    private void getMovieList(String date) {
        ServiceGenerator sg = new ServiceGenerator(getString(R.string.base_url));
        IWebService service = sg.getService(IWebService.class,this.getApplicationContext());
        final Call<MovieListDataModel> postingService = service.getMovies(
                date,"release_date.desc",page,getString(R.string.api_key)
        );
        postingService.enqueue(new Callback<MovieListDataModel>() {
            @Override
            public void onResponse(Call<MovieListDataModel> call, Response<MovieListDataModel> response) {
                if (response.isSuccessful()) {
                    tvNoConnection.setVisibility(View.INVISIBLE);
                    populateView(response.body().getResults());
                } else {
                    tvNoConnection.setVisibility(View.VISIBLE);
                    dialog.dismiss();
                }
            }
            @Override
            public void onFailure(Call<MovieListDataModel> call, Throwable t) {
                tvNoConnection.setVisibility(View.VISIBLE);
                dialog.dismiss();
            }
        });
    }

    public String getReleaseDate() {
        Calendar cal = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat")
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        return format1.format(cal.getTime());
    }

    public void SortMovieByDate(View view) {
        if(etSearch.getText().toString().isEmpty()){
            etSearch.clearFocus();
            Toast.makeText(this,"Enter Correct Year", Toast.LENGTH_SHORT).show();
        }else {
            etSearch.clearFocus();
            hideKeyBoard();
            page = 1;
            getMovieList(etSearch.getText().toString());
        }

    }

    private void hideKeyBoard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideKeyBoard();
    }

}
