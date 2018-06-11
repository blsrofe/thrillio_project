package root;

import constants.BookGenre;
import constants.Gender;
import constants.MovieGenre;
import constants.UserType;
import entities.Bookmark;
import entities.User;
import entities.UserBookmark;
import managers.BookmarkManager;
import managers.UserManager;

public class DataStore {
    private static final int TOTAL_USER_COUNT = 5;
    private static final int USER_BOOKMARK_LIMIT = 5;
    private static final int BOOKMARK_COUNT_PER_TYPE = 5;
    private static final int BOOKMARK_TYPE_COUNT = 3;
    private static User[] users = new User[TOTAL_USER_COUNT];
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPE_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    
    public static User[] getUsers() {
        return users;
    }

    public static Bookmark[][] getBookmarks() {
        return bookmarks;
    }

    public static void loadData() {
        loadUsers();
        loadWebLinks();
        loadBooks();
        loadMovies();
    }

    private static void loadUsers() {
        users[0] = UserManager.getInstance().createUser(1000, "user0@semanticsquare.com", "test", "John", "M",
                Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001, "user1@semanticsquare.com", "test", "Sam", "M",
                Gender.MALE, UserType.USER);
        users[2] = UserManager.getInstance().createUser(1002, "user2@semanticsquare.com", "test", "Anita", "M",
                Gender.MALE, UserType.EDITOR);
        users[3] = UserManager.getInstance().createUser(1003, "user3@semanticsquare.com", "test", "Sara", "M",
                Gender.FEMALE, UserType.EDITOR);
        users[4] = UserManager.getInstance().createUser(1004, "user4@semanticsquare.com", "test", "Dheeru", "M",
                Gender.MALE, UserType.CHIEF_EDITOR);
    }

    private static void loadWebLinks() {
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Taming Tiger, Part 2", "profile url",
                "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
                "http://www.javaworld.com");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001,
                "How do I import a pre-existing Java project into Eclipse and get up and running?", "profile url",
                "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
                "http://www.stackoverflow.com");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Interface vs Abstract Class",
                "profile url", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "NIO tutorial by Greg Travis",
                "profile url", "http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf", "http://cs.brown.edu");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Virtual Hosting and Tomcat", "profile url",
                "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org");
    }

    private static void loadBooks() {
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Walden", "profile url", 1854,
                "Wilder Publications", new String[] { "Henry David Thoreau" }, BookGenre.PHIOLOSOPHY, 4.3);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "Self-Reliance and Other Essays",
                "profile url", 1993, "Dover Publications", new String[] { "Ralph Waldo Emerson" },
                BookGenre.PHIOLOSOPHY, 4.5);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "Light From Many Lamps", "profile url", 1988,
                "Touchstone", new String[] { "Lillian Eichler Watson" }, BookGenre.PHIOLOSOPHY, 5.0);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Head First Design Patterns", "profile url",
                2004, "O'Reilly Media",
                new String[] { "Eric Freeman", "Bert Bates", "Kathy Sierra", "Elisabeth Robson" }, BookGenre.TECHNICAL,
                4.5);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Effective Java Programming Language Guide",
                "profile url", 2007, "Prentice Hall", new String[] { "Joshua Bloch" }, BookGenre.TECHNICAL, 4.9);
    }

    private static void loadMovies() {
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "profile url", 1941,
                new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.CLASSICS,
                8.5);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", "profile url", 1940,
                new String[] { "Henry Fonda", "Jane Darwell" }, new String[] { "John Ford" }, MovieGenre.CLASSICS, 8.2);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness", "profile url", 2004,
                new String[] { "Albert Cullum" }, new String[] { "Leslie Sullivan" }, MovieGenre.DOCUMENTARIES, 7.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", "profile url", 2007,
                new String[] { "Kaley Cuoco", "Jim Parsons" }, new String[] { "Chuck Lorre", "Bill Prady" },
                MovieGenre.TV_SHOWS, 8.7);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Ikiru", "profile url", 1952,
                new String[] { "Takashi Shimura", "Minoru Chiaki" }, new String[] { "Akira Kurosawa" },
                MovieGenre.FOREIGN_MOVIES, 8.4);
    }
}
