package custompackage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		List<Customer> customer = new ArrayList<Customer>();
		Map<Integer,String> custom = new HashMap<Integer,String>();
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("CUSTOMER DETAILS" + "\n"+ "Enter your choice: ");
			System.out.println("1. ADD NEW CUSTOMER ");
			System.out.println("2. VIEW ALL CUSTOMERS");
			System.out.println("3. VIEW CUSTOMER USING EMAIL");
			System.out.println("4. REMOVE CUSTOMER USING EMAIL");
			System.out.println("0. EXIT");
			System.out.println("===================================="); 
			
			int choice = scan.nextInt();
			
			switch(choice)
			{
			case 1:
				Scanner input = new Scanner(System.in);
				
				System.out.println("Enter ID: ");
				int str1 = input.nextInt();
				System.out.println("Enter Name: ");
				String str2 = input.next();
				System.out.println("Enter Email: ");
				String str3 = input.next();
				System.out.println("Enter DOB: ");
				LocalDate str4 = LocalDate.parse(input.next());
				
				Customer newCus = new Customer(str1,str2,str3,str4);
				customer.add(newCus);
				custom.put(str1, str3);
				
				System.out.println("New Customer: \n" + newCus );
				System.out.println("====================================");
				break;
				
				
			case 2: 
				if(customer.isEmpty())
				{
					System.out.println("No Data");
				}
				else
				{
					for(Customer c: customer)
					{
						System.out.println(c);
					}
				}
				System.out.println("====================================");
				break;
				
				
			case 3: 
				System.out.println("Viewing Customers Using Email: " + "\n");
				System.out.println("ID" + ":" + "Email");
				custom.forEach((key,value)-> System.out.println(key+ ":" + value));
				System.out.println("====================================");
				break;
				
				
			case 4: 
				Scanner sc = new Scanner(System.in);
				
				System.out.println("Enter Email To Be Remove: ");
				String valueToBeRemoved = sc.next();
				
				Iterator<Map.Entry<Integer,String>> iterator = custom.entrySet().iterator();
				
				while(iterator.hasNext()) 
				{
					Map.Entry<Integer, String> entry = iterator.next();
					if(valueToBeRemoved.equals(entry.getValue())) {
						iterator.remove();
					}
				}
				
				System.out.println("After Removing Email: ");
				System.out.println("ID" + ":" + "Email");
				custom.forEach((key,value)-> System.out.println(key+ ":" + value));
				System.out.println("====================================");
				break;
			
			case 0: 
				System.out.println("EXIT");
				System.exit(0);
				System.out.println("====================================");
				break;
			
			default: 
				System.out.println("Invalid Choice !");
				break;
			}
		}

	}

}
