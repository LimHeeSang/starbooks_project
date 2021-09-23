package startproject.starbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import startproject.starbooks.domain.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByUserId(String userId);

    boolean existsByUserId(String userId);
}
