package com.example.demo.pruebas;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;

@Slf4j
public class Firebase {

    public static void conectar() throws IOException {
        Otra oo = new Otra();

        oo.deCadena();

        FirebaseOptions options = new FirebaseOptions.Builder()
               // .setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .setCredentials(GoogleCredentials.fromStream(oo.metodo()))
              //  .setCredentials(GoogleCredentials.fromStream(oo.deCadena()))
                .build();

        var ii =FirebaseApp.initializeApp(options);
        System.out.println("Se conecto con FB");
        System.out.println(ii);
        ii.getInstance().delete();
        log.info("delete");
    }

}
