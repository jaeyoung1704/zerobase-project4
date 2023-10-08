package com.zerobase.fastlms.history.service;

import com.zerobase.fastlms.history.dto.HistoryDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface HistoryService {

    /**
     * 로그인시 자동으로 로그인 기록 저장
     */
    boolean save(HistoryDto parameter);

    /**
     * 아이디 기준으로 로그인 기록 조회
     */
    List<HistoryDto> list(String userId);

    /**
     * 아이디 기준으로 마지막 로그인 일자 조회
     */
//    Optional<LocalDateTime> lastLoggedIn(String userId);
}
