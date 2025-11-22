package lab.facade;

public class Main {
    public static void main(String[] args) {

        ComputerFacade pc1 = new ComputerFacade(new Ssd());
        pc1.start();
        pc1.sleep();
        pc1.wake();
        pc1.shutdown();

        ComputerFacade pc2 = new ComputerFacade(new Hdd());
        pc2.start();
        pc2.shutdown();
    }
}
