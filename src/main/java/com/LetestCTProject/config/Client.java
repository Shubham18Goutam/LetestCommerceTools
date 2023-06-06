package com.LetestCTProject.config;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.defaultconfig.ApiRootBuilder;
import com.commercetools.api.defaultconfig.ServiceRegion;
import io.vrap.rmf.base.client.oauth2.ClientCredentials;
import org.springframework.context.annotation.Bean;

public class Client {

    @Bean
    public static ProjectApiRoot createApiClient() {
//        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
//                .defaultClient(ClientCredentials.of()
//                                .withClientId("jevwMIWZnE_AQ3_2N7tIMQen")
//                                .withClientSecret("jzUWoFLj66Smtx1GO3ODWfVvRaLKuUoW")
//                                .build(),
//                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
//                .build("rishabh_ct");

        final ProjectApiRoot apiRoot = ApiRootBuilder.of()
                .defaultClient(ClientCredentials.of()
                                .withClientId("d1mW5xbgKdQh4-Dj_OLPEHNP")
                                .withClientSecret("soqT6UfwNbIpxSMCJ7hAh2dQ5K6ym-RS")
                                .build(),
                        ServiceRegion.GCP_AUSTRALIA_SOUTHEAST1)
                .build("sunrisedata-new");

        return apiRoot;
    }


}
