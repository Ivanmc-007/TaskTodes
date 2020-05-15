package com.ivan.testTask.myCriteria;

public class QueryCreatorImpl implements QueryCreator {

    @Override
    public <T> Query createSelectQuery(Class<T> type) {
        return new QuerySelect(type);
    }

    @Override
    public <T> Query createDeleteQuery(Class<T> type) {
        throw new UnsupportedOperationException("Not ready yet!");
    }

    @Override
    public <T> Query createSaveQuery(Class<T> type) {
        throw new UnsupportedOperationException("Not ready yet!");
    }
}
