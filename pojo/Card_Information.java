package com.example.myproject.pojo;

public class Card_Information {
    int ImageCoures;
    String NameCoures;
    String DescriptionCoures;

    public Card_Information(int imageCoures, String nameCoures, String descriptionCoures) {
        ImageCoures = imageCoures;
        NameCoures = nameCoures;
        DescriptionCoures = descriptionCoures;
    }

    public int getImageCoures() {
        return ImageCoures;
    }

    public void setImageCoures(int imageCoures) {
        ImageCoures = imageCoures;
    }

    public String getNameCoures() {
        return NameCoures;
    }

    public void setNameCoures(String nameCoures) {
        NameCoures = nameCoures;
    }

    public String getDescriptionCoures() {
        return DescriptionCoures;
    }

    public void setDescriptionCoures(String descriptionCoures) {
        DescriptionCoures = descriptionCoures;
    }
}
