package com.gtxc.util;

/*
    Created by gt at 11:49 AM on Sunday, February 06, 2022.
    Project: GList, Package: com.gtxc.util.
*/

import java.lang.reflect.Array;
import java.util.Arrays;

@SuppressWarnings("unchecked")
public class GList<T> implements IGList<T> {

    private T[] gList;
    private int capacity;


    public GList() {
        this.capacity = 10;
        this.gList = (T[]) new Object[capacity];

    }

    public GList(int capacity) {
        this.capacity = capacity;
        this.gList = (T[]) new Object[capacity];
    }

    @Override
    public int size() {
        int size = 0;
        for (T item : this.gList) {
            if (item != null) {
                ++size;
            }
        }
        return size;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }

    private void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(T data) {
        if (this.capacity == this.size()) {
            setCapacity(capacity * 2);
            T[] expand = (T[]) new Object[this.capacity];
            for (int i = 0; i < this.size(); ++i) {
                expand[i] = this.gList[i];
            }
            this.gList = expand;
        }
        for (int i = 0; i < this.capacity; ++i) {
            if (this.gList[i] == null) {
                this.gList[i] = data;
                break;
            }
        }
    }

    @Override
    public T get(int index) {
        if (index > this.getCapacity()) {
            return null;
        } else if (this.gList[index] == null) {
            return null;
        }
        return (T) this.gList[index];
    }

    @Override
    public T remove(int index) {
        if (index > this.getCapacity()) {
            return null;
        } else if (this.gList[index] == null) {
            return null;
        }
        T removed = this.gList[index];
        for (int i = 0; i < this.size(); ++i) {
            if (i >= index) {
                this.gList[i] = this.gList[i+1];
            }
        }
        return removed;
    }

    @Override
    public T set(int index, T data) {
        if (index > this.getCapacity()) {
            return null;
        } else if (this.gList[index] == null) {
            return null;
        }
        this.gList[index] = data;
        return data;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < this.size() - 1; ++i) {
            if (this.gList[i] != null) {
                s.append(this.gList[i]);
                s.append(", ");
            }
        }
        if (!this.isEmpty()) {
            s.append(this.gList[this.size() - 1]);
        }
        s.append("]");
        return s.toString();
    }

    @Override
    public int indexOf(T data) {
        for (int i = 0; i < this.size(); ++i) {
            if (this.gList[i] == data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T data) {
        for (int i = size()-1; i >= 0; --i) {
            if (this.gList[i] == data) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        for (T item : this.gList) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public T[] toArray() {
        return Arrays.copyOfRange(this.gList, 0, this.size());
    }

    @Override
    public void clear() {
        for (int i = 0; i < this.getCapacity(); ++i) {
            this.gList[i] = null;
        }
    }

    @Override
    public GList<T> sublist(int start, int finish) {
        GList<T> subList = new GList<>();
        if (start >= 0 && start <= finish && finish <= this.size()) {
            for (int i = start; i < finish + 1; ++i) {
                subList.add(this.get(i));
            }
        }
        return subList;
    }

    @Override
    public boolean contains(T data) {
        for (T item : this.gList) {
            if (item == data) {
                return true;
            }
        }
        return false;
    }
}
