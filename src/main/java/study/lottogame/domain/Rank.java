package study.lottogame.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
  MISS(0, 0, (countOfMatch, matchBonus) -> countOfMatch == 0),
  FIFTH(3, 5_000, (countOfMatch, matchBonus) -> countOfMatch == 3),
  FOURTH(4, 50_000, (countOfMatch, matchBonus) -> countOfMatch == 4),
  THIRD(5, 1_500_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && !matchBonus),
  SECOND(5, 30_000_000, (countOfMatch, matchBonus) -> countOfMatch == 5 && matchBonus),
  FIRST(6, 2_000_000_000, (countOfMatch, matchBonus) -> countOfMatch == 6);

  private int countOfMatch;
  private int winningMoney;
  private BiPredicate<Integer, Boolean> matchPredicate;

  private Rank(int countOfMatch, int winningMoney, BiPredicate<Integer, Boolean> matchPredicate) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
    this.matchPredicate = matchPredicate;
  }

  public int getCountOfMatch() {
    return countOfMatch;
  }

  public int getWinningMoney() {
    return winningMoney;
  }

  public boolean matches(int countOfMatch, boolean matchBonus) {
    return matchPredicate.test(countOfMatch, matchBonus);
  }

  public static Rank valueOf(int countOfMatch, boolean matchBonus) {
    return Arrays.stream(Rank.values())
            .filter(rank -> rank.matches(countOfMatch, matchBonus))
            .findFirst()
            .orElse(Rank.MISS);
  }
}
