package com.tenco.blog.repository.interfaces;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.tenco.blog.repository.model.Board;

public interface boardRepository {
	public int insert(Board board);
	public int updateById(Board board);
	public int deleteById(Integer id, String username);
	
	public int selectAll(Integer id);
	
	// TODO - 나중에 필요한거 추가
	public List<Board> findBoard();
	

}
