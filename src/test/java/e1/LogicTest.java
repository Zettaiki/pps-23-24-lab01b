package e1;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  final static int SIZE = 5;
  Logics logics;
  Pair<Integer, Integer> pawnPos;
  Pair<Integer, Integer> knightPos;

  @BeforeEach
  public void beforeEach() {
    this.pawnPos = new Pair<>(0,0);
    this.knightPos = new Pair<>(0, 2);
    this.logics = new LogicsImpl(SIZE, pawnPos, knightPos);
  }

  @Test
  public void checkPosition() {
    assertTrue(this.logics.hasPawn(0, 0));
    assertFalse(this.logics.hasPawn(0, 2));

    assertTrue(this.logics.hasKnight(0, 2));
    assertFalse(this.logics.hasKnight(0, 0));
  }

  @Test
  public void knightHit() {
    assertThrowsExactly(IndexOutOfBoundsException.class, () -> {this.logics.hit(100, 100);});
    assertFalse(this.logics.hit(4, 4));
    assertFalse(this.logics.hit(2, 1));
    assertTrue(this.logics.hit(0, 0));
  }

}
