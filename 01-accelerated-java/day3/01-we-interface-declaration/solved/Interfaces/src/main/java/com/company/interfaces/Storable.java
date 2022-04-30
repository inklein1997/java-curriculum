package com.company.interfaces;

public interface Storable {
    void storeData();

    void retrieveData();

    default void sillyMethod() {
        // implementation
    }
}
