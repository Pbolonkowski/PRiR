public class Main {
    static int ilosc_samochodow=10;
    static int ilosc_miejsc=5;
    static Parking parking;

    public static void main(String[] args) {
        parking = new Parking(ilosc_samochodow, ilosc_miejsc);
        for(int i = 0; i< ilosc_samochodow; i++)
            new Samochod(i,2000,parking).start();
    }
}