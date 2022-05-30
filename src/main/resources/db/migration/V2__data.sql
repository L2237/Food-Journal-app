SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';

# FOOD_ITEMS
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (0.47,'orange','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (20.7,'ice-cream','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (2.48,'beef','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (2.18,'chicken','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (2.42,'pork','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (1.45,'ham','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (0.45,'orange juice','litre');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (0.43,'beer','litre');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (2.65,'bread','gram');

# USERS
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('maria','maria.popescu@gmail.com','abcdr456');
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('marius','marius.alb@gmail.com','absdfr4dr456');
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('irina','irina.escu@gmail.com','aAADF$%_');
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('lori','loredana.toma@gmail.com','3456dfg');

# MEAL
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('BREAKFAST','2022-05-23',1);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('LUNCH','2022-05-23',1);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('DINNER','2022-05-23',1);

INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('BREAKFAST','2022-05-23',2);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('LUNCH','2022-05-23',2);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('DINNER','2022-05-23',2);

# SERVINGS
INSERT INTO `meal_servings`(`food_item`,`meal_id`,`quantity`, calories_per_serving) VALUES (1,1,100,47);
INSERT INTO `meal_servings`(`food_item`,`meal_id`,`quantity`, calories_per_serving) VALUES (2,1,100,47);
INSERT INTO `meal_servings`(`food_item`,`meal_id`, `quantity`, calories_per_serving) VALUES (9,2,150,65);
INSERT INTO `meal_servings`(`food_item`,`meal_id`,`quantity`, calories_per_serving) VALUES (6,3,5,1);



