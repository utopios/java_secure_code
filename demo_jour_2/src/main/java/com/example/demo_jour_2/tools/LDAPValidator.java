package com.example.demo_jour_2.tools;

public class LDAPValidator {
    public String escapeLDAPSearchFilter(String filter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < filter.length(); i++) {
            char curChar = filter.charAt(i);
            switch (curChar) {
                case '\\':
                    sb.append("\\5c");
                    break;
                case '*':
                    sb.append("\\2a");
                    break;
                case '(':
                    sb.append("\\28");
                    break;
                case ')':
                    sb.append("\\29");
                    break;
                case '\u0000':
                    sb.append("\\00");
                    break;
                default:
                    sb.append(curChar);
            }
        }
        return sb.toString();
    }

    //Avec un input => *)) (|uid=*))(&(uid=*, on autorise la connexion sans authentification
    public void search(String userInput) {
        //String filter = "(&(objectClass=user)(uid=" + userInput + "))";
        String filter = "(&(objectClass=user)(uid=" + escapeLDAPSearchFilter(userInput) + "))";
    }
}
