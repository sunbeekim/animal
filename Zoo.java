package basic.animal;

//animal - brid - main클래스
//		 \ fish /    ㅣ 
//
//추상		구현		
//animal	interface totalui -	ui
//	fish , brid			|	   add						button
//manager	crud	main	   delte	-	component - panel
//			data				modify					...	
//								search
//
//brid나 fish도 abstract 클래스로 하려면
//bird/fish - 독수리/상어 등으로 세분화 해야함
//gui클래스는 생략 

public class Zoo {

//	public int instanceMethod1() {
//		int result = staticMethod1();
//
//		return result;
//	}
//
//	public static int staticMethod1() {
//		int staticValue = 10;
//		return staticValue;
//	}
//
//	public int instanceMethod2(int a) {
//		System.out.println("instanceMethod2 입니다 : " + a);
//		return a;
//	}
//
//	public static void staticMethod2() {
//		int staticValue = 10;
//		Zoo zooSatic = new Zoo();
//		System.out.println("staticMethod2 입니다.");
//		zooSatic.instanceMethod2(staticValue);
//
//	}

//===============================================================//
	public static void main(String[] args) {
		// ZoodataManger dataManager = new ZooDataManager();
		// ZooCRUD zoo = new ZooCRUD(dataManager);
		// ZoodataManger 클래스에 statci을 안쓸경우
		// stacit를 안 쓰면 현재 구조대로라면 3~4개의 메소드 메모리 할당을 줄일 수있음
		// ZooCRUD에서 Menu() 메소드는 종료될 때까지 실행되고
		// 나머지 crud 메서드는 호출이 되야 메모리 할당이 됨
		// 결국 메모리 할당을 줄일 수 있음
		// 그럼 Menu()메소드는 static하면 되지 않나? 싶지만
		// static 메소드에서는 static 메소드를 호출이 가능함
		// instance 메소드나 필드는 호출할 수 없기 때문에
		// 기존 crud 메서드들도 static 선언을 해야함
		// 공통적으로 사용된다면 써도 되지만, ZooDataManager에 썻을 때와 차이가 거의 없음
		// 그러므로 사용자인터페이스 역할의 crud 데어티관리 zoodatamanager로 나눠서 가독성을 높이는 편을 선택
		// 분리되어 있어 테스트에도 좋음
		// 다른 클래스에서 데이터에 접근할 때 crud를 거쳐야해서 일관적이고 유지보수에 유리함
		// 다른 클래스에서 zoodatamanager에 직접 접근해서 사용하려면 복잡해짐
		// crud라는 가이드라인을 만들어서 재사용성을 높임
		// 스태틱은 로딩시점에 이미 준비완료 상태라 준비가 안된 인스턴스를 파악못함
		// 9시에 출근하는 스태틱은 9시 이후 랜덤시간에 출근하고 퇴근하는 인스턴스를 부를 수 없음
		// 9시 이후 랜덤 출근하는 인스턴스는 스태틱이 있다는 걸 알아서 호출가능
		// 다른 예로 스태틱이 인스턴스를 호출할 수 있는거 아닌가?
		// 랜덤출근하는 인스턴스를 스태틱은 찾지 않음-매번 찾았는데 없다면 매우 비효율적
		// 그럼 인스턴스가 스태틱을 불러서 일을 시키고 결과를 알려달라고 했다면?
		// 스태틱이 인스턴스가 출근했다는 것을 알고 결과를 알려줄 수 있음
		// 이 경우 return만 가능
		// 그럼에도 굳이 메소드형식의 호출을 하고 싶다면,
		// 인스턴스 호출이 아니라 해당 인스턴스를 가진 객체를 생성해서 호출히야함
		// Zoo zooMain = new Zoo();
		// System.out.println("instanceMethod1 : " + zooMain.instanceMethod1());
		// System.out.println("staticMethod1 : " + Zoo.staticMethod1());
		// zooMain.instanceMethod2(5);//5의 반환값
		// Zoo.staticMethod2();//static 메서드를 거쳐가서 인스턴스메서드2 는 10을 반환
		ZooCRUD zoo = new ZooCRUD();	
		zoo.displayMenu();
		// 예시로 만든 싱글톤 ZooCRUD.getInstance();
		// 쓸 필요는 없지만, 기능에 선택일괄삭제가 있다면 사용
		// 선택일괄삭제 객체에 동물을 추가, 삭제 한 후 최종 삭제하므로 추가된 동물과, 삭제된 동물을 추적해야 함
		// 그러므로 단일객체로써 존재해야함
	}
}
