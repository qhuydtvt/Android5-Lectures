package techkids.vn.dailyquote.models;

import android.database.Cursor;

/**
 * Created by apple on 10/13/16.
 */

public class Quote {
    public String content;
    public String title;

    public Quote(String content, String title) {
        this.content = content;
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("{%s: %s}", title, content);
    }
}
