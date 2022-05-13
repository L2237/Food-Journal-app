CREATE TABLE food_items
(
    food_id   TEXT,
    food_name TEXT,
    calories  INTEGER,
    unit      DOUBLE
);

CREATE TABLE servings
(
    serving_id   TEXT,
    meal_id      TEXT,
    food_item_id TEXT,
    quantity     DOUBLE
);

