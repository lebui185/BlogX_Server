INSERT INTO `role` VALUES (1, 'admin');
INSERT INTO `role` VALUES (2, 'user');


INSERT INTO `account` (id, username, password, email, is_active) VALUES (1, 'admin1', '123456', 'email', true);
INSERT INTO `account` (id, username, password, email, is_active) VALUES (2, 'admin2', '123456', 'email', true);

INSERT INTO `account` (id, username, password, email, is_active) VALUES (3, 'user1', '123456', 'email', true);
INSERT INTO `account` (id, username, password, email, is_active) VALUES (4, 'user2', '123456', 'email', true);


INSERT INTO `account_role` (account_id, role_id) VALUES (1, 1);
INSERT INTO `account_role` (account_id, role_id) VALUES (2, 1);
INSERT INTO `account_role` (account_id, role_id) VALUES (3, 2);
INSERT INTO `account_role` (account_id, role_id) VALUES (4, 2);


INSERT INTO `tag` VALUES (1, 'tag01');
INSERT INTO `tag` VALUES (2, 'tag02');
INSERT INTO `tag` VALUES (3, 'tag03');


INSERT INTO `article` (id, title, content, created_time, last_edited, account_id) VALUES (1, 'title1', 'content1', '2018-01-01 10:01:00', '2018-01-01 10:01:00', 3);
INSERT INTO `article` (id, title, content, created_time, last_edited, account_id) VALUES (2, 'title2', 'content2', '2018-01-02 10:02:00', '2018-01-02 10:02:00', 3);

INSERT INTO `article_tag` (article_id, tag_id) VALUES (1, 1);
INSERT INTO `article_tag` (article_id, tag_id) VALUES (1, 2);
INSERT INTO `article_tag` (article_id, tag_id) VALUES (2, 3);

INSERT INTO comment (id, content, created_time, last_edited, article_id, parent_id, account_id) VALUES (1, 'comment1', '2018-04-01 12:01:00', '2018-04-01 12:01:00', 1, null, 4);
INSERT INTO comment (id, content, created_time, last_edited, article_id, parent_id, account_id) VALUES (2, 'comment2', '2018-04-01 12:02:00', '2018-04-01 12:02:00', 1, null, 3);
INSERT INTO comment (id, content, created_time, last_edited, article_id, parent_id, account_id) VALUES (3, 'comment3', '2018-04-01 12:03:00', '2018-04-01 12:03:00', 1, 1, 4);
INSERT INTO comment (id, content, created_time, last_edited, article_id, parent_id, account_id) VALUES (4, 'comment4', '2018-04-01 12:04:00', '2018-04-01 12:04:00', 1, 1, 3);


INSERT INTO `article` (id, title, content, created_time, last_edited, account_id) VALUES (3, 'title3', 'content3', '2018-01-03', '2018-01-03', 4);
INSERT INTO `article` (id, title, content, created_time, last_edited, account_id) VALUES (4, 'title3', 'content2', '2018-01-03', '2018-01-03', 4);

INSERT INTO `article_tag` (article_id, tag_id) VALUES (3, 1);
INSERT INTO `article_tag` (article_id, tag_id) VALUES (3, 2);
INSERT INTO `article_tag` (article_id, tag_id) VALUES (4, 3);