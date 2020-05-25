/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  XC
 * Created: 2020-05-13
 */
--------------------------------------
--        CREATE SEQUENCES          --
-------------------------------------- 
CREATE SEQUENCE public.users_category_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.users_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.products_category_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

CREATE SEQUENCE public.products_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;
--------------------------------------


--------------------------------------
--           DROP TABLES            --
-------------------------------------- 
DROP TABLE IF EXISTS public.users_category CASCADE;
DROP TABLE IF EXISTS public.users CASCADE;
DROP TABLE IF EXISTS public.product_category CASCADE;
DROP TABLE IF EXISTS public.products CASCADE;
--------------------------------------


--------------------------------------
--         CREATE TABLES            --
-------------------------------------- 
CREATE TABLE IF NOT EXISTS users_category (
    id INT NOT NULL DEFAULT nextval('users_category_id_seq'::regclass),
    user_category character varying NOT NULL,
    CONSTRAINT users_category_id_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS users (
    id INT NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    id_user_category INT NOT NULL,
    user_name character varying NOT NULL,
    user_lastname character varying NOT NULL,
    login character varying NOT NULL,
    password character varying NOT NULL DEFAULT '098f6bcd4621d373cade4e832627b4f6'::character varying,
    CONSTRAINT users_id_pkey PRIMARY KEY (id),
    CONSTRAINT users_id_category_fkey FOREIGN KEY (id_user_category)
        REFERENCES public.users_category (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS product_category (
    id INT NOT NULL DEFAULT nextval('products_category_id_seq'::regclass),
    product_category character varying NOT NULL,
    CONSTRAINT product_category_id_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS products (
    id INT NOT NULL DEFAULT nextval('products_id_seq'::regclass),
    id_product_category INT NOT NULL,
    product_name character varying,
    product_autor_name character varying,
    product_autor_lastname character varying,
    product_country_name character varying,
    product_cost INT,
    CONSTRAINT products_id_pkey PRIMARY KEY (id),
    CONSTRAINT products_id_product_category_fkey FOREIGN KEY (id_product_category)
        REFERENCES public.product_category (id) MATCH SIMPLE
        ON UPDATE RESTRICT
        ON DELETE SET NULL
);
--------------------------------------


--------------------------------------
--              INSERTS             --
-------------------------------------- 
INSERT INTO users_category (id, user_category) VALUES (default,'pracownik');
INSERT INTO users_category (id, user_category) VALUES (default,'uzytkownik');
INSERT INTO users_category (id, user_category) VALUES (default,'kierownik');
--------------------------------------
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 3, 'Damian', 'Holecki', 'dholecki', 'dholecki123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 1, 'Lucjan', 'Włodarczyk', 'lwlodarczyk', 'lwlodarczyk123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 1, 'Robert', 'Mazur', 'rmazur', 'rmazur123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 1, 'Olaf', 'Zakrzewski', 'ozakrzewski', 'ozakrzewski123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 2, 'Ada', 'Urbańska', 'aurbanska', 'aurbanska123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 2, 'Agnieszka', 'Głowacka', 'aglowacka', 'aglowacka123');
INSERT INTO users (id, id_user_category, user_name, user_lastname, login, password) VALUES (default, 2, 'Klara', 'Witkowska', 'kwitkowska', 'kwitkowska123');
--------------------------------------
INSERT INTO product_category (id, product_category) VALUES (default, 'Książki');
INSERT INTO product_category (id, product_category) VALUES (default, 'Filmy');
INSERT INTO product_category (id, product_category) VALUES (default, 'Muzyka');
--------------------------------------
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 1, 'Agent Of The Banished', 'Jessie', 'Rock', 'United States of America', 35);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 1, 'Vulture Of Gold', 'Judith', 'Alexander', 'Turkey', 42);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 1, 'Men And Butchers', 'Jasmin', 'Sterling', 'United States of America', 32);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 2, 'Wolf Of History', 'Morgan', 'Stewart', 'Canada', 64);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 2, 'Guardians Of The North', 'Maya', 'Shepherd', 'Italy', 67);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 2, 'Country Of Dreams', 'Kristina', 'Chase', 'Virgin Islands', 72);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 3, 'Methodical madness', 'Jacob', 'Thomas', 'England', 98);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 3, 'Fascination', 'Nick', 'Blue', 'England', 37);
INSERT INTO products (id, id_product_category, product_name, product_autor_name, product_autor_lastname, product_country_name, product_cost) VALUES (default, 3, 'Bitten bullet', 'Damian', 'Griffin', 'Canada',66);