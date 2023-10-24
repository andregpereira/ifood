package com.github.andregpereira.ifood.cadastro.app.resource;

import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.dish.DishDto;
import com.github.andregpereira.ifood.cadastro.app.service.DishService;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Path("/restaurants/{restaurantId}/dishes")
@Tag(name = "dish")
public class DishResource {

    private @RestPath UUID restaurantId;
    private final DishService dishService;
    private final UriInfo uriInfo;

    private URI getUri(UUID id) {
        return uriInfo.getAbsolutePathBuilder().path("{id}").build(id);
    }

    @POST
    public Uni<RestResponse<DishDto>> createDish(DishCreateDto dto) {
        return dishService.create(restaurantId, dto).map(p -> ResponseBuilder.<DishDto>created(getUri(p.id())).entity(
                p).build());
    }

    @PUT
    @Path("/{dishId}")
    public Uni<RestResponse<DishDto>> updateDish(@RestPath UUID dishId, DishCreateDto dto) {
        return dishService.update(restaurantId, dishId, dto).map(p -> ResponseBuilder.<DishDto>ok().location(
                getUri(p.id())).entity(p).build());
    }

    @DELETE
    @Path("/{dishId}")
    public Uni<RestResponse<Void>> deleteDish(@RestPath UUID dishId) {
        return dishService.delete(restaurantId, dishId).replaceWith(RestResponse::ok);
    }

    @GET
    public Uni<RestResponse<List<DishDto>>> findAll() {
        return dishService.findAll().map(RestResponse::ok);
    }

}
