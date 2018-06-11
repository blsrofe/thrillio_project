package dao;

import entities.Bookmark;
import root.DataStore;

public class BookmarkDao {
    
    public Bookmark[][] getBookmarks() {
        return DataStore.getBookmarks();
    }
}
