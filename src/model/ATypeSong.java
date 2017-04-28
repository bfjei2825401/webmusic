package model;

import interfaces.Song;

/**
 * Created by baofeng on 2017/4/28.
 */
public class ATypeSong implements Song {
    private long id;
    private String name;
    private String singer;
    private int publicYear;
    private String musicUrl;
    private String albumUrl;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public String getAlbumUrl() {
        return albumUrl;
    }

    public void setAlbumUrl(String albumUrl) {
        this.albumUrl = albumUrl;
    }

    @Override
    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        stringBuilder.append("\"id\":");
        stringBuilder.append("\"" + id + "\",");

        stringBuilder.append("\"name\":");
        stringBuilder.append("\"" + name + "\",");

        stringBuilder.append("\"singer\":");
        stringBuilder.append("\"" + singer + "\",");

        stringBuilder.append("\"publicYear\":");
        stringBuilder.append("\"" + publicYear + "\",");

        stringBuilder.append("\"musicUrl\":");
        stringBuilder.append("\"" + musicUrl + "\",");

        stringBuilder.append("\"albumUrl\":");
        stringBuilder.append("\"" + albumUrl + "\"");

        stringBuilder.append("}");


        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ATypeSong aTypeSong = new ATypeSong();
        aTypeSong.setId(124);
        aTypeSong.setName("fdsag");
        aTypeSong.setSinger("haha");
        aTypeSong.setMusicUrl("musicurl");
        aTypeSong.setAlbumUrl("album");
        aTypeSong.setPublicYear(2017);
        System.out.printf(aTypeSong.toJSON());
    }
}
