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