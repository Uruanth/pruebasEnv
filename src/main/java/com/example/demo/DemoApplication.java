package com.example.demo;

import com.example.demo.pruebas.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        Logger log = Logger.getLogger("prin");

        try {
            Firebase.conectar();

        //    String uid = "zR7yXoFlb1Mmu7ZC1mjGhnFNvhP2";
           // UserRecord userRecord = FirebaseAuth.getInstance().getUser(uid);
// See the UserRecord reference doc for the contents of userRecord.
            log.info("Successfully fetched user data: " );

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
