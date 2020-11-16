import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MockKeyboard {
  public MockKeyboard() {
  }//Mock que simula los datos que recibe un usuario, en este caso int

  public void scanner(Integer dir) {
    InputStream in = new ByteArrayInputStream(dir.toString().getBytes());
    System.setIn(in);
  }//Mock que simula los datos que recibe un usuario, en este caso String

  public void scanner(String string) {
    InputStream in = new ByteArrayInputStream(string.getBytes());
    System.setIn(in);
  }
}