package com.github.andregpereira.ifood.cadastro.app.resource;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.app.service.RestaurantService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Path("/restaurants")
public class RestaurantResource {

    private final RestaurantService service;
    private final UriInfo uriInfo;

    @POST
    public Uni<RestResponse<RestaurantDto>> create(RestaurantCreateDto dto) {
        return service.create(dto).map(r -> {
            URI uri = uriInfo.getAbsolutePathBuilder().path("{id}").build(r.id());
            return RestResponse.ResponseBuilder.<RestaurantDto>created(uri).entity(r).build();
        });
    }

    @GET
    @Path("/{id}")
    public Uni<RestResponse<RestaurantDto>> findById(@RestPath UUID id) {
        return service.findById(id).map(RestResponse::ok);
    }

    @GET
    public Uni<RestResponse<List<RestaurantDto>>> findAll() {
        return service.findAll().map(RestResponse::ok);
    }

    @GET
    @Path("/name")
    public Uni<RestResponse<List<RestaurantDto>>> findByName(@RestQuery String name) {
        return service.findByName(name).map(RestResponse::ok);
    }

}
