# OrdersApplication
Application for import and process information about orders

Given a .csv with orders records, the application will:
- stores all the information in a internal BBDD
- generates a processed csv, with all the original data ordered by "orderId"

The input csv must have this headers columns:
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

The input file name must be included at application call, for example:
java -jar OrdersAplication-0.0.1-SNAPSHOT.jar C:\\inputFile.csv
