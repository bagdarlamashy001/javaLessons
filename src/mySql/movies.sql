CREATE SCHEMA IF NOT EXISTS `dao_lesson` DEFAULT CHARACTER SET = `utf8mb4`;
use `dao_lesson`;

DROP TABLE dao_lesson.movie;
CREATE TABLE dao_lesson.movie(
    `id` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `nameKz` CHAR(100) NOT NULL,
    `description` VARCHAR(255) NOT NULL
);