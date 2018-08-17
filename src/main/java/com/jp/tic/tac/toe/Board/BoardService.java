package com.jp.tic.tac.toe.Board;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

  private List<Move> validMoves(Board board) {
    boolean empty = true;
    List<Move> moves = new ArrayList<>();
    for (int i = 0; i < board.getBoardRep().length; i++) {
      if (board.getBoardRep()[i] != 0) {
        empty = false;
      }
    }
    if (empty) {
      moves.add(new Move(-1));
      return moves;
    } else {
      for (int i = 0; i < board.getBoardRep().length; i++) {
        if (board.getBoardRep()[i] == 0) {
          moves.add(new Move(i));
        }
      }
      if (moves.isEmpty()) {
        moves.add(new Move(-1));
        return moves;
      } else {
        return moves;
      }
    }
  }

  public int[] alphaBeta(Board board, int player, int alpha, int beta) {

    int[] results = new int[2];
    if (checkWin(board) != 0 || validMoves(board).get(0).getMove() == -1) {
      results[0] = checkWin(board);
      return results;
    }
    //ticTacToe copy=new ticTacToe(true,Toey.getBoard());
    if (player == 1) {
      int max = -100;
      Move move;
      for (int i = 0; i < validMoves(board).size(); i++) {
        move = validMoves(board).get(i);
        board.makeMove(move.getMove(), player);
        if (alphaBeta(board, player * -1, alpha, beta)[0] > max) {
          max = alphaBeta(board, player * -1, alpha, beta)[0];
          results[1] = move.getMove();

        }
        alpha = Math.max(alpha, max);
        board.undoMove(move.getMove());
        if (alpha >= beta) {
          break;
        }
      }
      results[0] = max;

      return results;


    } else {
      int min = 100;
      Move move;
      for (int i = 0; i < validMoves(board).size(); i++) {
        move = validMoves(board).get(i);
        board.makeMove(move.getMove(), player);
        if (alphaBeta(board, player * -1, alpha, beta)[0] < min) {
          min = alphaBeta(board, player * -1, alpha, beta)[0];
          results[1] = move.getMove();
        }
        beta = Math.min(beta, min);
        board.undoMove(move.getMove());
        if (alpha >= beta) {
          break;
        }
      }

      results[0] = min;

      return results;
    }

  }

  private int checkWin(Board board) {

    ArrayList<int[]> wins = new ArrayList<>();
    int[] winPos = {0, 1, 2};
    wins.add(winPos);
    int[] winPos1 = {3, 4, 5};
    wins.add(winPos1);
    int[] winPos2 = {6, 7, 8};
    wins.add(winPos2);
    int[] winPos4 = {0, 3, 6};
    wins.add(winPos4);
    int[] winPos3 = {1, 4, 7};
    wins.add(winPos3);
    int[] winPos5 = {2, 5, 8};
    wins.add(winPos5);
    int[] winPos6 = {0, 4, 8};
    wins.add(winPos6);
    int[] winPos7 = {2, 4, 6};
    wins.add(winPos7);
    for (int i = 0; i < wins.size(); i++) {
      int[] currentLines = wins.get(i);
      if (board.getBoardRep()[currentLines[0]] == 'X') {
        if ('X' == board.getBoardRep()[currentLines[1]]
            && 'X' == board.getBoardRep()[currentLines[2]]) {
        printBoard(board);
          return 100;
        }

      } else if (board.getBoardRep()[currentLines[0]] == 'O') {
        if ('O' == board.getBoardRep()[currentLines[1]]
            && 'O' == board.getBoardRep()[currentLines[2]]) {
          return -100;
        }
      }
    }
    return 0;

  }

  private void printBoard (Board board) {
    for (int i = 0; i < 3; i++) {
      System.out.print("[" + board.getBoardRep()[i] + "] " + "[" + board.getBoardRep()[i + 1] + "] " + "[" + board.getBoardRep()[i + 2] + "]");
      System.out.println();
    }
    System.out.println();
  }
}
