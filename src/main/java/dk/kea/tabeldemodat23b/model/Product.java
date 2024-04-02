package dk.kea.tabeldemodat23b.model;

public class Product {
    //unikt id fra database
    int id;
    String name;
    String genre; //to be normalized?
    double price;

    public Product() {
    }

    public Product(int id, String name, String genre, double price) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public Product(String name, String genre, double price) {
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
