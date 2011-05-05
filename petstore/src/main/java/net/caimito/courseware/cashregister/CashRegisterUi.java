package net.caimito.courseware.cashregister;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CashRegisterUi {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
		
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("cashRegister.xml") ;
		ApplicationContext ctx = new ClassPathXmlApplicationContext("jmsCashRegister.xml") ;
		
		CashRegister cashRegister = ctx.getBean(CashRegister.class) ;
		
		System.out.println("Which pet do you want to sell?") ;
		String petName = reader.readLine() ;
		
		cashRegister.sell(petName, 450.00) ;
		
		System.out.println("The total is: " + cashRegister.getTotalSale()) ;
		
		System.out.println("Money on the table?") ;
		String moneyOnTheTable = reader.readLine() ;
		
		cashRegister.pay(Double.parseDouble(moneyOnTheTable)) ;
		
		System.out.println("Return money is " + cashRegister.getReturnMoney()) ;
		
		System.out.println("Thank you for your business") ;
	}

}
