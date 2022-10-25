

./gradlew bootRun
### Endpoints

#### Sign-Up

```
POST /api/authentication/sign-up HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "name": "user",
    "username": "user",
    "password": "user"
}

http://localhost:8080/api/authentication/sign-up

{
    "name":"admin1",
    "username": "admin1",
    "password":"admin1"
}
```

#### Sign-In

```
POST /api/authentication/sign-in HTTP/1.1
Host: localhost:8080
Content-Type: application/json

{
    "username": "user",
    "password": "user"
}
```

#### Make-admin

```
PUT /api/internal/make-admin/admin HTTP/1.1
Host: localhost:8080
Authorization: Bearer InternalApiKey1234!
```
