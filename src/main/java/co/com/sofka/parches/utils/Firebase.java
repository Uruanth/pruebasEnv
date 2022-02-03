package co.com.sofka.parches.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.IOException;
import java.io.InputStream;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.commons.io.IOUtils;

@Slf4j
public class Firebase {


    private static FirebaseApp conn;

    private Firebase() {
    }

    //TODO: Poner la ruta del archivo de firebase del proyecto a despliegue
    public static void inicializarFirebase(FirebaseCredentials crendenciales) throws IOException {
        FirebaseOptions options = new FirebaseOptions.Builder()
                 .setCredentials(GoogleCredentials.fromStream(getCredentials(crendenciales)))
                .build();

        conn = FirebaseApp.initializeApp(options);
        log.info("conecto");
    }

    public static void finalizarFirebase() {
        conn.delete();
    }

    private static InputStream getCredentials(FirebaseCredentials crendenciales2) {

        FirebaseCredentials crendenciales = new FirebaseCredentials();

        crendenciales.setType("service_account");
        crendenciales.setProject_id("parche-dairon");

        crendenciales.setPrivate_key_id("dbc4d5841b6d8d7e18fb46e9fbb98c005bed135f");
        crendenciales.setPrivate_key("-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDpYQB1x2G1vF1e\nYsczfaCu+G6wQ4lqJDqIdaHMNdRc0sJeUPF2wR+BpXefoWPx8jMO3FTboGCO+RC5\nlYkfqZYQg4A3RffhgDWjRRGjbbHlm72Lol7Y/I3LylIJPVHt26AcQ7tgMsJfLIWW\nh8eCJHp66pjCEFdK9QVwufStiM4OtaPM+CpQ9Q5OTLfMzYDrIndEumoonulTarvu\nVnXr0Iu8jbDeAFEJNmtMzSfv87yQSvTEVi2rHr314qYntxnfD3notXi1JzhU6cbj\n1Wk8lt4jl1FZhmNABNtn+ncMQPGguFv1KcHltlc+afswEF9+utR/+kr+11KN1PmL\nb6fIPQe7AgMBAAECggEAX2ilIAFlbD84KpSWXHIRBUcSNWQ+4tIxzcTNYydkjJgr\nFxTfSk3UnBNx7qQzsF90STCBTpJntzuSf1RnTTbu3wxrl+02VA2un/NmLRp03moH\nmPTF8s55B6XMWPOlMWkWsUdtbHwD45XXfT1ALm/MVMDgt4GntkCqOzYClgk2OGN4\ny9HQWDIZnrxLIgIugpLQg4H58vsOSEOp9eO45JWOEA32uB9qcJdtmLRsjkh+QInq\n+0EeeUxHvSvnV2ebVNHQKtFQERGpSllAYm50E5+UB0ZzQRPEMWIFPMo4wC3+YSKx\nL68e0uQHO2y1livl+Q0dFAC5/bvHnI7pGln+YWDk+QKBgQD6heqateY+v81XES3o\nujrJKv3rPoHNOt3KTAktaCoptyxT5O6UFsk4INyXgexbPTUyduMGIDIRtgP572tI\nqTHEHJ30clOrPqVXRgyIFSGXK6Lyo9+QUx40iwT/N9uxH6Yxob7IsYL27mXOBPUm\nlFqb6/tQQSg9NSxptlRgd1RVuQKBgQDueyLAj2kztnnlBI2VU6/CVbLBQ6SocyGz\nwYBwBCAzrIKEH5Q+RcyZX97WWv62qfiRjATq0TVAacf0r6qK2UcO1pVWOzuZxpuM\n+hKGH63Oso/trfIHLz+N6YsGpdxad+qqwmehEIO2dwKuVTSW2HgY9bTXy1NkIgXz\nNLAuHIWDEwKBgCc6TPAIx5LPycF2aS/l6UqStsvdL8oJC62fllhL1T5O9lv0nv8F\nSmDFlIUMzQvEW84ZG5db9zsauyipuqzYAXjp2jnqpPtNhepSh6fPV0EqjgtcaadZ\nvIMRuaiVAIuNnyJqZ0tZsF4mGj7WO+TcmguMOf/pE/nxl5C+AhxQ0x3RAoGBAK34\nlByHQgagioHAdYzG1QPewp1sPDVKb/6THaAZ0mf/4+KAqwNWpfAJWSVkkkYs7pE2\n5OtsHP3VbTIZ6D6MTOMNNToH0e3XTehlEZhYidGsv4RzDYmiNSnQgkQiQQKaUk2p\nrjF4O62jWghVThzw44PJ0thNkpMMouyNtiydT+STAoGBANZW4HRSV3kw/m3xHHEY\nprUwpji8KU60DMKIJvpLIyGOQ/1CcihalEpQ3b6JHTJqHXzg3Z4HfCff+wMlsQHE\n1wJDFhHC9khHgOdhNHoW8h50O4wAOUig0icU90NlZQCsfp/qhW41lgxouTpR5Naw\n4VZ/K0tLq/kQ2ZPneWs92E9b\n-----END PRIVATE KEY-----\n");

        crendenciales.setClient_email("firebase-adminsdk-eq6b7@parche-dairon.iam.gserviceaccount.com");
        crendenciales.setClient_id("102876058372399207379");
        crendenciales.setAuth_uri("https://accounts.google.com/o/oauth2/auth");
        crendenciales.setToken_uri("https://oauth2.googleapis.com/token");
        crendenciales.setAuth_provider_x509_cert_url("https://www.googleapis.com/oauth2/v1/certs");
        crendenciales.setClient_x509_cert_url("https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-eq6b7%40parche-dairon.iam.gserviceaccount.com");


        log.info(""+crendenciales.equals(crendenciales2));
        log.info(""+crendenciales.getType().equals(crendenciales2.getType()));
        log.info(""+crendenciales.getProject_id().equals(crendenciales2.getProject_id()));
        log.info(""+crendenciales.getPrivate_key_id().equals(crendenciales2.getPrivate_key_id()));
        log.info(""+crendenciales.getPrivate_key().equals(crendenciales2.getPrivate_key()));
        log.info(""+crendenciales.getClient_email().equals(crendenciales2.getClient_email()));
        log.info(""+crendenciales.getClient_id().equals(crendenciales2.getClient_id()));
        log.info(""+crendenciales.getAuth_uri().equals(crendenciales2.getAuth_uri()));
        log.info(""+crendenciales.getToken_uri().equals(crendenciales2.getToken_uri()));
        log.info(""+crendenciales.getAuth_provider_x509_cert_url().equals(crendenciales2.getAuth_provider_x509_cert_url()));
        log.info(""+crendenciales.getClient_x509_cert_url().equals(crendenciales2.getClient_x509_cert_url()));



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