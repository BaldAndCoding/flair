CREATE USER flair_app_user WITH PASSWORD 'flair_pass';

GRANT SELECT, UPDATE, INSERT
ON ALL TABLES
IN SCHEMA flair
TO flair_app_user;

ALTER USER flair_app_user SET search_path to 'flair';