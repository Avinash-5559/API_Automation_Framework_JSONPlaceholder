# API Automation Framework – JSONPlaceholder

![Java](https://img.shields.io/badge/Java-11%2B-blue)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ%20IDEA-IDE-000000?logo=intellijidea&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build%20Tool-C71A36?logo=apachemaven&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-Framework-brightgreen)
![RestAssured](https://img.shields.io/badge/RestAssured-API--Testing-yellowgreen)
![Allure](https://img.shields.io/badge/Allure-Reports-ff69b4)

---

## 🗂️ Overview  

This project is an **API Automation Framework** built to test the public [JSONPlaceholder](https://jsonplaceholder.typicode.com/) REST API service.

It is developed using **Java**, **Rest-Assured**, **TestNG**, **Maven**, and **Allure Reports** to provide a scalable and maintainable automation setup.

The framework utilises **Map-based payloads**, which keep the design lightweight, flexible, and easy to maintain.

---

## 🚀 Features

- Complete **CRUD** test automation for JSONPlaceholder ``/posts`` endpoint
- **Map-based payload creation**
- Modular framework design with clear separation of concerns:
    - **Endpoints** for API URLs
    - **Modules** for payload building
    - **Assertions** for reusable validations
    - **Test suites** grouped logically
- Integrated **Allure Reporting** for interactive test results
- Logging support via **Log4j2**
- Lightweight, dependency-minimal structure

---

## ⚙️ Tech Stack

- **Java 11+**
- **IntelliJ IDEA** – IDE for development
- **Maven** – Build & dependency management
- **Rest-Assured** – HTTP client for API automation
- **TestNG** – Testing framework
- **AssertJ** – Advanced assertions
- **Allure Reports** – Reporting framework

---

## 🏗️ Project Structure

```bash
API_Automation_Framework_JSONPlaceholder/
│
├── .idea/                                                  # IntelliJ config
├── .mvn/                                                   # Maven wrapper files
├── allure-results/                                         # Allure results (auto-generated)
├── logs/
│   └── test.log                                            # Execution logs
│
├── pom.xml                                                 # Project dependencies & build config
├── .gitignore
│
├── testng_*.xml                                            # TestNG suite files
│
├── src/
│   ├── main/
│   │   ├── java/com.avinashsinha/
│   │   │   ├── endpoints/                                  # API endpoints
│   │   │   │   └── APIConstants.java
│   │   │   │
│   │   │   └── modules/                                    # Payload Manager (Map-based)
│   │   │       └── PayloadManager.java
│   │   │
│   │   └── resources/
│   │       └── log4j2.xml                                  # Logging configuration
│   │
│   └── test/
│       └── java/com.avinashsinha/
│           ├── asserts/                                    # Assertion utilities
│           │   └── AssertActions.java
│           │
│           ├── base/                                       # Base Test setup
│           │   └── BaseTest.java
│           │
│           └── tests/
│               ├── crud/                                   # CRUD Test Cases
│               │   ├── TestPostsCreate.java
│               │   ├── TestPostsDelete.java
│               │   ├── TestPostsDetails.java
│               │   ├── TestPostsDetailsById.java
│               │   ├── TestPostsFullUpdate.java
│               │   └── TestPostsPartialUpdate.java
│               │
│               ├── integration/                            # Integration Tests
│               │   └── TestE2EFlow.java
│               │
│               └── sample/                                 # Sample Tests
│                   └── TestIntegrationSample.java
│
└── README.md

```
---

## ▶️ Running Tests

### Integration Test (Create Posts, Details, Update and Delete Posts)

```bash
mvn clean test -DsuiteXmlFile=testng_integration.xml
```

#### Available TestNG XMLs

- `testng_createPosts.xml`
- `testng_deletePosts.xml`
- `testng_detailsById.xml`
- `testng_fullUpdate.xml`
- `testng_partialUpdate.xml`
- `testng_integration.xml`
- `testng_sample.xml`

---

## 📊 Reporting
### Generate Allure Report

```bash
allure serve allure-results
```
  <img src="https://github.com/user-attachments/assets/a80f69c2-f0c8-4645-9493-b7db8072b528" alt="JSONPlaceholder Allure Report" width="1100">

This will launch an interactive report in your browser.

---
##  ✅ Example Payload with Map

```java
Map<String, Object> payload = new LinkedHashMap<>();
payload.put("title", "Automation Framework");
payload.put("body", "Testing JSONPlaceholder APIs");
payload.put("userId", 101);
```
---
## 📌 Author
👤 Avinash Sinha

---
