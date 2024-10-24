package br.com.robsondejesus.app_auth_youtube.auth;

import org.apache.catalina.User;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/token")
@RestController
public class TokenController {


    @PostMapping("/")
    public ResponseEntity<String> token(@RequestBody User user){

        HttpHeaders headers = new HttpHeaders();
        RestTemplate rt = new RestTemplate();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();

        formData.add("client_id", user.client_id);
        formData.add("username", user.username);
        formData.add("client_secret", user.client_secret);
        formData.add("grant_type", user.grant_type);

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(formData, headers);

        var result = rt.postForEntity("http://localhost:8080/realms/youtube/protocol/openid-connect/token",entity, String.class);

        return result;

    }

    //String clientId
    //String password
    public record User(String client_secret, String client_id, String grant_type, String username){}
}
