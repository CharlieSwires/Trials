import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Trial {

	public static void main(String[] args) {
		ArrayList<Integer> integers100 = new ArrayList<>();
		for(int i=0;i<100;i++) {
			integers100.add(i);
		}
				
		Date timeStart1 = new Date();
		for (int j=0;j<1000;j++) {
			ArrayList<String> string100 = new ArrayList<>();
			for (Integer i:integers100) {
				string100.add(fizzBuzz(i));
			}
			if (j==0)System.out.println(string100.toString());

		}

		Date timeEnd1 = new Date();
		System.out.println("Loop for = "+(timeEnd1.getTime()-timeStart1.getTime()));
		Date timeStart2 = new Date();

		for (int j=0;j<1000;j++) {
			final ArrayList<String> stringtwo100 = new ArrayList<>();

			integers100.stream().map((i) -> fizzBuzz(i)).forEach((e) -> stringtwo100.add(e));
			if (j==0)System.out.println(stringtwo100.toString());
		}
		
		Date timeEnd2 = new Date();
		System.out.println("Loop stream = "+(timeEnd2.getTime()-timeStart2.getTime()));
		Date timeStart3 = new Date();

		for (int j=0;j<1000;j++) {
			Stream<String> temp  =integers100.parallelStream().map((i) -> fizzBuzz(i));
			List<String> stringthree100 = temp.collect(Collectors.toList());
			if (j==0)System.out.println(stringthree100.toString());
		}
		
		Date timeEnd3 = new Date();
		System.out.println("Loop parallel stream= "+(timeEnd3.getTime()-timeStart3.getTime()));  
		
		ArrayList<Integer> integers1000 = new ArrayList<>();
		for(int i=0;i<1000;i++) {
			integers1000.add(i);
		}
				
		Date timeStart4 = new Date();
		for (int j=0;j<1000;j++) {
			ArrayList<String> string100 = new ArrayList<>();
			for (Integer i:integers1000) {
				string100.add(fizzBuzz(i));
			}
			if (j==0)System.out.println(string100.toString());

		}

		Date timeEnd4 = new Date();
		System.out.println("1000 Loop for = "+(timeEnd4.getTime()-timeStart4.getTime()));
		Date timeStart5 = new Date();

		for (int j=0;j<1000;j++) {
			Stream<String> temp  =integers1000.stream().map((i) -> fizzBuzz(i));
			List<String> stringtwo1000 = temp.collect(Collectors.toList());
			if (j==0)System.out.println(stringtwo1000.toString());
		}
		
		Date timeEnd5 = new Date();
		System.out.println("1000 Loop stream = "+(timeEnd5.getTime()-timeStart5.getTime()));
		Date timeStart6 = new Date();

		for (int j=0;j<1000;j++) {
			Stream<String> temp  =integers1000.parallelStream().map((i) -> fizzBuzz(i));
			List<String> stringthree1000 = temp.collect(Collectors.toList());
			if (j==0)System.out.println(stringthree1000.toString());
		}
		
		Date timeEnd6 = new Date();
		System.out.println("1000 Loop parallel stream= "+(timeEnd6.getTime()-timeStart6.getTime()));

	}

	static String fizzBuzz(Integer i) {
		if ((i%15) == 0) return "fizzBuzz "+i;if ((i%3) == 0) return "fizz "+i;if ((i%5) == 0) return "Buzz "+i;
		return ""+i;
	}
}
