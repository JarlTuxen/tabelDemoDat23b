DROP TABLE IF EXISTS bookstore.products;
CREATE TABLE `bookstore`.`products` (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        `name` VARCHAR(45) NULL,
                                        `genre` VARCHAR(45) NULL,
                                        `price` DECIMAL(13,2) NULL,
                                        PRIMARY KEY (`id`));
INSERT INTO bookstore.products (id, name, genre, price)
VALUES
    (1, 'The Witcher 3: Wild Hunt', 'Action RPG', 59.99),
    (2, 'Grand Theft Auto V', 'Action-Adventure', 29.99),
    (3, 'The Legend of Zelda: Breath of the Wild', 'Action-Adventure', 49.99),
    (4, 'Red Dead Redemption 2', 'Action-Adventure', 39.99),
    (5, 'Dark Souls III', 'Action RPG', 19.99),
    (6, 'Overwatch', 'First-Person Shooter', 39.99),
    (7, 'Fortnite', 'Battle Royale', 0.00),
    (8, 'Minecraft', 'Sandbox', 26.95),
    (9, 'Fallout 4', 'Action RPG', 19.99),
    (10, 'The Elder Scrolls V: Skyrim', 'Action RPG', 39.99);

