package com.twoitesting.utilityClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoginDetailsReader {

    private Scanner sc;
    private File file;
    private ArrayList<String> loginDetails = new ArrayList<>();
    private String fileName = "loginDetails.csv";

    public LoginDetailsReader() {

        this.file = new File(this.fileName);

        try {
            this.sc = new Scanner(this.file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.sc.useDelimiter(",");

        while(this.sc.hasNext()) {
            this.loginDetails.add(this.sc.next());
        }
    }

    public String getUsername() {

        return loginDetails.get(0);
    }

    public String getPassword() {

        return loginDetails.get(1);
    }
}
