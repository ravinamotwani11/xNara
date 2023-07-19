# xNara

This project is an implementation of the assignment given by xNara.

## Pre-requisites:
* [Docker](https://docs.docker.com/engine/install/) should be install in your system.

## System Compatibility
This assignment can run on:
* Linux
* MacOs
* Windows

## Usage

```
git clone https://github.com/ravinamotwani11/xNara
cd xNara/api
gradle build
cd ..
docker build -t xNara . 
docker run -p 8080:8080 xNara
```  
* NOTE: Wait until docker image is up and running
 
# CRUD
open postman => select POST method => type the below URL=> provide request body => hit send button => You will get success response 

To get combined data for pack1 and pack2  
method: POST  
URL: 
http://localhost:8080/api/combine-packs

RequestBody:
{
    "customer_id": "101"
}

Note: Provide customer_id of your choice

SWAGGER URL: http://localhost:8080/swagger-ui.html


