# Multiple Projects Sample

## 目的

1. 展示使用Maven 來建置多模組的專案
2. 基本的Spring Data
3. 基本的Spring MVC
4. 基本的Spring Security，整合Google, Facebook的Oath2登入。

## Maven
### pom.xml
1. 利用```bom```來引入相關的libraries
2. 利用```dependencyManagement```來管理所有模組裡的library 版本
3. 設定```profiles```來為不同環境提供設定變數的管理

### build with profile

```
mvn clean install package -Ppersonal
mvn clean install package -Pstage
mvn clean install package -Pprod
```

### Demo with jetty

```
mvn clean jetty:run -Ppersonal
mvn clean jetty:run -Pstage
mvn clean jetty:run -Pprod
```

```
connect [localhost](http://localhost:8080/)
```

## Spring Data
### JDBC Connection 
1. 使用HikariCP
2. 使用h2 database



## Spring Security
### Login Account / Password

username = ```admin```
password = ```password```