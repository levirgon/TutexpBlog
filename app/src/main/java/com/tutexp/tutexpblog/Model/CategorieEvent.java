package com.tutexp.tutexpblog.Model;

import java.util.List;

/**
 * Created by noushad on 12/15/17.
 */

public class CategorieEvent {
    private List<AllCategorie> mCategories;

    public List<AllCategorie> getCategories() {
        return mCategories;
    }

    public CategorieEvent(List<AllCategorie> categories) {
        mCategories = categories;
    }
}
