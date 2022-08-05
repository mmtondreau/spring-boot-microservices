## Summary

This repo demonstrates a simple Spring Boot microservice cloud that utilzies: 
- Webflux 
- R2JDBC
- Eureka Service Discovery
- Spring Config Server
- Resilience4J Circuit Breaker

It is composed of 5 applications: 

1. Parent - The edge service that provides the core API to clients. Has two endpoints `fetch` and `ping`. Calls ChildOne and ChildTwo using WebFlux and Resilience4J.
2. ChildOne - Represnets an internal service that's backed by an Postgres DB using R2JDBC
3. ChildTwo - Represents a second internal service with an hard coded response.
4. Eureka - The service discovery server
5. Config - the configuration server with configurations stored at https://github.com/mmtondreau/spring-boot-config

## Build & Deploy

```shell
make clean all
```

## Sample Request

#### Request
```shell
curl 'localhost:8080/fetch'
```

#### Response
```shell
{"childOne":[{"data":"a"},{"data":"b"},{"data":"c"},{"data":"d"},{"data":"e"},{"data":"f"},{"data":"g"},{"data":"h"},{"data":"Blarp-o-o-000"}],"childTwo":[{"data":21},{"data":23},{"data":67}]}
```