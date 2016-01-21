/*
 * © Copyright 2015 -  SourceClear Inc
 */

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.ssl.AbstractVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.mindrot.jbcrypt.BCrypt;
import org.richfaces.resource.MediaOutputResource;
import org.springframework.http.converter.xml.AbstractXmlHttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;

import javax.faces.context.FacesContext;
import java.io.IOException;

public class ChrisMethodsTest {
  public static void main(String[] args) throws Exception {
    ChrisMethodsTest chrisMethodsTest = new ChrisMethodsTest(args[0]);

    System.out.println("matches: " + chrisMethodsTest.execute(args[1]));
  }

  private final String hashed;

  public ChrisMethodsTest(String hashed) {
    this.hashed = hashed;
  }

  public boolean execute(String password) throws IOException {
    MediaOutputResource resource = new MediaOutputResource();
    FacesContext context = FacesContext.getCurrentInstance();

    resource.encode(context);


    AbstractXmlHttpMessageConverter converter = new SourceHttpMessageConverter();
    converter.readInternal(String.class, null);

    validateSomeThings("foobar");

    BCrypt.checkpw(password, hashed);

    runSomeHttpTests(null);

    return false;
  }

  private void validateSomeThings(String thing) {
    ValidatorImpl v = new ValidatorImpl(null, null, null, null, null, null, null, null, false);
    v.validateProperty(new Object(), "foo");
  }

  private void runSomeHttpTests(HttpHost host) throws IOException {
    CloseableHttpClient client = new DefaultHttpClient();
    HttpRequest request = null;
    HttpContext context = null;
    client.execute(host, request, context);

    AbstractVerifier av = null;
    av.getCNs(null);
  }
}
