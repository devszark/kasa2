package com.example.kasa2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO Finish ApiOrderController class/methods
@RestController
public class ApiOrderController {
    /**
     * This controller responds to REST API requests for order-s
     */
    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/api/order/new")
    public int newOrder(@RequestBody Order newOrder) {
        /**
         * Adding a new order - this is order id and comment and products list
         * POST request with JSON
         *  JSON example: {  "comment": "Nowy order 11",
         *                   "id": 11,
         *                   "productList": [ 2,3 ]
         *                }
         */
        orderRepository.addOrder(newOrder);
        return 1;
    }

    @GetMapping("/api/order")
    public List<Order> getAll(){
        /**
         * GET list of all orders
         * Expect to get list of [ { "id": 2. "comment": "order nr 234" } , .... ]
         */
        return orderRepository.getAll();
        //TODO nie działa jak nalezy - zwraca w Postman liste razem z all, total, etc.
    }

//    @PutMapping("/api/order/{id}")
//      It will be to add list of products to the existing order id=X
//
    @GetMapping("/api/order/{id}")
    public List<Integer> getOneOrder(@PathVariable("id") int id){
        /**
         * To get list of product id-s in order id=X
          */
        Order o = orderRepository.getById(id);
        return o.getProductList();
    }
//
//    @GetMapping("/api/order/total/{id}")
//      To get total of the order id=X
//

}

