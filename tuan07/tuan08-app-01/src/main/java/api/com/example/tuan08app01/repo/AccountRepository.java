package api.com.example.tuan08app01.repo;

import api.com.example.tuan08app01.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUsername(String username);
}
