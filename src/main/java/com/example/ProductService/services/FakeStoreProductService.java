package com.example.ProductService.services;

import com.example.ProductService.DTOs.FakeStoreProductDTO;
import com.example.ProductService.exceptions.ProductNotFoundException;
import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
//        RestTemplate restTemplate = new RestTemplate();


        throw new RuntimeException("Something went wrong.");

//        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTOResponseEntity = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDTO.class);
//
//        FakeStoreProductDTO fakeStoreProductDTO = fakeStoreProductDTOResponseEntity.getBody();
//
//        if (fakeStoreProductDTO == null){
//            throw new ProductNotFoundException("Product with id " + productId + " does not exist");
//        }
//
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getAllProducts() {

        ResponseEntity<FakeStoreProductDTO[]> fakeStoreProductDtoResposne =
                restTemplate.getForEntity("https://fakestoreapi.com/products",
                        FakeStoreProductDTO[].class);

        List<FakeStoreProductDTO> fakeStoreProductDTOS =
                List.of(fakeStoreProductDtoResposne.getBody());

        List<Product> products = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Long productId) {
        return false;
    }

    private static Product convertFakeStoreProductDtoToProduct(FakeStoreProductDTO fakeStoreProductDto) {
        if (fakeStoreProductDto == null) {
            return null;
        }

        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setImageUrl(fakeStoreProductDto.getImage());
        product.setDescription(fakeStoreProductDto.getDescription());

        Category category = new Category();
        category.setTitle(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
