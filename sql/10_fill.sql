INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (2, 'project', 'there is need to complete term paper', 1, 4);

--Записи в таблице actor
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (3, 'unauthorized user', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (4, 'authorised user', 2, TRUE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (5, 'client', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (6, 'VIP client', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (7, 'employee', 2, TRUE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (8, 'courier', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (9, 'manager', 2, TRUE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (10, 'product manager', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (11, 'sales manager', 2, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (12, 'admin', 2, FALSE);

--Записи в таблице actors_relation
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (1, 4, 5);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (2, 4, 7);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (3, 5, 6);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (4, 7, 8);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (5, 7, 9);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (6, 7, 12);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (7, 9, 10);
INSERT INTO `actors_relation` (`id`, `parent_id`, `child_id`) VALUES (8, 9, 11);