package project.demo.action;

import java.util.ArrayList;

import project.demo.model.Article;

public class NewsResponse {
    String status;
    int totalResults;
    ArrayList<Article> articles;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getTotalResults() {
        return totalResults;
    }
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }
    public ArrayList<Article> getArticles() {
        return articles;
    }
    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }   
}
