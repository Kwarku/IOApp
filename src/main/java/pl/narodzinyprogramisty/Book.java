package pl.narodzinyprogramisty;

public class Book implements Comparable<Book> {
    //    id,cat,name,price,inStock,author_t,series_t,sequence_i,genre_s
    private String id;
    private String cat;
    private String name;
    private double price;
    private boolean inStock;
    private String author;
    private String series;
    private String sequence;
    private String genre;


    public Book(String id, String cat, String name, double price, boolean inStock, String author, String series, String sequence, String genre) {
        this.id = id;
        this.cat = cat;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.author = author;
        this.series = series;
        this.sequence = sequence;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Book name: %-25s, price: %.2f inStock: %5s", name, price, inStock);
    }

    @Override
    public int compareTo(Book o) {
        if (o.inStock) {
            if (this.price > o.price)
                return 0;
            else return 1;
        }
        return -1;

    }
}
