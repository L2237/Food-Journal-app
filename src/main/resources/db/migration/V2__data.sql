SET SESSION sql_mode='NO_AUTO_VALUE_ON_ZERO';

# FOOD_ITEMS
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (62,'orange','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (1000,'ice-cream','gram');
INSERT INTO `food_items`(`calories`,`food_name`,`unit`) VALUES (100,'pepsi','litre');


# USERS
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('alexandra','alexandra.vlad@gmail.com','abcdr456');
INSERT INTO `users`(`user_name`,`email`,`password`) VALUES ('lori','lori.toma@gmail.com','3456dfg');

# MEAL
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('BREAKFAST','2022-05-23',1);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('DINNER','2022-05-23',1);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('LUNCH','2022-05-23',1);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('LUNCH','2022-05-23',2);
INSERT INTO `meals`(`meal_type`,`meal_time`,`user`) VALUES ('DINNER','2022-05-23',2);
