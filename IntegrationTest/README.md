# MySQL Database

## Requirements

For building and running the application you need:

- [Docker](https://docs.docker.com/desktop/install/mac-install/)

## Running the application locally

First to run the app locally, you need to create the required componet. For this app you need to execute the command bellow.
```shell
docker-compose up -d
```

## Looking inside DB
You can have a look inside the DB with the command bellow
```shell
# Check if docker container exists
docker ps 
docker exec -it integrationtest_db_1 /bin/sh
# For password input "mauFJcuf5dhRMQrjj"
mysql -u root -p -h 127.0.0.1
use MyApp;
select * from pets;
```
## Edit DB schema
To Change the schema edit the file `IntegrationTest/init.sql`
