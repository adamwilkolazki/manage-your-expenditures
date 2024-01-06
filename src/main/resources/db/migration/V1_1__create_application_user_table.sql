CREATE TABLE IF NOT EXISTS application_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    first_name  VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL ,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(200) NOT NULL,
    role_id BIGINT,
    FOREIGN KEY (role_id) REFERENCES user_role (id)


)