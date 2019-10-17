# jaxenter.de-0029-MicroStream-001
Persistence with MicroStream 


## Hello World with MicroStream

### prepare your pom.xml
To start you need to add the following to your pom.xml

1) repository

```xml
    <repository>
      <id>microstream-releases</id>
      <url>https://repo.microstream.one/repository/maven-public/</url>
    </repository>
```

2) dependency for the local - embedded storage

```xml
    <dependency>
      <groupId>one.microstream</groupId>
      <artifactId>storage.embedded</artifactId>
      <version>02.00.00-MS-GA</version>
    </dependency>
```

