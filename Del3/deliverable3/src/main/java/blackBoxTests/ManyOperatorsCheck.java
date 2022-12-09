package blackBoxTests;

public class ManyOperatorsCheck {
	public int testOperators(int numbers) {
		for (int i =0; i < numbers; i++) {
			numbers+=5;
		}
		
		return numbers;
	}
}
