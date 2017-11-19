### 目录
```
.
├── cs-framework
│   ├── cs-msc
│   ├── cs-ocr
│   ├── cs-shiro
│   └── pom.xml
├── cs-tool
│   ├── cs-common   公共类
│   ├── cs-email
│   ├── cs-jpa   spring-boot-starter-data-jpa
│   ├── cs-rw-aop    多数据源主从 HikariCP 
│   ├── cs-rw-druid  多数据源主从 Druid 
│   └── pom.xml
├── pom.xml
└── README.md
```



整合 mybaits+spring-boot-starter-data-jpa包冲突
```
 <dependency>
     <groupId>javax.persistence</groupId>
	 <artifactId>persistence-api</artifactId>
	 <version>1.0.2</version>
</dependency>
```

