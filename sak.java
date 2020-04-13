public class sak{
    public static void main(String[] args){
        System.out.println("");
        if(args.length<1){
            //No input
            long start= System.currentTimeMillis();
            System.out.println("The app needs one command to execute. Use -Help to "
            +"see all the commands");
            System.out.println("");
            Help.printHelp();
            System.out.println("\nElapsed Time: "+(System.currentTimeMillis()-start)+" ms");

        }else if(args[0].equalsIgnoreCase("-Help")){
            //-Help Command
            long start= System.currentTimeMillis();
            System.out.println("Executing Help...");
            Help.printHelp();
            System.out.println("Elapsed Time: "+(System.currentTimeMillis()-start)+" ms");

        }else if(args[0].equalsIgnoreCase("-HttpRequest")){
            //-HttpRequest command
            long start= System.currentTimeMillis();
            System.out.println("Executing HttpRequest...");
            if(args.length<2){
                System.out.println("Invalid URL, please try again");
            }else{
                String URL= args[1];
                HttpRequest request= new HttpRequest();
                if(request.readURL(URL)){
                    System.out.println(request);
                }
            }
            System.out.println("Elapsed Time: "+(System.currentTimeMillis()-start)+" ms");
        }else if(args[0].equalsIgnoreCase("-HttpRequestIndex")){
            //-HttpRequestIndex Command
            long start= System.currentTimeMillis();
            System.out.println("Executing HttpRequestIndex...");
            if(args.length!=2){
                System.out.println("Invalid command Syntax.");
                Help.printHttpRequestIndexHelp();
            }else{
                String indexURL= args[1];
                HttpRequestIndex requestIndex= new HttpRequestIndex();
                if(requestIndex.readURL(indexURL)){
                    System.out.println(requestIndex);
                    requestIndex.parseIndex();
                }
            }
            System.out.println("Elapsed Time: "+(System.currentTimeMillis()-start)+" ms");
        }else if(args[0].equalsIgnoreCase("-Sleep")){
            //-Sleep
            System.out.println("Executing Sleep...");

            Sleep sleep= new Sleep();
            sleep.sleepFunction();
        }else if(args[0].equalsIgnoreCase("-SleepFast")){
            //-SleepFast command
            System.out.println("Executing SleepFast...");
            SleepFast sleepFast= new SleepFast();
            sleepFast.sleepFastFunction();
        }else if(args[0].equalsIgnoreCase("-SleepFastImplementsRunnable")){
            //-SleepImplementsRunnable Command
            System.out.println("Executing SleepFastImplementsRunnable...");
            SleepFastImplementsRunnable sleepFIR= new SleepFastImplementsRunnable();
            sleepFIR.sleepFIRFunction();
        }else if(args[0].equalsIgnoreCase("-JsonValidateIndex")){
            System.out.println("Executing JsonValidator...");
            if(args.length!=2){
                System.out.println("Invalid command Syntax");
            }else{
                String indexURL= args[1];
                JSONValidateIndex jsonVI= new JSONValidateIndex();
                if(jsonVI.readURL(indexURL)){
                    System.out.println(jsonVI);
                    jsonVI.parseIndex();
                }
            }
        }
    }
}