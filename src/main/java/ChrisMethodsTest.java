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
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import io.netty.handler.codec.http.websocketx.WebSocket08FrameDecoder

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
    compressDecompressSomeStuff(128);
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
  private void compressDecompressSomeStuff(Integer test) throws FileNotFoundException, IOException {
        
        FileInputStream fin = new FileInputStream("archive.tar.bz2");
        BufferedInputStream in = new BufferedInputStream(fin);
        FileOutputStream out = new FileOutputStream("archive.tar");
        BZip2CompressorInputStream bzIn = new BZip2CompressorInputStream(in);
        final byte[] buffer = new byte[test];
        int n = 0;
        while (-1 != (n = bzIn.read(buffer))) {
          out.write(buffer, 0, n);
       }
        out.close();
        bzIn.close();
       BZip2CompressorOutputStream outputBZStream = null;
       
        try {
            outputBZStream = new BZip2CompressorOutputStream(out);
            
            outputBZStream.finish();
        } catch (Exception e) {
            
        }
        
       
        
        
  }
}
