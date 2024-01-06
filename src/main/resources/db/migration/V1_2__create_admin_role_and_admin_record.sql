INSERT INTO  user_role(name) VALUES ('ADMIN'),('USER');

INSERT INTO
    application_user (first_name, last_name, email, password,role_id)
VALUES
-- adam.wilkolazki@gmail.com/haslo
('Adam', 'Wilkołazki', 'adam.wilkolazki@gmail.com', '{MD5}207023ccb44feb4d7dadca005ce29a64',1);