CREATE TABLE "public"."restaurant" (
   "created_date" timestamp,
   "modified_date" timestamp,
   "location_id" uuid NOT NULL,
   "restaurant_id" uuid PRIMARY KEY NOT NULL,
   "cnpj" varchar(255),
   "name" varchar(255),
   "owner" varchar(255)
);

ALTER TABLE "public"."restaurant"
ADD CONSTRAINT location_id_fk
FOREIGN KEY (location_id)
REFERENCES "public"."location"(location_id);

CREATE TABLE "public"."dish" (
   "price" numeric(5,2) NOT NULL,
   "dish_id" uuid PRIMARY KEY NOT NULL,
   "restaurant_id" uuid NOT NULL,
   "description" varchar(255),
   "name" varchar(255)
);

ALTER TABLE "public"."dish"
ADD CONSTRAINT restaurant_id_fk
FOREIGN KEY (restaurant_id)
REFERENCES "public"."restaurant"(restaurant_id);