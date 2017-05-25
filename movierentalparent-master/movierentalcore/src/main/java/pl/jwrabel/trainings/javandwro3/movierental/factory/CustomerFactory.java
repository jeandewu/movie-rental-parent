package pl.jwrabel.trainings.javandwro3.movierental.factory;

import pl.jwrabel.trainings.javandwro3.movierental.Customer;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class CustomerFactory implements MyFactory<Customer> {
	@Override
	public Customer create(String text) {
		try {
			return new Customer(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
