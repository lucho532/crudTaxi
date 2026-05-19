package com.luchodevs.cashtaxi.repository;

import com.luchodevs.cashtaxi.entity.TrayectosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrayectosRepository extends JpaRepository <TrayectosEntity,Long> {
}
