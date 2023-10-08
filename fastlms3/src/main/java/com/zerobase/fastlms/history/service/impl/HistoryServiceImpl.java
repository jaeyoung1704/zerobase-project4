package com.zerobase.fastlms.history.service.impl;

import com.zerobase.fastlms.history.dto.HistoryDto;
import com.zerobase.fastlms.history.entity.History;
import com.zerobase.fastlms.history.repository.HistoryRepository;
import com.zerobase.fastlms.history.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HistoryServiceImpl implements HistoryService {

    private final HistoryRepository historyRepository;

    @Override
    public boolean save(HistoryDto parameter) {
	History history = History.builder()
	    .userId(parameter.getUserId())
	    .logDt(parameter.getLogDt())
	    .ip(parameter.getIp())
	    .userAgent(parameter.getUserAgent())
	    .build();
	historyRepository.save(history);
	return true;
    }

    @Override
    public List<HistoryDto> list(String userId) {
	// db에서 불러온 검증된 유저id를 사용하기 때문에 no such user 오류 없음
	List<History> list = historyRepository.findAllByUserIdOrderByIdDesc(userId).get();
	// entity를 dto로 변환해서 리턴
	return list.stream().map(e -> HistoryDto.of(e)).collect(Collectors.toList());
    }

}
