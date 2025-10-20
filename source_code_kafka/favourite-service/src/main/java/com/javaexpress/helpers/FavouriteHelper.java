package com.javaexpress.helpers;

import com.javaexpress.dtos.FavouriteDto;
import com.javaexpress.dtos.ProductDto;
import com.javaexpress.dtos.UserDto;
import com.javaexpress.models.Favourite;

public interface FavouriteHelper {

    static FavouriteDto map(Favourite favourite){
        return FavouriteDto.builder()
                .productId(favourite.getProductId())
                .userId(favourite.getUserId())
                .likedDate(favourite.getLikedDate())
                .userDto(UserDto.builder()
                        .userId(favourite.getUserId())
                        .build())
                .productDto(ProductDto.builder()
                        .productId(favourite.getProductId())
                        .build())
                .build();
    }

    static Favourite map(FavouriteDto favouriteDto){
        return Favourite.builder()
                .productId(favouriteDto.getProductId())
                .userId(favouriteDto.getUserId())
                .likedDate(favouriteDto.getLikedDate())
                .build();
    }
}
