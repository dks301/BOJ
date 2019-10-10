package dataStructure;
/*
 * 1.Explain briefly what it is/why it is necessary
 * 2.How it works
 * 3.How it is implemented
 * 4. When it is good, when it is bad
 * 5. What people do to improve it
 */
public class Array {
	/*
	 * 1. 연관된 데이터들을 모아서 관리하기위해 사용하는 것
	 *    / 같은 종류의 데이터가 여러 개 필요할 때 사용
	 * 
	 * 2. index를 활용하여 해당 메모리에 직접 접근하는 방식으로 동작
	 */
	
	// 3.
	public void implementArray() {
		int[] arr = new int[10]; // 사이즈가 10인 배열 선언
		arr[7] = 7; // 배열 arr에서 index가 7인 곳에 7 저장;
		arr[5] = 5;
	} // 내부적으로 arr의 주솟값 = arr[0]의 주솟값만 저장하고 1, 2, ..., 9 까지 연속적으로 메모리에 저장한다.
	
	/*
	 * 4.
	 *   장점:
	 *   구현이 쉽다
	 *   index를 이용한 random access가 가능해 access 성능이 좋다. Big-O(1)
	 *   순차 접근의 경우에도 메모리에 연속적으로 저장되어있기 때문에 캐시 지역성을 이용하는 빠른 접근이 가능.
	 *   
	 *   단점:
	 *   삽입 삭제시에 다음 모든 데이터를 이동시켜야하므로 비효율적이다.
	 *   크기가 고정적이다. 따라서 너무 크게 잡으면 메모리가 낭비되고, 너무 작게 잡으면 부족할 수 있다.
	 *   메모리 재사용이 불가능하다. 사용하지 않는 메모리에는 junk데이터가 들어있다.(ex 짝수만 사용할때, arr[odd]는 미사용)
	 */
	
	/*
	 * 5. 삽입 삭제시에 이점이 있는 LinkedList자료구조 -> 링크드리스트로 ㄱㄱ
	 * 
	 *    자바에서 사용되는 ArrayList
	 *    배열을 List처럼 동적으로 사용하며 초기에 사이즈를 10으로 만들고 full이되었는데 add가 들어오면 grow()함수를 이용해 사이즈를 늘리고 copy한다.
	 */
}
