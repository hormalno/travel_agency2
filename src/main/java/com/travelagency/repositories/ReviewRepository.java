package com.travelagency.repositories;

import com.travelagency.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {


    @Query(value = "select * from reviews as r " +
            "where r.product_id = :id " +
            "order by r.release_date desc " +
            "limit 5",
            nativeQuery = true)
    List<Review> findAllByBookingProductId(@Param(value = "id") long id);

    List<Review> findAllByUserUsername(String username);
}
