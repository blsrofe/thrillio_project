package root;

import constants.KidFriendlyStatus;
import constants.UserType;
import controllers.BookmarkController;
import entities.Bookmark;
import entities.User;
import partner.Shareable;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing...");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarkList : bookmarks) {
            for (Bookmark bookmark : bookmarkList) {
                // Bookmarking
                if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    if (isBookmarked) {
                        bookmarkCount++;
                        BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                        System.out.println("New Item Bookmarked -- " + bookmark);
                    }
                }

                if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

                    // Mark as Kid Friendly

                    if (bookmark.isKidFriendlyEligible()
                            && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
                            BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
                        }
                    }

                    // Sharing!!

                    if (bookmark.isKidFriendlyEligible()
                            && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                            && bookmark instanceof Shareable) {
                        boolean isShared = getShareDecision();
                        if(isShared) {
                            BookmarkController.getInstance().share(user, bookmark);
                        }
                    }
                }
            }
        }
    }
    
    //TODO : Below methods simulate user input
    private static boolean getShareDecision() {
        return Math.random() < 0.5 ? true : false;      
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
        return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
                : (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
                        : KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5 ? true : false;
    }

}
