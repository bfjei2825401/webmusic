package dao;

import db.DbUtil;
import model.MusicBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by baofeng on 2017/4/28.
 */
public class MusicDAO {
    private PreparedStatement stmt = null;
    private Connection connection = null;
    private ResultSet rs = null;
    private MusicBean musicBean = null;
    private List<MusicBean> list = null;

    public MusicBean getMusic(long id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM music WHERE id=?";
        connection = DbUtil.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setLong(1, id);
        rs = stmt.executeQuery();
        while (rs.next()) {
            musicBean = getOneMusicBean(rs);
        }
        DbUtil.close(rs);
        return musicBean;
    }

    public List<MusicBean> getMusic(String name) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM music WHERE music_name=?";
        connection = DbUtil.getConnection();
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        rs = stmt.executeQuery();
        list = getListMusicBean(rs);
        return list;
    }

    private List<MusicBean> getListMusicBean(ResultSet rs) throws SQLException {
        List<MusicBean> list = new LinkedList<>();
        while (rs.next()) {
            MusicBean musicBean = getOneMusicBean(rs);
            list.add(musicBean);
        }
        return list;
    }

    private MusicBean getOneMusicBean(ResultSet rs) throws SQLException {
        MusicBean musicBean = new MusicBean();
        musicBean.setId(rs.getLong(1));
        musicBean.setName(rs.getString(2));
        musicBean.setSinger(rs.getString(3));
        musicBean.setPublicYear(rs.getInt(4));
        musicBean.setMusicUrl(rs.getString(5));
        musicBean.setAlbumUrl(rs.getString(6));
        return musicBean;
    }
}
