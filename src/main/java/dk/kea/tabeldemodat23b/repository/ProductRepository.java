package dk.kea.tabeldemodat23b.repository;

import dk.kea.tabeldemodat23b.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAll(){
        String sql = "select * from products";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class));

        return products;
    }

    //udregn pris, hvis alle produkter købes
    public double sumPrice(){
        final String sql = "SELECT SUM(price) FROM products";
        //brug queryForObject, når det er en værdi, der skal tilbage
        //angiv typen der kommer retur
        double sum = jdbcTemplate.queryForObject(sql, Double.class);
        return sum;
    }

    public List<Product> getAllDefault(){
        List<Product> products = new ArrayList<>();

        //lav testdata og sæt i productliste - genereret med ChatGpt
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

    public void create(Product product) {
        final String INSERT_SQL ="INSERT INTO products (name, genre, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(INSERT_SQL, product.getName(), product.getGenre(), product.getPrice());
    }

    public void deleteById(int deleteId){
        //slette sql
        final String DELETE_BY_ID_SQL = "DELETE FROM products WHERE id = ?";
        //kald af JdbcTemplate med sql og paramter
        jdbcTemplate.update(DELETE_BY_ID_SQL, deleteId);
    }

    public Product findById(int updateId) {
        //find SQL
        final String FIND_BY_ID_SQL = "SELECT * FROM products WHERE id = ?";

        //definer rowmapper som omsætter databaserække til product
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class);

        //returner query-resultat fra JdbcTemplate
        return jdbcTemplate.queryForObject(FIND_BY_ID_SQL, rowMapper, updateId);
    }

    public void update(Product product) {
        //update sql
        final String UPDATE_SQL = "UPDATE products SET name = ?, genre = ?, price = ? WHERE id = ?";
        //update db vha. JdbcTemplate
        jdbcTemplate.update(UPDATE_SQL, product.getName(), product.getGenre(), product.getPrice(), product.getId());
    }
}
