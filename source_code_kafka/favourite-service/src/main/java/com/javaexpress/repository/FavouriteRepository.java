package com.javaexpress.repository;

import com.javaexpress.models.Favourite;
import com.javaexpress.models.FavouriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteId> {
}
