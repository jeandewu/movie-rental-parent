package pl.jwrabel.trainings.javandwro3.movierental.factory;

/**
 * Created by jakubwrabel on 23/05/2017.
 */
public interface MyFactory <T> {
	T create(String text);
}
