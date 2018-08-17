package com.jp.tic.tac.toe.Board;

import java.util.function.Consumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class BoardCommanLineRunner implements CommandLineRunner {

  private final BoardRepository repository;

  public BoardCommanLineRunner(BoardRepository repository){
    this.repository = repository;
  }
  @Override
  public void run(String... strings) throws Exception {
    repository.save(new Board(1));
    repository.save(new Board(5));
    repository.findAll().forEach(consumerNames);
  }
  Consumer<Board> consumerNames = new Consumer<Board>() {
    public void accept(Board board) {
      System.out.println(board.getMove().intValue());
    }
  };
}
