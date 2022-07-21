package 상속;

public class Camel extends Animal{

	@Override
	public void Walk() {
		System.out.println("사막에서 걷다");
	}
	
	public void oil() {
		System.out.println("기름을 저장한다.");
	}

}
