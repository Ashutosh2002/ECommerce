package com.example.ProductService.controllers;


import org.springframework.web.bind.annotation.*;

// Controller that's going to host REST/HTTP APIs
@RestController
@RequestMapping("/sample")
public class SampleController {

    //<domain-name>/sample/sayHello
    @GetMapping("/sayHello/{name}")
    public String sample(@PathVariable("name") String str){
        return "Hello " + str;
    }

    //<domain-name>/sample/sayHello2
    @GetMapping("/sayHello2")
    public String sample2(@RequestParam("x") int x){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i < x ; i++){
            sb.append("Hello World\n");
        }
        return sb.toString();
    }
}

// http://amazon.in/orders/create
// localhost:8080 : 192.68.1.7:8080
// ProductController - /products
// UserController - /users
// CategoryController - /categories

// HandlerMapping (maintained by spring framework)
// /sample -> SampleController
// /products -> ProductController
// /categories -=> CategoryController

