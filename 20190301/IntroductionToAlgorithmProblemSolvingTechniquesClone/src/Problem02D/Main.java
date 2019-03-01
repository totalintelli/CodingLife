package Problem02D;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		// 콘솔의 첫 번째 줄에 있는 문자열을 가져온다.
		String s1 = scanner.next();
		// 콘솔의 두 번째 줄에 있는 문자열을 가져온다.
		String s2 = scanner.next();
		
		// 첫 번째 문자열을 구한다.
		MyString mys1 = new MyString(s1);
		// 두 번째 문자열을 구한다.
		MyString mys2 = new MyString(s2);
		
		// 첫 번째 문자열과 두 번째 문자열을 비교한 결과를 구한다.
		int result = mys1.compareTo(mys2);
		
		// 만약 비교한 결과가 0보다 작으면
		if (result < 0) 
		{
			// -1을 콘솔에 출력한다.
			System.out.println(-1);
		// 만약 비교한 결과가 0보다 크면
		} else if (result > 0)
		{
			// 1을 콘솔에 출력한다.
			System.out.println(1);
		// 비교한 결과가 0이면
		} else {
			// 0을 콘솔에 출력한다.
			System.out.println(0);
		}
	}
}

class MyString implements Comparable<MyString>
{
	private char[] characters; // 문자 배열
	
	public MyString(String original)
	{
		// 문자열을 문자 배열로 변환한다.
		characters = original.toCharArray();
	}
	
	public MyString(char[] original)
	{
		// 문자 배열을 객체에 저장한다.
		characters = new char[original.length];
		for (int i = 0; i < characters.length; i++) 
		{
			characters[i] = original[i];
		}
	
	}
	
	/**
	 * this와 파라미터 o를 비교하여
	 *   - this가 사전순으로 앞서면 음수
	 *   - o가 사전순으로 앞서면 양수
	 *   - 동일한 문자열이면 0
	 *   을 반환하는 함수를 설계하시오
	 *   @param other
	 *   @return
	 */
	@Override
	public int compareTo(MyString other) {
		// 짧은 글자 수를 구한다.
		int n = Math.min(this.characters.length, other.characters.length);
		for (int i = 0; i < n; i++) {
			// 두 단어의 글자를 비교한다.
			if (this.characters[i] < other.characters[i]) {
				return -1;
			} else if (this.characters[i] > other.characters[i]) {
				return 1;
			}
		}
		// 두 단어의 글자 차이 수를 출력한다.
		return this.characters.length - other.characters.length;
	}
	
	/**
	 * 두 문자열이 일치하면 true, 아니면 false를 반환하는 함수를 작성하시오.
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		// 다른 클래스에 속하는 객체는 비교하지 말자
		if (!(obj instanceof MyString)) {
			return false;
		}
		
		// 길이가 다른 문자열은 애초에 같은 문자열일 수 없다.
		MyString other = (MyString)obj;
		if (other.characters.length != this.characters.length) {
			return false;
		}
		
		int n = this.characters.length;
		for (int i = 0; i < n; i++) {
			if (this.characters[i] != other.characters[i]) {
				// 한 글자라도 다르면 서로 다른 문자열이다.
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return new String(characters);
	}
}
