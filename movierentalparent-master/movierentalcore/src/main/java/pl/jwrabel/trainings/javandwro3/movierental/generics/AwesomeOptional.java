package pl.jwrabel.trainings.javandwro3.movierental.generics;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class AwesomeOptional<T> {

	private T object;

	public AwesomeOptional(T object) {
		this.object = object;
	}

	public static void main(String[] args) {

		String s = "ABC";
		AwesomeOptional<String> stringAwesomeOptional = new AwesomeOptional<>("ABC");
		String object = stringAwesomeOptional.getObject();

		AwesomeOptional<Integer> integerAwesomeOptional = new AwesomeOptional<>(1);
		Integer object1 = integerAwesomeOptional.getObject();
	}

	public boolean isPresent() {
		return object != null;
	}

	public T getObject() {
		return object;
	}
}
