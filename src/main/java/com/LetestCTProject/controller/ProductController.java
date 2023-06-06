package com.LetestCTProject.controller;

import com.LetestCTProject.config.Client;
import com.LetestCTProject.service.ProductService;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.CartPagedQueryResponse;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import com.commercetools.api.models.product.*;
import com.commercetools.api.models.product_type.AttributeType;
import com.commercetools.api.models.product_type.ProductTypePagedQueryResponse;
import io.vrap.rmf.base.client.ApiHttpResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ProductController {

    ProjectApiRoot apiRoot= Client.createApiClient();
    @Autowired
    ProductService productService;

//    @GetMapping("GetAllProducts")
//     public ProductPagedQueryResponse getAllProducts(){
//        return apiRoot.products().get().executeBlocking().getBody();
//    }


    @GetMapping("GetAllByMono")
    public Mono<ProductPagedQueryResponse> getAllProducts(){
        return Mono.fromFuture(apiRoot.products().get().execute().thenApply(ApiHttpResponse::getBody));
    }




    @GetMapping("GetAllByFlux")
    public Flux<ProductPagedQueryResponse> getAllByFlux(){
        return Flux.fromIterable(Collections.singleton(apiRoot.products().get().executeBlocking().getBody()));
    }

//    @GetMapping("GetAllByProjection")
//    public ProductProjectionPagedQueryResponse getAllProductsByProjection(String id){
//        return (ProductProjectionPagedQueryResponse) apiRoot.productProjections().w;
//    }


    @GetMapping("/products-filterSize")
    ProductProjectionPagedSearchResponse productGetByfilter(){
        return productService.productGetByFilter();

    }

    @GetMapping("Mens")
    ProductProjectionPagedSearchResponse productByProjection(){
        return productService.MensProduct();
    }

    @GetMapping("/JacketMens")
    ProductProjectionPagedSearchResponse mensJacket (){
        return productService.mensJacket();
    }

    @GetMapping("/MensTop")
    ProductProjectionPagedSearchResponse mensTop (){
        return productService.mensTop();
    }


    @GetMapping("/TrouserMen")
    ProductProjectionPagedSearchResponse mensTrousers (){
        return productService.mensTrousers();
    }

    @GetMapping("/MensShirt")
    ProductProjectionPagedSearchResponse mensShirt (){
        return productService.mensShirt();
    }

    @GetMapping("/MensJeans")
    ProductProjectionPagedSearchResponse mensJeans (){
       return productService.mensJeans();
    }
    @GetMapping("/MensTShirt")
    ProductProjectionPagedSearchResponse mensTshirt (){
        return productService.mensTshirt();
    }

    @GetMapping("/MensBLzer")
    ProductProjectionPagedSearchResponse mensBlazer (){
        return productService.mensBlazer();
    }

    @GetMapping("/MensSuit")
    ProductProjectionPagedSearchResponse mensSuit (){
        return productService.mensSuit();
    }

    @GetMapping("/AllProducts")
    ProductProjectionPagedSearchResponse AllProducts(@RequestParam String id){

        return productService.AllProduct(id);
    }


    @GetMapping("/TwoProducts/{id},{id2}")
    ProductProjectionPagedSearchResponse TwoProducts(@PathVariable String id,@PathVariable String id2){
        return productService.TwoProducts(id, id2);
    }

    @GetMapping("/getByColor")
    ProductProjectionPagedSearchResponse getByColor(){
        return productService.GetByColor();
    }
    @GetMapping("/getById/{id}")
    ProductProjectionPagedSearchResponse getByIdColor(@PathVariable String id,@RequestParam String color,@RequestParam String size){
        return productService.getByIdColor(id,color,size);
    }

//    @GetMapping("/getByColor")
//    List<ProductProjection> getByColor() {
//        ProductProjectionPagedSearchResponse response = productService.GetByColor();
//        System.out.println(response.toString());
//        return response.getResults();
//    }

    @GetMapping("/GetCategories")
    CategoryPagedQueryResponse getCategory(){
        return productService.getCategories();
    }

    @GetMapping("/CategoryByFilter")
    List<Category> getCategoryy(){
        return productService.getCategory();
    }

    @GetMapping("/c")

    public List<AttributeType> getColorList() {

        return apiRoot.productTypes().get().executeBlocking().getBody()
                .getResults().stream().map(productType -> {
          return   productType.getAttribute("color").getType();
        }).collect(Collectors.toList());

//        ProductTypePagedQueryResponse response = apiRoot.productTypes().get().executeBlocking().getBody();
//
//        return response.getResults().stream().map(productType ->
//             productType.getAttribute("color").getType()).collect(Collectors.toList());

    }

    @GetMapping("/cc")
    public List<AttributeType> getColor(){
        return productService.getColor();
    }

    @GetMapping("/getColorByFacet")
    public ProductProjectionPagedSearchResponse getColorByFacet(){
        return productService.getColorByFacet();
    }

}
