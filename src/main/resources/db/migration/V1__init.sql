--Department Table Create Script
CREATE TABLE IF NOT EXISTS public.department
(
    id uuid NOT NULL,
    name text NOT NULL,
    CONSTRAINT department_pkey PRIMARY KEY(id)
);

--Employee Table Create Script
CREATE TABLE IF NOT EXISTS public.employee
(
    id uuid NOT NULL,
    first_name text NOT NULL,
    last_name text,
    designation text NOT NULL,
    country text NOT NULL,
    dept_id uuid NOT NULL,
    CONSTRAINT employee_pkey PRIMARY KEY (id, country),
    CONSTRAINT dept_id_fkey FOREIGN KEY(dept_id) REFERENCES department(id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT country_unique UNIQUE(country)
) PARTITION BY LIST (country);

-- Employee Table Partitions SQL

CREATE TABLE IF NOT EXISTS public.employee_australia PARTITION OF public.employee
    FOR VALUES IN ('AU');

CREATE TABLE IF NOT EXISTS public.employee_default PARTITION OF public.employee
    DEFAULT;

CREATE TABLE IF NOT EXISTS public.employee_india PARTITION OF public.employee
    FOR VALUES IN ('IN');

CREATE TABLE IF NOT EXISTS public.employee_sweden PARTITION OF public.employee
    FOR VALUES IN ('SE');

CREATE TABLE IF NOT EXISTS public.employee_united_states PARTITION OF public.employee
    FOR VALUES IN ('US');

-- Product Table Create Script
CREATE TABLE IF NOT EXISTS public.product
(
    id uuid NOT NULL,
    name text NOT NULL,
    price bigint,
    country text NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY(id, country)
) PARTITION BY LIST(country);

-- Product Table Partitions SQL

CREATE TABLE IF NOT EXISTS public.product_australia PARTITION OF public.product
    FOR VALUES IN ('AU');

CREATE TABLE IF NOT EXISTS public.product_default PARTITION OF public.product
    DEFAULT;

CREATE TABLE IF NOT EXISTS public.product_india PARTITION OF public.product
    FOR VALUES IN ('IN');

CREATE TABLE IF NOT EXISTS public.product_sweden PARTITION OF public.product
    FOR VALUES IN ('SE');

CREATE TABLE IF NOT EXISTS public.product_united_states PARTITION OF public.product
    FOR VALUES IN ('US');

-- Sales Table Create Script
CREATE TABLE IF NOT EXISTS public.sales
(
    id uuid NOT NULL,
    employee_id uuid NOT NULL,
    total_amount bigint,
    country text NOT NULL,
    discount bigint DEFAULT 0,
    CONSTRAINT sales_pkey PRIMARY KEY(id, country),
    CONSTRAINT employee_fkey FOREIGN KEY(employee_id) REFERENCES public.employee(id) ON UPDATE CASCADE ON DELETE CASCADE
) PARTITION BY LIST(country);

-- Sales Table Partitions SQL

CREATE TABLE IF NOT EXISTS public.sales_australia PARTITION OF public.sales
    FOR VALUES IN ('AU');

CREATE TABLE IF NOT EXISTS public.sales_default PARTITION OF public.sales
    DEFAULT;

CREATE TABLE IF NOT EXISTS public.sales_india PARTITION OF public.sales
    FOR VALUES IN ('IN');

CREATE TABLE IF NOT EXISTS public.sales_sweden PARTITION OF public.sales
    FOR VALUES IN ('SE');

CREATE TABLE IF NOT EXISTS public.sales_united_states PARTITION OF public.sales
    FOR VALUES IN ('US');

-- Order Table Create Script
CREATE TABLE IF NOT EXISTS public.order
(
    id uuid NOT NULL,
    product_id uuid NOT NULL,
    sales_id uuid NOT NULL,
    quantity bigint NOT NULL,
    amount bigint NOT NULL,
    country text NOT NULL,
    CONSTRAINT order_pkey PRIMARY KEY(id, country),
    CONSTRAINT product_fkey FOREIGN KEY(product_id) REFERENCES public.product(id) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT sales_fkey FOREIGN KEY(sales_id) REFERENCES public.sales(id) ON UPDATE CASCADE ON DELETE CASCADE
) PARTITION BY LIST(country);

-- Order Table Partitions SQL

CREATE TABLE IF NOT EXISTS public.australia PARTITION OF public.order
    FOR VALUES IN ('AU');

CREATE TABLE IF NOT EXISTS public."default" PARTITION OF public.order
    DEFAULT;

CREATE TABLE IF NOT EXISTS public.india PARTITION OF public.order
    FOR VALUES IN ('IN');

CREATE TABLE IF NOT EXISTS public.sweden PARTITION OF public.order
    FOR VALUES IN ('SE');

CREATE TABLE IF NOT EXISTS public.united_states PARTITION OF public.order
    FOR VALUES IN ('US');