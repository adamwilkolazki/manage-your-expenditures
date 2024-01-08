CREATE TABLE IF NOT EXISTS expenditure (
                                           id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                                           description VARCHAR(250) NOT NULL,
                                           sum DECIMAL NOT NULL ,
                                           category VARCHAR(30) NOT NULL ,
                                           date DATE NOT NULL,
                                           app_user_id BIGINT,
                                           FOREIGN KEY (app_user_id) REFERENCES application_user  (id))