import java.util.ArrayList;
public class JSONValidateIndex extends HttpRequestIndex {
    String firstName;
    String lastName;
    String preferredName;
    String email;
    int count;

    public Boolean parseIndex() {
        for (final String line : urlContent) {
            parseLine(line);
        }
        System.out.println("Total URLs indexed: "+count);
        return true;
    }

    public void parseMore(ArrayList<String> lines) {
        for(final String line : lines){

            String[] subString= line.split("\"");

            if (subString.length > 4) {
                if (subString[1].equals("firstName")) {
                    firstName = subString[3];
                }
                else if (subString[1].equals("lastName")) {
                    lastName = subString[3];
                }
                else if(subString[1].equals("email")){
                    email= subString[3]; 
                }
                else if(subString[1].equals("preferredName")){
                    preferredName= subString[3];
                }
            }
        }
        validate();
    }

    static boolean emailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void validate() {
        System.out.println("Validating..");

        //Checks First name
        if (firstName.length()==0) {
            System.out.println("Invalid First name. First name not found.");
        } else if (firstName.length()<2) {
            System.out.println("Invalid First name. First name should be more than 2 characters.");
        }else if(firstName.length()>16){
            System.out.println("Invalid First name. First name should be less than 16 characters.");
        }else{
            System.out.println("Valid Fist name.");
        }

        //Checks Last name
        if (lastName.length()==0) {
            System.out.println("Invalid Last name. Last name not found.");
        } else if (lastName.length()<2) {
            System.out.println("Invalid Last name. Last name should be more than 2 characters.");
        }else if(lastName.length()>16){
            System.out.println("Invalid Last name. Last name should be less than 16 characters.");
        }else{
            System.out.println("Valid Last name.");
        }

        //Checks Preferred name
        if (preferredName.length() < 2){
            System.out.println("Invalid Preferred name. Preferred name must be more than 2 characters.");
        }else if(preferredName.length()>16){
            System.out.println("Invalid Preferred name. Preferred name must be less than 16 characters.");
        }else {
            System.out.println("Valid Preferred Name!");
        }
        
        //Checks email and validates it
        if (email.length() > 1) {
            if(emailValid(email)){
                System.out.println("Email is valid.\n");
            }else{
                System.out.println("Email is invalid.\n");
            } 
        } else {System.out.println("Invalid. Email not found.");}
    }

    private void parseLine(final String line) {

        final String[] subString = line.split("\"");

        // subString 11 is the subString expected to contain a URL directed to another JSON file.
        if (subString.length >= 11) {
            if (subString[11].indexOf("https://") > -1) {
                count++;
                String embeddedURL = subString[11];
                // we need to generate an http request to the embedded URL
                JSONValidateIndex requestIndex = new JSONValidateIndex();
                if (requestIndex.readURL(embeddedURL)) {
                    System.out.println(requestIndex);
                    parseMore(requestIndex.urlContent);
                }
            }
        }
    }
}