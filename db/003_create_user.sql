CREATE USER flair_app_user WITH PASSWORD 'flair_pass';

GRANT USAGE ON SCHEMA flair TO flair_app_user;

GRANT SELECT, UPDATE, INSERT
ON ALL TABLES
IN SCHEMA flair
TO flair_app_user;

GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA flair TO flair_app_user;

ALTER USER flair_app_user SET search_path to 'flair';