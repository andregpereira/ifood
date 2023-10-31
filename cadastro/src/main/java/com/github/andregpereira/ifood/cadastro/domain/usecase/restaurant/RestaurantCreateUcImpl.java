package com.github.andregpereira.ifood.cadastro.domain.usecase.restaurant;

import com.github.andregpereira.ifood.cadastro.domain.gateway.RestaurantGateway;
import com.github.andregpereira.ifood.cadastro.domain.model.Restaurant;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.Claims;

@RequiredArgsConstructor
@Slf4j
@ApplicationScoped
public class RestaurantCreateUcImpl implements RestaurantCreateUc {

    private final RestaurantGateway gateway;

    @Claim(standard = Claims.sub)
    private ClaimValue<String> sub;

    @Override
    public Uni<Restaurant> create(Restaurant restaurant) {
        restaurant.setOwner(sub.getValue());
        return gateway.create(restaurant);
    }

}
