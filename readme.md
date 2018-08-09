# Multiple Projects Sample

## build with profile

```
mvn clean install package -Ppersonal
mvn clean install package -Pstage
mvn clean install package -Pprod
```

## Demo with jetty

```
mvn clean jetty:run -Ppersonal
mvn clean jetty:run -Pstage
mvn clean jetty:run -Pprod
```

```
connect [localhost](http://localhost:8080/)
```


## Login Account / Password

username = ```admin```
password = ```password```