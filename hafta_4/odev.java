package odev;

public class odev {

	public static void main(String[] args) {
	int hDegeri=6;
	int rDegeri=4;
	 double piDegeri=3.14;
	   
	double ustTaban,altTaban,yAlan,yanalToplam,vAlanDegeri;
	
  ustTaban=piDegeri*(rDegeri^2);
		System.out.println("üst Tabanın ölcümünü:" +ustTaban);
		altTaban =piDegeri*(rDegeri^2);
		System.out.println("alt Tabanın ölçümünü:"+ altTaban);
		yAlan=2*piDegeri*rDegeri*hDegeri;
System.out.println("yanal yüzeyin alananı:" +yAlan);
 yanalToplam = (yAlan+ustTaban);
System.out.println("yanal toplam:" +yanalToplam);
vAlanDegeri=piDegeri*(rDegeri^2)*hDegeri;
System.out.println("Silindirin hacmi taban alanı:" +vAlanDegeri);

	}
	}


