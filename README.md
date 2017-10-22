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
│   ├── cs-rw-aop   主从读写分离 
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

单独打包
```
mvn clean install -pl cs-tool/cs-common -am -rf cs-framework/cs-ocr
```