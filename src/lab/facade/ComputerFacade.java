package lab.facade;

public class ComputerFacade {
    private final Cpu cpu;
    private final Memory memory;
    private final IHardDrive hd;

    private static final long BOOT_ADDRESS = 0x1000;
    private static final long BOOT_SECTOR = 0x2000;
    private static final int SECTOR_SIZE = 64;

    private byte[] savedState; // for sleep/wake

    public ComputerFacade(IHardDrive hd) {
        this.cpu = new Cpu();
        this.memory = new Memory();
        this.hd = hd;
    }

    public void start() {
        System.out.println("Facade: starting computer");
        cpu.freeze();
        byte[] bootData = hd.read(BOOT_SECTOR, SECTOR_SIZE);
        memory.load(BOOT_ADDRESS, bootData);
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
        System.out.println("Facade: computer started\n");
    }

    public void sleep() {
        System.out.println("Facade: entering sleep mode...");
        savedState = new byte[]{1, 2, 3}; // pretend saved
        System.out.println("Facade: saving state and reducing power...");
    }

    public void wake() {
        System.out.println("Facade: waking up...");
        System.out.println("Facade: restoring saved state of size " + savedState.length);
    }

    public void shutdown() {
        System.out.println("Facade: shutting down computer");
        System.out.println("Facade: power off\n");
    }
}
