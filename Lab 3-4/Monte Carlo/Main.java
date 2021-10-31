import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MonteCarlo montecarlo1, montecarlo2, montecarlo3, montecarlo4;
        Scanner skaner = new Scanner(System.in);
        System.out.println("Podaj liczbe prób");
        int liczba_prob = skaner.nextInt();
        System.out.println("Podaj promien");
        double r = skaner.nextDouble();

        montecarlo1 = new MonteCarlo( liczba_prob,0,0, r/2, r/2);
        montecarlo2 = new MonteCarlo( liczba_prob,r/2,0, 1, r/2);
        montecarlo3 = new MonteCarlo( liczba_prob,0, r/2, r/2, r);
        montecarlo4 = new MonteCarlo(liczba_prob,r/2,r/2, r, r);

        montecarlo1.run();
        montecarlo2.run();
        montecarlo3.run();
        montecarlo4.run();

        try {
            montecarlo1.join();
            montecarlo2.join();
            montecarlo3.join();
            montecarlo4.join();
        }catch (Exception e){

        } //pole kola
        double pole = montecarlo1.wynik + montecarlo2.wynik + montecarlo3.wynik + montecarlo4.wynik;
        double pi = pole / ((double)liczba_prob * 4);
        System.out.println(pi * r*r);
    }
}
