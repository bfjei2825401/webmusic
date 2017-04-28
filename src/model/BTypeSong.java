package model;

import interfaces.Song;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baofeng on 2017/4/28.
 */
public class BTypeSong implements Song {
    private List<String> singers;
    private String name;
    private Date date;
    private String id;
    private String musicUrl;
    private List<String> albumList;

    public List<String> getSingers() {
        return singers;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMusicUrl() {
        return musicUrl;
    }

    public void setMusicUrl(String musicUrl) {
        this.musicUrl = musicUrl;
    }

    public List<String> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<String> albumList) {
        this.albumList = albumList;
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
        stringBuilder.append("\"" + String.join(",",singers) + "\",");

        stringBuilder.append("\"publicYear\":");
        stringBuilder.append("\"" + date.getYear() + "\",");

        stringBuilder.append("\"musicUrl\":");
        stringBuilder.append("\"" + musicUrl + "\",");

        stringBuilder.append("\"albumUrl\":");
        stringBuilder.append("\"" + String.join(",",albumList) + "\"");

        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        BTypeSong bTypeSong = new BTypeSong();
        List<String> singers = new LinkedList<>();
        List<String> albumList = new LinkedList<>();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = DateFormat.getDateInstance();

        singers.add("abc");
        singers.add("fds");
        singers.add("lee");
        singers.add("nbb");
        albumList.add("url1");
        albumList.add("url2");
        bTypeSong.setId("3243241");
        bTypeSong.setName("zhuimeng");
        bTypeSong.setDate(date);
        bTypeSong.setSingers(singers);
        bTypeSong.setMusicUrl("music-url");
        bTypeSong.setAlbumList(albumList);

        System.out.println(bTypeSong.toJSON());
    }
}
