DROP TABLE IF EXISTS mess CASCADE;
CREATE TABLE mess
(
    item_id SERIAL PRIMARY KEY,
    item_name varchar(255) NOT NULL ,
    item_quantity INT NOT NULL,
    total_price INT NOT NULL,
    month_name varchar(255) NOT NULL,
    year INT NOT NULL
);