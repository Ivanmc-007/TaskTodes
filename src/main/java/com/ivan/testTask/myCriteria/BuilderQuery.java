package com.ivan.testTask.myCriteria;

public interface BuilderQuery {
    BuilderQueryConjunction like(String fieldName, String pattern);
    BuilderQueryConjunction equal(String fieldName, String value);
}
