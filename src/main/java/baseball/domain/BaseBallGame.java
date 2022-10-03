package baseball.domain;

import java.util.List;

public class BaseBallGame {

    private final Computer computer;
    public GameMachineStatus gameMachineStatus;

    public BaseBallGame(PickBallsStrategy pickBallsStrategy) {
        this.computer = new Computer(pickBallsStrategy);
        gameMachineStatus = GameMachineStatus.RUNNING;
    }

    public GameResult playOnce(List<Integer> numbers) {
        GameResult gameResult = computer.judgeResult(new Balls(numbers));
        postProcess(gameResult);
        return gameResult;
    }

    private void postProcess(GameResult gameResult) {
        if (gameResult.isOut()) {
            gameMachineStatus = GameMachineStatus.FINISH;
        }
    }

    public boolean isGameEnd() {
        return gameMachineStatus.isFinish();
    }

}
