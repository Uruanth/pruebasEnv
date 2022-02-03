package co.com.sofka.parches.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
@Slf4j
public class Firebase {


    private Firebase() {
    }

    //TODO: Poner la ruta del archivo de firebase del proyecto a despliegue
    public static void inicializarFirebase() throws IOException {
        try{
            FileInputStream serviceAccount =
                    new FileInputStream(System.getenv().get("secrets.PROBANDO"));

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);

        }catch(Exception e){
                log.error("Error"+e.getMessage());
        }
    }

}
