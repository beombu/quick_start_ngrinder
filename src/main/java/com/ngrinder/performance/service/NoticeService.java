package com.ngrinder.performance.service;

import java.time.LocalDateTime;
import java.util.List;

import com.ngrinder.performance.domain.Notice;

import jakarta.servlet.http.HttpServletRequest;

public interface NoticeService {
	List<Notice> getAllNotices();

	List<Notice> findByPage(HttpServletRequest request, int pageNumber);

	List<Notice> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate);
}
