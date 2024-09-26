import java.util.regex.Pattern;

public class HW03_20230808010 {
    public static void main(String[] args) {
        Author def=new Author("defne", "demir", "d@a.f");
        PaperBook daslk=new PaperBook("fsd", "fsdfsdfsd", def, true);
        System.out.println(daslk.getShippingWeight());
    }
}
class Author{
    private String name;
    private String surname;
    private String mail;

    Author(String name, String surname, String mail){
        setMail(mail);
        setName(name);
        setSurname(surname);
    }
    public void setMail(String mail) {
        this.mail = mail;
        if(!patternMatches(mail)){
            throw new IllegalArgumentException("Error: invalid email adress");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getMail() {
        return mail;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public static boolean patternMatches(String emailAddress) {
        return Pattern.compile("^(.+)@(\\S+)$")
          .matcher(emailAddress)
          .matches();
    }
}
class Book{
    private Author author;
    private double price;
    private String title;
    private String isbn;

    Book(String isbn,String title,Author author,double price){
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        setTitle(title);
    }
    Book(String isbn,String title,Author author){
        setAuthor(author);
        setIsbn(isbn);
        setTitle(title);
        this.price=15.25;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Author getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }
    
}

class EBook extends Book{
    private String downloadUrl;
    private double sizeMb;
    
    EBook(String isbn, String title, Author author, double price,String downloadUrl,double sizesMB) {
        super(isbn, title, author, price);
        setSizeMb(sizesMB);
        setDownloadUrl(downloadUrl);
    }
    EBook(String isbn, String title, Author author,String downloadUrl,double sizesMB) {
        super(isbn, title, author);
        setSizeMb(sizesMB);
        setDownloadUrl(downloadUrl);
    }
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
    public void setSizeMb(double sizeMb) {
        this.sizeMb = sizeMb;
    }
    public double getSizeMb() {
        return sizeMb;
    }
    public String getDownloadUrl() {
        return downloadUrl;
    }
}

class PaperBook extends Book{
    private int shippingWeight;
    private boolean inStock;
    
    PaperBook(String isbn, String title, Author author, double price,int shippingWeight,boolean inStock) {
        super(isbn, title, author, price);
        setShippingWeight(shippingWeight);
        setInStock(inStock);
    }
    PaperBook(String isbn, String title, Author author,boolean inStock) {
        super(isbn, title, author);
        setShippingWeight((int)(Math.random()*10)+5);
        setInStock(inStock);
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    public void setShippingWeight(int shippingWeight) {
        this.shippingWeight = shippingWeight;
    }
    public boolean isInStock() {
        return inStock;
    }
    public int getShippingWeight() {
        return shippingWeight;
    }

}