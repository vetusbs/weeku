CREATE TABLE public.dish (
  id SERIAL NOT NULL,
  name text NOT NULL,
  preparation_time INTEGER,
  reference_text text NOT NULL,
  created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TYPE public.unit_type AS ENUM (
  'UNIT',
  'LITTLE_SPOON',
  'BIG_SPOON',
  'GRAM',
  'LITRE'
);

CREATE TABLE public.dish_ingredient (
  id SERIAL NOT NULL,
  dish_id INTEGER NOT NULL,
  name text NOT NULL,
  reference_text text NOT NULL,
  amount DECIMAL NOT NULL,
  unit_type public.unit_type DEFAULT 'UNIT'::public.unit_type,
  created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (dish_id) REFERENCES dish (id)
);

CREATE TABLE public.tag (
  id SERIAL NOT NULL,
  name text NOT NULL,
  reference_text text NOT NULL,
  created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE public.dish_tag (
  id SERIAL NOT NULL,
  dish_id INTEGER NOT NULL,
  tag_id INTEGER NOT NULL,
  created timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated timestamp with time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (dish_id) REFERENCES dish (id),
  FOREIGN KEY (tag_id) REFERENCES tag (id)
);

CREATE OR REPLACE FUNCTION update_updated_column()
  RETURNS TRIGGER AS
$$
BEGIN
  NEW.updated = now();
  RETURN NEW;
END;
$$
language 'plpgsql';

CREATE TRIGGER update_dish_date
  BEFORE UPDATE
  ON dish
  FOR EACH ROW
EXECUTE PROCEDURE update_updated_column();
