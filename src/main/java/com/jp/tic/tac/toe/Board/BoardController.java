package com.jp.tic.tac.toe.Board;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  private BoardRepository repository;
  private BoardService service;

  BoardController(BoardRepository repository, BoardService service) {
  this.repository = repository;
  this.service = service;
  }
  @GetMapping("/Board")
  @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
  Collection<Board> boards(){
    return repository.findAll();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/Board")
  @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
  public Move postBoard(@RequestBody Board board){
    return new Move(service.alphaBeta(board,-1,-100,100)[1]);
    //return service.getNextMove(board);
  }

}
