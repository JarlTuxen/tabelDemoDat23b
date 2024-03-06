package dk.kea.tabeldemodat23b.repository;

import dk.kea.tabeldemodat23b.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    public List<Product> getAll(){
        List<Product> products = new ArrayList<>();

        //lav testdata og sæt i productliste
        products.add(new Product(1, "Pokemon Go", "Mobilspil", 0));

        return products;
    }
}
