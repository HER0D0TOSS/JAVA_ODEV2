import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        double not = 58;

        if(not <= 44){
            System.out.println("KALDINIZ! HARF ARALIĞI: FF");
        }
        else if ((not > 44)&&(not <= 49)) {
            System.out.println("ORTALAMA 1.00 HARF ARALIĞI: DD");
        }
        else if ((not > 49)&&(not <= 59)) {
            System.out.println("ORTALAMA 1.50 HARF ARALIĞI: DC");
        } else if ((not > 59)&&(not <= 69)) {
            System.out.println("ORTALAMA 2.00 HARF ARALIĞI CC");
        }
        else if((not > 69)&&(not<= 79)){
            System.out.println("ORTALAMA 2.50 HARF ARALIĞI CB");
        }
        else if ((not > 79)&&(not <= 84)) {
            System.out.println("ORTALAMA 3.00 HARF ARALIĞI BB");
        }
        else if((not > 84)&&(not <= 89)){
            System.out.println("ORTALAMA 3.50 HARF ARALIĞI BA");
        }
        else if((not >89)&&(not<=100)){
            System.out.println("ORTALAMA 4.OO HARF ARALIĞI AA");
        }
        else{
            System.out.println("KALDINIZ...");
        }
    }
}