public class Job {
    int runTime;
    int currentTime;
    int timeFinished = 0;
    int startingTime;

    public Job(int runTime, int startingTime) {
        this.runTime = runTime;
        this.currentTime = runTime;
        this.startingTime = startingTime;
    }

    public int run(int currentRound) {
        this.timeFinished = currentRound;

        if (this.currentTime < 2) {
        //    System.out.println(this.currentTime);
        }
        return this.currentTime--;
    }

    public int getRoundsLeft() {
        return this.currentTime;
    }

    public int getTotalRunTime() {
        return this.runTime;
    }

    public int getTurnAroundTime() {
        return this.timeFinished - this.startingTime;
    }

    public boolean isDone() {
        return this.currentTime <= 0;
    }
}
