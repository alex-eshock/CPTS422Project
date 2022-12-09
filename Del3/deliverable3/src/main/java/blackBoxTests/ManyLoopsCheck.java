package blackBoxTests;

public class ManyLoopsCheck {
	public void manyLoops() {
		for(int i = 0; i < 2; i++) {
			String test = "Test";
		}
		
		char hyperDrive = '0';
		
		while(hyperDrive == '0') {
			hyperDrive = 'A';
		}
		
		int i =0;
		
		do {
			i++;
		}while(i < 10);
	}

}
