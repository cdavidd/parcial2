package edu.eci.pdsw.tests;

import org.quicktheories.core.Gen;
import static org.quicktheories.generators.SourceDSL.strings;

import edu.eci.pdsw.entities.User;


public class Generators {
	static private int nextUserID = 0;
	
	static public Gen<User> users() {
		return strings().basicLatinAlphabet().ofLengthBetween(10, 50)
				.zip(strings().basicLatinAlphabet().ofLengthBetween(10, 50),
						(name, lastName) -> {
							nextUserID++;
							return new User("user"+nextUserID,name,lastName);	
						});
	}
}
