CREATE TABLE users
(
    user_id   INTEGER NOT NULL AUTO_INCREMENT,
    user_name TEXT,
    email  TEXT,
    password TEXT,
    PRIMARY KEY (user_id)
);

CREATE TABLE meals
(
    meal_id   INTEGER NOT NULL AUTO_INCREMENT,
    meal_type TEXT,
    meal_time  DATE,
    user INTEGER,
    PRIMARY KEY (meal_id),
    FOREIGN KEY (user) REFERENCES users(user_id)
);

CREATE TABLE food_items
(
    food_id   BIGINT NOT NULL AUTO_INCREMENT,
    food_name TEXT,
    calories  DOUBLE,
    unit      TEXT,
    PRIMARY KEY (food_id)
);

CREATE TABLE meal_servings
(
    serving_id INTEGER NOT NULL AUTO_INCREMENT,
    food_item  BIGINT,
    meal_id    INTEGER,
    quantity   DOUBLE,
    calories_per_serving DOUBLE,
    PRIMARY KEY (serving_id),
    FOREIGN KEY (food_item) REFERENCES food_items(food_id),
    FOREIGN KEY (meal_id) REFERENCES meals(meal_id)
);

