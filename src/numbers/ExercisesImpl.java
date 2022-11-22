package numbers;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExercisesImpl implements Exercises {
    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream().min(Integer::compare).get();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream().max(Integer::compare).get();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.hashCode()==o1.hashCode();
      //  return false;
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> actualList = new ArrayList<Integer>();
        iterator.forEachRemaining(actualList::add);
        return actualList;
    }

    @Override
    public int computeSumOfNumbers(int number) {
        int sum = 0;
        for(int i =1; i<=number; i++){
            sum+=i;
        }

        return sum;
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        int sum = 0;
        for(int i =1; i<=number; i++){
            if(numberFilter.accept(i)){
            sum+=i;
            }
        }

        return sum;

    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {
        return null;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
        return null;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int i, int i1) {
        return null;
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return null;
    }
}