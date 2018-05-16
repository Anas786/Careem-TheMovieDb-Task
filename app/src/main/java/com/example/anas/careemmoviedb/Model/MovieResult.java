package com.example.anas.careemmoviedb.Model;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anas on 15-May-18.
 */


@JsonPropertyOrder({
        "vote_count",
        "id",
        "video",
        "vote_average",
        "title",
        "popularity",
        "poster_path",
        "original_language",
        "original_title",
        "genre_ids",
        "backdrop_path",
        "adult",
        "overview",
        "release_date"
})
public class MovieResult {
    @JsonProperty("vote_count")
    private Integer vote_count;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("video")
    private Boolean video;
    @JsonProperty("vote_average")
    private Float vote_average;
    @JsonProperty("title")
    private String title;
    @JsonProperty("popularity")
    private Float popularity;
    @JsonProperty("poster_path")
    private String poster_path;
    @JsonProperty("original_language")
    private String original_language;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("genre_ids")
    private List<Integer> genre_ids = null;
    @JsonProperty("backdrop_path")
    private Object backdrop_path;
    @JsonProperty("adult")
    private Boolean adult;
    @JsonProperty("overview")
    private String overview;
    @JsonProperty("release_date")
    private String release_date;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("vote_count")
    public Integer getVoteCount() {
        return vote_count;
    }

    @JsonProperty("vote_count")
    public void setVoteCount(Integer voteCount) {
        this.vote_count = voteCount;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("video")
    public Boolean getVideo() {
        return video;
    }

    @JsonProperty("video")
    public void setVideo(Boolean video) {
        this.video = video;
    }

    @JsonProperty("vote_average")
    public Float getVoteAverage() {
        return vote_average;
    }

    @JsonProperty("vote_average")
    public void setVoteAverage(Float voteAverage) {
        this.vote_average = voteAverage;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("popularity")
    public Float getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Float popularity) {
        this.popularity = popularity;
    }

    @JsonProperty("poster_path")
    public String getPosterPath() {
        return poster_path;
    }

    @JsonProperty("poster_path")
    public void setPosterPath(String posterPath) {
        this.poster_path = posterPath;
    }

    @JsonProperty("original_language")
    public String getOriginalLanguage() {
        return original_language;
    }

    @JsonProperty("original_language")
    public void setOriginalLanguage(String originalLanguage) {
        this.original_language = originalLanguage;
    }

    @JsonProperty("original_title")
    public String getOriginalTitle() {
        return original_title;
    }

    @JsonProperty("original_title")
    public void setOriginalTitle(String originalTitle) {
        this.original_title = originalTitle;
    }

    @JsonProperty("genre_ids")
    public List<Integer> getGenreIds() {
        return genre_ids;
    }

    @JsonProperty("genre_ids")
    public void setGenreIds(List<Integer> genreIds) {
        this.genre_ids = genreIds;
    }

    @JsonProperty("backdrop_path")
    public Object getBackdropPath() {
        return backdrop_path;
    }

    @JsonProperty("backdrop_path")
    public void setBackdropPath(Object backdropPath) {
        this.backdrop_path = backdropPath;
    }

    @JsonProperty("adult")
    public Boolean getAdult() {
        return adult;
    }

    @JsonProperty("adult")
    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    @JsonProperty("overview")
    public String getOverview() {
        return overview;
    }

    @JsonProperty("overview")
    public void setOverview(String overview) {
        this.overview = overview;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return release_date;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.release_date = releaseDate;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
