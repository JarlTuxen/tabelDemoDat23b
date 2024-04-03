package dk.kea.tabeldemodat23b.controller;

import dk.kea.tabeldemodat23b.model.Product;
import dk.kea.tabeldemodat23b.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ButikController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public String index(){
        return "redirect:/boghandel";
    }

    @GetMapping("/boghandel")
    public String visVareliste(Model model){

        //Hente collection af varer i repository
        List<Product> products = productRepository.getAll();

        //tilføj varer til view model
        model.addAttribute("varer", products);
        //separat kald til at finde summen af produkter
        model.addAttribute("sum", productRepository.sumPrice());
        return "bookstore";
    }

    @GetMapping("/create")
    public String visCreate(){
        return "create";
    }

    @PostMapping("/create")
    public String createProduct(
            @RequestParam("name") String navn,
            @RequestParam("genre") String genre,
            @RequestParam("price") double price
    ) {
        //lav nyt produkt
        Product product = new Product(navn, genre, price);
        //gem nyt produkt i databasen
        productRepository.create(product);
        //rediriger til produktliste
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int deleteId){
        //slet i repository
        productRepository.deleteById(deleteId);
        //redirect til liste
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable("id") int updateId, Model model){
        //find product i database
        Product product = productRepository.findById(updateId);

        //tilføj product til view model
        model.addAttribute("vare", product);

        //vis update-side
        return "update";
    }

    @PostMapping("/update")
    public String updateProduct(
                @RequestParam("id") int id,
                @RequestParam("name") String navn,
                @RequestParam("genre") String genre,
                @RequestParam("price") double price
                ){
        //lave product
        Product product = new Product(id, navn, genre, price);

        //opdater repository
        productRepository.update(product);

        //vis liste
        return "redirect:/";
    }
}
