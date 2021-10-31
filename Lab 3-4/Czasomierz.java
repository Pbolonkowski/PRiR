public class Czasomierz extends Thread {

    public void run() {
        int sekunda=0;
        int minuta = 0;
        int godzina = 0;
        while(true){
            sekunda++;
            if (sekunda == 60) {
                minuta++;
                sekunda = 0;}
                if (minuta == 60) {
                    godzina++;
                    minuta = 0;
                }
                System.out.println("H:"+godzina + " M:" + minuta + " S:" + sekunda);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }


    public static void main(String[] args) {
        Czasomierz cz = new Czasomierz();
        cz.start();
        ;
    }
}
