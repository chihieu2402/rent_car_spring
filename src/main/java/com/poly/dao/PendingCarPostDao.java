package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.entity.PendingCarPost;

public interface PendingCarPostDao extends JpaRepository<PendingCarPost, Integer> {
}
