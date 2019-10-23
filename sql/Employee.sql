-- Table: public.employee

-- DROP TABLE public.employee;

CREATE TABLE public.employee
(
    id uuid NOT NULL,
    first_name text COLLATE pg_catalog."default" NOT NULL,
    last_name text COLLATE pg_catalog."default",
    designation text COLLATE pg_catalog."default" NOT NULL,
    country text COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id, country)
) PARTITION BY LIST (country)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;

-- Partitions SQL

CREATE TABLE public.australia PARTITION OF public.employee
    FOR VALUES IN ('AU');

CREATE TABLE public."default" PARTITION OF public.employee
    DEFAULT;

CREATE TABLE public.india PARTITION OF public.employee
    FOR VALUES IN ('IN');

CREATE TABLE public.sweden PARTITION OF public.employee
    FOR VALUES IN ('SE');

CREATE TABLE public.united_states PARTITION OF public.employee
    FOR VALUES IN ('US');