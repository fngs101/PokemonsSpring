package com.pokemon.service;

import com.pokemon.domain.Auction;
import org.springframework.stereotype.Service;

@Service
public class AuctionHouseService
{

    public void createAuction(int amountToSell, double price)
    {
        Auction auction = new Auction(amountToSell, price);
    }
}
