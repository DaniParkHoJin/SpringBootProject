package com.hojin.dao;

import com.hojin.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class BoardDAO {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void create(Board board) throws Exception {
        String query = "INSERT INTO DIBOARD (title, content, writer) VALUES (?, ?, ?)";
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }

    public Board read(Integer boardNo) throws Exception {
        List<Board> results = jdbcTemplate.query(
                "SELECT board_no, title, content, writer, reg_date FROM diboard WHERE board_no = ? ",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        Timestamp timestamp = rs.getTimestamp("reg_date");
                        board.setRegdate(timestamp.toLocalDateTime());
                        return board;
                    }
                }, boardNo);
        return results.isEmpty() ? null : results.get(0);


    }

    public List<Board> list() throws Exception {
        List<Board> results = jdbcTemplate.query("SELECT board_no, title, content, writer, reg_date FROM diboard WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC",
                new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws
                            SQLException {
                        Board board = new Board();
                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        Timestamp timestamp = rs.getTimestamp("reg_date");
                        board.setRegdate(timestamp.toLocalDateTime());
                        return board;
                    }
                });
        return results;
    }

    public void update(Board board) throws Exception {
        String query = "UPDATE diboard SET title =?, content =? WHERE board_no = ?";
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());
    }
    public void delete(Integer boardNo) throws Exception {
        String query = "delete from diboard where board_no = ?";
        jdbcTemplate.update(query, boardNo);
    }


}

