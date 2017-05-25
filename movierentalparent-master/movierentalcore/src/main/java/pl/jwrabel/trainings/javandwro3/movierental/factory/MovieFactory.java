package pl.jwrabel.trainings.javandwro3.movierental.factory;

import pl.jwrabel.trainings.javandwro3.movierental.Movie;

import java.text.ParseException;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class MovieFactory implements MyFactory<Movie> {
	@Override
	public Movie create(String text) {
		try {
			return new Movie(text);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
