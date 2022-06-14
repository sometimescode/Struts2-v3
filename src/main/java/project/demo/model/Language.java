package project.demo.model;

public class Language {
    private String languageAbbr;
    private String languageName;

    public Language(String languageAbbr, String languageName) {
        this.languageAbbr = languageAbbr;
        this.languageName = languageName;
    }

    public String getLanguageAbbr() {
        return languageAbbr;
    }

    public void setLanguageAbbr(String languageAbbr) {
        this.languageAbbr = languageAbbr;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    @Override
    public String toString() {
        return "Language [languageAbbr=" + languageAbbr + ", languageName=" + languageName + "]";
    }
}
