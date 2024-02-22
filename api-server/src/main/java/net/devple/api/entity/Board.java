package net.devple.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

public class Board {

  @Entity(name = "board")
  @Getter
  @Setter
  public static class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String title;

    private String content;

    @Column(updatable = false)
    private Instant createdAt;

    private Integer writerId;

    public Response toResponse() {
      return Response.builder()
              .id(id)
              .title(title)
              .content(content)
              .createdAt(createdAt)
              .writerId(writerId)
              .build();
    }

    public static Domain of(Request request) {
      var domain = new Domain();
      domain.setTitle(request.getTitle());
      domain.setContent(request.getContent());
      domain.setWriterId(request.getWriterId());
      domain.createdAt = Instant.now();
      return domain;
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class Request {

      private Integer id;

      @Size(max = 500)
      @NotNull
      private String title;

      @Size(max = 2000)
      @NotNull
      private String content;

      @NotNull
      private Integer writerId;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  @Builder
  public static class Response {
      private Integer id;
      private String title;
      private String content;
      private Instant createdAt;
      private Integer writerId;

  }
}
