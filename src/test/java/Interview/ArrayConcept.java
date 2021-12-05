package Interview;

import org.bouncycastle.util.Arrays;

public class ArrayConcept {

	public static void main(String[] args) {
		int array1[]= {1,2,3};
		int array2[]=Arrays.copyOf(array1, 4);
		System.out.println(array2[3]);

	}

}
