# authentication_basic

Having a look at basic authentication support in Sprint Boot

## Notes

- if `spring-boot-starter-security` starter is in a dependency, then endpoints are secured with username: user, and password logged to console on application startup.
- can customise username and password via properties. `spring.security.user.name` and `spring.security.user.password` 
- `WebSecurityConfigurerAdapter` extension for custom behaviour, e.g. assigning roles to username/password pairs and authorizing these roles particular endpoints 


## Requests

Note the following requests inserts the username and password for the basic authentication into the URL. Alternatively the header `Authorization` with the username and password encoded could have been used.

```
The following 2 requests are equivalent:

>curl -X GET http://admin:password@localhost:8080/admin/stats
>curl -X GET http://localhost:8080/admin/stats -H 'Authorization: Basic dXNlcjpwYXNzd29yZA==' 

```
```
No authentication. Anybody can hit this endpoint:

>curl http://localhost:8080/about

```
```
Basic authentication and authorized to any role:

>curl -X GET http://user:password@localhost:8080/api/add
>curl -X GET http://admin:password@localhost:8080/api/add

```
```
Basic authentication and authorized to role ADMIN:

>curl -X GET http://admin:password@localhost:8080/admin/stats


The following is forbidden:

>curl -X GET http://user:password@localhost:8080/admin/stats
```
