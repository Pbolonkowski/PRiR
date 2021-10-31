public class MonteCarlo extends Thread {
    double xp, yp, xk, yk;
    int proby;
    static double wynik;
    public MonteCarlo(int liczba_prob, double xp, double yp, double xk, double yk ) {
        this.proby = liczba_prob;
        this.xp = xp;
        this.yp = yp;
        this.xk = xk;
        this.yk = yk;
        wynik=0;
    }
    public void run() {
        int czyjestwKole = 0;

        for (int i = 0; i < this.proby; i++) {

            double x = Math.random();
            double y = Math.random();

            if ((Math.pow(x,2) + Math.pow(y,2)) <= 1)
                czyjestwKole++;
        }
        wynik =  czyjestwKole;
    }

}
