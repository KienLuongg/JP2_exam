import java.util.Collection;

public class Book {
    private String BookID;
    private String BName;
    private String BAuthor;
    private Integer BPrice;

    public Book(String bookID, String BName, String BAuthor, Integer BPrice) {
        BookID = String.valueOf(bookID);
        this.BName = BName;
        this.BAuthor = BAuthor;
        this.BPrice = BPrice;
    }

    public Book() {

    }

    public String getBookID() {
        return BookID;
    }

    public void setBookID(Integer bookID) {
        BookID = String.valueOf(bookID);
    }

    public String getBName() {
        return BName;
    }

    public void setBName(String BName) {
        this.BName = BName;
    }

    public String getBAuthor() {
        return BAuthor;
    }

    public void setBAuthor(String BAuthor) {
        this.BAuthor = BAuthor;
    }

    public Integer getBPrice() {
        return BPrice;
    }

    public void setBPrice(Integer BPrice) {
        this.BPrice = BPrice;
    }


    public Collection all() {
        return null;
    }
}
