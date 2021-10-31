public class Samochod extends Thread{

    private String nrRej;
    private int pojZbiornika;
    private int paliwo;
    Paliwo paliwo1;
    String name;

    public Samochod (String nr, int _pojZbiornika){
        this.nrRej = nr;
        this.pojZbiornika=_pojZbiornika;
        name=getName();
    }
    public void tankowanie (int _paliwo){
        this.paliwo +=_paliwo;
        paliwo1= new Paliwo(paliwo,pojZbiornika,name);
    }
    public void start(){
        paliwo1.start();
    }
    public void zatrzymajSie(){
        paliwo1.interrupt();
    }
}
