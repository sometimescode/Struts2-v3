package project.demo.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

import project.demo.model.PhotoResponse;
import project.demo.model.PhotosSearchResponse;

public class Pexels2 extends ActionSupport{
    private PhotosSearchResponse photosSearchResponse;
    private String urlQuery;
    private String error;
    private String searchQuery = "nature";

    // private String imgSrc; this together with togglePhotoSource can be used if actually fetching resized values (something called DPR is modified as well as the width and height)

    public String execute() {
        return SUCCESS;
    }

    public String searchAPI() throws Exception {
        // System.out.println("AAAAAAAAAAAAAAAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
        // try {
 
        //     URL url = new URL("https://api.pexels.com/v1/search?query=" + searchQuery + "&per_page=1");        

        //     urlQuery = url.toString();

        //     HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //     conn.setRequestMethod("GET");
        //     conn.setRequestProperty("Authorization", "563492ad6f9170000100000153899aa6e1494be5a16c0c67c06637c0");
 
        //     if (conn.getResponseCode() != 200) {
        //         throw new RuntimeException("Failed : HTTP error code : "
        //                 + conn.getResponseCode());
        //     }
 
        //     BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        //     String output;
        //     while ((output = br.readLine()) != null) {
        //         ObjectMapper mapper = new ObjectMapper();
        //         photosSearchResponse = mapper.readValue(output, PhotosSearchResponse.class);
        //     }
        //     // imgSrc = photoResponse.getSrc().getOriginal();
        //     conn.disconnect();
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     error = e.toString();
        // }
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
