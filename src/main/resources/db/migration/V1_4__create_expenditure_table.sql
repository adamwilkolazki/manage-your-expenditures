CREATE TABLE IF NOT EXISTS expenditure (
                                           id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                                           description VARCHAR(250) NOT NULL,
                                           sum decimal(10,2) NOT NULL ,
                                           category VARCHAR(30) NOT NULL ,
                                           date DATE NOT NULL,
                                           application_user_id BIGINT,
                                           FOREIGN KEY (application_user_id) REFERENCES application_user (id))