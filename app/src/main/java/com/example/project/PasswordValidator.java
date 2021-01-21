package com.example.project;

public class PasswordValidator {

    private int grade;
    private int MINIMUM_LENGTH_OF_PASSWORD = 8;

    /**
     * Determines strength of an entered password. Can be changed and/or modified.
     * @param pw User input.
     * @return int grade - used for displaying password strength.
     */
    public int validate(String pw) {
        boolean length = false;
        boolean upperCase = false;
        boolean lowerCase = false;
        boolean number = false;

        if(pw.length() > MINIMUM_LENGTH_OF_PASSWORD) {
            System.out.println(pw);
            length = true;
            for (int i = 0; i < pw.length(); i++) {
                char a = pw.charAt(i);
                if (Character.isUpperCase(a)) {
                    upperCase = true;
                }
                if (Character.isDigit(a)) {
                    number = true;
                }
                if (Character.isLowerCase(a)) {
                    lowerCase = true;
                }
            }
        }

        if (length && upperCase && number && lowerCase){
            grade = 4;
        } else if(length && upperCase && lowerCase || length && number && lowerCase || length && number && upperCase){
            grade = 3;
        } else if(length && (upperCase || number || lowerCase)) {
            grade = 2;
        }else{
            grade = 1;
        }
        return grade;
    }
}