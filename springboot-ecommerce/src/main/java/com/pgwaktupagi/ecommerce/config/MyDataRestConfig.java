package com.pgwaktupagi.ecommerce.config;

import com.pgwaktupagi.ecommerce.entity.*;
import jakarta.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.stream.Collectors;


@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String[] origins;

    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE,HttpMethod.POST, HttpMethod.PATCH};

        // disable http methods for product: put,delete,post
        disableHttpMethods(Product.class,config, theUnsupportedActions);

        // disable http methods for product category: put,delete,post
        disableHttpMethods(ProductCategory.class,config, theUnsupportedActions);

        // country
        disableHttpMethods(Country.class,config, theUnsupportedActions);

        // state
        disableHttpMethods(State.class,config, theUnsupportedActions);

        // order
        disableHttpMethods(Order.class,config, theUnsupportedActions);

        // agar id tampil di response
        config.exposeIdsFor(entityManager.getMetamodel().getEntities().stream().map(e -> e.getJavaType()).collect(Collectors.toList()).toArray(new Class[0]));

        cors.addMapping(config.getBasePath() + "/**").allowedOrigins(origins);
    }

    private static void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }


}
