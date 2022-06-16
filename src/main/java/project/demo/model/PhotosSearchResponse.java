package project.demo.model;

public class PhotosSearchResponse {
    private PhotoResponse photos[];
    private int page;
    private int per_page;
    private int total_results;
    private String prev_page;
    private String next_page;

    public PhotoResponse[] getPhotos() {
        return photos;
    }
    public void setPhotos(PhotoResponse[] photos) {
        this.photos = photos;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getPer_page() {
        return per_page;
    }
    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }
    public int getTotal_results() {
        return total_results;
    }
    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
    public String getPrev_page() {
        return prev_page;
    }
    public void setPrev_page(String prev_page) {
        this.prev_page = prev_page;
    }
    public String getNext_page() {
        return next_page;
    }
    public void setNext_page(String next_page) {
        this.next_page = next_page;
    }

    @Override
    public String toString() {
        return "PhotosSearchResponse [next_page=" + next_page + ", page=" + page + ", per_page=" + per_page
                + ", photos=" + photos + ", prev_page=" + prev_page + ", total_results=" + total_results + "]";
    }

    
}
