package com.pokemon.repository;

import com.pokemon.domain.OwnedCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnedCardRepository  extends JpaRepository<OwnedCard, Integer>
{
}
