package com.ssafy.ssarijileo.singing.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.ssafy.ssarijileo.singing.dto.SingingDto;
import com.ssafy.ssarijileo.song.entity.Song;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Singing {

	// PK (AUTO_INCREMENT)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long singingId;

	// 사용자PK
	String userId;

	// 노래PK
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "song_id")
	Song song;

	// 모드(N:일반,P:퍼펙트스코어,O:가사순서맞추기,R:이어부르기)
	char mode;

	// 점수
	int score;

	// 총부른시간
	String totalSingingTime;

	// Dto to Entity
	@Builder
	public Singing(SingingDto singingDto, Song song) {
		this.singingId = singingDto.getSingingId();
		this.userId = singingDto.getUserId();
		this.song = song;
		this.mode = singingDto.getMode();
		this.score = singingDto.getScore();
		this.totalSingingTime = singingDto.getTotalSingingTime();
	}
}
