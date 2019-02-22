INSERT INTO public.dish (id, name, preparation_time, reference_text)
    VALUES
    (1, 'Macarrons bolonyesa', 30, 'macarroni.meat'),
    (2, 'Patata i monjeta tendra', 15, 'boiled.potato.beans'),
    (3, 'Sopa de peix', 60, 'soup.fish'),
    (4, 'Caldo de verdures', 120, 'brew.vegetables'),
    (5, 'Amanida verda amb burrata', 10, 'salad.green.cheese'),
    (6, 'Arros a la cubana', 20, 'rice.cuban');

INSERT INTO public.dish_ingredient (dish_id, name, reference_text, amount, unit_type)
    VALUES
    (1, 'macarrons', 'macarroni', 100, 'GRAM'),
    (1, 'salsa tomaquet', 'sauce.tomatoe', 20, 'GRAM'),
    (1, 'carn picada', 'meat.smashed', 50, 'GRAM'),
    (2, 'arros', 'rice', 100, 'GRAM'),
    (2, 'salsa de tomaquet', 'sauce.tomatoe', 30, 'GRAM'),
    (2, 'ou', 'egg', 1, 'UNIT');

INSERT INTO public.tag (id, name, reference_text)
    VALUES
    (1, 'pasta', 'pasta'),
    (2, 'plat unic', 'unique'),
    (3, 'menjar sa', 'healthy'),
    (4, 'peix', 'fish'),
    (5, 'carn', 'carn');


INSERT INTO public.dish_tag (dish_id, tag_id)
    VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (3, 4),
    (5, 3);
