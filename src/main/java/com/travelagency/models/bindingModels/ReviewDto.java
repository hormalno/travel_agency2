package com.travelagency.models.bindingModels;

public class ReviewDto {

    //@Size(max = 300,message = "Review must be 300 characters long")
    private String content;

    //@Range(min = 1, max = 10,message = "Rate must be between 1 and 10")
    private int score;

    private String username;

    private long productId;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
