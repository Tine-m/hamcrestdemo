package test;

import static test.IsEven.isEven;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


import org.hamcrest.Description;import org.hamcrest.TypeSafeDiagnosingMatcher;
import static org.junit.Assert.assertTrue;

/**
 * Custom isEven Matcher
 */
class IsEven extends TypeSafeDiagnosingMatcher<Integer> {
   @Override
   protected boolean matchesSafely(Integer integer, Description description) {
       description.appendText("was ").appendValue(integer).appendText(", which is an Odd number");
       return integer % 2 == 0;
   }

   @Override
   public void describeTo(Description description) {
       description.appendText("an Even number");
   }

   public static IsEven isEven() {
       return new IsEven();
   }
}
//############ Start of Tests #######################
public class HamcrestDemoTest {
  
  @Test
  public void testWithPlainAssert() {
    String measured = "Hello";
    assertEquals("Testing the Dummy Class","Hello",measured);
  }
  
  @Test
  public void testWithHamcrest() {
    String measured= "Hello World";
     assertThat(measured, is(not("Hello")));  
  }
  
   @Test
  public void t1(){
    List<Integer> list = Arrays.asList(1, 2, 4,6,8);
    assertThat(list, not(everyItem(isEven())));
  }
   @Test
  public void t2(){
    List<Integer> list = Arrays.asList(1,2,4,6,8);
    assertThat(list, everyItem(isEven()));
  }
  
  @Test
  public void t3(){
    String measured = "Hello";
    assertTrue(measured.length() % 2 == 0 );
  }
  
  @Test
  public void t4(){
    String measured = "Hello";
    assertThat(measured.length(),isEven());
  }
  
  List<String> names = Arrays.asList("Lars","Tine","Christian");
  @Test
  public void testList1(){
    org.junit.Assert.assertThat(names, hasSize(3));
  }
 @Test
  public void testList2(){
    org.junit.Assert.assertThat(names, contains("Lars","Tine","Christian"));
  }
  
  @Test
  public void testList3(){
    org.junit.Assert.assertThat(names, containsInAnyOrder("Tine","Lars","Christian"));
  }
  @Test
  public void testList4(){
    org.junit.Assert.assertThat(names, hasItem("Lars"));
    org.junit.Assert.assertThat(names, not(hasItem("Ib")));
  }
  @Test
  public void testList5(){
    List<Integer> numbers = Arrays.asList(1,3,4,5,6,7);
    org.junit.Assert.assertThat(numbers, is(everyItem(greaterThan(0))));
  }
  
  
}

