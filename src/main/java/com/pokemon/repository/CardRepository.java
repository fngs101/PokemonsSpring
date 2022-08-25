package com.pokemon.repository;

import com.pokemon.domain.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, String>
{
}
