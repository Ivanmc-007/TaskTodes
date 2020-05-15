package com.ivan.testTask.myCriteria;

public class Param<T1,T2> {
    private final T1 t1;
    private final T2 t2;

    public Param(T1 t1, T2 t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    @Override
    public String toString() {
        return "Param[" +
                "field:" + t1 +
                ", value:" + t2 + "]";
    }
}
