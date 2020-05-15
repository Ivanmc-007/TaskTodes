package com.ivan.testTask;

import com.ivan.testTask.entities.Gender;
import com.ivan.testTask.entities.Summary;
import com.ivan.testTask.helper.MyDateParser;
import com.ivan.testTask.services.SummaryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InsertTest {
    public static Logger LOG = LoggerFactory.getLogger(InsertTest.class);

    @Autowired
    private SummaryService summaryService;

    @Test
    public void myTestOne() {
        Summary summary = summaryService.findBySurnameNamePatronymic("Морская","Мария","Васильевна");
        Assert.assertNotNull(summary);
        LOG.info("result: ");
        LOG.info(summary.getSurname());
        LOG.info(summary.getName());
        LOG.info(summary.getPatronymic());
        LOG.info(summary.getGender().name());
        LOG.info(MyDateParser.getJustDate(summary.getDateBorn()));
    }

    @Test
    public void myTestTwo() {
        List<Summary> summaries = summaryService.findByGenderOrLastPartOfSurname(Gender.WOMAN,"ов");
        Assert.assertEquals(3,summaries.size());
        LOG.info("List size: "+summaries.size());
    }

}
