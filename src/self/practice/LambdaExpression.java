package self.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class LambdaExpression {

	public static void main(String[] args) {

		// Use 1
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("Hello before Java 8");
			}
		});
		thread.start();
		Thread thread8 = new Thread(() -> System.out.println("Hello in Java 8"));
		thread8.start();

		// Use 2
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		// for (String feature : features) { System.out.println(feature); }
		features.forEach(n -> System.out.println(n));
		
		// Use 3 using predicate from java.util.function
		Predicate condition = (str) -> ((String) str).length() > 4;
		List languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		System.out.println("Languages which starts with J :");
		filter(languages, (str) -> ((String) str).startsWith("J"));
		System.out.println("Languages which ends with a ");
		filter(languages, (str) -> ((String) str).endsWith("a"));
		System.out.println("Print all languages :");
		filter(languages, (str) -> true);
		System.out.println("Print no language : ");
		filter(languages, (str) -> false);
		System.out.println("Print language whose length greater than 4:");
		languages.stream().filter( (lang) -> condition.test(lang)).forEach((lang) -> {System.out.println(lang + " ");});
		//filter(languages, (str) -> ((String) str).length() > 4);

		// Use 4 : lambda expression with streams
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500); 
		costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
		double bill = costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).reduce(0.0, (a,b) -> a+b);
		System.out.println("bill:" +bill);
}

	public static void filter(List<String> names, Predicate condition) {
		for (String name : names) {
			if (condition.test(name)) {
				System.out.println(name + " ");
			}
		}
	}

}
