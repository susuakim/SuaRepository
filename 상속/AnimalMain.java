package 상속;

public class AnimalMain {

	public static void main(String[] args) {
		
		Dog dog = new Dog();
		chiken chicken = new chiken();
		Camel camel = new Camel();
		
//		ca1.Walk();
//		d1.Walk();
//		ch1.Walk();

		//동물클래스를 담을 수 있는 객체배열 
		Animal[] animals = new Animal[3];
		animals[0] = camel;
		animals[1] = chicken;
		animals[2] = camel;
		
		for(int i=0; i<animals.length; i++) {
			animals[i].Walk();
			
			if(animals[i] instanceof Dog) {
				((Dog)animals[i]).gun();
			}else if(animals[i] instanceof Camel) {
				((Camel)animals[i]).oil();
			}else if(animals[i] instanceof chiken) {
				((chiken)animals[i]).fried();
			}
		}
		
		
		
		
		

	}

}
