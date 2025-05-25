# Price-Comparator-Backend

A java based backend logic for a "price Comparator - Market" application. 

## Project Structure

The project is structured as shown bellow:
```
PRICE-COMPARATOR-BACKEND/
│
├── data/                       .csv files with prices & discounts available from different stores
│   ├── kaufland_2025-05-01.csv
│   ├── ....................
│   ├── lidl_2025-05-01.csv
│   ├── .....................
│   ├── profi_2025-05-01.csv
│   └── ......................
│
├── features/                   feature-specific logic
│   ├── DoOnDiscounts.java
│   └── DoOnShoppingBasket.java
│
├── model/                      data model
│   ├── Discount.java
│   └── Product.java
│
├── utils/                      helper classes
│   ├── CSVReader.java
│   └── ReadFilesFromFolderNIO.java
│
├── Main.java                   entry point, menu navigation
└── README.md                   documentation and usage guide
```

## How to build and run the project

### Requirements
- Java 17+
- IDE or CLI (e.g., IntelliJ, VS Code, or javac + java)

### Compile & Run
```
Run Main.java from your IDE.
```

## Assumptions/ simplications/ comments

The code was designed with reusability and scalability in mind. The logic of the application can handle an arbitrary number of .csv files or additional stores without needing major code changes.
All data (store prices &discounts) will be stored in the folder `data` and be a valid .csv file.
All the files included in the folder must have the same naming and format `Filename format: storename_date.csv (e.g., lidl_2025-05-08.csv,
kaufland_2025-05-08.csv)`.

## How to use the implemented features

For now, the user has to choose a feature and follow the instructions shown in the terminal according to his choice.

## Next steps:

### Implementation of future features
- Custom Price Alert: set a flag (the user provides product and the preffered price for that product). Once the product's price drops to/bellow the preffered price, the user will be informed.
- Product Substitutes & Recommendations: calculate the fairness of the price for each product available. Highlight products with fair price to user as "best buys".

### Improvements
- the reading of the .csv files from the a folder would be replaced by a proper database for a faster and flexible system.
- for the the existing features logic (`Daily Shopping Basket Monitoring` & `Best Discounts`) take in consideration and apply existing discounts to the store prices.
- create more datasets beyond the existing ones as the project grows in complexity. 
