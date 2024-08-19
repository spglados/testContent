package com.tenco.blog.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tenco.blog.dto.updateDto;
import com.tenco.blog.repository.interfaces.boardRepository;
import com.tenco.blog.repository.model.Board;

import jakarta.servlet.http.HttpSession;

@Service
public class BoardService {
	
	private final boardRepository boardRepository;
	
	public BoardService(boardRepository boardRepository) {
		this.boardRepository = boardRepository;
	}
	
	@Transactional
	public List<Board> readBoardAll(){
		List<Board> boardListEntity = null;
		
		boardListEntity = boardRepository.findBoard();
		
		
		return boardListEntity;
	}
	
	public void updateBoard(updateDto dto) {
		
		Board boardEntity = (Board)boardRepository.findBoard(); 
		
		boardRepository.updateById(boardEntity);
		
	}
}
