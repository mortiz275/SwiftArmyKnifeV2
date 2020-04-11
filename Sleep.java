class SimpleOneSecondSleeper{
    private int sleepNumber;

    SimpleOneSecondSleeper(int sleepNumberIn){
        sleepNumber= sleepNumberIn;
    }
    public void sleep(){
        System.out.println(sleepNumber + " - Going to sleep");
        try{
            Thread.sleep(1000); //Sleep for one second.
        }catch(Exception e){
            System.out.println("Execption: "+e);
        }
        System.out.println("..."+ sleepNumber+"- Done sleeping");
    }
}


public class Sleep{
    public void sleepFunction(){
        SimpleOneSecondSleeper sleeper0= new SimpleOneSecondSleeper(0);
        SimpleOneSecondSleeper sleeper1= new SimpleOneSecondSleeper(1);

        System.out.println("\nSleep");
        long start= System.currentTimeMillis();
        sleeper0.sleep();
        sleeper1.sleep();
        System.out.println("Elapsed time= "+ (System.currentTimeMillis()-start)+"\n");
    }
}