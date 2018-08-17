package com.jp.tic.tac.toe.Board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Board {
  @Id
  @GeneratedValue
  private Long id;
  private Integer move;
  private char[] boardRep;


  public Board(){
  }
  public Board(Integer move){
    this.move = move;
  }
  public Board(Integer move,char[] board){
    this.move = move;
    this.boardRep = board;
  }

  public char[] getBoardRep() {
    return boardRep;
  }

  public void setBoardRep(char[] boardRep) {
    this.boardRep = boardRep;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getMove() {
    return move;
  }

  public void setMove(Integer move) {
    this.move = move;
  }

  public void makeMove(int move, int player) {
    if(player == -1) {
      boardRep[move] = 'O';
    }
    else {
      boardRep[move] = 'X';
    }
  }

  public void undoMove(int move) {
    boardRep[move] = 0;
  }
}
