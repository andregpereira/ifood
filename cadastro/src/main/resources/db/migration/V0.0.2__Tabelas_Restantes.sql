CREATE TABLE tb_restaurant (
   restaurant_id UUID NOT NULL,
   name VARCHAR(255),
   owner VARCHAR(255),
   cnpj VARCHAR(255),
   created_date TIMESTAMP WITHOUT TIME ZONE,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   location_id UUID NOT NULL,
   CONSTRAINT pk_tb_restaurant PRIMARY KEY (restaurant_id)
);

ALTER TABLE tb_restaurant
ADD CONSTRAINT LOCATION_ID_FK
FOREIGN KEY (location_id)
REFERENCES tb_location (location_id);

CREATE TABLE tb_dish (
   dish_id UUID NOT NULL,
   name VARCHAR(255),
   description VARCHAR(255),
   price DECIMAL(5, 2) NOT NULL,
   restaurant_id UUID NOT NULL,
   CONSTRAINT pk_tb_dish PRIMARY KEY (dish_id)
);

ALTER TABLE tb_dish
ADD CONSTRAINT RESTAURANT_ID_FK
FOREIGN KEY (restaurant_id)
REFERENCES tb_restaurant (restaurant_id);
