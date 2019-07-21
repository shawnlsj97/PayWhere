package com.marshmallow.paywhere;

import java.util.Comparator;

/**
 * StoreComparator helps us to sort stores lexicographically based on store names in our list of
 * stores for our RecyclerAdapter.
 */
public class StoreComparator implements Comparator<Store> {

    /**
     * Ignore case when comparing store names.
     * @param s1 First store.
     * @param s2 Other store we are comparing the first store to.
     * @return
     */
    @Override
    public int compare(Store s1, Store s2) {
        return (s1.getName()).compareToIgnoreCase(s2.getName());
    }
}
