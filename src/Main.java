import java.util.Scanner;

    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.Register();

        Scanner scanner = new Scanner(System.in);
        Login login = new Login(registration.userName, registration.password,
                registration.FirstName, registration.LastName);

        System.out.println("Please log in now. ");

        //For loop: maximum 3 attempts
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter Username: ");
            String loginUser = scanner.nextLine();
            System.out.println("enter password: ");
            String loginPass = scanner.nextLine();

            String message = login.LoginUser(loginUser, loginPass);
            System.out.println(message);

            //If login successful, break out of the loop
            if (message.startsWith("Welcome")) {
                break;

            }

            //If it was a 3rd attempt, lock the account
            if (i ==2) {
                System.out.println("Too many failed attempts. account locked:");
            }





        }
    }

