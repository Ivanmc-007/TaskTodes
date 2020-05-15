package com.ivan.testTask.services;

import com.ivan.testTask.entities.Gender;
import com.ivan.testTask.entities.Summary;
import com.ivan.testTask.myCriteria.BuilderQuery;
import com.ivan.testTask.myCriteria.Query;
import com.ivan.testTask.myCriteria.QueryCreator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryServiceImpl implements SummaryService {

    private SessionFactory sessionFactory;

    @Autowired
    public SummaryServiceImpl(EntityManagerFactory factory) {
        if(factory.unwrap(SessionFactory.class) == null){
            throw new NullPointerException("factory is not a hibernate factory");
        }
        this.sessionFactory = factory.unwrap(SessionFactory.class);
    }

    @Autowired
    private QueryCreator queryCreator;

    public Summary findBySurnameNamePatronymic(String surname, String name, String patronymic) {
        Session session = sessionFactory.openSession();
        try {
            Query selectQuery = queryCreator.createSelectQuery(Summary.class);
            BuilderQuery builderQuery = selectQuery.builderQuery();
            Query query = builderQuery
                    .equal("surname", surname)
                    .and()
                    .equal("name", name)
                    .and()
                    .equal("patronymic", patronymic)
                    .build();
            String resQuery = query.getQueryAsString();
            List<Summary> summaries = session.createNativeQuery(resQuery,Summary.class).getResultList();
            if(!summaries.isEmpty())
                return summaries.get(0);
            else
                return null;
        } finally {
            session.close();
        }
    }

    public List<Summary> findByGenderOrLastPartOfSurname(Gender gender, String lastPartSurname) {
        Session session = sessionFactory.openSession();
        try {
            Query selectQuery = queryCreator.createSelectQuery(Summary.class);
            BuilderQuery builderQuery = selectQuery.builderQuery();
            Query query = builderQuery
                    .equal("gender", gender.name())
                    .or()
                    .like("surname", "%"+lastPartSurname)
                    .build();
            String resQuery = query.getQueryAsString();
            List<Summary> summaries = session.createNativeQuery(resQuery,Summary.class).getResultList();
            if(!summaries.isEmpty())
                return summaries;
            else
                return new ArrayList<>();
        } finally {
            session.close();
        }
    }

}
