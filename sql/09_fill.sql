--Записи в таблице "module"
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (3, 'MATHEMATICS', NULL, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (4, 'physics', NULL, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (5, 'Russian', NULL, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (6, 'mathematical analysis', 3, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (7, 'differential equations', 3, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (8, 'geometry', 3, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (9, 'Planimetry', 8, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (10, 'Stereometry', 8, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (11, 'Projective geometry', 8, 1);

--Записи в таблице "use_cases_relation"
INSERT INTO `use_cases_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (1, 7, 5, 2);
INSERT INTO `use_cases_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (2, 7, 6, 2);
INSERT INTO `use_cases_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (3, 8, 3, 1);
INSERT INTO `use_cases_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (4, 2, 9, 0);