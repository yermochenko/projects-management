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
#Записи в таблице project
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (1, 'test', '\r\ntest data', 1, 5);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (4, 'Statement of the educational process', 'Timetable of classes ,tests, exams, retake', 2, 10);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (7, 'Аmbulance project', 'Сustomer requirements', 9, 8);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (14, 'Banking system', 'Castumer requirements "Belinvestbank"', 6, 3);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (15, 'Banking system', 'Custumer requirements "Belarusbank" ', 6, 2);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (16, 'www.Onliner.by', 'Styling website', 10, 6);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (18, 'www.Plus-Minus.by', 'Search for bugs and errors', 10, 9);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (19, 'IOS', 'Software development', 5, 4);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (22, 'ANDROID', 'Software development', 5, 6);
INSERT INTO `project` (`id`, `name`, `description`, `category_id`, `manager_id`) VALUES (24, 'Shporgalki.vsu', 'help students', 10, 8);