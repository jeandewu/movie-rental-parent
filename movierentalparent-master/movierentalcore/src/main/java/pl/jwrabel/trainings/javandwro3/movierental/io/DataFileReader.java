package pl.jwrabel.trainings.javandwro3.movierental.io;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import pl.jwrabel.trainings.javandwro3.movierental.factory.MyFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakubwrabel on 22/05/2017.
 */
public class DataFileReader<T> {
	private MyFactory<T> factory;

	public DataFileReader(MyFactory<T> factory) {
		this.factory = factory;
	}

	public List<T> readFromFile(String fileName) throws IOException {
		List<T> returnList = new ArrayList<>();

		List<String> fileLines = Files.readLines(new File(fileName), Charsets.UTF_8);

		for (String line : fileLines) {
			T object = factory.create(line);
			returnList.add(object);
		}

		return returnList;
	}
}
