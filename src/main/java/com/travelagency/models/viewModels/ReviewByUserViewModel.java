package com.travelagency.models.viewModels;

import java.util.Date;

public class ReviewByUserViewModel {

    private String content;

    private int score;

    private Date releaseDate;

    private String bookingProductName;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getBookingProductName() {
        return bookingProductName;
    }

    public void setBookingProductName(String bookingProductName) {
        this.bookingProductName = bookingProductName;
    }
}
