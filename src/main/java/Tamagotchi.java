@Test
public void tamagotchi_returnActivityLevel_0(){
  Tamagotchi tamagotchi = new Tamagotchi("Santa");
  assertEquals(0, tamagotchi.getActivityLevel());
}

public class Tamagotchi {
  private String mName;
  private int mAge;
  private int mFoodLevel;
  private int mSleepLevel;
  private int mActivityLevel;
  private boolean mIsAlive;
  private final int MAX_AGE = 16;
  private final int MAX_FOOD = 10;
  private final int MAX_ACTIVITY = 10;
  private final int MAX_SLEEP = 10;


  public Tamagotchi (String name){
    mName = name;
    mAge = 0;
    mFoodLevel = 0;
    mSleepLevel = 0;
    mActivityLevel = 0;
    mIsAlive = true;
  }

  public String getName(){
   return mName;
  }

  public int getAge(){
    return mAge;
  }
  public int getFoodLevel(){
    return mFoodLevel;
  }
  public int getSleepLevel(){
    return mSleepLevel;
  }
  public int getActivityLevel(){
    return mActivityLevel;
  }
  public boolean getAliveStatement(){
    return mIsAlive;
  }
}
