package com.example.demo.pruebas;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Slf4j
public class Otra {

    private Properties properties = new Properties();

    @Value("${propiedad}")
    private String prop;

    public String getProp() {
        return prop;
    }

    public InputStream metodo() throws IOException {


        try {
            log.info("properties");
            properties.load(properties.getClass().getResourceAsStream("./src/main/resources/application.properties"));
            log.info(properties.getProperty(properties.toString()));
            log.info(properties.getProperty("propiedad"));
        } catch (Exception e){
            log.error(e.getMessage());
        }

        log.info(getProp());

        Gson gson = new Gson();
        Cosa cosa = gson.fromJson("{'ff': 'asddd', 'nn': 'asdasd'}", Cosa.class);

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

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(crendenciales);

        return IOUtils.toInputStream(jsonString);


    }


    public InputStream deCadena() {
        StringBuilder jsonString = new StringBuilder();
        jsonString.append("'{type': 'service_account',");
        jsonString.append("'project_id': 'parche-dairon',");
        jsonString.append("'private_key_id': 'dbc4d5841b6d8d7e18fb46e9fbb98c005bed135f',");
        jsonString.append("'private_key': '-----BEGIN PRIVATE KEY-----\\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDpYQB1x2G1vF1e\\nYsczfaCu+G6wQ4lqJDqIdaHMNdRc0sJeUPF2wR+BpXefoWPx8jMO3FTboGCO+RC5\\nlYkfqZYQg4A3RffhgDWjRRGjbbHlm72Lol7Y/I3LylIJPVHt26AcQ7tgMsJfLIWW\\nh8eCJHp66pjCEFdK9QVwufStiM4OtaPM+CpQ9Q5OTLfMzYDrIndEumoonulTarvu\\nVnXr0Iu8jbDeAFEJNmtMzSfv87yQSvTEVi2rHr314qYntxnfD3notXi1JzhU6cbj\\n1Wk8lt4jl1FZhmNABNtn+ncMQPGguFv1KcHltlc+afswEF9+utR/+kr+11KN1PmL\\nb6fIPQe7AgMBAAECggEAX2ilIAFlbD84KpSWXHIRBUcSNWQ+4tIxzcTNYydkjJgr\\nFxTfSk3UnBNx7qQzsF90STCBTpJntzuSf1RnTTbu3wxrl+02VA2un/NmLRp03moH\\nmPTF8s55B6XMWPOlMWkWsUdtbHwD45XXfT1ALm/MVMDgt4GntkCqOzYClgk2OGN4\\ny9HQWDIZnrxLIgIugpLQg4H58vsOSEOp9eO45JWOEA32uB9qcJdtmLRsjkh+QInq\\n+0EeeUxHvSvnV2ebVNHQKtFQERGpSllAYm50E5+UB0ZzQRPEMWIFPMo4wC3+YSKx\\nL68e0uQHO2y1livl+Q0dFAC5/bvHnI7pGln+YWDk+QKBgQD6heqateY+v81XES3o\\nujrJKv3rPoHNOt3KTAktaCoptyxT5O6UFsk4INyXgexbPTUyduMGIDIRtgP572tI\\nqTHEHJ30clOrPqVXRgyIFSGXK6Lyo9+QUx40iwT/N9uxH6Yxob7IsYL27mXOBPUm\\nlFqb6/tQQSg9NSxptlRgd1RVuQKBgQDueyLAj2kztnnlBI2VU6/CVbLBQ6SocyGz\\nwYBwBCAzrIKEH5Q+RcyZX97WWv62qfiRjATq0TVAacf0r6qK2UcO1pVWOzuZxpuM\\n+hKGH63Oso/trfIHLz+N6YsGpdxad+qqwmehEIO2dwKuVTSW2HgY9bTXy1NkIgXz\\nNLAuHIWDEwKBgCc6TPAIx5LPycF2aS/l6UqStsvdL8oJC62fllhL1T5O9lv0nv8F\\nSmDFlIUMzQvEW84ZG5db9zsauyipuqzYAXjp2jnqpPtNhepSh6fPV0EqjgtcaadZ\\nvIMRuaiVAIuNnyJqZ0tZsF4mGj7WO+TcmguMOf/pE/nxl5C+AhxQ0x3RAoGBAK34\\nlByHQgagioHAdYzG1QPewp1sPDVKb/6THaAZ0mf/4+KAqwNWpfAJWSVkkkYs7pE2\\n5OtsHP3VbTIZ6D6MTOMNNToH0e3XTehlEZhYidGsv4RzDYmiNSnQgkQiQQKaUk2p\\nrjF4O62jWghVThzw44PJ0thNkpMMouyNtiydT+STAoGBANZW4HRSV3kw/m3xHHEY\\nprUwpji8KU60DMKIJvpLIyGOQ/1CcihalEpQ3b6JHTJqHXzg3Z4HfCff+wMlsQHE\\n1wJDFhHC9khHgOdhNHoW8h50O4wAOUig0icU90NlZQCsfp/qhW41lgxouTpR5Naw\\n4VZ/K0tLq/kQ2ZPneWs92E9b\\n-----END PRIVATE KEY-----\\n',");
        jsonString.append("'client_email': 'firebase-adminsdk-eq6b7@parche-dairon.iam.gserviceaccount.com',");
        jsonString.append("'client_id': '102876058372399207379',");
        jsonString.append("'auth_uri': 'https://accounts.google.com/o/oauth2/auth',");
        jsonString.append("'token_uri': 'https://oauth2.googleapis.com/token',");
        jsonString.append("'auth_provider_x509_cert_url': 'https://www.googleapis.com/oauth2/v1/certs',");
        jsonString.append("'client_x509_cert_url': 'https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-eq6b7%40parche-dairon.iam.gserviceaccount.com'}");

        Gson gson = new Gson();

        return IOUtils.toInputStream(jsonString);

    }


}
