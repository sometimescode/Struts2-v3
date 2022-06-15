package project.demo.model;

public class PhotoResponse {
    private int id;
    private int width;
    private int height;
    private String url;
    private String photographer;
    private String photographer_url;
    private String photographer_id;
    private String avg_color;
    private PhotoSource src;
    private boolean liked;
    private String alt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPhotographer() {
        return photographer;
    }
    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }
    public String getPhotographer_url() {
        return photographer_url;
    }
    public void setPhotographer_url(String photographer_url) {
        this.photographer_url = photographer_url;
    }
    public String getPhotographer_id() {
        return photographer_id;
    }
    public void setPhotographer_id(String photographer_id) {
        this.photographer_id = photographer_id;
    }
    public String getAvg_color() {
        return avg_color;
    }
    public void setAvg_color(String avg_color) {
        this.avg_color = avg_color;
    }
    public PhotoSource getSrc() {
        return src;
    }
    public void setSrc(PhotoSource src) {
        this.src = src;
    }
    public boolean isLiked() {
        return liked;
    }
    public void setLiked(boolean liked) {
        this.liked = liked;
    }
    public String getAlt() {
        return alt;
    }
    public void setAlt(String alt) {
        this.alt = alt;
    }

    @Override
    public String toString() {
        return "PhotoResponse [alt=" + alt + ", avg_color=" + avg_color + ", height=" + height + ", id=" + id
                + ", photographer=" + photographer + ", photographer_id=" + photographer_id + ", photographer_url="
                + photographer_url + ", src=" + src + ", url=" + url + ", width=" + width + "]";
    }

    
}