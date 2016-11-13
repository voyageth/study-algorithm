package recursive;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author voyageth
 *         2016-11-10
 */
public class TelephoneWordTest {
	@Test
	public void printTest() {
		TelephoneWord telephoneWord = new TelephoneWord();
		telephoneWord.printAvailableWordsRec(new int[] {2, 1, 2});
	}

	@Test
	public void getCharKeyTest() {
		TelephoneWord telephoneWord = new TelephoneWord();
		Assert.assertEquals('A', telephoneWord.getCharKey(2, 1));
		Assert.assertEquals('B', telephoneWord.getCharKey(2, 2));
		Assert.assertEquals('C', telephoneWord.getCharKey(2, 3));
		Assert.assertEquals('D', telephoneWord.getCharKey(3, 1));
		Assert.assertEquals('E', telephoneWord.getCharKey(3, 2));
		Assert.assertEquals('F', telephoneWord.getCharKey(3, 3));
		Assert.assertEquals('G', telephoneWord.getCharKey(4, 1));
		Assert.assertEquals('H', telephoneWord.getCharKey(4, 2));
		Assert.assertEquals('I', telephoneWord.getCharKey(4, 3));
		Assert.assertEquals('J', telephoneWord.getCharKey(5, 1));
		Assert.assertEquals('K', telephoneWord.getCharKey(5, 2));
		Assert.assertEquals('L', telephoneWord.getCharKey(5, 3));
		Assert.assertEquals('M', telephoneWord.getCharKey(6, 1));
		Assert.assertEquals('N', telephoneWord.getCharKey(6, 2));
		Assert.assertEquals('O', telephoneWord.getCharKey(6, 3));
		Assert.assertEquals('P', telephoneWord.getCharKey(7, 1));
		Assert.assertEquals('R', telephoneWord.getCharKey(7, 2));
		Assert.assertEquals('S', telephoneWord.getCharKey(7, 3));
		Assert.assertEquals('T', telephoneWord.getCharKey(8, 1));
		Assert.assertEquals('U', telephoneWord.getCharKey(8, 2));
		Assert.assertEquals('V', telephoneWord.getCharKey(8, 3));
		Assert.assertEquals('W', telephoneWord.getCharKey(9, 1));
		Assert.assertEquals('X', telephoneWord.getCharKey(9, 2));
		Assert.assertEquals('Y', telephoneWord.getCharKey(9, 3));
	}

}