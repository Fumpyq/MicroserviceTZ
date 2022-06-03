package com.example.microservice1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundHandler implements ExceptionMapper<NotFoundException> {

    @Context
    private HttpHeaders headers;
    @Operation(summary = "Обрабатывает любые не поддержываемые методы",
            tags = {"405"},
            description = "выдает 405 на любые несуществующие методы",
            responses = {
                    @ApiResponse(responseCode = "405", description = "Без тела ответа"),

            })
    public Response toResponse(NotFoundException ex){
        Object yourMessage;
        return Response.status(405).build();
    }

}