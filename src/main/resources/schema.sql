DROP TABLE IF EXISTS signature;
DROP TABLE IF EXISTS petition;

CREATE TABLE petition (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          title VARCHAR(255) NOT NULL,
                          description VARCHAR(500),
                          emoji VARCHAR(10),
                          petitioner_first_name VARCHAR(100),
                          petitioner_last_name VARCHAR(100),
                          petition_body LONGTEXT,
                          petition_date DATE
);

CREATE TABLE signature (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           signer_first_name VARCHAR(100),
                           signer_last_name VARCHAR(100),
                           signer_email VARCHAR(100),
                           signed_date DATE,
                           petition_id BIGINT,
                           CONSTRAINT fk_petition
                               FOREIGN KEY (petition_id)
                                   REFERENCES petition(id)
                                   ON DELETE CASCADE
);