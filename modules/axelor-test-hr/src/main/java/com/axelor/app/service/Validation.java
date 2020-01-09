package com.axelor.app.service;

import com.axelor.hr.db.Student;
import java.util.*;

public class Validation {
  public Object validationMethod(Object bean, Map<String, Object> context) {
    assert bean instanceof Student;
    Student s = (Student) bean;
    s.setTotal(s.getMarks1() + s.getMarks2() + s.getMarks3());
    java.math.BigDecimal n;
    Double no = (double) (s.getTotal() / 3);
    n = new java.math.BigDecimal(no.toString());
    s.setPersantage(n);
    if (no >= 70) {
      s.setGrade("Distiction");
      s.setGreadselect(1);
      s.setProgress(1);
    } else if (70 > no && 60 <= no) {
      s.setGrade("firstClass");
      s.setGreadselect(2);
      s.setProgress(1);
    } else if (60 < no && 50 <= no) {
      s.setGrade("second class");
      s.setGreadselect(3);
      s.setProgress(2);
    } else if (50 < no && 40 <= no) {
      s.setGrade("passClass");
      s.setGreadselect(4);
      s.setProgress(2);
    } else {
      s.setGrade("fail");
      s.setGreadselect(5);
      s.setProgress(3);
    }
    return bean;
  }
}
