package entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import constants.BookGenre;
import managers.BookmarkManager;

class BookTest {

    @Test
    void testIsKidFriendlyEligible() {
        //Test 1 philosophy genre -- false
        
        Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "profile url", 1854,
                "Wilder Publications", new String[] { "Henry David Thoreau" }, BookGenre.PHIOLOSOPHY, 4.3);
        boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
        
        assertFalse("For philosophy genre, isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 2 self help genre -- false
        
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "profile url", 1854,
                "Wilder Publications", new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();
        
        assertFalse("For self-help genre, isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 3 any genre except philosophy and self-help -- true
        
        book = BookmarkManager.getInstance().createBook(4000, "Walden", "profile url", 1854,
                "Wilder Publications", new String[] { "Henry David Thoreau" }, BookGenre.FICTION, 4.3);
        isKidFriendlyEligible = book.isKidFriendlyEligible();
        
        assertTrue("For any genre except philosopy and self-help, isKidFriendlyEligible should return true", isKidFriendlyEligible);
    }

}
