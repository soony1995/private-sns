-- Create the user 'soony' with password '1234'
CREATE USER 'soony'@'%' IDENTIFIED BY '1234';

-- Grant all privileges on all databases to 'soony'
GRANT ALL PRIVILEGES ON *.* TO 'soony'@'%' WITH GRANT OPTION;

-- Flush the privileges to ensure that they are saved and available in the current session
FLUSH PRIVILEGES;