##

An online banking app that uses no database, but only JSON

![](Capture.PNG)

## Project Structure

```
online-bank-system/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── yourcompany/
│   │   │   │       └── onlinebank/
│   │   │   │           ├── Bank.java
│   │   │   │           ├── User.java
│   │   │   │           ├── JsonUtil.java
│   │   │   │           └── Main.java
│   │   └── resources/
│   │       └── users.json
│   └── test/
│       └── java/
│           └── com/
│               └── yourcompany/
│                   └── onlinebank/
│                       └── BankTest.java
│                       └── UserTest.java
│                       └── JsonUtilTest.java
│
├── .gitignore
├── pom.xml (or build.gradle if using Gradle)
└── README.md
```