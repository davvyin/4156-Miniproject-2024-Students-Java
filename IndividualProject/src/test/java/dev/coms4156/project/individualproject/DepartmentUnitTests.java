package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Course unit tests.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {
  public Department testDepartment;
  public Course sampleCourse;

  /**
   * Sets up a sample department for testing purposes.
   * Initializes a test department with a sample course and
   * assigns an instructor and enrollment capacity.
   */
  @BeforeEach
  public void setupDepartmentForTesting() {

    sampleCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
    Map<String, Course> courses = new HashMap<>();
    courses.put("COMS4156", sampleCourse);
    testDepartment = new Department("CS", courses, "ABC", 100);
  }

  @Test
  public void getNumberOfMajorsTest() {
    assertEquals(100, testDepartment.getNumberOfMajors());
  }

  @Test
  public void addPersonToMajorTest() {
    testDepartment.addPersonToMajor();
    assertEquals(101, testDepartment.getNumberOfMajors());
  }

  @Test
  public void dropPersonFromMajorTest() {
    testDepartment.dropPersonFromMajor();
    assertEquals(99, testDepartment.getNumberOfMajors());
  }

  @Test
  public void dropPersonFromMajorBelowZeroTest() {
    for (int i = 0; i < 100; i++) {
      testDepartment.dropPersonFromMajor();
    }
    testDepartment.dropPersonFromMajor();
    assertEquals(0, testDepartment.getNumberOfMajors());
  }

  @Test
  public void getDepartmentChairTest() {
    assertEquals("ABC", testDepartment.getDepartmentChair()); // Assuming typo to be fixed.
  }

  @Test
  public void getCourseSelectionTest() {
    Map<String, Course> courseSelection = testDepartment.getCourseSelection();
    assertEquals(1, courseSelection.size());
    assertTrue(courseSelection.containsKey("COMS4156"));
    assertEquals(sampleCourse, courseSelection.get("COMS4156"));
  }

  @Test
  public void addCourseTest() {
    Course newCourse = new Course("James", "500 Mudd", "2:00-3:15", 100);
    testDepartment.addCourse("COMS4111", newCourse);
    Map<String, Course> courseSelection = testDepartment.getCourseSelection();
    assertEquals(2, courseSelection.size());
    assertTrue(courseSelection.containsKey("COMS4111"));
    assertTrue(courseSelection.containsKey("COMS4156"));
    assertEquals(newCourse, courseSelection.get("COMS4111"));
  }

  @Test
  public void createCourseTest() {
    testDepartment.createCourse("COMS4111", "James", "600 Mudd", "3:30-4:45", 200);
    Map<String, Course> courseSelection = testDepartment.getCourseSelection();
    assertEquals(2, courseSelection.size());
    assertTrue(courseSelection.containsKey("COMS4111"));
    Course createdCourse = courseSelection.get("COMS4111");
    assertEquals("600 Mudd", createdCourse.getCourseLocation());
  }

  @Test
  public void toStringTest() {
    String expectedString = "CS COMS4156: \nInstructor: "
        + "Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55\n";
    assertEquals(expectedString, testDepartment.toString());
  }

}
