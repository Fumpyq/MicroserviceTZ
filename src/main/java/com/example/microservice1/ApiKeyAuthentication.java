package com.example.microservice1;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
@Provider
@Priority(Priorities.AUTHENTICATION)
public class ApiKeyAuthentication implements ContainerRequestFilter {


        @Override
        public void filter(ContainerRequestContext requestContext)  {

            String apiKey = requestContext.getHeaderString("Key");
            if(apiKey!=null && apiKey.equals("Simple-key"))
            {


            }
            else requestContext.abortWith( Response.status(401).build());

        }
    }

