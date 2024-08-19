package com.tenco.blog.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tenco.blog.dto.updateDto;
import com.tenco.blog.repository.model.Board;
import com.tenco.blog.service.BoardService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
	
	@Autowired
	private final HttpSession session;
	private final BoardService boardService;
	
    @GetMapping({ "/list", "/" })
    public String listPage(Model model) {
    	
    	List<Board> boardList = boardService.readBoardAll();
    	model.addAttribute("boardList", boardList);
        return "board/board";
    }
    
    @GetMapping("/update")
    public String updateBoardPage() {
    	
    	return "board/update";
    }
    
    @PostMapping("/update")
    public String updateBoardProc(updateDto dto) {
    		boardService.updateBoard(dto);
    	
    	return "redirect:/board/list";
    }
    

    @GetMapping("/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }

    @GetMapping("/{id}/updateForm")
    public String updateForm(@PathVariable int id) {
        return "board/updateForm";
    }

    @PostMapping("/save")
    public String save(){
        return "redirect:/";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable int id){
        return "redirect:/";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        return "redirect:/";
    }
}
