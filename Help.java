public class Help{

    public Help(){
        printHelp();
    }

    public static void printHelp(){
        System.out.println("For the app to execute you must input one of the following commands:");
        System.out.println("-Help: Shows all the commands.");
        System.out.println("-HttpRequest [URL] reads an URL and prints its information. Insert URL inside [] and remove them.");
        System.out.println("-HttpRequestIndex [URL] prints a JSON referenced to the URL and parses it. Insert URL inside [] and remove them.");
        System.out.println("-Sleep: Sleeps the process for 1 second. Shows time elapsed in milliseconds.");
        System.out.println("-SleepFast: Same functionality as Sleep but implements Threads to show differences in Elapsed Time.");
        System.out.println("-SleepFastImplementsRunnable: Same functionality as SleepFast but implements Runnable instead.");
        System.out.println("-JsonValidateIndex [URL]: Checks an index and validates JSONs found in it. Insert URL inside [] and remove them.");
    }
    public static void printHttpRequestIndexHelp(){
        System.out.println("To use the HttpRequestIndex command, it must contain a valid URL.");
        System.out.println("Example: java sak -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
    }
}

