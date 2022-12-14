package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

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
		return o.equals(o1);// o.hashCode()==o1.hashCode();
		// return false;
	}

	@Override
	public boolean isSameObject(Object o, Object o1) {

		return o.hashCode() == o1.hashCode();// o.equals(o1);
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
		for (int i = 1; i <= number; i++) {
			sum += i;
		}

		return sum;

	}

	@Override
	public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
		int sum = 0;
		for (int i = 1; i <= number; i++) {
			if (numberFilter.accept(i)) {
				sum += i;
			}
		}

		return sum;

	}

	@Override
	public List<Integer> computeNumbersUpTo(int number) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < number; i++) {
			list.add(i);
		}
		return list;
	}

	@Override
	public Map<Integer, Integer> countOccurrences(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (Integer integer : list) {

			map.put(integer, (map.getOrDefault(integer, 0) + 1));
		}
		return map;

	}

	@Override
	public IntegerGenerator createIntegerGenerator(int i, int i1) {
		IntegerGeneratorImpl generator = new IntegerGeneratorImpl(i, i1);

		return generator;
	}

	@Override
	public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator,
			NumberFilter numberFilter) {
		IntegerGeneratorImpl generator = new IntegerGeneratorImpl(integerGenerator, numberFilter);
		if (generator != null) {

			return generator;
		}
		return null;
	}
}
