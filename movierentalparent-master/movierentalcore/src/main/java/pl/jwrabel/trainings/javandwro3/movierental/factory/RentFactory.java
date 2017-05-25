package pl.jwrabel.trainings.javandwro3.movierental.factory;

import pl.jwrabel.trainings.javandwro3.movierental.Rent;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class RentFactory implements MyFactory<Rent> {
	@Override
	public Rent create(String text) {
		try {
			return new Rent(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
