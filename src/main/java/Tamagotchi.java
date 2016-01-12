import java.util.Timer;
import java.util.TimerTask;

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

  static Timer timer = new Timer();
  static int seconds = 0;


  public Tamagotchi (String name){
    mName = name;
    mAge = 0;
    mFoodLevel = 10;
    mSleepLevel = 10;
    mActivityLevel = 10;
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

  public void addFood(){
    if (mFoodLevel >= 5){
      mFoodLevel = MAX_FOOD;
    } else {
      mFoodLevel += 5;
    }
  }
  public void addSleep(){
    mSleepLevel = MAX_SLEEP;
  }
  public void addPlay(){
    if (mActivityLevel >= 5){
      mActivityLevel = MAX_ACTIVITY;
    } else {
      mActivityLevel += 5;
    }
  }

  public void LifeCycle(){
    mFoodLevel--;
    mSleepLevel--;
    mActivityLevel--;
    if (mActivityLevel == 0) {
      mSleepLevel --;
    }
    if ((mSleepLevel <= 0) || (mFoodLevel <= 0) || (mAge >= 16)){
      mIsAlive = false;
    }
  }

  public void MyTimer(){
    TimerTask task;
      task = new TimerTask() {
        private final int MAX_SECONDS = 300;
        @Override
        public void run() {
          if (seconds < MAX_SECONDS) {
              seconds++;
              if (seconds % 15 == 0) {
                LifeCycle();
              }
          } else {
            mAge ++;
            seconds = 0;
          }
          if (!getAliveStatement()) {
            cancel();
          }
       }
    };
    timer.schedule(task, 0, 1000);
  }

  public void startGame() {
    MyTimer();
  }

  public void killTamagotchi(){
    mIsAlive = false;
  }
}
