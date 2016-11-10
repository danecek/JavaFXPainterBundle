package org.mu.model;


public class MyElementId implements Comparable<MyElementId> {

    private final int id;

    public MyElementId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof MyElementId)) {
            return false;
        }
        return compareTo((MyElementId) o) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
        return hash;
    }

    @Override
    public int compareTo(MyElementId t) {
        return this.id - t.id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
    

}
