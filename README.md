# momenton-coding-challenge

#### Modules
---
- **company-hierarchy-client**
---

  Client user interface module of the application which connects to the backend service engine. This can be deployed to any server or the same server as the backend service engine. Currently proxy has been configured to connect to the following backend url.

  ```sh
  http://localhost:8080/aceme-portal
  ```
  Configure this url appropriately in the file,

  ```sh
  proxy.config.json
  ```
  ###### Technologies
  - Angular 6.0.3
  - Angular CLI 6.0.3

  ###### Dependencies
  - Node 10.0.0
  - npm 5.6.0

  ###### Build

  ```sh
  1. Clone this repository
    git clone https://github.com/shanaka-diluk/momenton-coding-challenge.git

  2. Change directory to company-hierarchy-client

  3. Install dependencies
    npm install

  4. Run the server
    npm start

  5. Application client will be available at
    http://localhost:4200

  6. Run test
    npm test

  7. Distribution
    npm run build

    Distribution files will be available on 'dist' folder.
  ```

---
- **company-hierarchy**
---
Server module of the application implemented as a RESTful web service.


###### Technologies
- Spring Boot 2.0.2
- H2 in-memory database

###### Dependencies
- Java 8
- Maven

###### Build

```sh
1. Clone this repository
  git clone https://github.com/shanaka-diluk/momenton-coding-challenge.git

2. Change directory to company-hierarchy

3. Run the server
  mvn spring-boot:run

4. Server will be available at
  http://localhost:8080/acme-portal

5. Swagger documentation of the RESTful API is available on the following urls.
  http://localhost:8080/acme-portal/v2/api-docs
  http://localhost:8080/acme-portal/swagger-ui.html
```

###### Test coverage

| Module            | Coverage | Covered Instructions | Missed Instructions |
| ----------------- | -------- | -------------------- | ------------------- |
| company-hierarchy | 93.2%    | 397                  | 29                  |
