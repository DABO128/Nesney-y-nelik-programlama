package Odevv5;
import java.util.Scanner;
/**
 * 
 * @author Ömer Dabo
 *
 */
public class TopCarBolIslemleri {

	public static void main(String[] args) {
		
		Scanner Sayi=new Scanner(System.in); 
		int Deger1 , Deger2 , Toplama, Cikarma,Carpma; 
		double Kalan ,Bolme;
		
		System.out.println("1. Sayıyı girin"); 
	    Deger1=Sayi.nextInt();
	    
		System.out.println("2. Sayıyı girin");
		Deger2=Sayi.nextInt();
		
		Toplama= Deger1 + Deger2;  
		Cikarma= Deger1 - Deger2;      
		Carpma= Deger1 * Deger2;        
		Bolme= Deger1 / Deger2;       
		Kalan= Deger1 % Deger2;     
		
		System.out.println(Deger1+" + "+Deger2+" = "+Toplama);
		System.out.println(Deger1+" - "+Deger2+" = "+Cikarma);    
		System.out.println(Deger1+" x "+Deger2+" = "+Carpma);
		System.out.println(Deger1+" / "+Deger2+" = "+Bolme);
		System.out.println(Deger1+" mod "+Deger2+" = "+Kalan);
		


			
			
			
	

	}

}
