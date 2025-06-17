package com.example.ProductService.repositories;

import com.example.ProductService.models.Category;
import com.example.ProductService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    //select * from Product where id = ?
    @Override
    Optional<Product> findById(Long prodjuctId);

    @Override
    List<Product> findAll();

    //iPhone
    //select * from products where lower(title) LIKE '%iphone%'
    List<Product> findByTitleContainsIgnoreCase(String title);

    //find all the products where price >= 100 and <= 1000
    List<Product> findByPriceBetween(Double priceAfter, Double priceBefore);

    //select * from products where category_id = category.id;
    List<Product> findByCategory(Category category);

    List<Product> findAllByCategory_Id(Long categoryId);

    //JOIN Query
    List<Product> findAllByCategory_Title(String categoryTitle);

//     update + insert => upsert
    Product save(Product product);

    @Override
    void deleteById(Long productId);

    @Query(value = "select * from products p where p.id = :id", nativeQuery = true)
    Product findProductWithGivenId(@Param("id") Long productId);
}
