package emailapp;
import java.util.*;
public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String generatedEmail;
    private int MailBoxCapacity = 500;
    private int randomPassLength = 10;
    private String alternateEmail;
    private String companySuffix = "hybelabels.com";


    //Constructor to receive firstname and lastname
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //call a method - return department
        this.department = setDepartment();
        System.out.println("DEPARTMENT: " + this.department);


        //call a method that return random password
        this.password = Setpassword(randomPassLength);
        System.out.println("YOUR PASSWORD IS: " + this.password);

        //generate an email in a given format
        generatedEmail = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + generatedEmail);


    }


    //Ask for the department
    private String setDepartment() {
        System.out.print("DEPARTMENT CODES: \n 1 for Sales \n 2 for Development \n 3 for Accounting \n 0 for none \n Enter the department code \n");
        Scanner sc = new Scanner(System.in);
        int depChoice = sc.nextInt();
        if(depChoice == 1) { return "sales";}
        else if(depChoice == 2) {return "development";}
        else if(depChoice == 3) {return "accounting";}
        return "";


    }


    //Generate a random password

    private String Setpassword(int length) {
        String password1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String password2 = "1234567890";
        String password3 = "abcdefghijklmnopqrstuvwxyz";
        String password4 = "!#$%&()*+,-./:;<=>?@[]^_{|}";

        char[] pass = new char[length];
        for(int i=0; i<length/4; i++) {
            int randomchar = (int) (Math.random() * password1.length());
            pass[i] = password1.charAt(randomchar);
        }
        for(int i=length/4; i<length/2; i++) {
            int randomchar = (int) (Math.random() * password3.length());
            pass[i] = password3.charAt(randomchar);
        }
        for(int i=length/2; i<(length*3)/4; i++) {
            int randomchar = (int) (Math.random() * password4.length());
            pass[i] = password4.charAt(randomchar);
        }
        for(int i=(length*3)/4; i<length; i++) {
            int randomchar = (int) (Math.random() * password2.length());
            pass[i] = password2.charAt(randomchar);
        }
        return new String(pass);
    }



    //Set the mailbox Capacity
    public void setMailboxCapacity(int capacity) {
        this.MailBoxCapacity = capacity;
    }



    //Set the alternate email
    public void setAltEmail(String Alt) {
        this.alternateEmail = Alt;
    }



    //Change the password
    public void setPassword(String password) {
       if(AuthenticatePass(password)){
        this.password = password;
       }
       else{
        System.out.println(" The entered password does not satisfy given conditions: \n 1. The password must contain at least one Uppercase alphabet \n 2. The password must contain at least one Lowercase alphabet \n 3. The password must contain at least one Special Character \n 4. The password must contain at least one numeric character");
       }
        
    }

    //get the mailbox capacity
    public int getMailBoxCapacity() {
        return MailBoxCapacity;
    }

    //get the alternate email
    public String getAltEmail() {
        return alternateEmail;
    }

    //get the password
    public String getpass() {
        return password;
    }

    /*  authenticate password as per the rules:
       1. The password must contain at least one Uppercase alphabet
       2. The password must contain at least one Lowercase alphabet
       3. The password must contain at least one Special Character
       4. The password must contain at least one numeric character
    */

    private boolean AuthenticatePass(String password) {
        int Uppercase_count = 0;
        int Lowercase_count = 0;
        int Specialchar_count = 0;
        int Numeric_char = 0;
        for(int i=0; i<password.length(); i++) {
            if(Character.isUpperCase(password.charAt(i))){
                Uppercase_count +=1;
            }else if(Character.isLowerCase(password.charAt(i))){
                Lowercase_count +=1;
            }else if(checkSpecial(password.charAt(i))) {
                Specialchar_count +=1;
            }else if(Character.isDigit(password.charAt(i))){
                Numeric_char +=1;
            }
        }

        if(Uppercase_count>=1 && Lowercase_count>=1 && Specialchar_count>=1 && Numeric_char>=1) {
            return true;
        }
        return false;
    }

    //method to return if a character is special character or not

    private boolean checkSpecial(char Str){
        String specialCharacters="!#$%&'()*+,-./:;<=>?@[]^_`{|}";
        
    
            if (specialCharacters.contains(Character.toString(Str))) {
                return true;
            }
            return false;
    }









}

