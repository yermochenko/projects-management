INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES(1, 'module A', NULL, 1);
INSERT INTO `module` (`id`, `name`, `parent_id`, `project_id`) VALUES(2, 'module B', NULL, 1);

--Записи в таблице "use_case"
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (1, 'test1', 1);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (2, 'test2', 1);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (3, 'test3', 1);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (4, 'test4', 1);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (5, 'test5', 1);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (6, 'test6', 2);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (7, 'test7', 2);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (8, 'test8', 2);
INSERT INTO `use_case` (`id`, `name`, `module_id`) VALUES (9, 'test9', 2);

INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (1, 'actor white', 1, FALSE);
INSERT INTO `actor` (`id`, `name`, `project_id`, `is_abstract`) VALUES (2, 'actor black', 1, FALSE);

--Записи в таблице "actor_use_case_relation"
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (1, 1, 1);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (2, 1, 2);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (3, 1, 3);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (4, 2, 4);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (5, 1, 5);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (6, 2, 5);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (7, 1, 6);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (8, 2, 8);
INSERT INTO `actor_use_case_relation` (`id`, `actor_id`, `use_case_id`) VALUES (9, 2, 9);