package basic.animal.animalinterface;

public interface Appearance extends BasicInformation{//색과 사이즈
	String getColor();
    void setColor(String color);
    
    int getSize();
    void setSize(int size);
}
