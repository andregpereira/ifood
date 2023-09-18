package com.github.andregpereira.ifood.cadastro.infra.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "restaurant")
public class RestaurantEntity {

    @Id
    @GeneratedValue
    @Column(name = "restaurant_id")
    private UUID id;

    private String name;
    private String owner;
    private String cnpj;

    @CreationTimestamp
    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private OffsetDateTime modifiedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, name = "location_id", foreignKey = @ForeignKey(name = "location_id_fk"))
    private LocationEntity location;

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof RestaurantEntity restaurant))
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        return id != null && Objects.equals(id, restaurant.id);
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy hibernateProxy
                ? hibernateProxy.getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

}
