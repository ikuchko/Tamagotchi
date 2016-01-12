import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void tamagotchi_initiatesObject_true(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(true, tamagotchi instanceof Tamagotchi);
  }
}
