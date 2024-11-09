package basic.animal.animalinterface;

public abstract interface BasicInformation {
	int getAge();

	void setAge(int age);

	String getName();

	void setName(String name);

	String getColor();

	void setColor(String color);

	int getSize();

	void setSize(int size);

	String getSound();

	String makeSound(String sound);
}
