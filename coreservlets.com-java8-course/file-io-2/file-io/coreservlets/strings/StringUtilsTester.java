package coreservlets.strings;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/** Some unit tests using the newer assertThat style.
 *  See StringUtilsTester for a variation that uses the
 *  more traditional assertEquals, assertTrue, and 
 *  assertFalse methods.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

// Note that under some Eclipse settings, Eclipse will make
// a warning that the methods can potentially be declared static.
// In this case, you should ignore the warning, since JUnit methods
// should NOT be static.

public class StringUtilsTester {
  @Test
  public void testReverse() {
    assertThat("oof", is(equalTo(StringUtils.reverseString("foo"))));
    assertThat("rab", is(equalTo(StringUtils.reverseString("bar"))));
    assertThat("!zaB", is(equalTo(StringUtils.reverseString("Baz!"))));
  }
  
  @Test
  public void testPalindromes() {
    String[] matches = 
      { "a", "aba", "Aba", "abba", "AbBa", "abcdeffedcba", "abcdEffedcba" };
    String[] misMatches = 
      { "ax", "axba", "Axba", "abbax", "xAbBa", "abcdeffedcdax", "axbcdEffedcda" };
    for(String s: matches) {
      assertThat(StringUtils.isPalindrome(s), is(true));
    }
    for(String s: misMatches) {
      assertThat(StringUtils.isPalindrome(s), is(false));
    }
  }
}
