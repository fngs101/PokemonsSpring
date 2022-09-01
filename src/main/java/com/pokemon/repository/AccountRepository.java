package com.pokemon.repository;

import com.pokemon.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String>
{

}
