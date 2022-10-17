package api.com.example.tuan08app01;

import api.com.example.tuan08app01.model.Account;
import api.com.example.tuan08app01.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;
    @PostMapping("/login")
    public Account login(@RequestBody Account account, HttpServletResponse res) throws IOException {
        Account accountDb= accountRepository.findByUsername(account.getUsername());
        if(account.getUsername().equals(accountDb.getUsername())){
            if(account.getPassword().equals(accountDb.getPassword())){
                return accountDb;
            }
        }
        res.sendError(401);
        return null;
    }
    @PostMapping("/register")
    public Account register(@RequestBody Account account,HttpServletResponse res) throws IOException {
        Account accountDb= accountRepository.findByUsername(account.getUsername());
        if(accountDb != null){
            res.sendError(404);
            return null;
        }else {
            return accountRepository.save(account);
        }
    }
}
