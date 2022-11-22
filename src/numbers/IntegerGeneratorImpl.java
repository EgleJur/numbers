package numbers;

import lt.itakademija.exam.IntegerGenerator;
import java.util.Random;

public class IntegerGeneratorImpl implements IntegerGenerator {
    @Override
    public Integer getNext() {
        //return null;
        return new Random().nextInt();
    }
    public Integer getNext(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
