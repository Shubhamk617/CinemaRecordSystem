package com.cinemarecords.model;

public class Review {

	private int reviewId;

	private String reviewDesc;

	private int likes;


	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int reviewId, String reviewDesc, int likes) {
		super();
		this.reviewId = reviewId;
		this.reviewDesc = reviewDesc;
		this.likes = likes;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

}
