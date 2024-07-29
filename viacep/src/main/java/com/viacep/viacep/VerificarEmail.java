package com.viacep.viacep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import lombok.Data;

@Data
public class VerificarEmail {

    private static final String Email_Pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
    private static Pattern pattern = Pattern.compile(Email_Pattern);

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;

        }
        email = email.trim().toLowerCase();

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void Email() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Email:");
        String email = sc.nextLine();
    }
}
