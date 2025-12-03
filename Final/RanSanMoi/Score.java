package ransanmoi;

public class Score {

    // ====== Điểm hiện tại ======
    private int currentScore = 0;

    // ====== Điểm cần để thắng (trong GameConfig) ======
    private int requiredScore = 0;

    // ====== Constructor rỗng ======
    public Score() {    
    }

    // ====== Điểm qua màn ======
    public void setRequiredScore(int requiredScore) {
        this.requiredScore = requiredScore;
    }

       public int getCurrentScore() {
        return currentScore;
    }

    public int getRequiredScore() {
        return requiredScore;
    }

    // ====== Dùng để hỗ trợ hiển thị điểm ======
    public void add(int amount) {
        currentScore += amount;
    }

    public void reset() {
        currentScore = 0;
    }

    // ====== Kiểm tra đủ điểm thắng  ======
    public boolean hasReachedGoal() {
        return currentScore >= requiredScore;
    }
}
