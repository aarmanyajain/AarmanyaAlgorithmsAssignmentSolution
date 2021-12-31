package college;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class main extends manager {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter the number of companies");
		int totalCompanies = scan.nextInt();

		Stock[] stocks = new Stock[totalCompanies];
		for(int i = 0; i< totalCompanies; ++i) {
			Double price;
			Boolean isPriceRose;
			System.out.println("Enter current stock price of the company " + (i+1));
			price = scan.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			String str = scan.next();
			isPriceRose = str.equals("true") ? Boolean.valueOf(true) : Boolean.valueOf(false);

			stocks[i] = new Stock(price, isPriceRose);
		}
		printAllOptions();
		int optionChosen = scan.nextInt();
		List<Stock> stks = Arrays.asList(stocks);
		while(optionChosen > 0) {
			switch(optionChosen) {
				case 1:
					Arrays.sort(stocks, (a,b) -> a.price.compareTo(b.price));
					System.out.println( "Stock prices in ascending order are :");
					Arrays.stream(stocks).forEach(stk -> System.out.println(stk.price ));
					
					break;
				case 2:
					Arrays.sort(stocks, (a,b) -> b.price.compareTo(a.price));
					 System.out.println( "Stock prices in descending order are :" );
					Arrays.stream(stocks).forEach(stk -> System.out.println(stk.price));
					break;
				case 3:
					System.out.println("Total no of companies whose stock price rose today :" + stks.stream().filter(stk -> stk.isPriceRose.equals(true)).count());
					break;
				case 4:
					System.out.println("Total no of companies whose stock price declined today :" + stks.stream().filter(stk -> stk.isPriceRose.equals(false)).count());
					break;
				case 5:
					System.out.println("enter the key value");
					Double searchedPrice = scan.nextDouble();
					if(stks.stream().filter(stk -> stk.price.equals(searchedPrice)).count() > 0) {
						System.out.println("Stock of value " + searchedPrice + " is present");
					} else {
						System.out.println("Stock of value " + searchedPrice + " is absent");
					}
					break;
				default:
					System.out.println("Not a valid option, please enter your preference between 0-5");
					break;
			}
			printAllOptions();
			optionChosen = scan.nextInt();
		}

		System.out.println("Exited successfully");
	

		
}
}


