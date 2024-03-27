package com.ngrinder.performance.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ngrinder.performance.domain.Notice;

@Mapper
public interface NoticeReadMapper {

	public List<Notice> findAll();

	public List<Notice> findByPage(int startIdx);

	List<Notice> findNoticesByDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
