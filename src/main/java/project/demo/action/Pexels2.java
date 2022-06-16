package project.demo.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

import project.demo.model.PhotosSearchResponse;

public class Pexels2 extends ActionSupport{
    private PhotosSearchResponse photosSearchResponse;
    private String urlQuery;
    private String error;
    private String searchQuery;

    public String execute() {
        return SUCCESS;
    }

    public String searchByUserQuery() throws MalformedURLException, Exception {
        if(searchQuery != null && !searchQuery.isBlank()){
            searchAPI(new URL("https://api.pexels.com/v1/search?query=" + searchQuery));
        } else {
            error = "Please enter a valid search term.";
        }

        return SUCCESS;
    }

    private void searchAPI(URL url) throws Exception {
        try {      
            urlQuery = url.toString();
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "563492ad6f9170000100000153899aa6e1494be5a16c0c67c06637c0");
    
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
    
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                photosSearchResponse = mapper.readValue(output, PhotosSearchResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            error = e.toString();
        }
    }

    public String fetchPage() throws MalformedURLException, Exception {
        searchAPI(new URL(searchQuery));

        return SUCCESS;
    }

    public PhotosSearchResponse getPhotosSearchResponse() {
        return photosSearchResponse;
    }

    public void setPhotosSearchResponse(PhotosSearchResponse photosSearchResponse) {
        this.photosSearchResponse = photosSearchResponse;
    }

    public String getUrlQuery() {
        return urlQuery;
    }

    public void setUrlQuery(String urlQuery) {
        this.urlQuery = urlQuery;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    
}
