package es.ull.menus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BPPcontainerViewTest {

	@Test
	public void cleanStringWithControlCharactersTest() {
		String dirtyString = "Line1\nLine2\tLine3\bLine4";
		String expectedCleanString = "Line1Line2Line3Line4";
		assertEquals(expectedCleanString, BPPcontainerView.cleanString(dirtyString));
	}

	@Test
	public void cleanStringWithTrailingSpacesTest() {
		String dirtyString = "Trailing spaces    ";
		String expectedCleanString = "Trailing spaces";
		assertEquals(expectedCleanString, BPPcontainerView.cleanString(dirtyString));
	}

	@Test
	public void cleanStringWithLeadingSpacesTest() {
		String dirtyString = "    Leading spaces";
		String expectedCleanString = "    Leading spaces"; // Manteniendo los espacios iniciales
		assertEquals(expectedCleanString, BPPcontainerView.cleanString(dirtyString));
	}


	@Test
	public void cleanStringEmptyTest() {
		String dirtyString = "";
		String expectedCleanString = "";
		assertEquals(expectedCleanString, BPPcontainerView.cleanString(dirtyString));
	}

	@Test
	public void cleanStringWithNewLinesTest() {
		String dirtyString = "Line1\nLine2\nLine3";
		String expectedCleanString = "Line1Line2Line3";
		assertEquals(expectedCleanString, BPPcontainerView.cleanString(dirtyString));
	}

}
