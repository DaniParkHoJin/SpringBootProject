package com.board.dao;

import com.board.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Board board) throws Exception {
        String query = "INSERT INTO jdbcBoard (board_no, title, content, writer) VALUES (jdbcBoard_seq.NEXTVAL, ?, ?,?)";
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getWriter());
    }


    public List<Board> list() throws Exception {
        List<Board> result = jdbcTemplate.query("SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC", new RowMapper<Board>() {
            @Override
            public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board board = new Board();

                board.setBoardNo(rs.getInt("board_no"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setWriter(rs.getString("writer"));
                board.setRegDate(rs.getDate("reg_date"));


                return board;
            }
        });

        return result;
    }

    public List<Board> list2() throws Exception {
        String query = "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no > 0 ORDER BY board_no desc, reg_date DESC";

       return jdbcTemplate.query(query, (rs, rowNum) -> {
            Board board = new Board();
            board.setBoardNo(rs.getInt("board_no"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getDate("reg_date"));
            return board;
        });


    }


    public Board read(Integer boardNo) throws Exception {
        List<Board> result = jdbcTemplate.query(
                "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no = ?", new RowMapper<Board>() {
                    @Override
                    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Board board = new Board();

                        board.setBoardNo(rs.getInt("board_no"));
                        board.setTitle(rs.getString("title"));
                        board.setContent(rs.getString("content"));
                        board.setWriter(rs.getString("writer"));
                        board.setRegDate(rs.getDate("reg_date"));

                        return board;
                    }
                }, boardNo);
        return result.isEmpty() ? null : result.get(0);
    }

    public Board read2(Integer boardNo) throws Exception {

        String query = "SELECT board_no, title, content, writer, reg_date FROM jdbcBoard WHERE board_no = ?";

        List<Board> result = jdbcTemplate.query(query, (rs, rowNum) -> {
            Board board = new Board();
            board.setBoardNo(rs.getInt("board_no"));
            board.setTitle(rs.getString("title"));
            board.setContent(rs.getString("content"));
            board.setWriter(rs.getString("writer"));
            board.setRegDate(rs.getDate("reg_date"));
            return board;
        }, boardNo);
        return result.isEmpty() ? null : result.get(0);
    }


    public void update(Board board) throws Exception {

        String query = "UPDATE jdbcBoard SET title = ?, content = ? WHERE board_no = ?";
        jdbcTemplate.update(query, board.getTitle(), board.getContent(), board.getBoardNo());

    }

    public void delete(Integer boardNo) throws Exception {
        String query = "DELETE FROM jdbcBoard WHERE board_no = ?";
        jdbcTemplate.update(query, boardNo);

    }
}
