package co.com.sofka.parches.utils;

import co.com.sofka.parches.collections.Usuario;
import co.com.sofka.parches.dtos.UsuarioDTO;
import co.com.sofka.parches.repositories.UsuarioRepository;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

@Component
public class Validaciones {

    final Logger log = Logger.getLogger("utils");

    private final UsuarioRepository repositorio;


    @Value("${FIREBASE_TYPE}")
    private String type;
    @Value("${FIREBASE_PROJECT_ID}")
    private String project_id;
    @Value("${FIREBASE_PRIVATE_KEY_ID}")
    private String private_key_id;
    @Value("${FIREBASE_PRIVATE_KEY}")
    private String private_key;
    @Value("${FIREBASE_CLIENT_EMAIL}")
    private String client_email;
    @Value("${FIREBASE_CLIENT_ID}")
    private String client_id;
    @Value("${FIREBASE_AUTH_URI}")
    private String auth_uri;
    @Value("${FIREBASE_TOKEN_URI}")
    private String token_uri;
    @Value("${FIREBASE_AUTH_PROVIDER_X509_CERT_URL}")
    private String auth_provider_x509_cert_url;
    @Value("${FIREBASE_CLIENT_X509_CERT_URL}")
    private String client_x509_cert_url;

    public Validaciones(UsuarioRepository repositorio) {
        this.repositorio = repositorio;
    }

    public Mono<Usuario> verificarExistenciaUsuarioMongoYFirebaseParaCrearUsuario(UsuarioDTO usuario) {
        UserRecord userRecord;
        try {
            Firebase.inicializarFirebase(getCredentials());
            userRecord = FirebaseAuth.getInstance().getUser(usuario.getUid());

            if (userRecord == null || !userRecord.getEmail().equals(usuario.getEmail())) {
                return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT));
            }
            return repositorio.findByUid(usuario.getUid());
        } catch (Exception e) {
            log.warning(e.getMessage());
            return Mono.error(new ResponseStatusException(HttpStatus.CONFLICT));
        }
    }

    public Mono<Usuario> verificarExistenciaUsuarioMongoYFirebaseParaIniciarSesion(String uid) {
        try {
            Firebase.inicializarFirebase(getCredentials());

        } catch (IOException e) {
            log.warning(e.getMessage());
        }
        return verificarExistencia(uid)
                .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.CONFLICT)));

    }


    private Mono<Usuario> verificarExistencia(String uid) {
        UserRecord userRecord = null;
        try {
            userRecord = FirebaseAuth.getInstance().getUser(uid);
        } catch (FirebaseAuthException e) {
            log.warning(e.getMessage());
        }
        if (userRecord == null) {
            return Mono.empty();
        }

        return repositorio.findByUid(uid);
    }



    private  FirebaseCredentials getCredentials(){
        return new FirebaseCredentials(
                 type,  project_id,
                 private_key_id,  private_key,
                 client_email,  client_id,
                 auth_uri,  token_uri,
                 auth_provider_x509_cert_url,
                 client_x509_cert_url
        );

    }
}
