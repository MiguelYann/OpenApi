# OPenAPI With Spring Boot

## Install

* Add dependency

````xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-core</artifactId>
    <version>1.1.44</version>
</dependency>
````

* Then we can run app on http://localhost:port/v3/api-docs/

* To customize your path, set on properties files that statement

````properties
springdoc.api-docs.path=/yourCustomizationPath
````
Then you can run app on http://localhost:port/yourCustomizationPath
 
 > By default OpenAPI definition is in JSON format, but you can access on YAML format, by adding http://localhost:port/yourCustomizationPath.yaml

## Set up SpringDoc openAPI with Swagger UI

Besides generate OpenAPi specs, you can add SpringDoc-OpenApi with Swagger
* Add new dependency for that

````xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.1.44</version>
</dependency>
````

* We can now access the Api documentation on http://localhost:port/swagger-ui.html
> We can modify the path , by adding the custom's path on properties
````properties
springdoc.swagger-ui.path=/swagger-ui-custom.html
````

* Then go on http://localhost:port//swagger-ui-custom.html

> Issues can occurs with incompatible version of Spring Boot, we can fix it by adding one exclusion [See here](https://github.com/springdoc/springdoc-openapi/issues/133)

## Architecture

* Hexagonal Architecture

We have ports that represent the boundaries of application (PlayerPort) which are used by external parts. Then we have the core of application
which implement the business logic. We define an interface with same logic of port, and the implementation

* Adding H2 database and integrate Spring JPA


### Open APi and Spring Boot

SpringDoc-Api provides a Maven plugin **SpringDoc-openApi-maven-Plugin** for generating openApi descriptions in json and yaml formats
Spring-doc-openApi-maven-plugin work with spring-boot-maven plugin. And Maven runs the OpenApi plugin during the integration test phase

````xml
<plugin>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-maven-plugin</artifactId>
    <version>0.2</version>
    <executions>
        <execution>
            <phase>integration-test</phase>
            <goals>
                <goal>generate</goal>
            </goals>
        </execution>
    </executions>
</plugin>
````

We call also configure the plugin, with custom values like
* apiDocUrl: where the docs in json format can be access
* outPutFileName: name of the file where the definitions are stored 
*outPutDir: Absolute path for the directory where the docs are stored 

````xml
 <configuration> 
        <apiDocsUrl>http://localhost:8080/v3/api-docs</apiDocsUrl> 
        <outputFileName>openapi.json</outputFileName> 
        <outputDir>${project.build.directory}</outputDir> 
  </configuration>
````
## Tips

* You must add properties **produces/consumes = APPLICATION_JSON_UTF8_VALUE** aux methodes de mapping
* [More Doc](https://springdoc.github.io/springdoc-openapi-demos/faq.html#how-can-i-configure-swagger-ui)

## Issues

We have an issue due to create groupe Api; then for using **GroupedOpenApi**
youu must install this dependency:

````xml
 <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-webmvc-core</artifactId>
      <version>1.2.33</version>
   </dependency>
````
