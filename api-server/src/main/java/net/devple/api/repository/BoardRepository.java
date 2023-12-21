package net.devple.api.repository;

import net.devple.api.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board.Domain, Integer> {

  Page<Board.Domain> findAllByOrderByCreatedAtDesc(Pageable pageable);

  Page<Board.Domain> findAllByTitleContainingOrderByCreatedAtDesc(String title, Pageable pageable);

  Page<Board.Domain> findAllByContentContainingOrderByCreatedAtDesc(String content, Pageable pageable);

  Page<Board.Domain> findAllByTitleContainingOrContentContainingOrderByCreatedAtDesc(String title, String content, Pageable pageable);

  Page<Board.Domain> findAllByWriterIdOrderByCreatedAtDesc(Integer writerId, Pageable pageable);

  Page<Board.Domain> findAllByTitleContainingAndWriterIdOrderByCreatedAtDesc(String title, Integer writerId, Pageable pageable);

  Page<Board.Domain> findAllByContentContainingAndWriterIdOrderByCreatedAtDesc(String content, Integer writerId, Pageable pageable);

  Page<Board.Domain> findAllByTitleContainingOrContentContainingAndWriterIdOrderByCreatedAtDesc(String title, String content, Integer writerId, Pageable pageable);

}
