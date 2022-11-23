package com.pokemon.repository;

import com.pokemon.domain.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionHouseRepository extends JpaRepository<Auction, String>
{
}
