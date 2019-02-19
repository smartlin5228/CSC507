
# Project Repo for CSC507

Make sure your git config is correct and ssh configuration is done

Please start by creating your own fork by clicking the `fork` button on the top right corner

Submitting the project by creating a pull request and reviewed by at least one of the other developer beforing merging the master


## Configure you local environment

Please make sure the following software are install in your local

Maven [Installation instructions for Windows Users](https://stackoverflow.com/questions/38549614/how-to-install-maven-in-windows)

MySQL (I am using MySQL 8.x) [Installation Instruction for Community Server](https://dev.mysql.com/downloads/)

Tomcat [Installation Guide for Windows](https://www.programmergate.com/step-by-step-guide-for-installing-tomcat-on-windows/)

#### Important: Please make sure Tomcat is running on port 8080 and mysql is running on port 3306

## Configure MySQL
Make sure you create a user with username:"csc505", and password:"password"

For mylocal testing there is a database called `userlogin` and a table with the following schema

```mysql
mysql> mysql> select * from userlogin;
+------------------+------------+----------+
| username         | password   | role     |
+------------------+------------+----------+
| 123              | Spring2019 | Employee |
| asd              | Spring2019 | Employee |
| asdadadas        | Spring2019 | Employee |
| asdasdasd        | Spring2019 | Employee |
| CSC507           | Spring2019 | Employee |
| CSC507adasdadasd | Spring2019 | Employee |
| czxzx            | Spring2019 | Employee |
| sss              | Spring2019 | Employee |
| zxcxzczx         | Spring2019 | Employee |
+------------------+------------+----------+
9 rows in set (0.00 sec)
```


## Configure your Tomcat for quick local testing 

add the following lines to tomcat-users.xml

```sh
<role rolename="manager"/>
<role rolename="admin"/>
<role rolename="manager-script"/>
<role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager,manager-gui,admin,manager-script"/>
```
so the file should look like this
```sh
<?xml version="1.0" encoding="UTF-8"?>
<!--
  Licensed to the Apache Software Foundation (ASF) under one or more
  contributor license agreements.  See the NOTICE file distributed with
  this work for additional information regarding copyright ownership.
  The ASF licenses this file to You under the Apache License, Version 2.0
  (the "License"); you may not use this file except in compliance with
  the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
-->
<tomcat-users xmlns="http://tomcat.apache.org/xml"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd"
              version="1.0">
<!--
  NOTE:  By default, no user is included in the "manager-gui" role required
  to operate the "/manager/html" web application.  If you wish to use this app,
  you must define such a user - the username and password are arbitrary. It is
  strongly recommended that you do NOT use one of the users in the commented out
  section below since they are intended for use with the examples web
  application.
-->
<!--
  NOTE:  The sample user and role entries below are intended for use with the
  examples web application. They are wrapped in a comment and thus are ignored
  when reading this file. If you wish to configure these users for use with the
  examples web application, do not forget to remove the <!.. ..> that surrounds
  them. You will also need to set the passwords to something appropriate.
-->
<!--
  <role rolename="tomcat"/>
  <role rolename="role1"/>
  <user username="tomcat" password="<must-be-changed>" roles="tomcat"/>
  <user username="both" password="<must-be-changed>" roles="tomcat,role1"/>
  <user username="role1" password="<must-be-changed>" roles="role1"/>
-->
  <role rolename="manager"/>
  <role rolename="admin"/>
  <role rolename="manager-script"/>
  <role rolename="manager-gui"/>
  <user username="admin" password="admin" roles="manager,manager-gui,admin,manager-script"/>
</tomcat-users>
```

Then within the project folder, run 
```sh
mvn tomcat7:deploy
```
There is link popup within the log and direct you to the URL
```sh
[INFO] Deploying war to http://localhost:8080/BookMyRoom  
Uploading: http://localhost:8080/manager/text/deploy?path=%2FBookMyRoom&update=true
Uploaded: http://localhost:8080/manager/text/deploy?path=%2FBookMyRoom&update=true (3280 KB at 50461.5 KB/sec)

[INFO] tomcatManager status code:200, ReasonPhrase:
[INFO] OK - Deployed application at context path [/BookMyRoom]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.460 s
[INFO] Finished at: 2019-02-06T23:48:30-05:00
[INFO] Final Memory: 17M/308M
[INFO] ------------------------------------------------------------------------
```
Click on it you will see your project deployed on Tomcat server