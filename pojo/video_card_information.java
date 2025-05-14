package com.example.myproject.pojo;

public class video_card_information {
    private int image_video;
    private String title_video;
    private String desc_video;

    public int getImage_video() {
        return image_video;
    }

    public void setImage_video(int image_video) {
        this.image_video = image_video;
    }

    public String getTitle_video() {
        return title_video;
    }

    public void setTitle_video(String title_video) {
        this.title_video = title_video;
    }

    public String getDesc_video() {
        return desc_video;
    }

    public void setDesc_video(String desc_video) {
        this.desc_video = desc_video;
    }

    public video_card_information(int image_video, String title_video, String desc_video) {
        this.image_video = image_video;
        this.title_video = title_video;
        this.desc_video = desc_video;
    }
}
