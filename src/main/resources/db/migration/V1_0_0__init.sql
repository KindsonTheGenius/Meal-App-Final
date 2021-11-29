-- Table: public.meal

-- DROP TABLE IF EXISTS public.meal;

CREATE TABLE IF NOT EXISTS public.meal
(
    id serial PRIMARY KEY,
    description character varying(255) COLLATE pg_catalog."default",
    gluton_free boolean,
    image_url character varying(255) COLLATE pg_catalog."default",
    ingredients character varying(255) COLLATE pg_catalog."default",
    kcal double precision,
    meal_name character varying(255) COLLATE pg_catalog."default",
    price double precision,
    spicy boolean
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.meal
    OWNER to postgres;
