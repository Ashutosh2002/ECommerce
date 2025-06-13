package com.example.ProductService.services;

import com.example.ProductService.exceptions.CategoryNotFoundException;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import com.example.ProductService.repositories.CategoryRepository;
import com.example.ProductService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
//@Primary
public class SelfProductService implements ProductService{

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with given id " + productId + " not found.",productId);
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    /*

    {
        "title" : "Apple airtag",
        "description" : "useless item",
        "price" : "2000.0",
        "category" : {
                        "title" : "tracking device"
                     }
    }

     */
    @Override
    public Product createProduct(Product product) throws CategoryNotFoundException {

        Category category = product.getCategory();

        if (category == null){
            throw new CategoryNotFoundException("Product cannot be created without category, Please mention product category also");
        }

//        Find the category with the title
        Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

        if (optionalCategory.isEmpty()) {
            //There's no category in the DB with the given title.
            //Create a category object and save it in the DB.
            category = categoryRepository.save(category);
        } else {
            category = optionalCategory.get();
        }

        product.setCategory(category);

        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepository.deleteById(productId);
    }
}
