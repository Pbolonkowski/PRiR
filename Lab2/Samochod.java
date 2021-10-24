import java.util.Random;
public class Samochod extends Thread {
    //definicja stanu samolotu
    static int PARKING =1;
    static int START=2;
    static int JAZDA =3;
    static int KONIEC_PARKOWANIA =4;
    static int BRAK_PALIWA =5;
    static int TANKUJ=1000;
    static int REZERWA=500;
    //zmienne pomocnicze
    int numer;
    int paliwo;
    int stan;
    Parking l;
    Random rand;
    public Samochod(int numer, int paliwo, Parking l){
        this.numer=numer;
        this.paliwo=paliwo;
        this.stan= JAZDA;
        this.l=l;
        rand=new Random();
    }

    public void run(){
        while(true){
            if(stan== PARKING){
                if(rand.nextInt(2)==1){
                    stan=START;
                    paliwo=TANKUJ;
                    System.out.println("Na parkingu, szukam miejsca, samochod "+numer);
                    stan=l.start(numer);
                }
                else{
                    System.out.println("Jeszcze nie bede parkowac " + numer);
                }
            }
            else if(stan==START){
                System.out.println("Szukam, samochod "+numer);
                stan= JAZDA;
            }
            else if(stan== JAZDA){
                paliwo-=rand.nextInt(500);
                System.out.println("Samochod "+numer+" szuka ");
                if(paliwo<=REZERWA){
                    stan= KONIEC_PARKOWANIA;
                }
                else try{
                    sleep(rand.nextInt(1000));
                }
                catch (Exception e){}
            }
            else if(stan== KONIEC_PARKOWANIA){
                System.out.println("Zaparkowalem "+numer+" ilosc paliwa "+paliwo);
                stan=l.parkuj();
                if(stan== KONIEC_PARKOWANIA){
                    paliwo-=rand.nextInt(500);
                    System.out.println("REZERWA "+paliwo);
                    if(paliwo<=0) stan= BRAK_PALIWA;
                }
            }
            else if(stan== BRAK_PALIWA){
                System.out.println("Skonczylo sie paliwo samochod "+numer);
                l.zmniejsz();
            }
        }} }