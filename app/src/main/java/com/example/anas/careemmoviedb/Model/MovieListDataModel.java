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
        "page",
        "total_results",
        "total_pages",
        "results"
})
public class MovieListDataModel {
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("total_results")
    private Integer total_results;
    @JsonProperty("total_pages")
    private Integer total_pages;
    @JsonProperty("results")
    private List<MovieResult> results = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("total_results")
    public Integer getTotalResults() {
        return total_results;
    }

    @JsonProperty("total_results")
    public void setTotalResults(Integer totalResults) {
        this.total_results = totalResults;
    }

    @JsonProperty("total_pages")
    public Integer getTotalPages() {
        return total_pages;
    }

    @JsonProperty("total_pages")
    public void setTotalPages(Integer totalPages) {
        this.total_pages = totalPages;
    }

    @JsonProperty("results")
    public List<MovieResult> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(List<MovieResult> results) {
        this.results = results;
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
