import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin() {
        Scanner scanner = new Scanner(System.in);
        boolean validation = false;
        this.login = scanner.nextLine();
    }


    public void setPassword() { // !necessarily! Upper/lower case letters and numbers
        Scanner scanner = new Scanner(System.in);
        this.password = scanner.nextLine();
        char [] pass = this.password.toCharArray();
        for (int i = 0; i < pass.length; i++) {
            if (Integer.valueOf(pass[i])<48 && Integer.valueOf(pass[i])>57){
                    this.password = scanner.nextLine();
            } else
                break;
        }


    }
}
