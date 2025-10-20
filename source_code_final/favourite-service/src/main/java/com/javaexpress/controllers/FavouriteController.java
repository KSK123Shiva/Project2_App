package com.javaexpress.controllers;

import com.javaexpress.dtos.FavouriteDto;
import com.javaexpress.services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/favourites")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping
    public ResponseEntity<FavouriteDto> save(@RequestBody FavouriteDto favouriteDto){
        return ResponseEntity.ok(favouriteService.saveFavourite(favouriteDto));
    }


}
