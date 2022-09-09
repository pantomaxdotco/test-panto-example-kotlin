# Documentation

Learning kotlin spring boot application restful API with basic CRUD and authentication API Key

## TechStack
* MySQL Database
* Docker Compose
* Spring Boot

## API Spec

---
### Request Authentication
All the request restful API must have headers authentication
#### Request :

* Header :
  * X-Auth-API : secret key

> Use default secret api key bellow for authenticated. This key is md5 encryption from secret value, you can find on **application.properties**

Default Api Key :
```shell 
5ebe2294ecd0e0f08eab7690d2a6ee69
```

---
### Get Product by Id
#### Request :
  * Method : GET
  * Endpoint : ``api/v1/product/{id}``
  * Header :
    * Accept: application/json
#### Response :
```json
{
  "status": "boolean",
  "code": "number",
  "message": "string",
  "data": {
      "id": 1,
      "name": "string",
      "price": "number",
      "qty": "number"
  }
}
```
---
### Insert Product
#### Request :
* Method : POST
* Endpoint : ``api/v1/product``
* Header :
  * Accept: application/json
  * Content-Type: application/json
* Body :
```json
{
  "name": "string",
  "price": "number",
  "qty": "number"
}
```
#### Response :
```json
{
  "status": "boolean",
  "code": "number",
  "message": "string",
  "data": null
}
```
---
### Get Product with paging
#### Request :
* Method : GET
* Endpoint : ``api/v1/product``
* Header :
  * Accept: application/json
* Query :
  * page: number
  * limit: number
#### Response :
```json
{
  "status": "boolean",
  "code": "number",
  "message": "string",
  "data": {
      "total": "number",
      "current_page": "number",
      "prev_page": "number",
      "content": [
          {
            "id": 1,
            "name": "string",
            "price": "number",
            "qty": "number"
          }
      ]
  }
}
```
---
### Update Product by Id
#### Request :
* Method : PUT
* Endpoint : ``api/v1/product/{id}``
* Header :
  * Accept: application/json
  * Content-Type: application/json
* Body :
```json
{
  "name": "string",
  "price": "number",
  "qty": "number"
}
```
#### Response :
```json
{
  "status": "boolean",
  "code": "number",
  "message": "string",
  "data": null
}
```
---
### Delete Product by Id
#### Request :
* Method : DELETE
* Endpoint : ``api/v1/product/{id}``
* Header :
  * Accept: application/json
#### Response :
```json
{
  "status": "boolean",
  "code": "number",
  "message": "string",
  "data": null
}
```