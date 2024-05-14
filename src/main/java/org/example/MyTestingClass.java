package org.example;


class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Custom hashCode method
    @Override
    public int hashCode() {
        return id * 31;
    }
}

