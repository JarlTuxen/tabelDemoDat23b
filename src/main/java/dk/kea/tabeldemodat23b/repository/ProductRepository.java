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
        products.add(new Product(1, "The Witcher 3: Wild Hunt", "Action RPG", 59.99));
        products.add(new Product(2, "Grand Theft Auto V", "Action-Adventure", 29.99));
        products.add(new Product(3, "The Legend of Zelda: Breath of the Wild", "Action-Adventure", 49.99));
        products.add(new Product(4, "Red Dead Redemption 2", "Action-Adventure", 39.99));
        products.add(new Product(5, "Dark Souls III", "Action RPG", 19.99));
        products.add(new Product(6, "Overwatch", "First-Person Shooter", 39.99));
        products.add(new Product(7, "Fortnite", "Battle Royale", 0.00));
        products.add(new Product(8, "Minecraft", "Sandbox", 26.95));
        products.add(new Product(9, "Fallout 4", "Action RPG", 19.99));
        products.add(new Product(10, "The Elder Scrolls V: Skyrim", "Action RPG", 39.99));

        return products;
    }
}
