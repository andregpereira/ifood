CREATE TABLE tb_location (
   location_id UUID NOT NULL,
   latitude DOUBLE PRECISION NOT NULL,
   longitude DOUBLE PRECISION NOT NULL,
   CONSTRAINT pk_tb_location PRIMARY KEY (location_id)
);
