package book.model;
public class Book {
    private int bookID;
    private String btitle;
    private String bauthor;
    private String bgenre;
    private String bcoursecode;
    private double bprice;
    private String bcondition;
    private String bdistributor;
    private int adminID;
    private Book book;
    
    public Book() {
        // You can choose to initialize default values for instance variables here if needed
        // For example:
        this.bookID=0;
        this.btitle = "";
        this.bauthor = "";
        this.bgenre = "";
        this.bcoursecode = "";
        this.bprice = 0.0;
        this.bcondition = "";
        this.bdistributor = "";
        this.adminID = 0;
    }
   

    public Book(int bookID, String btitle, String bauthor, String bgenre, String bcoursecode, double bprice,
                String bcondition, String bdistributor, int adminID) {
        this.bookID = bookID;
        this.btitle = btitle;
        this.bauthor = bauthor;
        this.bgenre = bgenre;
        this.bcoursecode = bcoursecode;
        this.bprice = bprice;
        this.bcondition = bcondition;
        this.bdistributor = bdistributor;
        this.adminID = adminID;
    }

    // Getters and Setters
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return btitle;
    }

    public void setTitle(String btitle) {
        this.btitle = btitle;
    }

    public String getAuthor() {
        return bauthor;
    }

    public void setAuthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getGenre() {
        return bgenre;
    }

    public void setGenre(String bgenre) {
        this.bgenre = bgenre;
    }

    public String getCourseCode() {
        return bcoursecode;
    }

    public void setCourseCode(String bcourseCode) {
        this.bcoursecode = bcourseCode;
    }

    public double getPrice() {
        return bprice;
    }

    public void setPrice(double bprice) {
        this.bprice = bprice;
    }

    public String getCondition() {
        return bcondition;
    }

    public void setCondition(String condition) {
        this.bcondition = condition;
    }

    public String getDistributor() {
        return bdistributor;
    }

    public void setDistributor(String distributor) {
        this.bdistributor = distributor;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    // Other methods

    @Override
    public String toString() {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + btitle + '\'' +
                ", author='" + bauthor + '\'' +
                ", genre='" + bgenre + '\'' +
                ", courseCode='" + bcoursecode + '\'' +
                ", price=" + bprice +
                ", condition='" + bcondition + '\'' +
                ", distributor='" + bdistributor + '\'' +
                ", adminID=" + adminID +
                '}';
    }
}
