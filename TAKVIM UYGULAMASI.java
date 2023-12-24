/*ÖDEV-1.KISIM : ŞİMDİKİ ZAMANI EKRANA YAZDIRAN BİR TAKVİM ÖRNEĞİ */
/*ÖDEV-2.KISIM : HARF NOTU YAZMA (NOTU 58 OLAN BİR ÖĞRENCİNİN HARF NOTUNU BULMA) */
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main { // JTextField, JLabel ve JPanel değişkenlerini sınıf düzeyine taşıyın
    private int ayHesap, gunhesap;
    private String sonuc,status,verim;
    private JTextField xField;
    private JTextField yField;
    private JTextField field;
    private JPanel panel1;

    public Main() {
        xField = new JTextField(5);
        yField = new JTextField(5);
        field = new JTextField(3);
        panel1 = new JPanel();
    }

    public void Panel(String tarih, String saat) {
        panel1.add(new JLabel(tarih));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(new JLabel(saat));
        panel1.add(new JLabel("ISTENILEN TARIH GUNU"));
        panel1.add(field);

        int result = JOptionPane.showOptionDialog(null, panel1,
                "TAKVIM UYGULAMASI", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"ONCE", "SONRA"}, "default");
        Calendar takvim1 = Calendar.getInstance();

        int gun = takvim1.get(Calendar.DATE);
        int ay = takvim1.get(Calendar.MONTH)+1;
        int yil = takvim1.get(Calendar.YEAR);

        String strGun = Integer.toString(gun);
        String strAy = Integer.toString(ay);
        String strYil = Integer.toString(yil);

        String total = strGun+"-"+strAy+"-"+strYil;
        System.out.println(total);

        if(result == 0){
            List<Integer> degerler = new ArrayList<>();
            System.out.println("ONCEKI BUTON");
            String veri = field.getText();

            int verim = Integer.parseInt(veri);

            if((verim>0)&&(verim<=365)){
                int hesapAy = verim / 30;
                System.out.println("AY DONUSUMU: "+ hesapAy + " AY");
                int hesapGun = verim % 30;
                System.out.println("GUN DONUSUMU: " + hesapGun + " GUN" );

                degerler.add(hesapGun);
                degerler.add(hesapAy);

                int gunToplam = gun - degerler.get(0);
                int ayToplam = ay - degerler.get(1) ;

                if(gunToplam <=0){
                    System.out.println("KONTROL ETME BLOGU");
                    gunToplam +=30;
                    ayToplam = ayToplam - 1;
                    sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
                    System.out.println(sonuc);

                    if(ayToplam <= 0){
                        System.out.println("2. KONTROL ETME BLOĞU");
                        ayToplam += 12;
                        yil = yil-1;
                        System.out.println("yil degeri : " + yil);
                    }

                }

                System.out.println("GUN DEGERİ: "+ gunToplam);
                System.out.println("AY DEGERİ: "+ ayToplam);
                sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
                Panel2(sonuc, status);

            }
            else if(verim>365){
                int hesapYil = verim /365;
                System.out.println("YIL DONUSUMU: " + hesapYil +" YIL");
                int hesapAy = (verim % 365);
                System.out.println("AY DONUSUMU: "+ hesapAy /30 + " AY");
                int hesapGun = (hesapAy) ;
                System.out.println("GUN DONUSUMU: "+ hesapAy % 30 + " GUN");

                degerler.add(hesapAy % 30);
                degerler.add(hesapAy /30);
                degerler.add(hesapYil);

                int gunToplam = gun -  degerler.get(0)  ;
                int ayToplam =  ay - degerler.get(1)  ;
                int yilToplam = yil - degerler.get(2) ;
                
                if(gunToplam <=0){
                    System.out.println("KONTROL ETME BLOGU");
                    gunToplam +=30;
                    ayToplam = ayToplam - 1;
                    sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yil;
                    System.out.println(sonuc);

                    if(ayToplam <= 0){
                        System.out.println("2. KONTROL ETME BLOĞU");
                        ayToplam += 12;
                        yil = yil-1;
                        System.out.println("yil degeri : " + yil);
                    }

                }
                sonuc = verim +" GÜN ÖNCE TARİH: "+ gunToplam+ "-"+ ayToplam+"-"+yilToplam;
                status = Integer.toString(verim);
                Panel2(sonuc, status);
            }

        }
        else if (result == 1) {
            System.out.println("SONRAKI BUTON");
            String status = field.getText();

            ayHesap = Integer.parseInt(status) / 30;
            gunhesap = gun + Integer.parseInt(status);

            takvim1.set(Calendar.MONTH, ay + ayHesap);
            takvim1.set(Calendar.DATE, gun - gunhesap);

            System.out.println(gun);
            System.out.println(ayHesap);
            System.out.println(gunhesap);
        }
    }

    public void Panel2(String sonuc, String status) {
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel(" GUN ONCE " + sonuc));

        int result2 = JOptionPane.showConfirmDialog(null, panel2,
                "TAKVIM UYGULAMASI", JOptionPane.OK_CANCEL_OPTION);
    }
    public void Panel3(String status){
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel(status + " GUN SONRA TARIH: "));


        int result3 = JOptionPane.showConfirmDialog(null, panel3,
                "TAKVIM UYGULAMASI", JOptionPane.OK_CANCEL_OPTION);

    }

    public static void main(String[] args) {
        Main panelim = new Main();

        Calendar zaman = Calendar.getInstance();

        int gun = zaman.get(Calendar.DATE);
        int ay = zaman.get(Calendar.MONTH)+1;
        int yil = zaman.get(Calendar.YEAR);
        int saat = zaman.get(Calendar.HOUR);
        int dakika = zaman.get(Calendar.MINUTE);

        String strgun = Integer.toString(gun);
        String strAy = Integer.toString(ay);
        String strYil = Integer.toString(yil);
        String strSaat = Integer.toString(saat);
        String strDakika = Integer.toString(dakika);

        String tarih = "GUNCEL TARIH: " + strgun + "-" + strAy + "-" + strYil;
        String Saat = "GUNCEL SAAT: " + strSaat + ":" + strDakika;

        // Panel metodunu çağırarak işlemi gerçekleştirin
        panelim.Panel(tarih, Saat);
    }
}