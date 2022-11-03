package Bill;
import java.util.ArrayList;  
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.text.SimpleDateFormat;    
import java.util.Date;
import java.util.HashMap;
import java.util.Calendar;  
class Product   
    {    
        private int id;  
        private String pname;  
        private int qty;  
        private double price;  
        private double totalPrice;  
           
        Product(int id, String pname, int qty, double price, double totalPrice)   
        {  
            this.id=id;  
            this.pname = pname;  
            this.qty = qty;  
            this.price = price;  
            this.totalPrice = totalPrice;  
        }  
            
            public int getId()   
                {  
                    return id;  
                }  
                
            public String getPname()   
                {  
                    return pname;  
                }  
                
                public int getQty()   
                {  
                    return qty;  
                }  
                public double getPrice()   
                {  
                    return price;  
                }  
                public double getTotalPrice()   
                {  
                    return totalPrice;  
                }  
             
                public static void displayFormat()   
                {  
                    System.out.format("-----------------------------------------------------------------------------------------------------------------------------------");  
                    System.out.print("\nBill ID \t\tName\t\tQuantity\t\tRate \t\t\t\tTotal Price\n");  
                    System.out.format("-----------------------------------------------------------------------------------------------------------------------------------\n");  
                }  
                   
             
                public void display()   
                {  
                    System.out.format("   %-9s             %-9s      %5d               %9.2f                       %14.2f\n" ,id, pname, qty, price, totalPrice);  
                }  
    }  
public class ShoppingBill   
    {  
        public static void main(String args[])   
            {  
int bid=0;        	
                int id =0;  
                String productName = null;  
                int quantity = 0;  
                double price = 0.0;  
                double totalPrice = 0.0;  
                double overAllPrice = 0.0;  
                double cgst, sgst, subtotal=0.0, discount=0.0;  
                char choice = '\0';  
                Scanner scan=new Scanner(System.in);
                for(int i=0;;i++)
            	{
            	System.out.println("PRESS ANY OPTION TO CONTINUE");
            	System.out.println("1.INSERTION FOOD & Price");
            	System.out.println("2.INSERT BILL");
            	System.out.println("3.Search ID");
            	System.out.println("4.Show all");
            	System.out.println("5.EXIT");
            	int press;
            	press=scan.nextInt();
            	List<Product> product = new ArrayList<Product>();
            	HashMap<String,Float> food1=new HashMap<>();
            	HashMap<String,Float> food=new HashMap<>();
            	food.put("Parrota", (float) 10); 
        		food.put("Poori", (float) 20); 
        		food.put("Vadai", (float) 10); 
        		food.put("", (float) 70);
        		food.put("Veg_Meals", (float) 90);
        		food.put("Non_Veg_Meals", (float) 150);
        		food.put("Chappati", (float) 15);
        		food.put("Dhosa", (float) 10);
        		food.put("Idly", (float) 6);
        		food.put("Pongal", (float) 50);
           String f;Float val;
           int store;
           ShoppingBill s; 
           String check;
            	switch(press)
            	{
            	case 1:
            		
            		System.out.println("No of items to be inserted");
            		int ivalue=scan.nextInt();
            	
            		for(int c=1;c<=ivalue;c++)
            		{
            			
            		System.out.println("Enter the Food Name");
            		 f= scan.next();
            		 System.out.println("Enter the Food Price");
            		 val= scan.nextFloat();
            		 food.put(f,(float) val);
            		}	
                    System.out.println("For Chech Value");
            		check=scan.next();
            		break;           	
            	
            	case 2:

                    System.out.println("\t\t\t\t--------------------Invoice Bill-----------------");  
                    System.out.println("\t\t\t\t\t "+"  "+"Pradeep Kumar Restaurant");  
                    System.out.println("\t\t\t\t\t3/98 SilkMill,Vellore");  
                    System.out.println("\t\t\t\t\t"  +"    " +"Opposite Bus stand Walk");  
                    System.out.println("                    "+"\t\t\t\t\t\t\t\tContact: (+91) 9442241484");  
                      
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
                    Date date = new Date();    
                    Calendar calendar = Calendar.getInstance();  
                    String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
                    
                    System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]+"\t\t\t\t\t\t (+91) 8610535422");  
                    scan.nextLine();
                    
                    System.out.print("Bill ID: ");  
                    id = id+1;
                    System.out.print(id);
                   
                    do   
                        {  
                    	System.out.println("");
                            System.out.println("Enter the food details: ");  
                            System.out.println("");
                            System.out.println(food);
                            System.out.print("Food Name: ");  
                            productName = scan.nextLine();  
                            System.out.print("Quantity: ");  
                            quantity = scan.nextInt();  
                            System.out.println("Enter food name");
                            String key=scan.next();
                            boolean flag=food.containsKey(key);
       					 
    						if(flag==true) {

    							System.out.println(key+"          "+quantity+ ":" +"               "+ (food.get(key))*quantity);
    					 totalPrice=(food.get(key))*quantity;
    					 overAllPrice = overAllPrice + totalPrice;  
    					 price=(food.get(key));
    					 product.add( new Product(id, productName, quantity, price, totalPrice) );                                     
    						}  
                            System.out.print("Want to add more items? (y or n): ");  
                              
                            choice = scan.next().charAt(0);  
                              
                            scan.nextLine();  
    						} 
                    
                    while (choice == 'y' || choice == 'Y');  
                 
                    Product.displayFormat();  
                    for (Product p : product)   
                    {  
                        p.display();  
                    }  
           
              
                    
                    
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) "+overAllPrice);  
                    subtotal = overAllPrice;   
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal "+subtotal);  
                      
                    sgst=overAllPrice*5/100;  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
                    cgst=overAllPrice*5/100;  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) "+cgst);  
                      
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal+cgst+sgst));  
                    System.out.println("\t\t\t\t----------------Thank You for Coming :)!!-----------------");  
                    System.out.println("\t\t\t\t                     Visit Again");  
                    overAllPrice = 0;
            		break;
                		
            	case 3:
            		
            		break;
                	
            	case 4:


                    
                    System.out.println("\t\t\t\t--------------------Invoice Bill-----------------");  
                    System.out.println("\t\t\t\t\t "+"  "+"Pradeep Kumar Restaurant");  
                    System.out.println("\t\t\t\t\t3/98 SilkMill,Vellore");  
                    System.out.println("\t\t\t\t\t"  +"    " +"Opposite Bus stand Walk");  
                    System.out.println("                    "+"\t\t\t\t\t\t\tContact: (+91) 9442241484");  
                      
                     
                
            		Product.displayFormat();  
                    for (Product p : product)   
                    {  
                        p.display();  
                    }  
                      
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);  
                    subtotal = overAllPrice;   
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal "+subtotal);  
                     
                    sgst=overAllPrice*5/100;  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
                    cgst=overAllPrice*5/100;  
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) "+cgst);  
                      
                    System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal+cgst+sgst));  
                    System.out.println("\t\t\t\t----------------Thank You for Coming :)!!-----------------");  
                    System.out.println("\t\t\t\t                     Visit Again");  
                    break;           	
                    
            	case 5:
            		System.exit(0);
            		break;
            	default:
            		break;
            	}
            	}
            }     
    } 