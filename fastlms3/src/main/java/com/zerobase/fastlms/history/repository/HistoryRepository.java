package com.zerobase.fastlms.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zerobase.fastlms.history.entity.History;

import java.util.List;
import java.util.Optional;

public interface HistoryRepository extends JpaRepository<History, String> {

    Optional<List<History>> findAllByUserIdOrderByIdDesc(String userId);

    Optional<History> findFirstByUserIdOrderByIdDesc(String userId);

}
