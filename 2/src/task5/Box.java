package task5;

public class Box implements Comparable<Box>{
    public Box(int volume, int worth){
        this.volume=volume;
        this.worth=worth;
    }
    public int getVolume() {
        return volume;
    }

    public int getWorth() {
        return worth;
    }

    private int volume;
    private int worth;

    @Override
    public int compareTo(Box o) {
        return this.getVolume()-o.getVolume();
    }

    @Override
    public String toString() {
        return "Box{" +
                "volume=" + volume +
                ", worth=" + worth +
                '}';
    }
}
