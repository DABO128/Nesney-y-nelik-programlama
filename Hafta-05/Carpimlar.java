package Odevv5;

import java.util.Scanner;
/**
 * @author Ömer Dabo
 * 
 *
 */
public class Carpimlar {

	public static void main(String[] args) {
		Scanner Sayi =new Scanner(System.in); 
		int Islem,Sonuc;                     
		
		
		System.out.println("Bir sayı giriniz"); 
		Islem=Sayi.nextInt();          
		
		
		for (int i = 1; i <=10; i++) {
			
			Sonuc=Islem*i;    
			System.out.println(Islem+"x"+i+"="+Sonuc); 
			}
			
			
			


	}

}
