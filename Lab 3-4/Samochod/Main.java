import java.util.Random;

public class Main {

    public static void main(String[] args) {

		Random rn = new Random();
    	for(int i=0;i<5;i++) {

			Samochod samochod = new Samochod("Honda", 10);
			samochod.tankowanie( rn.nextInt(10)+1);
			samochod.start();
		}
    }
}
