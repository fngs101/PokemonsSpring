package com.pokemon.repository;

import com.pokemon.domain.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, String>
{

}
