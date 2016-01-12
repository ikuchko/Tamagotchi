import org.junit.*;
import static org.junit.Assert.*;

public class AppTest {

  @Test
  public void tamagotchi_initiatesObject_true(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(true, tamagotchi instanceof Tamagotchi);
  }

  @Test
  public void tamagotchi_returnName_Santa(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals("Santa", tamagotchi.getName());
  }

  @Test
  public void tamagotchi_returnAge_0(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(0, tamagotchi.getAge());
  }

  @Test
  public void tamagotchi_returnFoodLevel_10(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(10, tamagotchi.getFoodLevel());
  }

  @Test
  public void tamagotchi_returnSleepLevel_10(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(10, tamagotchi.getSleepLevel());
  }

  @Test
  public void tamagotchi_returnActivityLevel_10(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(10, tamagotchi.getActivityLevel());
  }

  @Test
  public void tamagotchi_returnIsAlive_true(){
    Tamagotchi tamagotchi = new Tamagotchi("Santa");
    assertEquals(true, tamagotchi.getAliveStatement());
  }

}
