package Odevv5;

/**Girilen bir string degerini ters cevirip ekrana yazan Java programi yaziniz.
 
 */
import java.util.Scanner;
/**
 * @author Ömer Dabo
 *
 */
public class TerstenYazma  {

	public static void main(String[] args) {

		 Scanner veri=new Scanner(System.in);
	        String kelime;              
	        System.out.println("KELIME");  
	        kelime=veri.next();
	        
	        
	        System.out.print("YAZININ TERS=");
	        for(int i=kelime.length()-1;i>=0;i--)   
	        {
	            System.out.print(kelime.charAt(i)); 

	}

	}
	}
