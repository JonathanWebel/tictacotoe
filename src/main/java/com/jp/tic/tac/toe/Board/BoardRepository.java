package com.jp.tic.tac.toe.Board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


interface BoardRepository extends JpaRepository<Board, Long> {
}
