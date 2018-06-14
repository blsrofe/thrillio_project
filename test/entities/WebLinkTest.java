package entities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import managers.BookmarkManager;

class WebLinkTest {

    @Test
    void testIsKidFriendlyEligible() {
        //Test 1: porn in url -- false
        WebLink webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "profile url",
                "http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html",
                "http://www.javaworld.com");
        
        boolean isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        
        assertFalse("For porn in url, isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 2: porn in title -- false
        
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming porn, Part 2", "profile url",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");
        
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        
        assertFalse("For porn in title, isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 3: adult in host -- false
        
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "profile url",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.adult.com");
        
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        
        assertFalse("For adult in host, isKidFriendlyEligible should return false", isKidFriendlyEligible);
        
        //Test 4: adult in url, but not in host part -- true
        
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "profile url",
                "http://www.javaworld.com/adult/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");
        
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        
        assertTrue("For adult in url, but not in host, isKidFriendlyEligible should return true", isKidFriendlyEligible);
        
        //Test 5: adult in title only -- true
        
        webLink = BookmarkManager.getInstance().createWebLink(2000, "Taming Adult, Part 2", "profile url",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");
        
        isKidFriendlyEligible = webLink.isKidFriendlyEligible();
        
        assertTrue("For adult in title only, isKidFriendlyEligible should return true", isKidFriendlyEligible);
    }

}
