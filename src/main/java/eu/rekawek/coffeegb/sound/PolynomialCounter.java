package eu.rekawek.coffeegb.sound;

public class PolynomialCounter {

    private final int shiftedDivisor;

    private int i;

    public PolynomialCounter(int value) {
        int clockShift = value >> 4;
        int divisor;
        switch (value & 0b111) {
            case 0:
                divisor = 8;
                break;

            case 1:
                divisor = 16;
                break;

            case 2:
                divisor = 32;
                break;

            case 3:
                divisor = 48;
                break;

            case 4:
                divisor = 64;
                break;

            case 5:
                divisor = 80;
                break;

            case 6:
                divisor = 96;
                break;

            case 7:
                divisor = 112;
                break;

            default:
                throw new IllegalStateException();
        }
        shiftedDivisor = divisor << clockShift;
    }

    public boolean tick() {
        if (++i == shiftedDivisor) {
            i = 0;
            return true;
        } else {
            return false;
        }
    }
}
