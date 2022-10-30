package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiProductController {
    /**
     * This controller responds to REST API requests
     */
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/api/products/new")
    public int newProductGET(@RequestParam(value="name") String name,
                                        @RequestParam(value="price") Float price){
        System.out.println("My message from newProductGet (/api/product/new)");
        Product newProd = new Product(0,name,price);
        productRepository.addProduct(newProd);
        System.out.println("Nowy produkt: "+newProd);
        // This is place to store the new product (newprod) somewhere (file/db).
        return 1;
    }

    @PostMapping("/api/products/new")
    public int newProductPOST(@RequestBody List<Product> newProductsList) {
        for (Product newProduct : newProductsList){
            productRepository.addProduct(newProduct);
        }
        return 1;
    }

    @PutMapping("/api/products/{id}")
    public int newProductPUT(@PathVariable("id") int id, @RequestBody Product newProduct) {
        Product prod = productRepository.getById(id);
        if (prod!=null) {
            prod.setName(newProduct.getName());
            prod.setPrice(newProduct.getPrice());
            productRepository.updateProduct(prod);
            return 1;
        } else return -1;
    }

    @GetMapping("/api/products")
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    @GetMapping("/api/products/sum")
    public float getSum(){
        return productRepository.getSum();
    }

    @GetMapping("/api/products/{id}")
    public Product getProduct(@PathVariable("id") int id){
        return productRepository.getById(id);
    }

    @DeleteMapping("/api/products/{id}")
    public int deleteProduct(@PathVariable("id") int id){
        Product product = productRepository.getById(id);
        if (product!=null){
            productRepository.deleteById(id);
            return 1;
        } else return -1;
    }
}
