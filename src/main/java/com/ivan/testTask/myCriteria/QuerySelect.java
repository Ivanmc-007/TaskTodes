package com.ivan.testTask.myCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuerySelect implements Query {
    private final static String SELECT_QUERY = "SELECT * FROM ";

    private String queryValue = SELECT_QUERY;

    private Class<?> typeClass;

    private List<Param<?,?>> list = new ArrayList<>();

    public <T> QuerySelect(Class<T> type) {
        setNameOfTable(type);
        typeClass = type;
    }

    private <T> void setNameOfTable(Class<T> type) {
        javax.persistence.Entity entity;
        javax.persistence.Table table;
        entity = type.getAnnotation(javax.persistence.Entity.class);
        table = type.getAnnotation(javax.persistence.Table.class);
        if(Objects.isNull(entity)) {
            throw new IllegalArgumentException("It does not Entity!");
        }
        if(Objects.nonNull(table)) {
            queryValue = queryValue.concat(table.name());
            return;
        }
        // todo: заглушка
        // create converter: nameEntity -> nameDB
        queryValue = queryValue.concat(type.getSimpleName().toLowerCase());
    }

    @Override
    public BuilderQuery builderQuery() {
        return new BuilderQueryImpl(typeClass);
    }

    @Override
    public String getQueryAsString() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

    @Override
    public List<Param<?, ?>> getParameters() {
        return list;
    }
}
