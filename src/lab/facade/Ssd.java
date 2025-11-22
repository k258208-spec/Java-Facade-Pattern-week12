package lab.facade;

public class Ssd implements IHardDrive {
    @Override
    public byte[] read(long lba, int size) {
        System.out.println("SSD: fast read of " + size + " bytes from LBA " + lba);
        byte[] data = new byte[size];
        for (int i = 0; i < size; i++) data[i] = 1;
        return data;
    }
}
