package com.javaexpress.services;

import com.javaexpress.dtos.FavouriteDto;
import com.javaexpress.helpers.FavouriteHelper;
import com.javaexpress.repository.FavouriteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    public FavouriteDto saveFavourite(FavouriteDto favouriteDto) {
        log.info("FavouriteService :: saveFavourite");
        return FavouriteHelper.map(favouriteRepository.save(FavouriteHelper.map(favouriteDto)));
    }
}
