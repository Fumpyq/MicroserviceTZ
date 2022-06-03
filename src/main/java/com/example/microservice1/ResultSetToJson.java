package com.example.microservice1;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.json.Json;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToJson  {


    public static String ToJson(final ResultSet rs)
            throws SQLException, IOException {


        JsonFactory jf = new JsonFactory();
        StringWriter sw=new StringWriter();
        JsonGenerator jg = jf.createGenerator(sw);
        jg.setCodec(new ObjectMapper());
        jg.useDefaultPrettyPrinter();

        RsToJson(rs, jg);
        return sw.toString();
    }

    public static void ToJson(final ResultSet rs,
                              final JsonGenerator jg)
            throws SQLException, IOException {
        RsToJson(rs, jg);
    }



    private static void RsToJson(ResultSet rs, JsonGenerator jg) throws SQLException, IOException {
        final var rsmd = rs.getMetaData();
        final var columnCount = rsmd.getColumnCount();
        jg.writeStartArray();
        while (rs.next()) {
            jg.writeStartObject();
            for (var i = 1; i <= columnCount; i++) {
                jg.writeObjectField(rsmd.getColumnName(i), rs.getObject(i).toString());
            }
            jg.writeEndObject();
        }
        jg.writeEndArray();
    }
}