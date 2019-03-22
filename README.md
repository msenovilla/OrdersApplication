# OrdersApplication
Application for import and process information about orders

Given a .csv with orders records, the application will:
- stores all the information in an internal BBDD
- generates a processed csv, with all the original data sorted by "orderId"

The input csv file must have these headers columns:
- Region
- Country
- Item Type
- Sales Channel
- Order Priority
- Order Date
- Order ID
- Ship Date
- Units Sold
- Unit Price
- Unit Cost
- Total Revenue
- Total Cost
- Total Profit

The input file name must be included at application call, for example:<br/>
java -jar OrdersAplication-0.0.1-SNAPSHOT.jar C:\\inputFile.csv</code><br>
mvn spring-boot:run -Dspring-boot.run.arguments=--C:\\inputFile.csv</code>

Technologies used for this project:
- IDE Eclipse 2018, with pluggins:
  - Spring IDE
  - Checkstyle
  - Web Tools
- Java SE 1.8 
- Spring Boot (version 2) https://spring.io/projects/spring-boot
- Spring Batch https://spring.io/projects/spring-batch
- Maven https://maven.apache.org/
- JUnit https://junit.org/junit5/
- H2 http://www.h2database.com/html/main.html
