package tree;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author voyageth
 *         2016-10-27
 */
public class KevinBaconGameTest {
	@Test
	public void test() {
		KevinBaconGame game = new KevinBaconGame();
		game.addMovieActorList(Arrays.asList("a", "b", "c"));
		game.addMovieActorList(Arrays.asList("b", "c", "d"));
		game.addMovieActorList(Arrays.asList("d", "e"));
		System.out.println(game.getKevinBaconNumber("a", "e"));
	}
}