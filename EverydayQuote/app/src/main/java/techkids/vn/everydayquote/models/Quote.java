package techkids.vn.everydayquote.models;

/**
 * Created by apple on 10/11/16.
 */

public class Quote {
    private String title;
    private String content;
    private String imageUrl;

    public Quote(String title, String content, String imageUrl) {
        this.title = title;
        this.content = content;
        this.imageUrl =  imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
