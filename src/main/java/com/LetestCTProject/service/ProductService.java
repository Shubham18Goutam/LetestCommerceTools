package com.LetestCTProject.service;

import com.LetestCTProject.repository.ProductRepository;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import com.commercetools.api.models.product.FacetResults;
import com.commercetools.api.models.product.ProductProjection;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import com.commercetools.api.models.product_type.AttributeType;
import com.commercetools.api.models.product_type.ProductType;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class ProductService {

ProductRepository productRepository= new ProductRepository();
   public ProductProjectionPagedSearchResponse productGetByFilter(){
       return productRepository.productGetByFilter();

   }

    public ProductProjectionPagedSearchResponse MensProduct(){
        return productRepository.mensProduct();
    }
    public ProductProjectionPagedSearchResponse mensJacket(){

       return productRepository.mensJacket();
    }
    public ProductProjectionPagedSearchResponse mensTop(){

       return productRepository.mensTop();
    }
    public ProductProjectionPagedSearchResponse mensTrousers(){

       return productRepository.mensTrousers();
    }
    public ProductProjectionPagedSearchResponse mensShirt(){

       return productRepository.mensShirt();
    }
    public ProductProjectionPagedSearchResponse mensJeans(){

       return productRepository.mensJeans();
    }
    public ProductProjectionPagedSearchResponse mensTshirt(){

       return productRepository.mensTshirt();
    }
    public ProductProjectionPagedSearchResponse mensBlazer(){

       return productRepository.mensBlazer();
    }
    public ProductProjectionPagedSearchResponse mensSuit(){

       return productRepository.mensSuit();
    }
    public ProductProjectionPagedSearchResponse AllProduct(String id){

       return productRepository.allProducts(id);
    }
    public ProductProjectionPagedSearchResponse TwoProducts(String id,String id2){
       return productRepository.twoProducts(id,id2);
    }


    public ProductProjectionPagedSearchResponse GetByColor(){
       return productRepository.getByColor();
    }

    public ProductProjectionPagedSearchResponse getByIdColor(String id, String color,String size) {
       return productRepository.getByIdColor(id,color,size);
    }

    public CategoryPagedQueryResponse getCategories(){
       return productRepository.getCategaries();
    }
    public List<Category> getCategory(){
       return productRepository.getCategory();
    }

    public List<AttributeType> getColor(){
       return productRepository.getColor();
    }


//    public List<ProductType> getColor(){
//       return productRepository.getColorList();
//    }

    public ProductProjectionPagedSearchResponse getColorByFacet(){
       return productRepository.getColorByFacet();
    }





}
