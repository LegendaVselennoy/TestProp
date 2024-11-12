create table if not exists dz.product
(
    id bigserial primary key not null ,
    product_id VARCHAR(3) NOT NULL ,
    status varchar(20),
    fulfilment_center char(3),
    qty integer,
    value decimal(10,2)
);