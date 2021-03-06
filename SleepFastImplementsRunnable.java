import java.util.ArrayList;

class RunnableOneSecondSleeper implements Runnable{
    private int sleepNumber;

    RunnableOneSecondSleeper(int sleepNumberIn){
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
    public void run(){
        sleep();
    }
}


public class SleepFastImplementsRunnable{
    public void sleepFIRFunction(){

        RunnableOneSecondSleeper sleeper0= new RunnableOneSecondSleeper(0);
        RunnableOneSecondSleeper sleeper1= new RunnableOneSecondSleeper(1);


        System.out.println("\nNon-Threaded Sleep");
        long start= System.currentTimeMillis();
        sleeper0.sleep();
        sleeper1.sleep();
        System.out.println("Elapsed time= "+ (System.currentTimeMillis()-start)+" ms"+"\n");

        System.out.println("\nThreaded Sleep");
        start= System.currentTimeMillis();

        Thread t0 = new Thread(sleeper0);
        Thread t1= new Thread(sleeper1);
        t0.start();
        t1.start();

        try{
            t0.join();
            t1.join();
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
        System.out.println("Elapsed time= "+ (System.currentTimeMillis()-start)+" ms"+"\n");

        //Sleeping ArrayList
        ArrayList<RunnableOneSecondSleeper> sleeperList= new ArrayList<RunnableOneSecondSleeper>();
        for(int i=2; i<12;i++){
            sleeperList.add(new RunnableOneSecondSleeper(i));
        }

        System.out.println("\nNon-Threaded ArrayList sleep:");
        start= System.currentTimeMillis();
        for(RunnableOneSecondSleeper s:sleeperList){
            s.sleep();
        }
        System.out.println("Elapsed time= "+(System.currentTimeMillis()-start)+" ms");

        System.out.println("\nThreaded ArrayList sleep:");
        ArrayList<Thread> threadList = new ArrayList<Thread>();
        for(RunnableOneSecondSleeper s: sleeperList){
            threadList.add(new Thread(s));
        }

        start= System.currentTimeMillis();
        for(Thread t:threadList){
            t.start();
        }
        try{
            for(Thread t:threadList){
                t.join();
            }
        }catch(Exception e){
            System.out.println("Exception: "+e);
        }
        System.out.println("Elapsed time= "+(System.currentTimeMillis()-start)+" ms");
    }
}