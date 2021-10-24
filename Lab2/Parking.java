public class Parking {
    static int PARKING =1;
    static int START=2;
    static int JAZDA =3;
    static int KONIEC_PARKOWANIA =4;
    static int BRAK_PALIWA=5;
    int ilosc_miejsc;
    int ilosc_zajetych;
    int ilosc_samochodow;
    Parking(int ilosc_miejsc,int ilosc_samochodow){
        this.ilosc_miejsc =ilosc_miejsc;
        this.ilosc_samochodow =ilosc_samochodow;
        this.ilosc_zajetych=0;
    }
    synchronized int start(int numer){
        ilosc_zajetych--;
        System.out.println("Pozwolenie na rozpoczecie parkowania "+numer);
        return START;
    }
    synchronized int parkuj(){
        try{
            Thread.currentThread().sleep(1000);
        }
        catch(Exception ie){
        }
        if(ilosc_zajetych< ilosc_miejsc){
            ilosc_zajetych++;
            System.out.println("Pozwolenie na parkowanie na miejscu "+ilosc_zajetych);
            return PARKING;
        }
        else
        {return KONIEC_PARKOWANIA;}
    }
    synchronized void zmniejsz(){
        ilosc_samochodow--;
        System.out.println("SKONCZYLO SIE PALIWO");
        if(ilosc_samochodow == ilosc_miejsc) System.out.println("Ilosc samochodow jaka sama jak miejsc");
    }
}