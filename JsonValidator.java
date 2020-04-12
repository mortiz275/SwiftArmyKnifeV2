public class JsonValidator extends HttpRequestIndex{
    private String firstName;
    private String lastName;
    private String email;
    private String preferredName;

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    public void parse(){
        for(final String line:urlContent){
            String[] subString= line.split("\"");

            if (subString.length > 4) {
                if (subString[1].equals("firstName")) {
                    firstName = subString[3];
                }
                if (subString[1].equals("lastName")) {
                    lastName = subString[3];
                }
                if(subString[1].equals("email")){
                    email= subString[3];
                }
                if(subString[1].equals("preferredName")){
                    preferredName= subString[3];
                }
            }
        }//End of For
        
    }
    public void validate() {
        if (urlContent.size() < 1) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: No content loaded\n");
            return;
        }

        //Cheking First names 
        if (firstName.length() == 0) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: First Name (\"firstName\") is required but not found\n\n");
        }else if(firstName.length()<2) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: First Name "+firstName+" is too short to be valid. First name should be longer than 2 characters.\n\n");
        }else if(firstName.length()>16){
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: First Name "+firstName+" is too long to be valid. First name should be shorter than 16 characters.\n\n");
        }else{
            System.out.println("Validating: " + requestURL);
            System.out.println("First Name is valid.\n\n");
        }
        //Checking Last names
        if (lastName.length() == 0) {   
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Last Name (\"lastName\") is required but not found\n\n");         
        } else if(lastName.length()<2) {
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Last Name "+lastName+" is too short to be valid. Last name should be longer than 2 characters.\n\n");
        }else if(lastName.length()>16){
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Last Name "+lastName+" is too long to be valid. Last name should be shorter than 16 characters.\n\n");
        }else{
            System.out.println("Validating: " + requestURL);
            System.out.println("Last Name is valid.\n\n");
        }
        //Checking Email
        if(email.length()==0){
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Email (\"email\") is required but not found\n\n");
        }else if(email.length()>2){
            System.out.println("Validating: "+requestURL);
            if(isValid(email)){
                System.out.println("Email is valid.\n\n");
            }else{
                System.out.println("Email is invalid.\n\n");
            } 
        }
        //Checking Preferred Name
        if(preferredName.length()==0){
            System.out.println("Preferred name not found. This field is optional. JSON is valid.");
        }else if(preferredName.length()<2){
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Preferred name "+preferredName+" is not valid. Preferred name should be longer than 2 characters.\n\n");
        }else if(preferredName.length()>16){
            System.out.println("Validating: " + requestURL);
            System.out.println("    **Failed**: Preferred Name "+preferredName+" is too long to be valid. Preferred name should be shorter than 16 characters.\n\n");
        }else{
            System.out.println("Validating: " + requestURL);
            System.out.println("Preferred Name is valid.\n\n");
        }
    
    }
}