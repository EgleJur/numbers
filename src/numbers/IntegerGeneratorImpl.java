package numbers;

import java.util.ArrayList;
import java.util.List;

import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

public class IntegerGeneratorImpl implements IntegerGenerator {

	private List<Integer> list;// = new ArrayList<>();
	private int index;// = 0;

	public IntegerGeneratorImpl(int min, int max) {
		list = new ArrayList<>();
		index = 0;

		for (int i = min; i <= max; i++) {
			list.add(i);
		}

		// list = IntStream.rangeClosed(min - 1,
		// max).boxed().collect(Collectors.toList());

	}

	public IntegerGeneratorImpl(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
		list = new ArrayList<>();
		index = 0;
		while (true) {
			try {
				int integer = integerGenerator.getNext();

				if (numberFilter.accept(integer)) {
					list.add(integer);
				}

			} catch (Exception e) {
				break;
			}

		}

	}

	@Override
	public Integer getNext() {

		if (index >= list.size()) {
			return null;
		}
		return list.get(index++);

	}

}
