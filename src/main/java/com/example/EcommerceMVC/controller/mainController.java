package com.example.EcommerceMVC.controller;

import com.example.EcommerceMVC.dto.ElectronicDTO;
import com.example.EcommerceMVC.dto.FashionDTO;
import com.example.EcommerceMVC.dto.JewelleryDTO;
import com.example.EcommerceMVC.service.ElectronicService;
import com.example.EcommerceMVC.service.FashionService;
import com.example.EcommerceMVC.service.JewelleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class mainController {
    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private FashionService fashionService;
    @Autowired
    private JewelleryService jewelleryService;


    @GetMapping("/")
    public String mainn(Model model) {
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList", allElectronicDTO);

        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);

        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList", allJewelleryDTO);

        return "index";
    }

    @GetMapping("/a")
    public String test(Model model) {
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList", allElectronicDTO);

        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);

        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList", allJewelleryDTO);

        return "a";
    }

    @GetMapping("/addToCart/{id}")
    public String showAddToCardPage(@PathVariable Integer id) {
        return "a"; // Assumes you have a fashion.html in src/main/resources/templates
    }
    @GetMapping("/buyNow/{id}")
    public String showBuyNowPage(@PathVariable Integer id) {
        return "a"; // Assumes you have a fashion.html in src/main/resources/templates
    }

    //    @GetMapping("/fashion")
//    public String showFashionPage() {
//        return "fashion"; // Assumes you have a fashion.html in src/main/resources/templates
//    }
//
    @GetMapping("/electronic")
    public String showElectronicPage() {
        return "electronic"; // Return the Thymeleaf template name without the ".html" extension
    }

    //    @GetMapping("/jewellery")
//    public String showJewelleryPage() {
//        return "jewellery"; // Assumes you have a jewellery.html in src/main/resources/templates
//    }
    @GetMapping("/index.html")
    public String redirectToMainPage() {
        return "index";
//        return new RedirectView("/", false);
    }

    @GetMapping("/blog_list.html")
    public String getToBlogPage() {
        return "blog_list";
//        return new RedirectView("/", false);
    }

    @GetMapping("/contact.html")
    public String getToContactPage() {
        return "contact";
//        return new RedirectView("/", false);
    }

    @GetMapping("/about.html")
    public String getToAboutPage() {
        return "about";
//        return new RedirectView("/", false);
    }
    @GetMapping("/product.html")
    public String getToProductPage(Model model) {
        List<ElectronicDTO> allElectronicDTO = electronicService.getAllElectronic();
        model.addAttribute("allElectronicDTOList", allElectronicDTO);

        List<FashionDTO> allFashionDTO = fashionService.getAllFashion();
        model.addAttribute("allFashionDTOList", allFashionDTO);

        List<JewelleryDTO> allJewelleryDTO = jewelleryService.getAllJewellery();
        model.addAttribute("allJewelleryDTOList", allJewelleryDTO);
        return "product";
//        return new RedirectView("/", false);
    }

    @GetMapping("/testimonial.html")
    public String getToTestimonialPage() {
        return "testimonial";
    }


    //    @GetMapping("/admin")
//    public String adminPage() {
//        return "admin/indexAdmin";
//    }
    @GetMapping("/indexAdmin.html")
    public String dashboard() {
        return "admin/indexAdmin";
    }

    @GetMapping("/ui-buttons.html")
    public String uiButtons() {
        return "admin/ui-buttons";
    }

    @GetMapping("/ui-alerts.html")
    public String uiAlerts() {
        return "admin/ui-alerts";
    }

    @GetMapping("/ui-card.html")
    public String uiCard() {
        return "admin/ui-card";
    }

    @GetMapping("/ui-forms.html")
    public String uiForms() {
        return "admin/ui-forms";
    }

    @GetMapping("/ui-typography.html")
    public String uiTypography() {
        return "admin/ui-typography";
    }

    @GetMapping("/authentication-login.html")
    public String uiAuthenticationLogin() {
        return "admin/authentication-login";
    }

    @GetMapping("/authentication-register.html")
    public String uiAuthenticationRegister() {
        return "admin/authentication-register";
    }

    @GetMapping("/icon-tabler.html")
    public String uiIconTabler() {
        return "admin/icon-tabler";
    }

    @GetMapping("/sample-page.html")
    public String uiSamplePage() {
        return "admin/sample-page";
    }
}
