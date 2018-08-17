package com.jp.tic.tac.toe.Board;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Move {
  @Id
  @GeneratedValue
  private long id;
  private int move;

  public int getMove() {
    return move;
  }

  public void setMove(int move) {
    this.move = move;
  }

  public Move(int move){
    this.move = move;
  }


}
