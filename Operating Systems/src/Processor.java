public class Processor {
    Job currentJob;
    boolean free = true;

    public boolean isFree() {
        return this.free;
    }

    public void runJob(int currentTime) {
        int roundsLeft = this.currentJob.run(currentTime);

        // in round robin we run each job once and then grab a new job
        //this.free = true;

        // in FIFO we will run a job until it is complete
        if (roundsLeft <= 0)
        {
            this.free = true;
        }
    }

    public void newJob(Job job) {
        this.currentJob = job;
        this.free = false;
    }
}
