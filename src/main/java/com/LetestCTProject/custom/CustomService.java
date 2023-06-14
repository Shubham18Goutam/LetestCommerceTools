package com.LetestCTProject.custom;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.ProductResourceIdentifier;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.commercetools.api.models.state.StateResourceIdentifier;
import com.commercetools.api.models.type.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomService {
@Autowired
    CustomRepository customRepository;


    public Type createType(){
        FieldDefinition fieldDefinition = FieldDefinition
                .builder()
                //.type(FieldTypeBuilder::numberBuilder)

                .type(FieldType.stringBuilder().build())
                .name("image")
                //.inputHint(TypeTextInputHint.SINGLE_LINE)
                .label(LocalizedString.ofEnglish("image"))
                .required(true)
                .build();

// Create typeDraft with the FieldDefinition
        final TypeDraft typeDraft = TypeDraft
                .builder()
                .key("a333")
                .name(LocalizedString.ofEnglish("image"))
                .resourceTypeIds(ResourceTypeId.REVIEW)
                .fieldDefinitions(fieldDefinition)
//                    .resourceTypeIds(List.of(ResourceTypeId.CUSTOMER))
//                    .fieldDefinitions(List.of(fieldDefinition))
                .build();
        return customRepository.createType(typeDraft);
    }





}
