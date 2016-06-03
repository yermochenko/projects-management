#Записи в таблице project
INSERT INTO `project` (`id`,  `name`, `description`, `category_id`, `manager_id`) VALUES (1, 'VSU', NULL );
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (2, 'The Faculty of Mathematics', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (3, 'The Faculty of Law', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (4, 'The Faculty of Art and Graphics', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (5, 'The Faculty of Physical Culture and Sports', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (6, 'The Faculty of Social Pedagogy and Psychology', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (7, 'The Faculty of Pedagogy', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (8, 'The Faculty of Biology', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (9, 'The Faculty of History', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (10, 'The Faculty of Preliminary Training', 1);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (11, 'Group 41', 2);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (12, 'Group 43', 2);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`, `category_id`, `manager_id`) VALUES (13, 'Subgroup_1 (41)', 11);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (14, 'Subgroup_2 (41)', 11);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (15, 'Applied Mathematics and Mechanics', 2);
#Записи в таблице project_category
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (1, 'Test category', 1);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (2, 'University category', 2);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (3, 'University(student) category', 2);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (4, 'University(teacher) category', 2);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (5, 'IT Company category', 5);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (6, 'Banks category\r\n\r\n', 6);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (7, 'Medicine category', 7);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (8, 'Medicine( pharmacy) category', 7);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (9, 'Medicine( Emergency Room) category', 7);
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (10, 'Web technology category', 10);
