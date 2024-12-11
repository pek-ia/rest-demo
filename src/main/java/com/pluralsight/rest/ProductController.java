package com.pluralsight.rest;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/rest/products")
public class ProductController {


    @RequestMapping(method=RequestMethod.GET, path="/{id}")
    public Product findById( @PathVariable("id") Integer productId) {
        return new Product(1, "Super Dad Gift", "Gifts", 12.00);
    }

    @GetMapping
    public List<Product> findAll(){
        List<Product> results = new ArrayList<>();
        results.add(new Product(1, "Super Dad Gift", "Gifts", 12.00));
        return results;
    }

    @PostMapping
    @ResponseStatus(code= HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product){
        System.out.println(product);
        return product;
    }


    @RequestMapping(method = RequestMethod.DELETE, path="/{id}")
    @ResponseStatus(code=HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable(name = "id") Integer productId){
        System.out.println("deleted product id " + productId);

    }


}
