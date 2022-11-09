package com.example.kasa2;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {
    private int id;
    private String comment;
    private List<Integer> productList = new ArrayList<>();

    @Autowired
    ProductRepository productRepository;

    public int addProduct(Integer prodId){
        /**
         * Add single product to the order
         */
        productList.add(prodId);
        return 1;
    }

    public int addProduct(List<Integer> newProductsList){
        /**
         * Add list of products
          */
        productList.addAll(newProductsList);
        return 1;
    }

    public float getTotal(){
        /**
         * Counts total order value by adding prices for all products in the order
         */
        float total=0f;
        for (Integer p : productList){
            total += productRepository.getById(p).getPrice();
        }
        return total;
    }

    public List<Integer> getAll(){
        /**
         * returns list of products in this order
         */
        return productList;
    }
}
