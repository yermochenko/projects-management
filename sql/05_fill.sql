--Записи в таблицe "user_group"
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (1, 'VSU', NULL);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (2, 'The Faculty of Mathematics', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (3, 'The Faculty of Law', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (4, 'The Faculty of Art and Graphics', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (5, 'The Faculty of Physical Culture and Sports', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (6, 'The Faculty of Social Pedagogy and Psychology', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (7, 'The Faculty of Pedagogy', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (8, 'The Faculty of Biology', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (9, 'The Faculty of History', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (10, 'The Faculty of Preliminary Training', 1);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (11, 'Group 41', 2);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (12, 'Group 43', 2);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (13, 'Subgroup_1 (41)', 11);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (14, 'Subgroup_2 (41)', 11);
INSERT INTO `users_group` (`id`, `name`, `parent_id`) VALUES (15, 'Applied Mathematics and Mechanics', 2);

--Записи в таблицe "user"
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (1, 'Admin', 'admin', 'Сергей', 'Александрович', 'Ермоченко', 1, 15);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (2, 'Tima', 't123', 'Timofei', 'Mikhailovich', 'Mironenko', 0, 13);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (3, 'Borya', 'mfgood', 'Boris', 'Andreevich', 'Petrenko', 0, 13);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (4, 'Max', 'mrtgds', 'Maxim', 'Sergeevich', 'Sheidin', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (5, 'Baton', 'rfuvfl12', 'Nikita', 'Sergeevich', 'Bondarenko', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (6, 'Pasha', 'vfdsjk43', 'Pavel', 'Alekseevich', 'Rogovoi', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (7, 'Actor', 'actor', 'Alexandr', 'Ivanovich', 'Dovgyalo', 0, 12);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (8, 'Den', 'den98c', 'Denis', 'Pavlovich', 'Voropaev', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (9, 'Nastya', 'vdsjk76', 'Anastasiya', 'Aleksandrovna', 'Sapezhinskaya', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (10, 'Vlad', 've3kf', 'Vladislav', 'Ivanovich', 'Lyalugo', 0, 13);

--Записи в таблице "project_category"
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (1, 'test category', NULL);

--Записи в таблице "project"
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (1, 'test', NULL, 1, 5);

--Записи в таблице "team"
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (1, 1, 4);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (2, 1, 5);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (3, 1, 3);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (4, 1, 2);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (5, 1, 10);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (6, 1, 1);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (7, 1, 8);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (8, 1, 7);