package com.ngrinder.performance.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

import com.ngrinder.performance.domain.Notice;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LogSendServiceImpl implements SendService {
	private NoticeService noticeService;
	int processors = Runtime.getRuntime().availableProcessors();
	int threadPoolSize = Math.max(2, processors); // 최소 2개의 스레드 사용
	ExecutorService customThreadPool = Executors.newWorkStealingPool(threadPoolSize);

	public LogSendServiceImpl(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	@Override
	public long sendAll() {
		List<Notice> notices = noticeService.getAllNotices();
		long beforeTime = System.currentTimeMillis();

		//동기
		// notices.forEach(notice -> {
		// 	sending(notice.getTitle());
		// });

		//비동기
		notices.forEach(notice -> {
			CompletableFuture.runAsync(() -> sending(notice.getTitle()), customThreadPool)
				.exceptionally(throwable -> {
					//예외 처리 필수
					log.error("Exception occurred : " + throwable.getMessage());
					return null;
				});
		});

		long afterTime = System.currentTimeMillis();
		long diffTime = afterTime = beforeTime;
		log.info("실행 시간(ms) : " + diffTime);

		return diffTime;
	}

	private void sending(String message) {
		try {
			Thread.sleep(1); // 임의의 작업시간을 주기위해 설정
			log.info("message : {}", message);
		} catch (Exception e) {
			log.error("[Error] : {} ", e.getMessage());
		}
	}

}
