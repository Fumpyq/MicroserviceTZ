package com.example.microservice1;





import javax.ws.rs.ApplicationPath;

import javax.ws.rs.core.Application;




@ApplicationPath("/rest")
public class HelloApplication extends Application {
    /*@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();

        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);

        return resources;
    }
    public  HelloApplication (@Context ServletConfig scfg)
    {

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/docs/rest");
        beanConfig.setResourcePackage("com.example.microservice1");
        beanConfig.setScan(true);
    }*/
}
