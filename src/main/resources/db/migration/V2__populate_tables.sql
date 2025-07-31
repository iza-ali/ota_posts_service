use ota_posts_db;


INSERT INTO categories (category_id, name) VALUES (1, 'Knitting');
INSERT INTO categories (category_id, name) VALUES (2, 'Beading');
INSERT INTO categories (category_id, name) VALUES (3, 'Writing');
INSERT INTO categories (category_id, name) VALUES (4, 'Painting');
INSERT INTO categories (category_id, name) VALUES (5, 'Sewing');
INSERT INTO categories (category_id, name) VALUES (6, 'Singing');
INSERT INTO categories (category_id, name) VALUES (7, 'Piano');

INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (1, 'Test1', 'one', 2, 1, 'Beginner', 'Draft',false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (2, 'Test2', 'two', 3, 3, 'Intermediate', 'Published', false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (3, 'Test3', 'three', 6, 5, 'Intermediate', 'Published', false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (4, 'Test4', 'four', 3, 6, 'Beginner', 'Published', false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (5, 'Test5', 'five', 1, 1, 'Expert', 'Draft', false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (6, 'Test6', 'six', 4, 7, 'Beginner', 'Draft', false);
INSERT INTO posts (post_id, title, body, profile_id, category_id, skill_level, status, is_deleted) VALUES (7, 'Test7', 'seven', 4, 5, 'Intermediate', 'Published', false);

INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (1, 1, 5, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (2, 4, 1, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (3, 6, 4, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (4, 1, 3, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (5, 5, 6, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (6, 3, 1, 'comment', false);
INSERT INTO comments (comment_id, profile_id, post_id, body, is_deleted) VALUES (7, 5, 1, 'comment', false);