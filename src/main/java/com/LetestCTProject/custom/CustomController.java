package com.LetestCTProject.custom;

import com.commercetools.api.models.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomController {

    @Autowired
    CustomService service;

    @PostMapping("/A")
    public Type createType(){
        return service.createType();
    }


}
