package com.stackroute.spring.jdbc.main;

import com.stackroute.spring.jdbc.model.Actor;
import com.stackroute.spring.jdbc.model.Movie;
import com.stackroute.spring.jdbc.service.MovieManagerImpl;
import com.stackroute.spring.jdbc.service.MovieManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		MovieManager movieManager = ctx.getBean("movieManager",
				MovieManagerImpl.class);

		Movie cust = createDummyMovie();
		movieManager.createMovie(cust);

		ctx.close();
	}

	private static Movie createDummyMovie() {
		Movie movie = new Movie();
		movie.setId(8);
		movie.setMovieName("vivah");
		movie.setReleaseYear(2015);
		movie.setRating(8);
		Actor actor = new Actor();
		actor.setActorId(8);
		actor.setName("pulkit");
		// setting value more than 20 chars, so that SQLException occurs
		actor.setAge(30);
		movie.setActor(actor);
		return movie;
	}

}
