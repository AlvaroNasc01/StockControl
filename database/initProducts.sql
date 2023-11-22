CREATE TABLE products (
   id serial PRIMARY KEY,
   product_name varchar(100) NOT NULL,
   category varchar(50) NOT NULL,
   provider varchar(50) NOT NULL,
   amount INTEGER NOT NULL,
   price NUMERIC(5,2) NOT NULL,
   expiration_date DATE NOT NULL
)
