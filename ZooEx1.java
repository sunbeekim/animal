package basic.animal;

public class ZooEx1 {
/*



package basic.animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
//animal - brid - main클래스
//		 \ fish /    ㅣ 
//추상		구현		ui		  			
//brid나 fish도 abstract 클래스로 하려면
//bird/fish - 독수리/상어 등으로 세분화 해야함
//gui클래스는 생략 

public class Zoo {
	private static ArrayList<Animal> animalsList = new ArrayList<>();
	// 같은 클래스에서만 사용가능한 변수 arraylist 생성 O(n)
	// 프로그램이 실행될때 메모리할당되며 Animal 타입의 변수를 arraylist의 요소로 선언
	private static HashMap<String, Animal> animalsMap = new HashMap<>();
	// hash map <key, value>을 생성 O(1)/보통, O(n)/최악의상황
	// 가벼운 프로그램이라 메모리할당은 상관하지 알고리즘 선택
	// arraylist, hash map O(n) O(1)
	// n값이 적을 때 효율적인 것은? O(n^2)
	// 복잡한 알고리즘의 오버헤드가 시간이 걸릴 수 있음
	// 예를 들어 적은데이터를 가진 객체를 다룰때
	// 숫자를 정렬해서 사용하려 할 때 숫자 정렬에 사용
	private static Iterator<Animal> iter = animalsList.iterator();
	// 객체의 내부구조를 알 필요 없이 요소를 하니씩 구분함

	public static void addAnimal(Animal animal) {//fish 객체를 animal객체로 업캐스팅
		try {
			if(animalsMap.containsKey(animal.getName())){
				throw new IllegalArgumentException("이미 같은 이름을 가진 동물이 있습니다.");
			} 
			animalsList.add(animal);// animal type을 array객체의 add메서드 사용 animal 삽입
			animalsMap.put(animal.getName(), animal);// 동물이름을 키값으로 animal객체를 값으로 저장
		} catch (IllegalArgumentException e) {
	        System.out.println("Error: " + e.getMessage());
	    }			
	}

	// 동물 삭제
	public static void removeAnimal(String name) {// remove 메서드에는 반환값이 있음
		Animal animal = animalsMap.remove(name);// 이름 키값에 해당되는 객체데이터를 반환하고 map에서는 삭제
		if (animal != null) {// animal이 null이 아니라면
			animalsList.remove(animal);// arraylist에서도 index가 아닌 object로 삭제//index는 E 값을 반환 object는 true/false로 반환
			System.out.println(name + " removed from the zoo.");
		} else {
			System.out.println("No animal found with name: " + name);// 이름이 같지 않거나 없으면 못찾음
		}
	}

	// 동물 수정 (새)
	public static void updateAnimalBird(String oldName, String newName) {
//		System.out.println("oldName:" + oldName);
//		System.out.println("newName:" + newName);
		// Animal animal = animalsMap.remove(oldName); 를 써도 되지만 삭제와 구분하기 위해 get을 사용
		Animal animal = animalsMap.get(oldName);// 기존이름 키를 가진 해시맵의 객체데이터를 animal객체에 대임
		if (animal != null) {// species, name, maxDistance, region, color,size, age, sound
			animal = new Bird(animal.getSpecies(), newName, animal.getMaxDistance(), animal.getRegion(),
					animal.getColor(), animal.getSize(), animal.getAge(), animal.getSound());
			// 이름만 바꿀 것이기때문에 나머지는 그대로 사용
			animalsList.removeIf(a -> a.getName().equals(oldName));
			// 리스트의 메서드를 사용 a(arrylist)의 요소 중에 a.name과 oldname을 비교해서 객체삭제
			// 없다면 메서드 자체 false
			animalsList.add(animal);// 새롭게 만든 animal을 추가
			animalsMap.put(newName, animal);// 새로운 키값에 새로만든 animal객체 저장
			animalsMap.remove(oldName);// 기존 키값에 해당하는 animal 제거
			System.out.println("Animal updated: " + oldName + " to " + newName);
		} else {
			System.out.println("No animal found with name: " + oldName);
		}
	}

	// 동물 수정 (물고기)
	public static void updateAnimalFish(String oldName, String newName) {
		Animal animal = animalsMap.get(oldName);// 기존 키값과 맞는 객체데이터를 animal에 대입
		if (animal != null) {
			animal = new Fish(animal.getSpecies(), newName, animal.getMaxDistance(), animal.getRegion(),
					animal.getColor(), animal.getSize(), animal.getAge(), animal.getSound(), 0, 0);
			animalsList.removeIf(a -> a.getName().equals(oldName));
			animalsList.add(animal);
			animalsMap.put(newName, animal);
			animalsMap.remove(oldName);
			// 위의 메서드와 동일
			System.out.println("Animal updated: " + oldName + " to " + newName);
		} else {
			System.out.println("No animal found with name: " + oldName);
		}
	}

	// 동물 검색 검색에 더 적합한 map을 사용
	public static Animal searchAnimal(String name) {
		return animalsMap.get(name);// 키값에 맞는 데이터 반환
		// hash map<name, animal>
	}

	// 모든 동물 출력 모든동물을 출력해야하므로 list 사용
	public static void printAllAnimals() {// 자식클래스 bird와 fish에서 메소드 호출
		if (animalsList.isEmpty()) {
			System.out.println("No animals in the zoo.");
		} else {
			for (Animal animal : animalsList) {// Animal type animal에 animalsList의 값을 저장하고 길이만큼 반복
				// animal = List[animal], animal = List[anima2], animal = List[anima3]...
				if (animal instanceof Bird) {// Bird클래스의 인스턴스에 부모인 animal가 슈퍼생성자 형태로 있음
					// animal이 Bird type의 객체이면
					Bird bird = (Bird) animal; // 다운캐스팅

					System.out.println("//======== Bird ========//");
					System.out.println("Bird: " + bird.getName() + ", Sound: " + bird.getSound());
				} else if (animal instanceof Fish) {
					Fish fish = (Fish) animal; // 다운캐스팅
					System.out.println("//======== Fish ========//");
					System.out.println("Fish: " + fish.getName() + ", Swim Speed: " + fish.getSwimmingSpeed());
					// 물고기에는 소리가 없으므로 소리를 제외하고 출력할 수 있음
					// 다운캐스팅 사용을 위해 억지로 animal에 sound 메서드를 오버라이드했음
				} else {
					System.out.println("Unknown animal: " + animal.getName());
				}
			}
		}
	}

//	 public void printAnimals2() { // 위와 다르게 animal 객체의 메소드에 직접 접근해서 출력
//	        for (Animal animal : animalsList) {//animal의 멤버변수만 private이기에 public메소드를 통해 호출 가능
//	            System.out.println(animal.getSound());
//	        }
//	    }
//	public void printAnimals3() {//반복자를 이용해서 요소를 구분한 animalsList를 Iteratol객체의 animal 타입으로 대입		
//		while (iter.hasNext()) {//다음 값을 가지고 있는지 확인 아니라면 false
//			System.out.println(iter.next().getName()+iter.next().getSize());//name과 size를 리턴
//			
//		}
//	}

	// 정수 입력을 받는 메서드
	public static int getIntegerInput(Scanner scanner) {
		int input = -1;
		boolean validInput = false;
		while (!validInput) {
			try {
				input = Integer.parseInt(scanner.nextLine()); // 정수로 변환
				validInput = true; // 정수가 입력되면 유효한 입력으로 처리
			} catch (NumberFormatException e) {
				System.out.println("정수를 입력하세요.");
			}
		}
		return input;
	}

	// 문자열 입력을 받는 메서드
	public static String getStringInput(Scanner scanner) {
		String input = "";
		boolean validInput = false;
		while (!validInput) {
			input = scanner.nextLine();
			try {
				Integer.parseInt(input);//
				System.out.println("문자열을 입력해주세요.");
			} catch (NumberFormatException e) {
				if (!input.isEmpty()) {
					validInput = true; // 비어있지 않으면 유효한 입력으로 처리
				} else {
					System.out.println("빈 문자열은 입력할 수 없습니다. 다시 시도해주세요.");
				}
			}
		}
		return input;
	}

//===============================================================//
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ZooData zooname = ZooData.HI_ZOO;// enum 클래스
		ZooData location = ZooData.서울;
		boolean exit = false;

		while (!exit) {
			System.out.println("동물 관리 페이지 입니다.");
			System.out.println("//============================//");
			System.out.println(zooname + " " + location + " 동물원 관리 메뉴:");
			System.out.println("1. 동물 추가");
			System.out.println("2. 동물 삭제");
			System.out.println("3. 동물 수정");
			System.out.println("4. 동물 검색");
			System.out.println("5. 모든 동물 출력");
			System.out.println("6. 종료");
			System.out.print("선택하세요: ");

			int choice = getIntegerInput(scanner);

			switch (choice) {
			case 1:
				// 동물 추가
				System.out.println("1. 새 추가");
				System.out.println("2. 물고기 추가");
				System.out.print("어떤 동물을 추가하시겠습니까? : ");
				int animalChoice = getIntegerInput(scanner);

				System.out.println("추가 할 동물의 이름을 입력해주세요 :");
				String animalName = getStringInput(scanner);
				
					if(animalsMap.containsKey(animalName))
				
				
				// 같은 이름은 입력할 수 없게 메서드 추가
				System.out.print("나이를 입력하세요(year): ");
				int animalAge = getIntegerInput(scanner);

				System.out.print("서식지를 입력하세요: ");
				String animalHabitat = getStringInput(scanner);

				System.out.print("색상을 입력하세요: ");
				String animalColor = getStringInput(scanner);

				System.out.print("크기를 입력하세요(cm): ");
				int animalSize = getIntegerInput(scanner);

				System.out.print("소리를 입력하세요: ");
				String animalSound = getStringInput(scanner);

				System.out.print("최대이동거리를 입력하세요(m): ");
				int animalMaxDistance = getIntegerInput(scanner);

				if (animalChoice == 1) {
					// addAnimal(new Bird());
					addAnimal(new Bird("새", animalName, animalMaxDistance, animalHabitat, animalColor, animalSize,
							animalAge, animalSound));
					// this()를 이용해서 인자전달값을 최소한으로 할 수 있으나, 전부 입력되게 생성자를 추가하지 않음
				} else if (animalChoice == 2) {
					System.out.print("수영 속도를 입력하세요 (m/h): ");
					int swimSpeed = getIntegerInput(scanner);
					System.out.print("잠수 깊이를 입력하세요 (m): ");
					int depthLimited = getIntegerInput(scanner);
					addAnimal(new Fish("물고기", animalName, animalMaxDistance, animalHabitat, animalColor, animalSize,
							animalAge, animalSound, swimSpeed, depthLimited));

					// addAnimal 메서드의 인자전달 값으로 Fish 타입을 전달
					// Fish class의 생성자와 파라미터의 형태가 같아야 한다.
					// Fish class에 파라미터가 0개인 생성자부터 this()로
					// 생성자를 여러개 만들면 입력값을 적게 넣어도 됨
					// 입력값 없을 시 null
				}
				break;

			case 2:
				// 동물 삭제
				System.out.print("삭제할 동물의 이름을 입력하세요: ");
				String removeName = getStringInput(scanner);
				removeAnimal(removeName);
				break;

			case 3:
				// 동물 수정
				System.out.println("수정할 동물의 종류를 선택하세요.");
				System.out.print("1. bird 2. fish : ");
				int choiceBirdAndFish = getIntegerInput(scanner);
				if (choiceBirdAndFish == 1) {
					System.out.println("수정할 동물의 이름을 입력하세요:");
					// scanner.nextLine(); // buffer cleaning
					String oldName = getStringInput(scanner);
					System.out.print("새로운 이름을 입력하세요: ");
					String newName = getStringInput(scanner);
					updateAnimalBird(oldName, newName);
				} else {
					System.out.println("수정할 동물의 이름을 입력하세요:");
					// scanner.nextLine(); // buffer cleaning
					String oldName = getStringInput(scanner);
					System.out.print("새로운 이름을 입력하세요: ");
					String newName = getStringInput(scanner);
					updateAnimalFish(oldName, newName);
				}
				break;

			case 4:
				// 동물 검색
				System.out.print("검색할 동물의 이름을 입력하세요: ");
				String searchName = getStringInput(scanner);
				Animal foundAnimal = searchAnimal(searchName);
				if (foundAnimal != null) {
					System.out.println("Found animal: " + foundAnimal);
				} else {
					System.out.println("No animal found with the name: " + searchName);
				}
				break;

			case 5:
				// 모든 동물 출력
				printAllAnimals();
				break;

			case 6:
				// 종료
				System.out.println("프로그램을 종료합니다.");
				exit = true;
				break;

			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
		for (Animal animal : animalsList) {
			System.out.println(animal.getSound());
		}
		scanner.close();
	}

private static void getNameCheck(Animal animal, String animalName) {
	// TODO Auto-generated method stub
	
}
}



 */
}
