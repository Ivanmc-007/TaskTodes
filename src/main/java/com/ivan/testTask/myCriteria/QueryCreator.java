package com.ivan.testTask.myCriteria;

public interface QueryCreator {
    <T> Query createSelectQuery(Class<T> type);
    <T> Query createDeleteQuery(Class<T> type);
    <T> Query createSaveQuery(Class<T> type);
}
