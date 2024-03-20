package dk.kea.tabeldemodat23b.controller;

import dk.kea.tabeldemodat23b.model.Product;
import dk.kea.tabeldemodat23b.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
        return "bookstore";
    }

}
