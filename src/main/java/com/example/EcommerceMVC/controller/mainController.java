package com.example.EcommerceMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    @GetMapping("/index.html")
    public String redirectToMainPage() {
        return "index";
//        return new RedirectView("/", false);
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin/indexAdmin";
    }
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
