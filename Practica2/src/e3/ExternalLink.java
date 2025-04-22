package e3;

public class ExternalLink {
    private final String title;
    private final String url;

    //método constructor
    public ExternalLink(String title, String url) {
        this.title = title;
        this.url = url;
    }


    //getters y setters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

}