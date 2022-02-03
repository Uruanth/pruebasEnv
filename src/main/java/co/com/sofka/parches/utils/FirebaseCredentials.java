package co.com.sofka.parches.utils;

import org.springframework.beans.factory.annotation.Value;

import java.util.Objects;

public class FirebaseCredentials {

    private String type;
    private String project_id;
    private String private_key_id;
    private String private_key;
    private String client_email;
    private String client_id;
    private String auth_uri;
    private String token_uri;
    private String auth_provider_x509_cert_url;
    private String client_x509_cert_url;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getPrivate_key_id() {
        return private_key_id;
    }

    public void setPrivate_key_id(String private_key_id) {
        this.private_key_id = private_key_id;
    }

    public String getPrivate_key() {
        return private_key;
    }

    public void setPrivate_key(String private_key) {
        this.private_key = private_key;
    }

    public String getClient_email() {
        return client_email;
    }

    public void setClient_email(String client_email) {
        this.client_email = client_email;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getAuth_uri() {
        return auth_uri;
    }

    public void setAuth_uri(String auth_uri) {
        this.auth_uri = auth_uri;
    }

    public String getToken_uri() {
        return token_uri;
    }

    public void setToken_uri(String token_uri) {
        this.token_uri = token_uri;
    }

    public String getAuth_provider_x509_cert_url() {
        return auth_provider_x509_cert_url;
    }

    public void setAuth_provider_x509_cert_url(String auth_provider_x509_cert_url) {
        this.auth_provider_x509_cert_url = auth_provider_x509_cert_url;
    }

    public String getClient_x509_cert_url() {
        return client_x509_cert_url;
    }

    public void setClient_x509_cert_url(String client_x509_cert_url) {
        this.client_x509_cert_url = client_x509_cert_url;
    }

    public FirebaseCredentials() {
    }

    @Override
    public String toString() {
        return "FirebaseCredentials{" +
                "type='" + type + '\'' +
                ", project_id='" + project_id + '\'' +
                ", private_key_id='" + private_key_id + '\'' +
                ", private_key='" + private_key + '\'' +
                ", client_email='" + client_email + '\'' +
                ", client_id='" + client_id + '\'' +
                ", auth_uri='" + auth_uri + '\'' +
                ", token_uri='" + token_uri + '\'' +
                ", auth_provider_x509_cert_url='" + auth_provider_x509_cert_url + '\'' +
                ", client_x509_cert_url='" + client_x509_cert_url + '\'' +
                '}';
    }

    public FirebaseCredentials(String type, String project_id,
                               String private_key_id, String private_key,
                               String client_email, String client_id,
                               String auth_uri, String token_uri,
                               String auth_provider_x509_cert_url,
                               String client_x509_cert_url) {
        this.type = type;
        this.project_id = project_id;
        this.private_key_id = private_key_id;
        this.private_key = private_key;
        this.client_email = client_email;
        this.client_id = client_id;
        this.auth_uri = auth_uri;
        this.token_uri = token_uri;
        this.auth_provider_x509_cert_url = auth_provider_x509_cert_url;
        this.client_x509_cert_url = client_x509_cert_url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FirebaseCredentials that = (FirebaseCredentials) o;
        return Objects.equals(type, that.type) && Objects.equals(project_id, that.project_id) && Objects.equals(private_key_id, that.private_key_id) && Objects.equals(private_key, that.private_key) && Objects.equals(client_email, that.client_email) && Objects.equals(client_id, that.client_id) && Objects.equals(auth_uri, that.auth_uri) && Objects.equals(token_uri, that.token_uri) && Objects.equals(auth_provider_x509_cert_url, that.auth_provider_x509_cert_url) && Objects.equals(client_x509_cert_url, that.client_x509_cert_url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, project_id, private_key_id, private_key, client_email, client_id, auth_uri, token_uri, auth_provider_x509_cert_url, client_x509_cert_url);
    }
}
