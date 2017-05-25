package pl.jwrabel.trainings.javandwro3.movierental;

import pl.jwrabel.trainings.javandwro3.movierental.exceptions.MovieAlreadyExistsException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;
import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullMovieException;

import java.util.Date;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public class MovieRentalMain {
	public static void main(String[] args) throws NullCustomerException, NullMovieException, MovieAlreadyExistsException {
		MovieRental movieRental = new MovieRental();
		movieRental.printAllData();

		System.out.println("dodaję klienta");
		movieRental.addCustomer(new Customer("1234", "Adam", "Kowalski", "Wrocław", new Date()));
		System.out.println("dodaję film");
		movieRental.addMovie(new Movie("Terminator", "Action", "BLA"));
		System.out.println("dodaję wypożyczenie");
		movieRental.addRent(new Rent(0,0));

		movieRental.printAllData();


	}
}
