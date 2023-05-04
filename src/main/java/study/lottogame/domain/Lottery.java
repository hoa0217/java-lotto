package study.lottogame.domain;

import java.util.Collections;
import java.util.Set;

public class Lottery {

  public static final Money LOTTERY_PRICE = new Money(1000);
  public static final int LOTTO_NUMBER_COUNT = 6;

  private Set<LottoNumber> lottoNumbers;

  public Lottery(final Set<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.lottoNumbers = lottoNumbers;
  }

  public int matchLottoNumbers(Lottery otherLottery) {
    Set<LottoNumber> otherLottoNumbers = otherLottery.getLottoNumbers();
    return (int) lottoNumbers.stream()
        .filter(otherLottoNumbers::contains)
        .count();
  }

  public boolean matchLottoNumber(LottoNumber lottoNumber) {
    return this.lottoNumbers.contains(lottoNumber);
  }

  public Set<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableSet(lottoNumbers);
  }
}
