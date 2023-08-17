import java.util.ArrayList;
import java.util.Scanner;

public class Program {
	
	//I apologize in advance if there are any mistakes in the logic
	
	//The code can be optimized in a lot of ways and an edit mode could be added to change prices and discounts
	public static void main(String[] args) {
		ArrayList<Product> ProductList = CreateProduct();
		ArrayList<Client> ClientList =CreateClient();
		double BasicDiscount = 0;
		double Over10000Discount = 0;
		double Over30000Discount = 0;
		double TotalCostofDAfterDiscount;
		char CH =65;
		int ID = Begin();
		
		try {
	
		switch(ID) {
		case 1:
			System.out.println("Logged in as Client 1");
			BasicDiscount = ClientList.get(0).BasicDiscount;
			Over10000Discount = ClientList.get(0).Over10000Disc;
			Over30000Discount = ClientList.get(0).Over30000Disc;
			;
			break;
		
		case 2:
			System.out.println("Logged in as Client 2");
			BasicDiscount = ClientList.get(1).BasicDiscount;
			Over10000Discount = ClientList.get(1).Over10000Disc;
			Over30000Discount = ClientList.get(1).Over30000Disc;
			
			break;
		case 3:
			System.out.println("Logged in as Client 3");
			BasicDiscount = ClientList.get(2).BasicDiscount;
			Over10000Discount = ClientList.get(2).Over10000Disc;
			Over30000Discount = ClientList.get(2).Over30000Disc;
			
			break;
		case 4:
			System.out.println("Logged in as Client 4");
			BasicDiscount = ClientList.get(3).BasicDiscount;
			Over10000Discount = ClientList.get(3).Over10000Disc;
			Over30000Discount = ClientList.get(3).Over30000Disc;
			
			break;
		case 5:
			System.out.println("Logged in as Client 5");
			BasicDiscount = ClientList.get(4).BasicDiscount;
			Over10000Discount = ClientList.get(4).Over10000Disc;
			Over30000Discount = ClientList.get(4).Over30000Disc;
			
			break;
		default:
			System.out.println("Wrong");
			throw new WrongIDException();
			}
		}
		catch(WrongIDException e) {
			e.printStackTrace();;
		}
		//Input
		Scanner Scan1 = new Scanner(System.in);
		System.out.println("Enter order amount for Product A");
		double ProdAOrder =  Scan1.nextDouble();
		System.out.println("Enter order amount for Product B");		
		double ProdBOrder = Scan1.nextDouble();
		System.out.println("Enter order amount for Product C");
		double ProdCOrder = Scan1.nextDouble();
		System.out.println("Enter order amount for Product D");
		double ProdDOrder = Scan1.nextDouble();
		//double TotalOrder = ProdAOrder + ProdBOrder+ ProdCOrder + ProdDOrder;
		
		
		//Prints 
		
		//1.a Ordered amounts of products
		OrderAmounts(ProdAOrder,ProdBOrder, ProdCOrder,ProdDOrder);
		
		
		//1.b Base unit price
		System.out.println("BASE UNIT PRICE: ");
		
		for(int i = 0; i <ProductList.size(); i++) {
			if(i < 2)
				BaseUnitPrices(CH,ProductList.get(i).UnitCost,ProductList.get(i).markup);
			if(i>=2)
			System.out.println(CH +": " + String.format("%.2f", ProductList.get(i).UnitPrice) + " EUR");
			CH++;	
		}
		
		
		CH = CHDefault();
		//1.c Promotion off every product
		
		//Price after applied promotions
		
		System.out.println("Unit price after applied promotions");
		for(int i = 0; i < ProductList.size(); i++) {
			System.out.println(CH+": " + String.format("%.2f", ProductList.get(i).UnitPrice) + " EUR");
			CH++;
		}
		
		if(ProdDOrder >= 3) {
		TotalCostofDAfterDiscount = (ProdDOrder*ProductList.get(3).UnitPrice) -((ProdDOrder*ProductList.get(3).UnitPrice)/3);
		}
		else {
			TotalCostofDAfterDiscount = (ProdDOrder*ProductList.get(3).UnitPrice);
		}
		
		double DiscountforD;
		if(ProdDOrder >= 3) {
		DiscountforD = (ProdDOrder/3)*ProductList.get(3).UnitPrice;
		}
		else {
			DiscountforD = 0;
		}
		
		double PromotionforA = Product.PromotionCalculator(ProductList.get(0).UnitCost,ProductList.get(0).markup, ProductList.get(0).ProductPromotion);
		double PromotionforB = Product.PromotionCalculator(ProductList.get(1).UnitCost,ProductList.get(1).markup, ProductList.get(1).ProductPromotion);
		double PromotionforC = Product.PromotionCalculator(ProductList.get(2).UnitCost,ProductList.get(2).markup, ProductList.get(2).ProductPromotion);
		
		double AverageSaved = ((PromotionforA+PromotionforB+PromotionforC+DiscountforD)/4);
		System.out.println("The average money saved is: " + String.format("%.2f", AverageSaved) + " EUR");
		// This is very sloppily done and i don't really like it myself, but it was a last minute addition
		//This is also where i'm the most unsure about the logic used
		
		//1.d Line total in EUR
		CH= CHDefault();
		System.out.println("Line total for every product in EUR");
		
		//Could be optimized as a for cycle if the order amounts were added to an ArrayList
		//
			System.out.println( CH + ": "+ String.format("%.2f",(ProductList.get(0).UnitPrice*ProdAOrder)) + " EUR");
			CH++;
			System.out.println(CH +": " + String.format("%.2f",(ProductList.get(1).UnitPrice*ProdBOrder)) + " EUR");
			CH++;
			System.out.println(CH + ": " + String.format("%.2f",(ProductList.get(2).UnitPrice*ProdCOrder)) + " EUR");
			CH++;
			System.out.println(CH + ": " + String.format("%.2f", TotalCostofDAfterDiscount) + " EUR");
			
			
		//2. Total in EUR
		double Total = (ProdAOrder* ProductList.get(0).UnitPrice)+(ProdBOrder*ProductList.get(1).UnitPrice)+
				(ProdCOrder*ProductList.get(2).UnitPrice)+ TotalCostofDAfterDiscount;
		System.out.println("Total before Client Discounts: " + String.format("%.2f", Total) + " EUR");
		
		
		double TotalOrderVolume = ProdDOrder + ProdCOrder + ProdBOrder + ProdDOrder;
		
		
		//3.Discounts
		
		double TotalAfterBasicDiscount = Total - ((Total*BasicDiscount)/100);
		System.out.println("Total after Basic Client Discount: " +String.format("%.2f", TotalAfterBasicDiscount) + " EUR");
		
		if(Total >= 10000) {
			double TotalAfter10000Discount = TotalAfterBasicDiscount - ((TotalAfterBasicDiscount*Over10000Discount)/100);
			System.out.println("Total if the order is above 10000 euro :" + String.format("%.2f", TotalAfter10000Discount)+ " EUR");
			if(Total >=30000) {
				double TotalAfter30000Discount = TotalAfter10000Discount - ((TotalAfter10000Discount*Over30000Discount)/100);
				System.out.println("Total if the order is above 30000 euro :" + String.format("%.2f", TotalAfter30000Discount)+ " EUR");
			}
		}
		
		System.out.println("There are " + TotalOrderVolume +" items in the order");
	}
		
		
	
	public static ArrayList<Product> CreateProduct() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		Product A = new Product(0.52,80,0,0);
		Product B = new Product(0.38,120,30,0);
		Product C = new Product(0.41,0.9,0,0);
		Product D = new Product(0.60,1.0,0,0);
		
		A.UnitPrice = Product.MarkUpCalculator(A.UnitCost,A.markup, A.ProductPromotion);
		B.UnitPrice = Product.MarkUpCalculator(B.UnitCost, B.markup, B.ProductPromotion);
		C.UnitPrice = Product.MarkUpCalculatorC(C.UnitCost, C.markup);
		D.UnitPrice = Product.MarkUpCalculatorC(D.UnitCost, D.markup);
		//Different logic applies to the promotion for D but at this stage it's useful to use the method 
		//used for product C
		
		
		list.add(A);
		list.add(B);
		list.add(C);
		list.add(D); 
		return list;
	}
	
	public static ArrayList<Client> CreateClient(){
		ArrayList<Client> list = new ArrayList<Client>();
		Client One = new Client(1,5,0,2);
		Client Two = new Client(2,4,1,2);
		Client Three = new Client(3,3,1,3);
		Client Four = new Client(4,2,3,5);
		Client Five = new Client(5,0,5,7);
		
		list.add(One);
		list.add(Two);
		list.add(Three);
		list.add(Four);
		list.add(Five);
		
		return list;
	}
	
	public static int Begin() {
		System.out.println("Please enter your client ID");
		Scanner Scan = new Scanner(System.in);
		int ID = Scan.nextInt();
		
		return ID;
	}
	//Not implemented:
	public static void TryAgain() {
		System.out.println("No such client found, please try again");
		Begin();
	}
	
	static void OrderAmounts(double ProdAOrder, double ProdBOrder, double ProdCOrder, double ProdDOrder) {
		
		System.out.println("ORDER AMOUNT: A: " + ProdAOrder +  " B: " + ProdBOrder +" C " + ProdCOrder +" D " + ProdDOrder);
	}
	
	static void BaseUnitPrices(char CH,double UnitPrices, double markup) {

		System.out.println(CH + ": "+ String.format("%.2f", Product.BaseUnitPrice(UnitPrices, markup)) + " EUR");
		
	}
	
	public static double OrderPrice(double Quantity, double Price) {
		double TotalPrice = Quantity*Price;
		return TotalPrice;
	}
	
	public static char CHDefault() {
		char CH = 65;
		return CH;
	}
}
