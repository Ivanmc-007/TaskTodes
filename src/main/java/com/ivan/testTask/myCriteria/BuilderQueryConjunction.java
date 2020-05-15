package com.ivan.testTask.myCriteria;

public interface BuilderQueryConjunction {
    BuilderQuery and();
    BuilderQuery or();
    Query build();
}
