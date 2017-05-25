package pl.jwrabel.trainings.javandwro3.movierental;

import pl.jwrabel.trainings.javandwro3.movierental.exceptions.NullCustomerException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Created by jakubwrabel on 24/05/2017.
 */
public class MovieRentalWindow extends JFrame {
	private JList<Customer> customerJList;
	private JList<Movie> movieJList;
	private JList<Rent> rentJList;

	private MovieRental movieRental;

	/***
	 * Konstruktor klasy {@link MovieRentalWindow}, przyjmuje obiekt {@link MovieRental} - wypożyczalnię filmów
	 * dla której ma być ustawione, "wypożyczalnię dla której ma być to okno"
	 */
	public MovieRentalWindow(MovieRental movieRental) throws HeadlessException {
		this.movieRental = movieRental;

		setSize(600, 400);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		customerJList = new JList<>();
		customerJList.setPreferredSize(new Dimension(300,200));
		add(customerJList);

		movieJList.setPreferredSize(new Dimension(300,200));
		add(movieJList);

		rentJList = new JList<>();
		rentJList.setPreferredSize(new Dimension(300,200));
		add(rentJList);

		JButton btnAddCustomer = new JButton("Dodaj klienta");
		add(btnAddCustomer);

		MovieRentalWindow movieRentalWindow = this;

		btnAddCustomer.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerWindow(movieRental, movieRentalWindow);
			}
		});

		showCustomers();
		showMovies();
		showRents();

		JButton btnEditCustomer = new JButton("Edytuj klienta");
		add(btnEditCustomer);

		btnAddCustomer.addActionListener(new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddCustomerWindow(movieRental, movieRentalWindow);
			}
		});




	}




	/***
	 * Metoda main do stworzenia wypożyczalni i wyświetlenia dla niej okna
	 */
	public static void main(String[] args) {
		MovieRental movieRental = new MovieRental();
		new MovieRentalWindow(movieRental);
	}

	/***
	 * metoda wyciągająca wszystkich klientów z wypożyczalni i wyświetlająca ich w customerJList (liście w okienku)
	 */
	public void showCustomers() {
		// wyciągnięcie listy klientów z wypożyczalni
		java.util.List<Customer> customerList = movieRental.getCustomers();

		// ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW
		Customer[] customersArray = new Customer[customerList.size()];
		for (int i = 0; i < customersArray.length; i++) {
			customersArray[i] = customerList.get(i);
		}

		// ZAMIANA LISTY KLIENTÓW NA TALBLICĘ KLIENTÓW - 2 sposób
		Customer[] customersArray2 = customerList.toArray(new Customer[customerList.size()]);

		// ustawienie tablicy klientów jako danych, które ma wyświetlać customerJList - Swingowa lista
		customerJList.setListData(customersArray);
	}

	/***
	 * metoda wyciągająca wszystkie wypożyczenia z wypożyczalni i wyświetlająca je w rentsJList (liście w okienku)
	 */
	public void showRents() {
		java.util.List<Rent> rentsList = movieRental.getRents();
		Rent[] rentsArray = rentsList.toArray(new Rent[rentsList.size()]);
		rentJList.setListData(rentsArray);
	}

	/***
	 * metoda wyciągająca wszystkie filmy z wypożyczalni i wyświetlająca je w movieJList (liście w okienku)
	 */
	public void showMovies() {
		java.util.List<Movie> movieList = movieRental.getMovies();
		Movie[] moviesArray = movieList.toArray(new Movie[movieList.size()]);
		movieJList.setListData(moviesArray);
	}
}