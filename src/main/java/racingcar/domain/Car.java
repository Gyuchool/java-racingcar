package racingcar.domain;

import racingcar.domain.car.Name;

public class Car {
    private static final String CAR_STATUS_DELIMITER = " : ";
    private static final String CAR_POSITION_STATUS = "-";

    private final Name name;
    private int position;
    private CarMoveRule rule;

    public Car(String name) {
        this.name = new Name(name);
        this.position = 0;
        this.rule = new CarMoveRule();
    }

    public Name getName() {
        return this.name;
    }

    public int getPosition() { return this.position; }

    public void moveByDefaultRule() {
        move(rule.applyDefaultRule());
    }

    public void move(boolean moveRule) {
        if (moveRule) {
            position++;
        }
    }

    public String toString() {
        return this.name + CAR_STATUS_DELIMITER + repeat(CAR_POSITION_STATUS, this.position);
    }

    private String repeat(String str, int num) {
        return new String(new char[num]).replace("\0", str);
    }

    public int aboveMaxPosition(int maxPosition) {
        if (this.position > maxPosition) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isMaxPosition(int maxPosition) {
        if (maxPosition == this.position) {
            return true;
        }
        return false;
    }
}
