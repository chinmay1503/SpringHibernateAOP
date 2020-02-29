# SpringHibernateAOP

A Spring project that consists of basic usage of Hibernate and AOP (Aspect Oriented Programming). The Spring configuration is XML based
It helps one learn the core concepts of Spring Hibernate as well as Spring AOP.

I Have also included the dump of the database file which can be easily imported in your ORACLE database
using the following command :

CREATE OR REPLACE DIRECTORY datapump AS '{Full Directory Path}'; eg 'C:\Scripts'

GRANT READ, WRITE ON DIRECTORY datapump TO {DbName};
 
impdp {DbName}/{DbPassword}@{SID} DUMPFILE=SPRINGDB.DMP LOGFILE=SPRINGDB.log DIRECTORY=datapump REMAP_SCHEMA=HibernateDb:{DbName} REMAP_TABLESPACE=HibernateDb:{DbName} CONTENT=ALL TABLE_EXISTS_ACTION=REPLACE

Wherein {DbName} eg HibernateDb is the schema name of your Database
{DbPassword} eg HibernateDb (same password) is the schema password of your database
{SID} eg ORACLE12 is the container database name.

The project was intended for solely educational purpose. Feel free to refer. Credits to all the people for the resources that I have utilized in this project.
