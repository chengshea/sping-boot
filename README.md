### 目录
```
.
├── cs-framework
│   ├── cs-msc
│   ├── cs-ocr
│   ├── cs-shiro
│   └── pom.xml
├── cs-tool
│   ├── cs-common
│   ├── cs-entity   spring-boot-starter-data-jpa
│   ├── cs-rw-aop    主从 HikariCP 
│   ├── cs-rw-druid  主从 Druid 
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

