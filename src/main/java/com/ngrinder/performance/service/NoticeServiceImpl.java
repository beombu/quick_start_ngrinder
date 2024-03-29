package com.ngrinder.performance.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ngrinder.performance.domain.Notice;
import com.ngrinder.performance.mapper.NoticeReadMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class NoticeServiceImpl implements NoticeService{
	private NoticeReadMapper noticeReadMapper;

	public NoticeServiceImpl(NoticeReadMapper noticeReadMapper) {
		this.noticeReadMapper = noticeReadMapper;
	}

	@Override
	@Cacheable(value = "NoticeReadMapper.findAll")
	@Transactional
	public List<Notice> getAllNotices() {
		return noticeReadMapper.findAll();
	}

	@Override
	public List<Notice> findByPage(HttpServletRequest request, int pageNumber) {
		return null;
	}

	@Override
	public List<Notice> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate) {
		return null;
	}
}
