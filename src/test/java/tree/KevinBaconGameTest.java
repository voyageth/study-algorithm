package tree;

import org.junit.Test;

import java.util.Arrays;

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
        game.addMovieActorList(Arrays.asList("b", "c", "e"));
        System.out.println(game.getKevinBaconNumber("a", "e"));
    }
}