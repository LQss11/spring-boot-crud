# spring-boot-crud
A simple spring boot project as a crud template.
# Quick start
This project is containerized so you need to install docker and docker compose and then you are ready to go.

You will need to run the following commands to test your application:
```sh
docker-compose up --build -d 
```
# Access ports:
| App        | Port                             |
| ---------- | -------------------------------- |
| phpmyadmin | [localhost:9081](localhost:9081) |
| tomcat     | [localhost:9080](localhost:9080) |
> The username and password of **PHPMYADMIN** are specified in the docker-compose which are root:root