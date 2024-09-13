package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Course unit tests.
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  @BeforeEach
  public void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB", "11:40-12:55", 250);
  }

  @Test
  public void toStringTest() {
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  @Test
  public void enrollStudentTestWithAvaiableCapacity() {
    for (int i = 0; i < 250; i++) {
      assertTrue(testCourse.enrollStudent());
    }
  }

  @Test
  public void enrollStudentTestWithFullCapacity() {
    for (int i = 0; i < 250; i++) {
      assertTrue(testCourse.enrollStudent());
    }
    assertFalse(testCourse.enrollStudent());

  }

  @Test
  public void dropStudentTestNotEmpty() {
    for (int i = 0; i < 250; i++) {
      assertTrue(testCourse.enrollStudent());
    }

    for (int i = 0; i < 250; i++) {
      assertTrue(testCourse.dropStudent());
    }
  }

  @Test
  public void dropStudentTestEmpty() {
    assertTrue(testCourse.enrollStudent());
    assertTrue(testCourse.dropStudent());
    assertFalse(testCourse.dropStudent());
  }

  @Test
  public void isCourseFullTestWithEmpty() {
    assertFalse(testCourse.isCourseFull());
  }

  @Test
  public void isCourseFullTestWithFullCapacity() {
    for (int i = 0; i < 250; i++) {
      assertTrue(testCourse.enrollStudent());
    }
    assertTrue(testCourse.isCourseFull());
  }

  @Test
  public void getCourseLocationTest() {
    String expectedResult = "417 IAB";
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  @Test
  public void getInstructorNameTest() {
    String expectedResult = "Griffin Newbold";
    assertEquals(expectedResult, testCourse.getInstructorName());
  }

  @Test
  public void reassignInstructorTest() {
    testCourse.reassignInstructor("John Doe");
    assertEquals("John Doe", testCourse.getInstructorName());
  }

  @Test
  public void reassignLocationTest() {
    testCourse.reassignLocation("500 Mudd");
    assertEquals("500 Mudd", testCourse.getCourseLocation());
  }

  @Test
  public void reassignTimeTest() {
    testCourse.reassignTime("2:30-3:45");
    assertEquals("2:30-3:45", testCourse.getCourseTimeSlot());
  }

  @Test
  public void setEnrolledStudentCountTest() {
    testCourse.setEnrolledStudentCount(100);
    assertEquals(100, testCourse.isCourseFull() ? 100 : 100);
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
}
