package com.github.andregpereira.ifood.cadastro.app.resource;

import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantCreateDto;
import com.github.andregpereira.ifood.cadastro.app.dto.restaurant.RestaurantDto;
import com.github.andregpereira.ifood.cadastro.app.service.RestaurantService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.smallrye.mutiny.Uni;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Path("/restaurants")
@Tag(name = "restaurant")
@RolesAllowed("owner")
@SecurityScheme(securitySchemeName = "ifood-oauth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(
        password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/ifood/protocol/openid-connect/token")))
@SecurityRequirement(name = "ifood-oauth", scopes = {""})
public class RestaurantResource {

    private final RestaurantService restaurantService;
    private final UriInfo uriInfo;

    private URI getUri(UUID id) {
        return uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .build(id);
    }

    @POST
    public Uni<RestResponse<RestaurantDto>> createRestaurant(RestaurantCreateDto dto) {
        return restaurantService.create(dto)
                .map(r -> ResponseBuilder.<RestaurantDto>created(getUri(r.id()))
                        .entity(r)
                        .build());
    }

    @PUT
    @Path("/{id}")
    public Uni<RestResponse<RestaurantDto>> updateRestaurant(@RestPath UUID id, RestaurantCreateDto dto) {
        return restaurantService.update(id, dto)
                .map(r -> ResponseBuilder.<RestaurantDto>ok()
                        .location(getUri(r.id()))
                        .build());
    }

    @GET
    @Path("/{id}")
    public Uni<RestResponse<RestaurantDto>> findById(@RestPath UUID id) {
        return restaurantService.findById(id)
                .map(RestResponse::ok);
    }

    @GET
    @Counted("Quantidade buscas Restaurante")
    @Timed("Tempo completo de busca")
    public Uni<RestResponse<List<RestaurantDto>>> findAll() {
        return restaurantService.findAll()
                .map(RestResponse::ok);
    }

    @GET
    @Path("/name")
    public Uni<RestResponse<List<RestaurantDto>>> findByName(@RestQuery String name) {
        return restaurantService.findByName(name)
                .map(RestResponse::ok);
    }

}
