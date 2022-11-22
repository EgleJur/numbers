package numbers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class IntegerGeneratorImpl implements IntegerGenerator {

	private List<Integer> list;
	private int min;
	private int max;
	private int index;

	public IntegerGeneratorImpl(int min, int max) {
		super();
		this.min = min;
		this.max = max;
		index = 0;
		list = IntStream.rangeClosed(min - 1, max).boxed().collect(Collectors.toList());

	}

	@Override
	public Integer getNext() {
		// return null;
		Integer value = null;
		if (index < list.size()) {
			value = list.get(index);
			index++;
		}
		return value;
	}

	public Integer filterGetNext(NumberFilter numberFilter) {
		List<Integer> tempList = new ArrayList();
		for (Integer integer : list) {
			if (numberFilter.accept(integer)) {
				tempList.add(integer);
			}
		}
		list = tempList;
		return getNext();

	}

}
