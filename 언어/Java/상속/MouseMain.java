package 상속;

public class MouseMain {

	public static void main(String[] args) {
		
		Mouse m1 = new Mouse();
		
		m1.click();
		m1.rigthClick();
		m1.drag();
		
		WheelMouse wm1 = new WheelMouse();
		
		wm1.click();
		wm1.rigthClick();
		wm1.drag();
		wm1.scroll();
		
		System.out.println("게이밍마우스 파트");
		
		GamingMouse gm1 = new GamingMouse();
		gm1.customClick();
		gm1.click();
		
		verticalMouse vm1 = new verticalMouse();
		vm1.customClick();
		vm1.health();
		
		System.out.println(vm1.toString());
		

	}

}
