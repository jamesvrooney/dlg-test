# Getting Started

## Running the application
* Pull docker image
    - docker pull **jamesvrooney/dlg-image-james**
* Go to project root
* Run command:
    - **docker container run --name james-dlg-app --rm -p 8080:8080 -d jamesvrooney/dlg-image-james**

## Viewing data in `in-memory` database
* Browse to http://localhost:8080/h2-console
* Use the parameters:
    - JDBC URL: **jdbc:h2:mem:testdb**
    - User Name: **sa**
    - Password: <leave this empty>

## Viewing OpenAPI documentation
* Browse to http://localhost:8080/swagger-ui.html