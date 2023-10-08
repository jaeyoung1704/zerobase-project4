package com.zerobase.fastlms.history.dto;

import java.time.LocalDateTime;

import javax.persistence.Id;

import com.zerobase.fastlms.history.entity.History;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryDto {
    private Long id;
    private String userId;
    private LocalDateTime logDt; // 로그인 날짜
    private String ip;
    private String userAgent;

    public static HistoryDto of(History history) {
	return HistoryDto.builder()
	    .id(history.getId())
	    .userId(history.getUserId())
	    .logDt(history.getLogDt())
	    .ip(history.getIp())
	    .userAgent(history.getUserAgent())
	    .build();
    }
}
