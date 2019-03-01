package Problem02D;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
	public static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		// �ܼ��� ù ��° �ٿ� �ִ� ���ڿ��� �����´�.
		String s1 = scanner.next();
		// �ܼ��� �� ��° �ٿ� �ִ� ���ڿ��� �����´�.
		String s2 = scanner.next();
		
		// ù ��° ���ڿ��� ���Ѵ�.
		MyString mys1 = new MyString(s1);
		// �� ��° ���ڿ��� ���Ѵ�.
		MyString mys2 = new MyString(s2);
		
		// ù ��° ���ڿ��� �� ��° ���ڿ��� ���� ����� ���Ѵ�.
		int result = mys1.compareTo(mys2);
		
		// ���� ���� ����� 0���� ������
		if (result < 0) 
		{
			// -1�� �ֿܼ� ����Ѵ�.
			System.out.println(-1);
		// ���� ���� ����� 0���� ũ��
		} else if (result > 0)
		{
			// 1�� �ֿܼ� ����Ѵ�.
			System.out.println(1);
		// ���� ����� 0�̸�
		} else {
			// 0�� �ֿܼ� ����Ѵ�.
			System.out.println(0);
		}
	}
}

class MyString implements Comparable<MyString>
{
	private char[] characters; // ���� �迭
	
	public MyString(String original)
	{
		// ���ڿ��� ���� �迭�� ��ȯ�Ѵ�.
		characters = original.toCharArray();
	}
	
	public MyString(char[] original)
	{
		// ���� �迭�� ��ü�� �����Ѵ�.
		characters = new char[original.length];
		for (int i = 0; i < characters.length; i++) 
		{
			characters[i] = original[i];
		}
	
	}
	
	/**
	 * this�� �Ķ���� o�� ���Ͽ�
	 *   - this�� ���������� �ռ��� ����
	 *   - o�� ���������� �ռ��� ���
	 *   - ������ ���ڿ��̸� 0
	 *   �� ��ȯ�ϴ� �Լ��� �����Ͻÿ�
	 *   @param other
	 *   @return
	 */
	@Override
	public int compareTo(MyString other) {
		// ª�� ���� ���� ���Ѵ�.
		int n = Math.min(this.characters.length, other.characters.length);
		for (int i = 0; i < n; i++) {
			// �� �ܾ��� ���ڸ� ���Ѵ�.
			if (this.characters[i] < other.characters[i]) {
				return -1;
			} else if (this.characters[i] > other.characters[i]) {
				return 1;
			}
		}
		// �� �ܾ��� ���� ���� ���� ����Ѵ�.
		return this.characters.length - other.characters.length;
	}
	
	/**
	 * �� ���ڿ��� ��ġ�ϸ� true, �ƴϸ� false�� ��ȯ�ϴ� �Լ��� �ۼ��Ͻÿ�.
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		// �ٸ� Ŭ������ ���ϴ� ��ü�� ������ ����
		if (!(obj instanceof MyString)) {
			return false;
		}
		
		// ���̰� �ٸ� ���ڿ��� ���ʿ� ���� ���ڿ��� �� ����.
		MyString other = (MyString)obj;
		if (other.characters.length != this.characters.length) {
			return false;
		}
		
		int n = this.characters.length;
		for (int i = 0; i < n; i++) {
			if (this.characters[i] != other.characters[i]) {
				// �� ���ڶ� �ٸ��� ���� �ٸ� ���ڿ��̴�.
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
