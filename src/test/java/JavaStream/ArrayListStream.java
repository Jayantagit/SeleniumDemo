package JavaStream;

import java.util.Arrays;
import java.util.List;

public class ArrayListStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> lang =Arrays.asList("Java","Python","Ruby");
		
		lang.stream().filter(s->!s.isEmpty()).forEach(s->System.out.println(s));
		

	}

}
