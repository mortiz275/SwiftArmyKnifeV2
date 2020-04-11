public class HttpRequestIndex extends HttpRequest{
    private int count= 0;
    public Boolean parseIndex(){
        for(final String line:urlContent){
            parseLine(line);
        }
        return true;
    }

    private void parseLine(final String line){
        System.out.println("\nParsing: "+line);

        final String[] subString= line.split("\"");

        //Substring 11 is the Contact URL we want to do a HttpRequest
        if(subString.length>11){
            //Substring 9 is "ContactURL"
            if(subString[9].equals("ContactURL")){
                String contactURL = subString[11];

                System.out.println("\nHttpRequest at: "+contactURL);

                String URL= contactURL;
                HttpRequest request= new HttpRequest();
                if(request.readURL(URL)){
                    System.out.println(request);
                    count++;
                }
                
            }
            System.out.println("Total URLs found: "+count);
        }
    }
}