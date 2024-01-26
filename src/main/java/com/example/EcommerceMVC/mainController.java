package com.example.EcommerceMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class mainController {

    @GetMapping("/")
    public String mainn(){
        return "index";
    }
    @GetMapping("/fashion")
    public String showFashionPage() {
        return "fashion"; // Assumes you have a fashion.html in src/main/resources/templates
    }

    @GetMapping("/electronic")
    public String showElectronicPage() {
        return "electronic"; // Return the Thymeleaf template name without the ".html" extension
    }

    @GetMapping("/jewellery")
    public String showJewelleryPage() {
        return "jewellery"; // Assumes you have a jewellery.html in src/main/resources/templates
    }
}
