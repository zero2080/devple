package net.devple.api.service;

import lombok.RequiredArgsConstructor;
import net.devple.api.entity.Board;
import net.devple.api.exception.NotFoundException;
import net.devple.api.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository repository;

  public Page<Board.Response> getBoardList(Pageable pageable) {
    return repository.findAll(pageable).map(Board.Domain::toResponse);
  }

  public Board.Response getBoard(Integer id) {
    return repository.findById(id).orElseThrow(NotFoundException::new).toResponse();
  }

  public void saveBoard(Board.Request board) {
    if(board.getId() != null) {
      var domain = repository.findById(board.getId()).orElseThrow(NotFoundException::new);
      domain.setTitle(board.getTitle());
      domain.setContent(board.getContent());
      repository.save(domain);
      return;
    }
    repository.save(Board.Domain.of(board));
  }
}
