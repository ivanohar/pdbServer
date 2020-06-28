# delete table with name "user" if exist
DROP TABLE IF EXISTS `pdb`.`user`;

# delete table with name "person" if exist
DROP TABLE IF EXISTS `pdb`.`person`;

# delete database with name "pdb" if exist
DROP DATABASE IF EXISTS pdb;

# delete user with name "pdb" if exist
DROP USER IF EXISTS 'pdb'@'localhost';
