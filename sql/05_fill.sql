#Записи в таблицe "user_group"
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

#Записи в таблицe "user"
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (1, 'Admin', 'admin', 'Sergey', 'Aleksandrovich', 'Ermochenko', 1, 15);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (2, 'Tima', 't123', 'Timofei', 'Mikhailovich', 'Mironenko', 0, 13);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (3, 'Borya', 'mfgood', 'Boris', 'Andreevich', 'Petrenko', 0, 13);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (4, 'Max', 'mrtgds', 'Maxim', 'Sergeevich', 'Sheidin', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (5, 'Baton', 'rfuvfl12', 'Nikita', 'Sergeevich', 'Bondarenko', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (6, 'Pasha', 'vfdsjk43', 'Pavel', 'Alekseevich', 'Rogovoi', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (7, 'Actor', 'actor', 'Alexandr', 'Ivanovich', 'Dovgyalo', 0, 12);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (8, 'Den', 'den98c', 'Denis', 'Pavlovich', 'Voropaev', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (9, 'Nastya', 'vdsjk76', 'Anastasiya', 'Aleksandrovna', 'Sapezhinskaya', 0, 14);
INSERT INTO `user` (`id`, `name`, `password`, `first_name`, `middle_name`, `last_name`, `is_admin`, `group_id`) VALUES (10, 'Vlad', 've3kf', 'Vladislav', 'Ivanovich', 'Lyalugo', 0, 13);

#Записи в таблице "project_category"
INSERT INTO `projects_category` (`id`, `name`, `parent_id`) VALUES (1, 'test category', NULL);

#Записи в таблице "project"
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (1, 'test', NULL, 1, 5);

#Записи в таблице "team"
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (1, 1, 4);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (2, 1, 5);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (3, 1, 3);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (4, 1, 4);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (5, 1, 2);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (6, 1, 4);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (7, 1, 10);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (8, 1, 1);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (9, 1, 8);
INSERT INTO `team` (`id`, `project_id`, `leader_id`) VALUES (10, 1, 7);

#Записи в таблице "contact_type"
INSERT INTO `contacts_type` (`id`, `name`, `regexp`) VALUES (1, 'email', '^[a-zA-Z]([.]?([a-zA-Z0-9_-]+)*)?@([a-zA-Z0-9\\-_]+\\.)+[a-zA-Z]{2,4}$');
INSERT INTO `contacts_type` (`id`, `name`, `regexp`) VALUES (2, 'telephone', '^([+]375)[0-9]{9}');
INSERT INTO `contacts_type` (`id`, `name`, `regexp`) VALUES (3, 'addres', '');

#Записи в таблице "contact"
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (1, '+375555666', 1, 2);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (2, 'Actor@mail.com', 7, 1);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (3, 'Vitebsk', 5, 3);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (4, '+37599911555', 7, 2);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (5, 'Brovki st.', 7, 3);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (6, 'ber@gmail.com', 3, 1);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (7, '+3753332517985', 3, 2);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (8, 'Moskovskyi pr.', 3, 3);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (9, 'timka@mail.com', 2, 1);
INSERT INTO `contact` (`id`, `name`, `user_id`, `type_id`) VALUES (10, '+3752564568', 2, 2);

#Записи в таблице "employee"
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (1, 7, 1, 0);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (2, 1, 1, 1);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (3, 5, 2, 0);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (4, 3, 2, 0);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (5, 3, 3, 1);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (6, 4, 3, 1);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (7, 9, 3, 0);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (8, 6, 4, 1);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (9, 2, 5, 0);
INSERT INTO `employee` (`id`, `user_id`, `team_id`, `role`) VALUES (10, 10, 5, 1);

