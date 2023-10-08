package com.zerobase.fastlms.configuration;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.bind.ServletRequestUtils;

import com.zerobase.fastlms.history.dto.HistoryDto;
import com.zerobase.fastlms.history.service.HistoryService;

import lombok.RequiredArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler
    extends SimpleUrlAuthenticationSuccessHandler {
    private final HistoryService historyService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
					HttpServletResponse response,
					Authentication authdata)
	throws IOException, ServletException {
	System.out.println("authdata:" + authdata.getName());
	request.setAttribute("userId", authdata.getName());
	System.out.println("userId:" + request.getAttribute("userId"));
	HistoryDto historyDto = HistoryDto.builder()
	    .userId(authdata.getName())
	    .logDt(LocalDateTime.now())
	    .ip(request.getRemoteAddr())
	    .userAgent(request.getHeader("user-agent"))
	    .build();

	historyService.save(historyDto);
	response.sendRedirect("/");
    }
}
