package module4assignment;

import java.sql.*;
import java.util.*;

public class Module4Assignment {

    public static void main(String[] args) {
        System.out.println("-------------Step 1, 2, 3-------------");
        
        //scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        //try/catch to catch any database exceptions
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "admin");

            //stmt object
            Statement stmt = con.createStatement();

            //execute query for SELECT productName FROM products WHERE productLine = 'Classic Cars';
            ResultSet rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'Classic Cars'");
            
            System.out.println("Names of the classic cars: ");
        
            //while loop to display product names of the classic cars
            while (rs.next()) {
                    System.out.println(rs.getString("productName"));
            }//close while
            
            System.out.println("-------------Step 4 (inclduing optional challenge)-------------");
            
            //an array to hold the three different product lines
            String productLine[] = {"classic-cars", "ships", "motorcycles"};
            
            //ask the user which product line they want to see
            System.out.println("Select the type of product line you would like to see: ");
            
            //display product lines to user using for loop
            for (int x = 0; x < productLine.length; x++)
            {
                System.out.println((x + 1) + ". " + productLine[x]);
            }
            
            //scanner to take in the user's product line selection
            String productSelect = scanner.next();
            
            //if else statements to print out queries based on the user's productline selection
            //user can input either the product name or correspnding number
            
            //if user inputs classic cars or inputs 1
            if (productSelect.equalsIgnoreCase(productLine[0]) || productSelect.equals("1"))
            {
                System.out.println("Here is a list of our " + productLine[0]);
                
                //stmt object
                stmt = con.createStatement();

                //execute query for SELECT productName FROM products WHERE productLine = 'Classic Cars';
                rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'Classic Cars'");
        
                //while loop to display product names of the classic cars
                while (rs.next()) {
                        System.out.println(rs.getString("productName"));
                }//close while
                
                //number of classic cars (determined by SELECT COUNT(productName) AS numOfCars FROM products WHERE productLine = 'classic cars' in MySQL;
                int numOfClassics = 38;
                
                //array lists to hold certain values (the code for each car, the price of each car, the quantity of each car)
                ArrayList <String> classicCodes = new ArrayList<>();
                ArrayList <Double> classicPrices = new ArrayList<>();
                ArrayList <Integer> classicQuantity = new ArrayList<>();
                
                //for loop to add values from the database to each index of the arraylists
                for (int x = 0; x < numOfClassics; x++)
                {   
                    //execute query
                    rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'Classic Cars'");
                    
                    //while loop to add each productCode, buyPrice, and quantityinStock to arraylists
                    while (rs.next()){
                        classicCodes.add(rs.getString("productCode"));
                        classicPrices.add(rs.getDouble("buyPrice"));
                        classicQuantity.add(rs.getInt("quantityInStock"));
                    }
                }
                
                //display product codes of each car to the user using for loop
                System.out.println("Here is a list of product codes for the classic cars: ");
                
                for (int x = 0; x < numOfClassics; x++)
                {
                    System.out.println((x + 1) + ". " + classicCodes.get(x));
                }
                
                
                //ask user to input a code to display the price and quantity of product
                System.out.println("Input one of the product codes to recieve the price of the product: ");
                
                //variable to hold user's inpit
                String code = scanner.next();
                
                
                //for loop and if statement to match user's input to the classic codes array list
                for (int x = 0; x < numOfClassics; x++)
                {
                    if (code.equalsIgnoreCase(classicCodes.get(x)))
                    {
                        System.out.println("The price of this product is " + classicPrices.get(x));
                        System.out.println("The quantity we have in stock for his particular product is " + classicQuantity.get(x));
                    }
                }
            }
            
            //if user inputs ships or 2
            else if (productSelect.equalsIgnoreCase(productLine[1]) || productSelect.equalsIgnoreCase("2"))
            {
                System.out.println("Here is a list of our " + productLine[1]);
                
                
                //stmt object
                stmt = con.createStatement();

                //execute query
                rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'ships'");
        
                //while loop to display
                while (rs.next()) {
                        System.out.println(rs.getString("productName"));
                }//close while
                
                //number of classic cars (determined by SELECT COUNT(productName) AS numOfShips FROM products WHERE productLine = 'ships' in MySQL;
                int numOfShips = 9;
                
                //array lists to hold certain values (the code for each ship, the price of each ship, the quantity of each ship)
                ArrayList <String> shipCodes = new ArrayList<>();
                ArrayList <Double> shipPrices = new ArrayList<>();
                ArrayList <Integer> shipQuantity = new ArrayList<>();
                
                //for loop to add values from the database to each index of the arraylists
                for (int x = 0; x < numOfShips; x++)
                {   
                    //execute query
                    rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'ships'");
                    
                    //while loop to add productCode, buyPrice, and quantityInStock of each ship to the arraylists
                    while (rs.next()){
                        shipCodes.add(rs.getString("productCode"));
                        shipPrices.add(rs.getDouble("buyPrice"));
                        shipQuantity.add(rs.getInt("quantityInStock"));
                    }
                }
                
                //display product codes to user using for loop, shipCodes arrayList and get method
                System.out.println("Here are the product codes for the ships: ");
                
                for (int x = 0; x < numOfShips; x++)
                {
                    System.out.println((x + 1) + ". " + shipCodes.get(x));
                }
                
                //asl user to input a product code to view price and quantity of ship
                System.out.println("Input one of the product codes to recieve the price of the product: ");
                
                String code = scanner.next();
                
                //for loop and if statement to match user's input to the classic codes array list
                for (int x = 0; x < numOfShips; x++)
                {
                    if (code.equalsIgnoreCase(shipCodes.get(x)))
                    {
                        System.out.println("Your price is " + shipPrices.get(x));
                        System.out.println("We have " + shipQuantity.get(x) + " of this item in stock");
                    }
                }
            }
            
            //if user inputs motorcycles or 3
            else if (productSelect.equalsIgnoreCase(productLine[2]) || productSelect.equals("3"))
            {
                System.out.println("Here is a list of our " + productLine[2]);
              
                stmt = con.createStatement();

                //execute the SQL statement
                rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'motorcycles'");
        
                while (rs.next()) {
                        System.out.println(rs.getString("productName"));
                }//close while
                
                //number of classic cars (determined by SELECT COUNT(productName) AS numOfMotorCycles FROM products WHERE productLine = 'motorcycles' in MySQL;
                int numOfMotorcycles = 12;
                
                //array lists to hold certain values (the code for each motorcycle, the price of each motorcycle, the quantity of each motorcycle)
                ArrayList <String> motorCodes = new ArrayList<>();
                ArrayList <Double> motorPrices = new ArrayList<>();
                ArrayList <Integer> motorQuantity = new ArrayList<>();
                
                //for loop to add values from the database to each index of the arraylists
                for (int x = 0; x < numOfMotorcycles; x++)
                {   
                    //execute query
                    rs = stmt.executeQuery("SELECT * FROM products WHERE productLine = 'motorcycles'");
                    
                    //while loop to add productCode, buyPrice, and quantity to motorcycle arraylists
                    while (rs.next()){
                        motorCodes.add(rs.getString("productCode"));
                        motorPrices.add(rs.getDouble("buyPrice"));
                        motorQuantity.add(rs.getInt("quantityInStock"));
                    }
                }
                
                System.out.println("Here are the product codes for the motorcycles: ");
                
                for (int x = 0; x < numOfMotorcycles ; x++)
                {
                    System.out.println((x + 1) + ". " + motorCodes.get(x));
                }
                
                System.out.println("Input one of the product codes to recieve the price of the product: ");
                
                String code = scanner.next();
                
                for (int x = 0; x < numOfMotorcycles ; x++)
                {
                    if (code.equalsIgnoreCase(motorCodes.get(x)))
                    {
                        System.out.println("Your price is " + motorPrices.get(x));
                        System.out.println("We have " + motorQuantity.get(x) + " of this item in stock");
                    }
                }
            }
            
            
            System.out.println("-------------Step 5-------------");
            
            /* commented out for the delete part for step 6
            
            stmt.executeUpdate("INSERT INTO PRODUCTS \n" +
            "(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP)\n" +
            "VALUES \n" +
            "(\"S72_3213\",\"USS Monitor\", \"Ships\", \"1:72\", \"Second Gear Diecast\", \"Ironclad warship with her steam engine and revolving turret\", 780, 35.00, 55.00);\n");
            
            */
            
            rs = stmt.executeQuery("SELECT * FROM products WHERE productName = 'USS Monitor'");
            
            while (rs.next()){
                System.out.println(rs.getString("productCode") + " " + rs.getString("productName") + " " + rs.getString("productLine"));
            }
            
            System.out.println("-------------Step 6-------------");
            
            stmt.executeUpdate("DELETE FROM Products WHERE productName = 'USS Monitor';");
            
            rs = stmt.executeQuery("SELECT * FROM products");
            
            while (rs.next()){
                System.out.println(rs.getString("productCode") + " " + rs.getString("productName") + " " + rs.getString("productLine"));
            }
            
            con.close();
        
        }catch (Exception e){
            System.out.println(e);
        }
        
    } //end main method
    
} //end class

//hooray