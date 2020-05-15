package com.ivan.testTask.services;

import com.ivan.testTask.entities.Gender;
import com.ivan.testTask.entities.Summary;

import java.util.List;

public interface SummaryService {
    Summary findBySurnameNamePatronymic(String surname, String name, String patronymic);
    List<Summary> findByGenderOrLastPartOfSurname(Gender gender, String lastPartSurname);
}
