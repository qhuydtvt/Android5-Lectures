package techkids.vn.everydayquote.jsonmodels;

/**
 * Created by apple on 10/10/16.
 */

public class QuoteJSONModel {

    private String title;
    private String content;

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

    //    private class Quote {
//
//        private String quote;
//        private String author;
//
//        public Quote(String quote, String author) {
//            this.quote = quote;
//            this.author = author;
//        }
//
//        public String getQuote() {
//            return quote;
//        }
//
//        public void setQuote(String quote) {
//            this.quote = quote;
//        }
//
//        public String getAuthor() {
//            return author;
//        }
//
//        public void setAuthor(String author) {
//            this.author = author;
//        }
//    }
//
//    private class Content {
////        @SerializedName("quotes")
////        private ArrayList<Quote> quotes;
//
////        public Content() {
////            quotes = new ArrayList<>();
////        }
//    }
//
//    @SerializedName("contents")
//    public Quote quote;
}
