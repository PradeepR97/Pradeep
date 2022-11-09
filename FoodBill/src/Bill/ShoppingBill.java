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

class Menu {
  	
	
		    Scanner scan=new Scanner(System.in);
			  HashMap<String, Float> food = new HashMap<>();
		    int n;
		    String fname;
		    Float fprice;
		 
		    
		    
		    
		    
		    public HashMap<String, Float> getMenu()
		    {
		    System.out.println("ENTER BREAK-FAST MENU");
		    n=scan.nextInt();
		    for(int i=0;i<n;i++)
		    
		    {
		    	System.out.print("Enter Food Name ::");
		    	fname=scan.next();
		    	System.out.println("");
		    	System.out.print("Enter Food Price ::");
		    	fprice=scan.nextFloat();
		        System.out.println("");
		        food.put(fname, fprice);
		  
		    
		    }
		    return food;
		  }
		    
            int id =0;  
            String productName = null;  
            int quantity = 0;  
            double price = 0.0;  
            double totalPrice = 0.0;  
            double overAllPrice = 0.0;  
            double cgst, sgst, subtotal=0.0, discount=0.0;  
            char choice = '\0';  
            List<Product> product = new ArrayList<Product>();
            List<Product> productall = new ArrayList<Product>();
            HashMap<Integer,List<Product>> foodall=new HashMap<>();
        	
            
            
            public void calc()
		    {
		        
            	
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
                        System.out.print("food Name: ");  
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
                for (Product p : productall)   
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
            	                
				
            	
				foodall.put(id,product);
				productall.addAll(product);
				
		    }
		    
		    public void showAll()
		    {

        		System.out.println("\t\t\t\t--------------------Invoice Bill-----------------");  
                System.out.println("\t\t\t\t\t "+"  "+"Pradeep Kumar Restaurant");  
                System.out.println("\t\t\t\t\t3/98 SilkMill,Vellore");  
                System.out.println("\t\t\t\t\t"  +"    " +"Opposite Bus stand Walk");  
                System.out.println("                    "+"\t\t\t\t\t\t\t\tContact: (+91) 9442241484");  
                
                
				 overAllPrice = overAllPrice + totalPrice;
                
        		Product.displayFormat();  
                for (Product d : productall)   
                {  
                    d.display();  
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
		    	
		    }
		    
		    
		  }
		





    public class ShoppingBill   
    {  
        public static void main(String args[])   
            {  
int bid=0;

Menu m=new Menu();   

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
            	System.out.println("1.INSERTION food & Price");
            	System.out.println("2.INSERT BILL");
            	System.out.println("3.Search ID");
            	System.out.println("4.Show all");
            	System.out.println("5.EXIT");
            	int press;
            	press=scan.nextInt();
            	List<Product> product = new ArrayList<Product>();
            	
            	
            	ShoppingBill ob=new ShoppingBill();
           int store;
           
            String check;
           String fname;
		    Float fprice;
		    int menu;
		    
		      	switch(press)
            	{
            	case 1:
            		m.getMenu();
            	  
            		break;           	
            	
            	case 2:
            		m.calc();
                                    break;
                		
            	case 3:
            		
            		break;
                	
            	case 4:
                  m.showAll();
            		break;           	
                    
            	case 5:
            		System.exit(0);
            		break;
            	default:
            		System.out.println("Enter 1 to 5 numbers only");
            		break;
            	}
            	}
            }

		private void getMenu() {
			// TODO Auto-generated method stub
			
		}     
    } 