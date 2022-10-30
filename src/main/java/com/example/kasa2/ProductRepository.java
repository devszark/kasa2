package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addProduct(Product newProd) {
        return jdbcTemplate.update("INSERT INTO products (name,price) VALUES (?,?)",
                newProd.getName(), newProd.getPrice());
    }

    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT id, name, price from products",
                BeanPropertyRowMapper.newInstance(Product.class));
    }

    public float getSum() {
        List<Product> allProducts = getAll();
        float sum = 0.0f;
        for (Product product : allProducts){
            sum+=product.getPrice();
        }
        return sum;
    }

    public Product getById(int id) {
        Product product = jdbcTemplate.queryForObject("SELECT id, name, price from products where id=?",
                BeanPropertyRowMapper.newInstance(Product.class),
                id);
        return product;
    }

    public void deleteById(int id) {
        jdbcTemplate.update("DELETE from products WHERE id=?", id);
    }
}
