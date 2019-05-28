package com.example.milon;

import io.milton.annotations.ChildrenOf;
import io.milton.annotations.ResourceController;
import io.milton.annotations.Root;

import java.util.ArrayList;
import java.util.List;


@ResourceController
public class WebDavResourseController {
    private static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(WebDavResourseController.class);
    private List<Product> products = new ArrayList<>();

    public WebDavResourseController() {
        products.add(new Product("hello"));
        products.add(new Product("world"));
    }

    @Root
    public WebDavResourseController getRoot() {
        return this;
    }

    @ChildrenOf
    public List<Product> getProducts(WebDavResourseController root) {
        return products;
    }

    public class Product {
        private String name;

        public Product(String name) {
            this.name = name;
        }

    }
}
