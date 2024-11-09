package basic.animal;

//setter, getter를 animal에서 구현 안 해도 됨. 
//
public abstract class Animal implements AnimalInterface {
	private String species;
	private String name;
	private int maxDistance;
	private String region;
	private String color;
	private int size;
	private int age;
	private String sound;
	// species, name, maxDistance, region, color,size, age, sound

	public Animal(String species, String name, int maxDistance, String region, String color, int size, int age,
			String sound) {
		super();
		this.species = species; // 종
		this.name = name; // 이름
		this.maxDistance = maxDistance;// 최대이동거리
		this.region = region;// 출몰지역
		this.color = color;// 색
		this.size = size;// 크기
		this.age = age;// 나이
		this.sound = sound;// 소리
	}

	public Animal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "[Species=" + species + ", Name=" + name + ", MaxDistance=" + maxDistance + ", Region=" + region
				+ ", Color=" + color + ", Size=" + size + ", Age=" + age + ", sound=" + sound + "]";
	}

	// Getter and Setter methods
	@Override
	public String getSpecies() {
		return species;
	}

	@Override
	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getMaxDistance() {
		return maxDistance;
	}

	@Override
	public void setMaxDistance(int distance) {
		this.maxDistance = distance;
	}

	@Override
	public String getRegion() {
		return region;
	}

	@Override
	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String getSound() {
		return sound;
	}

	@Override
	public String makeSound(String sound) {
		this.sound = sound;
		return sound;
	}

}
