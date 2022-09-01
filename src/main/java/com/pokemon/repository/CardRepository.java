package com.pokemon.repository;

import com.pokemon.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends JpaRepository<Card, String>
{
}
