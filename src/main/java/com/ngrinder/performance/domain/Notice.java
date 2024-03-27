package com.ngrinder.performance.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Notice {
	private long id;

	private String title;

	private String content;

	private String who;

	private LocalDateTime createDate;

	private LocalDateTime updateDate;
}
