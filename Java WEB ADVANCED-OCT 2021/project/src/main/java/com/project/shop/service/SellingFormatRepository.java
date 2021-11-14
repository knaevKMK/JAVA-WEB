package com.project.shop.service;

import com.project.shop.model.entity.SellingFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SellingFormatRepository extends JpaRepository<SellingFormat, UUID> {
}
