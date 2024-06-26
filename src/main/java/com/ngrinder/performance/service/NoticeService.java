package com.ngrinder.performance.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.ngrinder.performance.domain.Notice;

public interface NoticeService {
	List<Notice> getAllNotices();

	List<Notice> findByPage(HttpServletRequest request, int pageNumber);

	List<Notice> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate);
}
