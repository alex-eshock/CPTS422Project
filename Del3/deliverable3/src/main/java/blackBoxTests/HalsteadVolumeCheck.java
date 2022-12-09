package blackBoxTests;

public class HalsteadVolumeCheck {
	public String triangle(int a, int b, int c) {
		if( a ==b && b ==c) {
			return "Equalateral";
		}
		if(a == b && b > c) {
			return "Isosceles";
		}
		else {
			return "Scalene";
		}
	}

}
