package com.ivan.testTask.myCriteria;

import java.util.List;

public interface Query {
    BuilderQuery builderQuery();
    String getQueryAsString();
    List<Param<?,?>> getParameters();
}
