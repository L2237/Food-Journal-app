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

CREATE TABLE user
(
     user_Id    TEXT,
     user_Name  TEXT,
     email      TEXT,
     password   TEXT

);

CREATE TABLE meal
(
    meal_Id     TEXT,
    date        TEXT,
    user_Id     TEXT
);
