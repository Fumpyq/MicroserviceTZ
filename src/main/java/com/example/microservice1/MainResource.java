package com.example.microservice1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



@Path("/patient")
@Produces({"application/json"})
public class MainResource {
    private static final Logger log = Logger.getLogger(MainResource.class.getName());
    private Connection con=null;

    @GET
    @Produces("application/json")
    @Path("/get")
    @Operation(summary = "Находит пациента по СНИЛС",
            tags = {"Снилс,Пациент"},
            description = "Возвращает всю информацию о пациенте",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Возвращает информацию о пациенте"),
                    @ApiResponse(responseCode = "400", description = "Возникла ошибка, связанная с данными запроса"),
                    @ApiResponse(responseCode = "404", description = "Пациент не найден")
            })
    public Response GetPatientInfo(@FormParam("snils") String snils) {

        if(snils==null)
            return Response.status(400).
                entity("Снилс не указан (snils=)")
                .build();

        try {  Long SnilsNum= Long.parseLong(snils);  }
        catch ( NumberFormatException e) {return Response.status(400).
                    entity("Не верный формат снилс")
                    .build();
        }




        try {
            con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/microservice","postgres","VV22");


            Statement statement = con.createStatement();



            String Sql="select * from patient Where patient.SNILS = "+snils;
            ResultSet res =statement.executeQuery(Sql);

            if(!res.isBeforeFirst())  return Response.status(404).build();// Пациент не найден

            return Response.status(200)
                    .entity(ResultSetToJson.ToJson(res))
                    .build();

        }
        catch (SQLException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            return Response.status(500).build();
        }
        catch (IOException e) {
            log.log(Level.SEVERE, "Exception: ", e);
            return Response.status(500).build();
        }

    }
}