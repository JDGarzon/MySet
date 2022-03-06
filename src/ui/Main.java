package ui;



import java.util.Scanner;
import java.util.Set;

import model.MySet;

public class Main{
	
	public static <T> Set<T> calculator(int index,Set<T> first,Set<T> second) {
		Set<T> result=null;
		switch(index) {
			case 1:
				result=union(first,second);
				break;
			case 2:
				result=intersection(first,second);
				break;
			case 3:
				result=symDif(first,second);
				break;
				
		}
		return result;
	}
	
	public static <T> Set<T> union(Set<T> first,Set<T> second) {
		Set<T> union=new MySet<>();
		union.addAll(first);
		union.addAll(second);
		return union;
	}
	
	public static <T> Set<T> intersection(Set<T> first,Set<T> second) {
		Set<T> inter=new MySet<>();
		for(T element:first) {
			for(T secondEl:second) {
				if(element.equals(secondEl)) {
					inter.add(element);
				}
			}
		}
		return inter;
	}
	
	public static <T> Set<T> symDif(Set<T> first,Set<T> second) {
		Set<T> dif=new MySet<>();
		Set<T> minus=new MySet<>();
		dif.addAll(first);
		dif.addAll(second);
		minus=intersection(first,second);
		for(T element:minus) {
			dif.remove(element);
		}
		return dif;
	}
	
	public static void main(String [] args) {
		try (Scanner sc = new Scanner(System.in)) {
			Set<String> first = new MySet<>();
			Set<String> second = new MySet<>();
			int amount;
			String elements;
			System.out.println("Seleccionar operacion");
			System.out.println("1. Union");
			System.out.println("2. Interseccion");
			System.out.println("3. Diferencia simetrica");
			
			int index=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Numero de elementos del primer conjunto");
			amount=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<amount;i++) {
				System.out.println("Digitar elemento (String)");
				elements=sc.nextLine();
				first.add(elements);
			}
			System.out.println("Numero de elementos del segundo conjunto");
			amount=sc.nextInt();
			sc.nextLine();
			for(int i=0;i<amount;i++) {
				System.out.println("Digitar elemento");
				elements=sc.nextLine();
				second.add(elements);
			}
			
			
			
			Set<String> op=calculator(index,first,second);
			
			System.out.println("Resultado");
			for(String element:op) {
				System.out.println(element);
			}
		}
		
	}
	
	
}
