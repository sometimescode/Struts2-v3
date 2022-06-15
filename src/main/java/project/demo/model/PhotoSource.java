package project.demo.model;

public class PhotoSource {
    private String original;
    private String large;
    private String large2x;
    private String medium;
    private String small;
    private String portrait;
    private String landscape;
    private String tiny;

    public String getOriginal() {
        return original;
    }
    public void setOriginal(String original) {
        this.original = original;
    }
    public String getLarge() {
        return large;
    }
    public void setLarge(String large) {
        this.large = large;
    }
    public String getLarge2x() {
        return large2x;
    }
    public void setLarge2x(String large2x) {
        this.large2x = large2x;
    }
    public String getMedium() {
        return medium;
    }
    public void setMedium(String medium) {
        this.medium = medium;
    }
    public String getSmall() {
        return small;
    }
    public void setSmall(String small) {
        this.small = small;
    }
    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
    public String getLandscape() {
        return landscape;
    }
    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }
    public String getTiny() {
        return tiny;
    }
    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    @Override
    public String toString() {
        return "PhotoSource [landscape=" + landscape + ", large=" + large + ", large2x=" + large2x + ", medium="
                + medium + ", original=" + original + ", portrait=" + portrait + ", small=" + small + ", tiny=" + tiny
                + "]";
    }
}
