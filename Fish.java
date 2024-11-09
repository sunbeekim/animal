package basic.animal;

import basic.animal.animalinterface.SwimProperties;

public class Fish extends Animal implements SwimProperties {
	private int swimmingSpeed;
	private int depthLimit;
	String sound = "물고기는 소리를 내지 않습니다.";

	public Fish(String species, String name, int maxDistance, String region, String color, int size, int age,
			String sound, int swimmingSpeed, int depthLimit) {

		super(species, name, maxDistance, region, color, size, age, null);
		this.swimmingSpeed = swimmingSpeed;
		this.depthLimit = depthLimit;
	}

	// 수영 속도
	@Override
	public int getSwimmingSpeed() {
		return swimmingSpeed;
	}

	@Override
	public void setSwimmingSpeed(int swimmingSpeed) {
		this.swimmingSpeed = swimmingSpeed;
	}

	// 잠수 깊이
	@Override
	public int getDepthLimit() {
		return depthLimit;
	}

	@Override
	public void setDepthLimit(int depthLimit) {
		this.depthLimit = depthLimit;
	}

	//(물고기는 소리를 내지 않습니다.)오버라이드 super생성자에서도 sound값은 null로 지정
	@Override
	public String getSound() {
		return sound;
	}

	// Overriding makeSound to allow changing the sound of the Fish (if needed)
	@Override
	public String makeSound(String sound) {
		this.sound = sound; // Optional: Modify the sound of the fish
		return sound;
	}

	// Override toString method
	@Override
	public String toString() {
		return "Fish [Species=" + getSpecies() + ", Name=" + getName() + ", MaxDistance=" + getMaxDistance()
				+ ", Region=" + getRegion() + ", Color=" + getColor() + ", Size=" + getSize() + ", Age=" + getAge()
				+ ", Sound=" + getSound() + ", SwimmingSpeed=" + swimmingSpeed + ", DepthLimit=" + depthLimit + "]";
	}

}
