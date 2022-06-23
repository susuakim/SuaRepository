package 상속;

public class 동물원 {

	public static void main(String[] args) {
		
		쿼카 쿼카1 = new 쿼카();
		
		거북이 거북이1 = new 거북이();

		하마 하마1 = new 하마();
		
		동물[] 동물들 = {쿼카1, 거북이1, 하마1};
		
		for(int i=0; i<동물들.length; i++) {
			동물들[i].먹기();
		}
		
		
		for(동물 animal : 동물들) {
			animal.먹기();
		}
		
	}

}
