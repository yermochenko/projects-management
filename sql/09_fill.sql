--Записи в таблице "module"
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (1, 'MATHEMATICS', NULL, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (2, 'physics', NULL, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (3, 'Russian', NULL, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (4, 'mathematical analysis', 1, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (5, 'differential equations', 1, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (6, 'geometry', 1, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (7, 'Planimetry', 6, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (8, 'Stereometry', 6, 4);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES (9, 'Projective geometry', 6, 4);

--Записи в таблице "use_case_relation"
INSERT INTO `use_case_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (1, 1, 2 ,0);
INSERT INTO `use_case_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (2, 2, 1 ,2);
INSERT INTO `use_case_relation` (`id`, `source_id`, `destination_id`, `type` ) VALUES (3, 3, 3 ,1);
