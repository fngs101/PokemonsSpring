package com.pokemon.repository;

import com.pokemon.domain.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionHouseRepository extends JpaRepository<Auction, String>
{
    List<Auction> findByPokemonCollectorId(int pokemonCollectorId);
}
