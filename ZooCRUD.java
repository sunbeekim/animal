package basic.animal;

import java.util.Scanner;

public class ZooCRUD {
//	private static ZooCRUD instance;
//
//	// 스태틱객체 변수 선언
//	private ZooCRUD() {		
//	}
//	
//	// 기본생성자의 접근제한자를 private
//	public static ZooCRUD getInstance() {
//		if (instance == null) {
//			instance = new ZooCRUD();
//			System.out.println("인스턴스가 생성되었습니다.");
//		} else {
//			System.out.println("인스턴스가 이미 있습니다.");
//		}
//		// 인스턴스가 없으면 생성, 있으면 인스턴스를 반환
//		return instance;
//	}
	private Scanner scanner;
	public ZooCRUD() {
		scanner = new Scanner(System.in);
	}
	
	ZooData zooname = ZooData.HI_ZOO;// enum 클래스
	ZooData location = ZooData.서울;

	public void displayMenu() {
		boolean exit = false;
		while (!exit) {
			System.out.println(zooname + " " + location + " 동물원");
			System.out.println("동물 관리 메뉴:");
			System.out.println("1. 동물 추가");
			System.out.println("2. 동물 삭제");
			System.out.println("3. 동물 수정");
			System.out.println("4. 동물 검색");
			System.out.println("5. 모든 동물 출력");
			System.out.println("6. 종료");
			System.out.print("선택하세요: ");

			int choice = ZooDataManager.getIntegerInput(scanner);

			switch (choice) {
			case 1:
				addAnimal();
				break;
			case 2:
				removeAnimal();
				break;
			case 3:
				updateAnimal();
				break;
			case 4:
				searchAnimal();
				break;
			case 5:
				ZooDataManager.printAllAnimals();
				break;
			case 6:
				System.out.println("종료합니다.");
				exit = true;
				break;
			default:
				System.out.println("잘못된 선택입니다.");
			}
		}
	}

	private void addAnimal() {
	    	// 동물 추가
			System.out.println("1. 새 추가");
			System.out.println("2. 물고기 추가");
			System.out.print("어떤 동물을 추가하시겠습니까? : ");
			int animalChoice = ZooDataManager.getIntegerInput(scanner);
			String animalName = null;
			JUMP: while(true) {
			System.out.println("추가 할 동물의 이름을 입력해주세요 :");
			animalName = ZooDataManager.getStringInput(scanner);
			if(ZooDataManager.searchAnimal(animalName)!=null) {
				System.out.println("[ERROR] 같은 이름의 동물이 있습니다.");
				continue JUMP;
			}else {
				break;
			}
			// 같은 이름은 입력할 수 없게 
			}
			System.out.print("나이를 입력하세요(year): ");
			int animalAge = ZooDataManager.getIntegerInput(scanner);

			System.out.print("서식지를 입력하세요: ");
			String animalHabitat = ZooDataManager.getStringInput(scanner);

			System.out.print("색상을 입력하세요: ");
			String animalColor = ZooDataManager.getStringInput(scanner);

			System.out.print("크기를 입력하세요(cm): ");
			int animalSize = ZooDataManager.getIntegerInput(scanner);

			System.out.print("소리를 입력하세요: ");
			String animalSound = ZooDataManager.getStringInput(scanner);

			System.out.print("최대이동거리를 입력하세요(m): ");
			int animalMaxDistance = ZooDataManager.getIntegerInput(scanner);

			if (animalChoice == 1) {
				// addAnimal(new Bird());
				ZooDataManager.addAnimal(new Bird("새", animalName, animalMaxDistance, animalHabitat, animalColor, animalSize,
						animalAge, animalSound));
				// this()를 이용해서 인자전달값을 최소한으로 할 수 있으나, 전부 입력되게 생성자를 추가하지 않음
			} else if (animalChoice == 2) {
				System.out.print("수영 속도를 입력하세요 (m/h): ");
				int swimSpeed = ZooDataManager.getIntegerInput(scanner);
				System.out.print("잠수 깊이를 입력하세요 (m): ");
				int depthLimited = ZooDataManager.getIntegerInput(scanner);
				ZooDataManager.addAnimal(new Fish("물고기", animalName, animalMaxDistance, animalHabitat, animalColor, animalSize,
						animalAge, animalSound, swimSpeed, depthLimited));
				// addAnimal 메서드의 인자전달 값으로 Fish 타입을 전달
				// Fish class의 생성자와 파라미터의 형태가 같아야 한다.
				// Fish class에 파라미터가 0개인 생성자부터 this()로
				// 생성자를 여러개 만들면 입력값을 적게 넣어도 됨
				// 입력값 없을 시 null
			}
	    }

	private void removeAnimal() {
		System.out.print("삭제할 동물의 이름을 입력하세요: ");
		String removeName = ZooDataManager.getStringInput(scanner);
		ZooDataManager.removeAnimal(removeName);
	}

	private void updateAnimal() {
		// 동물 수정
		System.out.println("수정할 동물의 종류를 선택하세요.");
		System.out.print("1. bird 2. fish : ");
		int choiceBirdAndFish = ZooDataManager.getIntegerInput(scanner);
		if (choiceBirdAndFish == 1) {
			System.out.println("수정할 동물의 이름을 입력하세요:");
			// scanner.nextLine(); // buffer cleaning
			String oldName = ZooDataManager.getStringInput(scanner);
			System.out.print("새로운 이름을 입력하세요: ");
			String newName = ZooDataManager.getStringInput(scanner);
			ZooDataManager.updateAnimalBird(oldName, newName);
		} else {
			System.out.println("수정할 동물의 이름을 입력하세요:");
			// scanner.nextLine(); // buffer cleaning
			String oldName = ZooDataManager.getStringInput(scanner);
			System.out.print("새로운 이름을 입력하세요: ");
			String newName = ZooDataManager.getStringInput(scanner);
			ZooDataManager.updateAnimalFish(oldName, newName);
		}
	}

	private void searchAnimal() {
		// 동물 검색
		System.out.print("검색할 동물의 이름을 입력하세요: ");
		String searchName = ZooDataManager.getStringInput(scanner);
		Animal foundAnimal = ZooDataManager.searchAnimal(searchName);
		if (foundAnimal != null) {
			System.out.println("Found animal: " + foundAnimal);
		} else {
			System.out.println("No animal found with the name: " + searchName);
		}
	}

}
