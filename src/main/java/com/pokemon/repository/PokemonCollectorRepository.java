package com.pokemon.repository;

import com.pokemon.domain.Card;
import com.pokemon.domain.PokemonCollector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonCollectorRepository extends JpaRepository<PokemonCollector, Integer>
{
}
