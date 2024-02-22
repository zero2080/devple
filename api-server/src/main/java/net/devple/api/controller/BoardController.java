package net.devple.api.controller;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import net.devple.api.entity.Board;
import net.devple.api.service.BoardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

  private final BoardService service;

  @GetMapping("/test")
  public Map<String,String> test(){
    return Map.of("key","value");
  }
  @GetMapping
  public Page<Board.Response> getBoardList(Pageable page) {
    return service.getBoardList(page);
  }

  @GetMapping("/{id}")
  public Board.Response getBoard(@PathVariable Integer id) {
    return service.getBoard(id);
  }

  @PostMapping
  public void saveBoard(@RequestBody Board.Request board) {
    service.saveBoard(board);
  }


}
