package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WebProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/web/products/new")
    public String webNewProduct(){
        return "webAddProduct";
    }

    @PostMapping("/web/products/new")
    public String submit(@ModelAttribute("product")Product product,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        productRepository.addProduct(product);
        return "webAddProduct";
    }

}
