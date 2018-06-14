package entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import constants.MovieGenre;
import managers.BookmarkManager;

class MovieTest {

    @Test
    void testIsKidFriendlyEligible() {
        //Test 1 horror in genre--false
        Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "profile url", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
                8.5);
        
        boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
        
        assertFalse("For Horror Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 2 thriller in genre-false
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "profile url", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
                8.5);
        
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        
        assertFalse("For Thrillers Genre - isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 3 anything but thriller or horror should return true
        
        movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "profile url", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
                8.5);
        
        isKidFriendlyEligible = movie.isKidFriendlyEligible();
        
        assertTrue("For anything but thriller or horror - isKidFriendlyEligible should return true", isKidFriendlyEligible);       
    }

}
