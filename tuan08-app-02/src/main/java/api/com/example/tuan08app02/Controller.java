package api.com.example.tuan08app02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    @PostMapping("/login")
    public Account register(@RequestBody Account account, HttpServletResponse res) throws IOException {
       try{
           HttpHeaders headers = new HttpHeaders();
           headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
           HttpEntity<Account> entity= new HttpEntity<Account>(account,headers);
           return restTemplate.exchange("http://localhost:8080/login", HttpMethod.POST,entity,Account.class).getBody();
       }catch (Exception e){
           res.sendError(404);
           return null;
       }
    }
}
