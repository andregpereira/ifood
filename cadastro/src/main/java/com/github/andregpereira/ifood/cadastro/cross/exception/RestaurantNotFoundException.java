package com.github.andregpereira.ifood.cadastro.cross.exception;

import com.tietoevry.quarkus.resteasy.problem.HttpProblem;
import jakarta.ws.rs.core.Response;

import java.text.MessageFormat;
import java.util.UUID;

public class RestaurantNotFoundException extends HttpProblem {

    public static final Response.StatusType status = Response.Status.NOT_FOUND;

    public RestaurantNotFoundException(UUID id) {
        super(builder().withStatus(status).withTitle("Restaurante não encontrado").withDetail(
                MessageFormat.format("Restaurante não encontrado com id {0}", id)));
    }

}
