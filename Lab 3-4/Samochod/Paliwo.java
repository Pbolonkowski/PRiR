public class Paliwo  extends Thread{

    int paliwo;
    int zbiornik;
    String name;

    public Paliwo(int paliwo, int zbiornik, String name){
        this.paliwo=paliwo;
        this.zbiornik=zbiornik;
        this.name=name;
    }

    @Override
    public void run() {
        for(int i=0;i<zbiornik;i++) {
                if(paliwo==1){
                    System.out.println("Koniec paliwa w samochodzie: "+name);
                    break;}
                try {
                    paliwo -= 1;
                    System.out.println("Zużywam 1 litr paliwa, zostało: "+ paliwo + " wątek: "+ name);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }
}
