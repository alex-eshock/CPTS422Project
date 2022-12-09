package blackBoxTests;

public class MultExpressionsCheck {
	public void manyExpressions() {
		int a = 69;
		int b = (a+11)/20;
		functionCallExpression((10+10)/20);
	}
	public int functionCallExpression(int answer) {
		return answer;
	}

}
