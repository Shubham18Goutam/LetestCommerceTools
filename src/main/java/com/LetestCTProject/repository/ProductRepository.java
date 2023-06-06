package com.LetestCTProject.repository;

import com.LetestCTProject.config.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import com.commercetools.api.models.product.FacetResults;
import com.commercetools.api.models.product.ProductProjection;
import com.commercetools.api.models.product.ProductProjectionPagedSearchResponse;
import com.commercetools.api.models.product_type.AttributeType;
import com.commercetools.api.models.product_type.ProductType;
import com.commercetools.api.models.product_type.ProductTypePagedQueryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ProductRepository {

    ProjectApiRoot apiRoot = Client.createApiClient();

    public ProductProjectionPagedSearchResponse productGetByFilter() {
        return apiRoot.productProjections().search().get()
                .addFilter("productType.id:\"47137e17-bff3-44a6-a7b3-026b17bee6ec\"").executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse mensProduct() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"148dd93a-def1-482e-b9fc-9735905f3e90\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse mensJacket() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"8a3a21eb-cb1d-4253-935e-a9d9c4f256b0\")").executeBlocking().getBody();
    }

    public ProductProjectionPagedSearchResponse mensTop() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"d5f6116e-c538-4c43-8ed2-c088689e4e43\")")
                .executeBlocking()
                .getBody();
    }


    public ProductProjectionPagedSearchResponse mensTrousers() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"d56d50c7-b160-4f76-b7ea-6d0c031eeaef\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse mensShirt() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"d732a651-f539-46d5-87ee-808cb31f65b3\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse mensJeans() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"f91e35f3-93d4-4ab7-a86a-aeb28f420970\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse mensTshirt() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"ad95a62b-a590-468e-8d0b-3e04e6d033bb\")")
                .executeBlocking()
                .getBody();

    }

    public ProductProjectionPagedSearchResponse mensBlazer() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"3b5c9826-abc4-45e7-b29e-351cb391f929\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse mensSuit() {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id: subtree(\"ae82e5a3-e807-49c4-a743-997a04a22ae2\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse allProducts(String id) {
        return apiRoot.productProjections()
                .search()
                .get()
                .withFilter("categories.id: " + id + "")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse twoProducts(String id, String id2) {
        return apiRoot.productProjections()
                .search()
                .get()
                //.addFacet("categories.id: subtree(\""+id+"\"), subtree(\""+id2+"\")")
                .addFilter("categories.id: subtree(\"" + id + "\"), subtree(\"" + id2 + "\")")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse getByColor() {
        return apiRoot.productProjections().search().get()
                .addFilter("categories.id: subtree(\"d732a651-f539-46d5-87ee-808cb31f65b3\")")
//                .addFacet("variants.attributes.color.label.en+counting+products")
                .addFilterQuery("variants.attributes.color.label.en:\"blue\"")
                .executeBlocking()
                .getBody();
    }

    public ProductProjectionPagedSearchResponse getByIdColor(String id, String color,String size) {
        return apiRoot.productProjections()
                .search()
                .get()
                .addFilter("categories.id:\""+id+"\"")
                .addFilter("variants.attributes.color.key:\""+color+"\"")
                .addFilter("variants.attributes.color.key:\""+size+"\"")
                .executeBlocking().getBody();
    }

    public CategoryPagedQueryResponse getCategaries() {
        return apiRoot.categories()
                .get()
                .executeBlocking()
                .getBody();
    }
    public List<Category> getCategory(){
        CategoryPagedQueryResponse response=apiRoot.categories().get().executeBlocking().getBody();
        List<Category> categories= response.getResults().stream().filter(category -> category.getAncestors().isEmpty()).collect(Collectors.toList());
        return categories;
    }

    public List<AttributeType> getColor() {
        return apiRoot.productTypes().get().executeBlocking().getBody()
                .getResults().stream().map(productType -> {
                    return   productType.getAttribute("color").getType();
                }).collect(Collectors.toList());
    }

    public ProductProjectionPagedSearchResponse getColorByFacet() {
        return apiRoot.productProjections().search().get()
               // .addFilter("productType.id:\"47137e17-bff3-44a6-a7b3-026b17bee6ec\"")
//                .addFacet("category.id:\"148dd93a-def1-482e-b9fc-9735905f3e90\"")
                .addFacet("variants.attributes.color.key counting products")
                .addFacet("variants.attributes.commonSize.key counting products")
                .addFacet("variants.attributes.size counting products")
                .addFacet("variants.attributes.creationDate counting products")
                .addFacet("variants.price.centAmount:range (0 to 10000)")
                .withFilterFacets("categories.id:\"ad95a62b-a590-468e-8d0b-3e04e6d033bb\"")

//                .addFilterFacets("variants.attributes.commonSize.key")

                .executeBlocking()
                .getBody();
    }


//    public List<ProductTypePagedQueryResponse> getColorList() {
//       // ProductTypePagedQueryResponse response=
//         return apiRoot.productTypes().get().executeBlocking().getBody();
//       // List<ProductType> productTypes= response.getResults()
//    }
}
