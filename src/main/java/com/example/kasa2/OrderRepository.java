package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Repository
public class OrderRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void addOrder(Order newOrder)
    /**
     * Add a new order
     * it is updating 2 tables: orders and order_product
    */
    {
        jdbcTemplate.update("INSERT INTO orders (id,comment) VALUES (?,?)",
                newOrder.getId(), newOrder.getComment());
        for (Integer prodId : newOrder.getProductList()){
            jdbcTemplate.update("INSERT INTO order_product (order_id,product_id) VALUES (?,?)",
                    newOrder.getId(), prodId);
        }
    }

    public Order getById(int id) {
        return jdbcTemplate.queryForObject("SELECT id, comment FROM orders WHERE id=?",
                BeanPropertyRowMapper.newInstance(Order.class), id);
    }

    public List<Order> getAll() {
        List<Order> ordersList = jdbcTemplate.query("SELECT id,comment from orders",
                BeanPropertyRowMapper.newInstance(Order.class));
        return ordersList;
    }

    //TODO dokończyć inne metody tej klasy
}
