package basic.animal;

import basic.animal.animalinterface.Soundable;

public class Bird extends Animal /*implements Soundable 원래는 여기들어감*/{
	public Bird() {
		super();
	}
	public Bird(String species, String name, int maxDistance, String region, String color, int size, int age,
			String sound) {
		super(species, name, maxDistance, region, color, size, age, sound);
		// 슈퍼생성자에 전달받은 인자를 전달
	}

	@Override
	public String toString() {//오버라이드
		// TODO Auto-generated method stub
		return "Bird" + super.toString();//버드+animal의 toString 리턴
	}
}
