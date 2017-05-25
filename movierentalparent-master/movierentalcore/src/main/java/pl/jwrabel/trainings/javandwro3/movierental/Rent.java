package pl.jwrabel.trainings.javandwro3.movierental;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class Rent implements CsvObject {
	public static final String CSV_SEPARATOR = ",";
	public static final String DATE_PATTERN = "yyyy-MM-dd";

	private int customerId;
	private int movieId;
	private Date date;

	// "customerId,movieId,date(2015-10-11)"
	public Rent(String text) throws ParseException {
		String[] split = text.split(CSV_SEPARATOR);

		this.customerId = Integer.parseInt(split[0]);
		this.movieId = Integer.parseInt(split[1]);

		String dateString = split[2];
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		this.date = simpleDateFormat.parse(dateString);
	}

	public String toCSVString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(customerId);
		stringBuilder.append(CSV_SEPARATOR);
		stringBuilder.append(movieId);
		stringBuilder.append(CSV_SEPARATOR);

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
		String formattedDate = simpleDateFormat.format(date);
		stringBuilder.append(formattedDate);

		return stringBuilder.toString();
	}

	public Rent(int customerId, int movieId) {
		this.customerId = customerId;
		this.movieId = movieId;
		this.date = new Date();
	}

	public int getCustomerId() {
		return customerId;
	}

	public int getMovieId() {
		return movieId;
	}

	public Date getDate() {
		return date;
	}
}
