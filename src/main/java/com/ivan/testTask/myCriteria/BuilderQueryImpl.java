package com.ivan.testTask.myCriteria;

public class BuilderQueryImpl implements BuilderQuery, BuilderQueryConjunction {

    private final static String WHERE = " WHERE ";
    private final static String AND = " AND ";
    private final static String OR = " OR ";
    private final static String LIKE = " LIKE ";
    private final static String EQUAL = " = ";

    private Query query;

    public <T> BuilderQueryImpl(Class<T> type) {
        query = new QuerySelect(type);
    }

    @Override
    public BuilderQueryConjunction equal(String fieldName, String value) {
        setParameters(fieldName, value, EQUAL);
        return this;
    }

    @Override
    public BuilderQuery and() {
        String currStr = query.getQueryAsString();
        currStr = currStr.concat(AND);
        QuerySelect querySelect = (QuerySelect) query;
        querySelect.setQueryValue(currStr);
        query = querySelect;
        return this;
    }

    @Override
    public BuilderQuery or() {
        String currStr = query.getQueryAsString();
        currStr = currStr.concat(OR);
        QuerySelect querySelect = (QuerySelect) query;
        querySelect.setQueryValue(currStr);
        query = querySelect;
        return this;
    }

    @Override
    public BuilderQueryConjunction like(String fieldName, String pattern) {
        setParameters(fieldName, pattern, LIKE);
        return this;
    }

    private void setParameters(String fieldName, String pattern, String operator) {
        query.getParameters().add(new Param<>(fieldName,pattern));
        String currStr = query.getQueryAsString();
        if (!currStr.contains(WHERE)) {
            currStr = currStr.concat(WHERE);
        }
        currStr = currStr.concat(fieldName + operator + '\''+pattern+'\'');
        QuerySelect querySelect = (QuerySelect) query;
        querySelect.setQueryValue(currStr);
        query = querySelect;
    }

    @Override
    public Query build() {
        return query;
    }
}
