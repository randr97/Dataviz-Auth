# Dataviz-Auth

Spring boot project to setup dataviz auth

## Steps

1. Run postgres on your localhost on port 5432
2. Run command `mvn clean` in the project dir
3. Run command `mvn install` in the project dir and ensure all tests pass
4. Run command `mvn spring-boot:run` to run server on 8080

## API

1. Register API

```
curl --location --request POST 'http://localhost:8080/api/v1/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstname": "rohit",
    "lastname": "shrothrium",
    "email": "rohit@gmail.com",
    "password": "password",
    "role": "ADMIN"
}'
```

2. Authenticate API
```
curl --location --request POST 'http://localhost:8080/api/v1/auth/authenticate' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "rohit@gmail.com",
    "password": "password"
}'
```

3. Demo api to check if autheticated
```
curl --location --request GET 'http://localhost:8080/api/v1/demo-controller' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyb2hpdEBnbWFpbC5jb20iLCJpYXQiOjE2ODM2OTg3NDcsImV4cCI6MTY4Mzc4NTE0N30.Cvb_zlTpkBujhaGb_ZRHE6uXJVSl-r5o8ul0hy6-njs'
```
