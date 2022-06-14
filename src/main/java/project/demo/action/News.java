package project.demo.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

import project.demo.model.Language;

public class News extends ActionSupport {
    private NewsResponse newsResponse;
    private final String API_KEY = "5f24cabdcc334f75b315c00604145df0";
    private String urlQuery;
    private String q = "";
    private String language = "en";
    private String sortBy = "publishedAt";
    private List<Language> languages;  //en, es, zh
    private String [] sortByOptions = {"relevancy", "popularity", "publishedAt" };
    private String error;

    public Date convertDateStringToDate(String dateString) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy hh:mm").parse(dateString);  
    }
    
    public String execute() throws Exception {
        String format = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String currentDate = dateFormat.format(calendar.getTime());
        try {
 
            URL url = new URL("https://newsapi.org/v2/everything?q=" + q + 
                "&searchIn=title,description" +
                "&from=" + currentDate +
                "&language=" + language +
                "&sortBy=" + sortBy + 
                "&apiKey=" + API_KEY);               

            urlQuery = url.toString();

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
 
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
 
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                newsResponse = mapper.readValue(output, NewsResponse.class);
            }
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            error = e.toString();
        }
        return SUCCESS;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public List<Language> getLanguages() {
        languages = new ArrayList<Language>();
		languages.add( new Language("en", "English") );
		languages.add( new Language("es", "Spanish") );
		languages.add( new Language("zh", "Chinese") );
		
		return languages;
    }

    public List<String> getSortByOptions() {
        return Arrays.asList(sortByOptions);
    }

    public NewsResponse getNewsResponse() {
        return newsResponse;
    }

    public void setNewsResponse(NewsResponse newsResponse) {
        this.newsResponse = newsResponse;
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
}
