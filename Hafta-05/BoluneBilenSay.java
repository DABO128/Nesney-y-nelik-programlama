package Odevv5;

/** Kullanicindan 1 den 9 kadar olan iki rakam aldiktan sonra, 1 ile 100 arasinda bu rakamlardan
herbirine ve ikisinin carpina tam bolunebilen sayilari ekrana yaziniz. Kullanici rakam disinda bir deger
girdiginde program uyari verip, yeni deger girilmesini istemeli!
*/
import java.util.Scanner;
/**
 * 
 * @author Ömer Dabo
 *
 */
  
public class BoluneBilenSay {

	public static void main(String[] args) {
		Scanner Sayi=new Scanner(System.in); 
		int Deger1=0, Deger2, Carpim,c = 0;      
		
		
		System.out.println("Birinci sayi girin");
		String Karakter=Sayi.nextLine(); 
		
		
		
		char harf = Karakter.charAt(0); 
		int ascii = (int) harf;   
		
		
		while(ascii<49||ascii>57 || Karakter.length()>1) 
		{
	        System.out.println("Lütfen 1'den 9 a kadar sayı girin");
	        	        
	        Karakter =Sayi.nextLine();
			
			 harf = Karakter.charAt(0); 
			 ascii = (int) harf; 
	        }
		
		Deger1=Integer.parseInt(Karakter); 
		
		
		System.out.println("Ikicinci sayı girin"); 
		Karakter =Sayi.nextLine();
		
		 harf = Karakter.charAt(0); 
		 ascii = (int) harf; 
		 
		 while(ascii<49||ascii>57 || Karakter.length()>1){
		        System.out.println("Lütfen 1'den 9 a kadar sayı girin");
		        Karakter =Sayi.nextLine();
				
				 harf = Karakter.charAt(0); 
				 ascii = (int) harf; 
		        }
		 
		 Deger2=Integer.parseInt(Karakter);
		Carpim=Deger1*Deger2;  
		
		System.out.println();
		System.out.println();
		
		System.out.println(Deger1+" İle bilinen sayılar");
		for (int i = 1; i <=100; i++) 
		{
			
			if(i%Deger1==0)  
			{
				System.out.print(i+" ,"); 
				
			}	
		}
		
		
		System.out.println();
		System.out.println();
		
		
		System.out.println(Deger2+"'e bolunebilen sayılar"); 
		for (int a = 1; a <=100; a++);
		{
		{
				
			
					
				
				}
			System.out.println();
			System.out.println();
		
			System.out.println(Carpim+"'e bolunebilen sayılar");
				for (int b = 1; b <=100; b++) 
				{
					if(b%Carpim==0) {
						System.out.print(b+",");
					
	
	}
}
				
}
}

	

}
