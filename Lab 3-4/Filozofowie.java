import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore ;


class Filozof1 extends Thread {
    static int MAX;
    static Semaphore[] widelec;
    int mojNum;

    public Filozof1(int nr) {
        mojNum = nr;
    }

    public void setMAX(int MAX) {
        Filozof1.MAX = MAX;
        widelec = new Semaphore[MAX];
    }


    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + mojNum);
            try {
                Thread.sleep((long) (7000 * Math.random()));
            } catch (InterruptedException e) {
            }
            widelec[mojNum].acquireUninterruptibly(); //przechwycenie L widelca
            widelec[(mojNum + 1) % MAX].acquireUninterruptibly(); //przechwycenie P widelca
// jedzenie
            System.out.println("Zaczyna jesc " + mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + mojNum);
            widelec[mojNum].release(); //zwolnienie L widelca
            widelec[(mojNum + 1) % MAX].release(); //zwolnienie P widelca
        }
    }

    public void zacznij_jesc() {
        for (int i = 0; i < MAX; i++) {
            widelec[i] = new Semaphore(1);
        }
        for (int i = 0; i < MAX; i++) {
            new Filozof1(i).start();
        }
    }
}

class Filozof2 extends Thread {
    static int MAX;
    static Semaphore[] widelec;
    int mojNum;

    public Filozof2(int nr) {
        mojNum = nr;
    }

    public  void setMAX(int MAX) {
        Filozof2.MAX = MAX;
        widelec = new Semaphore[MAX];
    }

    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            if (mojNum == 0) {
                widelec[(mojNum + 1) % MAX].acquireUninterruptibly();
                widelec[mojNum].acquireUninterruptibly();
            } else {
                widelec[mojNum].acquireUninterruptibly();
                widelec[(mojNum + 1) % MAX].acquireUninterruptibly();
            }
// jedzenie
            System.out.println("Zaczyna jesc " + mojNum);
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + mojNum);
            widelec[mojNum].release();
            widelec[(mojNum + 1) % MAX].release();
        }
    }

    public void zacznij_jesc()
    {
        for ( int i =0; i<MAX; i++) {
            Filozof2.widelec [ i ]=new Semaphore ( 1 ) ;
        }
        for ( int i =0; i<MAX; i++) {
            new Filozof2(i).start();
        }
    }
}


class Filozof3 extends Thread {
    static int MAX;
    static Semaphore[] widelec ;
    int mojNum;
    Random losuj;

    public Filozof3(int nr) {
        mojNum = nr;
        losuj = new Random(mojNum);
    }

    public void setMAX(int MAX) {
        Filozof3.MAX = MAX;
        widelec = new Semaphore[MAX];
    }

    public void run() {
        while (true) {
// myslenie
            System.out.println("Mysle ¦ " + mojNum);
            try {
                Thread.sleep((long) (5000 * Math.random()));
            } catch (InterruptedException e) {
            }
            int strona = losuj.nextInt(2);
            boolean podnioslDwaWidelce = false;
            do {
                if (strona == 0) {
                    widelec[mojNum].acquireUninterruptibly();
                    if (!(widelec[(mojNum + 1) % MAX].tryAcquire())) {
                        widelec[mojNum].release();
                    } else {
                        podnioslDwaWidelce = true;
                    }
                } else {
                    widelec[(mojNum + 1) % MAX].acquireUninterruptibly();
                    if (!(widelec[mojNum].tryAcquire())) {
                        widelec[(mojNum + 1) % MAX].release();
                    } else {
                        podnioslDwaWidelce = true;
                    }
                }
            } while (podnioslDwaWidelce == false);
            System.out.println("Zaczyna jesc " + mojNum);
            try {
                Thread.sleep((long) (3000 * Math.random()));
            } catch (InterruptedException e) {
            }
            System.out.println("Konczy jesc " + mojNum);
            widelec[mojNum].release();
            widelec[(mojNum + 1) % MAX].release();
        }
    }

    public void zacznij_jesc() {
        for (int i = 0; i < MAX; i++) {
            widelec[i] = new Semaphore(1);
        }
        for (int i = 0; i < MAX; i++) {
            new Filozof3(i).start();
        }
    }
}
public class Filozofowie {

    public static void main(String[] args) {

        System.out.println("Wybierz wariant uruchomienia: \n" +
                " 1.Zwykly \n" +
                " 2.Z niesymetrycznym  sieganiem po widelce \n" +
                " 3.Rzut monety");

        Scanner sc = new Scanner(System.in);
        int wybor;
        wybor = sc.nextInt();

        System.out.println("Podaj liczbe filozofow (od 2 do 100): ");

        int ilosc;
        ilosc = sc.nextInt();

        if(ilosc < 2)
        {
            System.out.println("Za malo filozofow");
        }
        else if(ilosc > 100)
        {
            System.out.println("Za duzo filozofow");
        }
        else {
            switch (wybor){
                case 1:
                    Filozof1 f1 = new Filozof1(1);
                    f1.setMAX(ilosc);
                    f1.zacznij_jesc();
                    break;
                case 2:
                    Filozof2 f2 = new Filozof2(1);
                    f2.setMAX(ilosc);
                    f2.zacznij_jesc();
                    break;
                case 3:
                    Filozof3 f3 = new Filozof3(0);
                    f3.setMAX(ilosc);
                    f3.zacznij_jesc();
                    break;
                default:
                    System.out.println("Podano zla opcje");
            }
        }
    }

}