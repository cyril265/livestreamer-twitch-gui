package de.bisquallisoft.twitch.utils;

import java.util.ArrayList;

public class LimitedQueue<E> extends ArrayList<E> {

    private int limit;

    public LimitedQueue(int limit) {
        super(limit);
        this.limit = limit;
    }

    @Override
    public boolean add(E o) {
        if (size() == limit) {
            super.remove(0);
        }
        return super.add(o);
    }

    public E getFirst() {
        if (!isEmpty()) {
            return get(0);
        }
        return null;
    }
}
