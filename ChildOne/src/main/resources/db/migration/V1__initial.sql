
CREATE SCHEMA tonberry;
CREATE TABLE tonberry.data (
                                data_id BIGSERIAL PRIMARY KEY,
                                value VARCHAR(32)
);

INSERT INTO tonberry.data (value) VALUES ('a');
INSERT INTO tonberry.data (value) VALUES ('b');
INSERT INTO tonberry.data (value) VALUES ('c');
INSERT INTO tonberry.data (value) VALUES ('d');
INSERT INTO tonberry.data (value) VALUES ('e');
INSERT INTO tonberry.data (value) VALUES ('f');
INSERT INTO tonberry.data (value) VALUES ('g');
INSERT INTO tonberry.data (value) VALUES ('h');
