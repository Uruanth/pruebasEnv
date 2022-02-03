package co.com.sofka.parches.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Firebase {


    private static FirebaseApp conn;

    private Firebase() {
    }

    //TODO: Poner la ruta del archivo de firebase del proyecto a despliegue
    public static void inicializarFirebase(FirebaseCredentials crendenciales) throws IOException {
        log.info(crendenciales.getAuth_uri());
        FirebaseOptions options = new FirebaseOptions.Builder()
            //    .setCredentials(GoogleCredentials.fromStream(crendenciales))
                 .setCredentials(GoogleCredentials.fromStream(getCredentials(crendenciales)))
                .build();

        conn = FirebaseApp.initializeApp(options);

    }

    public static void finalizarFirebase() {
        conn.delete();
    }

    private static InputStream getCredentials(FirebaseCredentials crendenciales) {

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(crendenciales);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }

        return IOUtils.toInputStream(jsonString);
    }


}