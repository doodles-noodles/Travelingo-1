package com.example.instatry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {

    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> login = new ArrayList<String>();
        login.add("The app uses google sign in or facebook sign in. You should have atleast one of these accounts.");

        List<String> modifyemailaddress = new ArrayList<String>();
        modifyemailaddress.add("You cannot modify your email address once you login with a specific ID. But feel free to contact us to know more and get your email address changed!");


        List<String> contactus = new ArrayList<String>();
        contactus.add("paishreya1412@gmail.com");
        contactus.add("kprajna99@gmail.com");
        contactus.add("amrusom99@gmail.com");

        expandableListDetail.put("How can I log into the app?", login);
        expandableListDetail.put("I can't change my email address.", modifyemailaddress);
        expandableListDetail.put("Contact us via email.", contactus);
        return expandableListDetail;
    }
}
