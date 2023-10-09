package com.example.demo.wish.repository;

import com.example.demo.wish.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishRepository extends JpaRepository<Wish,Long> {
    Optional<Wish> findByMember_IdAndItem_Id(Long memberId, Long itemId);
}
