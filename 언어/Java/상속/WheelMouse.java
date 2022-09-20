package 상속;

public class WheelMouse {
	
	Mouse m2 = new Mouse();
	
	public void click() {
		System.out.println("클릭");
	}
	
	public void rigthClick() {
		System.out.println("우클릭");	
	}
	
	public void drag() {
		System.out.println("드래그하기");
	}
	
	public void scroll() {
		System.out.println("스크롤하기");
	}
}
