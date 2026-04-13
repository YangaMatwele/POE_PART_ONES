import java.util.Scanner;

public class Registration {

    Scanner scanner = new Scanner(System.in);

    String userName;
    String password;
    String phoneNumber;
    String FirstName;
    String LastName;

    //Sets and checks conditions for username-must be less than or equals to 5 chars, and contain "_"
    public boolean checkuserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    //Sets and checks conditions for password-must be at least 8 chars can contain upper class,digit or special charecters
    public boolean checkPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasUppercase = false;
        boolean hasSpecial = false;
        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if ( Character.isUpperCase(ch)) hasUppercase = true;
            if (!Character.isLetterOrDigit(ch)) hasSpecial =true;
            if (Character.isDigit(ch)) hasDigit = true;
        }
        return hasUppercase && hasSpecial && hasDigit;


    }

    //Sets and checks condition for phoneNumber-must start with +27 or 0 and must have 9 digits after
    public boolean checkphoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\+27|0)[0-9]{9}");
    }
    public void Register() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First Name");
        FirstName = scanner.nextLine();
        System.out.println("Enter Last Name");
        LastName = scanner.nextLine();

        //userName
        do {
            System.out.println("Enter a username, must contain '_' and should not be more than 5");
            userName = scanner.nextLine();

            if (!checkuserName(userName)){
                System.out.println("invalid userName, please try again");
            }
        }while (!checkuserName(userName));

        //phoneNumber
        do{
            System.out.println("Enter phone number(must contain southAfrican county code and 10 numbers)");
            phoneNumber= scanner.nextLine();

            if (!checkphoneNumber(phoneNumber)){
                System.out.println("invalid phoneNumber, please try again");
            }
        }while (!checkphoneNumber(phoneNumber));

        //password
        while (true){
            System.out.println("Enter password");
            password = scanner.nextLine();

            if (checkPassword(password)){
                break;
            }
            else{
                System.out.println("Incorrect password");
                System.out.println("Password should contain a capital letter, special character or digits");
            }
        }

        //When the user inserts all the correct information
        System.out.println("Registration successful");

        Login login= new Login(userName,password,"Yanga","Matwele");
        login.LoginUser(userName,password);

    }


}
