package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/web/products/new")
    public String webNewProduct(){
        return "webAddProduct";
    }

// Not finished - it doesn't work yet
//    @PostMapping("/web/products/new")
//    public int newProductPOST(@RequestBody Product newProduct) {
//        for (Product newProduct : newProductsList){
//            productRepository.addProduct(newProduct);
//        }
//        return 1;

}
