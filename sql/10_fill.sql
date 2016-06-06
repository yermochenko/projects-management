--Записи в таблице actor
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (1, 'denis', 1);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (2, 'vlad', 4);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (3, 'vova', 7);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (4, 'nik', 14);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (5, 'pavel', 15);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (6, 'boris', 16);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (7, 'ann', 18);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (8, 'den', 19);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (9, 'klava', 22);
INSERT INTO `actor` (`id`, `name`, `project_id`) VALUES (10, 'petya', 24);

--Записи в таблице actors_relation
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (1, 1, 1);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (2, 2, 1);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (3, 3, 2);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (4, 4, 3);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (5, 5, 4);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (6, 6, 5);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (7, 7, 6);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (8, 8, 8);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (9, 9, 7);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (10, 10, 2);