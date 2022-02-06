package com.gtxc.util;

/*
    Created by gt at 2:32 PM on Sunday, February 06, 2022.
    Project: GList, Package: com.gtxc.util.
*/

public interface IGList<T> {
    int size();

    int getCapacity();

    void add(T data);

    T get(int index);

    T remove(int index);

    T set(int index, T data);

    String toString();

    int indexOf(T data);

    int lastIndexOf(T data);

    boolean isEmpty();

    T[] toArray();

    void clear();

    IGList<T> sublist(int start, int finish);

    boolean contains(T data);
}
