package coreservlets;

import javax.swing.*;

/** A regular JButton created with an ImageIcon and with borders
 *  and content areas turned off.
 *  <p>
 *  From <a href="http://courses.coreservlets.com/Course-Materials/">the
 *  coreservlets.com tutorials on JSF 2, PrimeFaces, Ajax, JavaScript, jQuery, GWT, Android,
 *  Spring, Hibernate, JPA, RESTful Web Services, Hadoop, Spring MVC,
 *  servlets, JSP, Java 8 lambdas and streams (for those that know Java already), 
 *  and Java 8 programming (for those new to Java)</a>.
 */

public class JIconButton extends JButton {
  public JIconButton(String file) {
    super(new ImageIcon(file));
    setContentAreaFilled(false);
    setBorderPainted(false);
    setFocusPainted(false);
  }
}