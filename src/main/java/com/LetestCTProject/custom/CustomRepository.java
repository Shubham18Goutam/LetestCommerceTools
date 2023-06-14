package com.LetestCTProject.custom;

import com.LetestCTProject.config.Client;
import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.type.Type;
import com.commercetools.api.models.type.TypeDraft;
import org.springframework.stereotype.Component;

@Component
public class CustomRepository {

    ProjectApiRoot apiRoot = Client.createApiClient();


    public Type createType(TypeDraft typeDraft) {
        return apiRoot.types().post(typeDraft).executeBlocking().getBody();
    }
}
