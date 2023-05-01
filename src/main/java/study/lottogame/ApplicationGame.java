package study.lottogame;

import study.lottogame.domain.GameResult;
import study.lottogame.domain.Lotteries;
import study.lottogame.domain.Lottery;
import study.lottogame.domain.Money;
import study.lottogame.factory.LotteriesFactory;
import study.lottogame.ui.InputView;
import study.lottogame.ui.OutputView;

public class ApplicationGame {

  public static void main(String[] args) {
    Money inputMoney = InputView.inputPurchaseMoney();
    Lotteries lotteries = LotteriesFactory.create(inputMoney);
    OutputView.printLotteries(lotteries);

    Lottery prizeLottery = InputView.inputPrizeLottery();
    GameResult gameResult = lotteries.calculateGameResult(prizeLottery);
    OutputView.printGameResult(inputMoney, gameResult);
  }
}
