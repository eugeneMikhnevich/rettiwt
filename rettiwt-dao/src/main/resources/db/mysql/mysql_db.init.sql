CREATE DATABASE rettiwt;
use rettiwt;

CREATE TABLE `account` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`created_at` TIMESTAMP NOT NULL,
	`updated_at` TIMESTAMP NOT NULL,
	`email` varchar(100) NOT NULL,
	`password` varchar(50) NOT NULL,
	`phone` varchar(30),
	`deleted` BOOLEAN NOT NULL DEFAULT false,
	PRIMARY KEY (`id`)
);

CREATE TABLE `profile` (
	`id` bigint NOT NULL,
	`created_at` TIMESTAMP NOT NULL,
	`updated_at` TIMESTAMP NOT NULL,
	`first_name` varchar(100) NOT NULL,
	`last_name` varchar(100) NOT NULL,
	`nickname` varchar(100) NOT NULL,
	`description` varchar(200),
	`location` varchar(100),
	PRIMARY KEY (`id`)
);

CREATE TABLE `profile_2_subscriber` (
	`profile_id` bigint NOT NULL,
	`subscriber_id` bigint NOT NULL
);

CREATE TABLE `post` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`created_at` TIMESTAMP NOT NULL,
	`updated_at` TIMESTAMP NOT NULL,
	`profile_id` bigint NOT NULL,
	`message` varchar(350) NOT NULL,
	`likes` INT NOT NULL DEFAULT '0',
	`dislikes` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
);

CREATE TABLE `comment` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`created_at` TIMESTAMP NOT NULL,
	`updated_at` TIMESTAMP NOT NULL,
	`profile_id` bigint NOT NULL,
	`post_id` bigint NOT NULL,
	`message` varchar(350) NOT NULL,
	`likes` INT NOT NULL DEFAULT '0',
	`dislikes` INT NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
);

ALTER TABLE `profile` ADD CONSTRAINT `profile_fk0` FOREIGN KEY (`id`) REFERENCES `account`(`id`);

ALTER TABLE `profile_2_subscriber` ADD CONSTRAINT `profile_2_subscriber_fk0` FOREIGN KEY (`profile_id`) REFERENCES `profile`(`id`);

ALTER TABLE `profile_2_subscriber` ADD CONSTRAINT `profile_2_subscriber_fk1` FOREIGN KEY (`subscriber_id`) REFERENCES `profile`(`id`);

ALTER TABLE `post` ADD CONSTRAINT `post_fk0` FOREIGN KEY (`profile_id`) REFERENCES `profile`(`id`);

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk0` FOREIGN KEY (`profile_id`) REFERENCES `profile`(`id`);

ALTER TABLE `comment` ADD CONSTRAINT `comment_fk1` FOREIGN KEY (`post_id`) REFERENCES `post`(`id`);


INSERT INTO account (id, created_at, updated_at, email, password, phone, deleted) VALUES (1, '2019-07-16 17:18:35.465', '2019-07-16 17:18:35.465', 'new@mail', 'newPsw', NULL, false);
INSERT INTO profile (id, created_at, updated_at, first_name, last_name, nickname, description, location) VALUES (1, '2019-07-16 17:18:35.465', '2019-07-16 17:18:35.465', 'Eugene', 'Mikh', '@eugene_mikh', NULL, 'Grodno, BY');
INSERT INTO post (id, created_at, updated_at, profile_id, message, likes, dislikes) VALUES (1, '2019-07-17 14:02:17.085827', '2019-07-17 14:02:17.085827', 1, 'post with id = 4', 0, 0);

INSERT INTO comment (id, created_at, updated_at, profile_id, post_id, message, likes, dislikes) VALUES (1, '2019-07-17 14:02:39.821344', '2019-07-17 14:02:39.821344', 1, 1, 'comment 1 under post 1', 0, 0);
INSERT INTO comment (id, created_at, updated_at, profile_id, post_id, message, likes, dislikes) VALUES (2, '2019-07-17 14:02:48.621007', '2019-07-17 14:02:48.621007', 1, 1, 'comment 2 under post 1', 0, 0);
