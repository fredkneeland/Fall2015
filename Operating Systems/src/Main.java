import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int stdID = 8332;
        int numbOfCores = stdID % 3 + 2;
        Random rand = new Random();

        // set to # of tests to run
        for (int x = 0; x < 100; x++)
        {
            boolean done = false;
            int currentTime = 0;
            int currentJob = 0;
            int currentProcessingJob = 0;
            // set size to 12 when running on provided sample and 1000
            Job[] jobArray = new Job[1000];
            Processor[] processors = new Processor[numbOfCores];
            for (int i = 0; i < processors.length; i++)
            {
                processors[i] = new Processor();
            }

            int[] arrivalTimes = {4,15,18,20,26,29,35,45,57,83,88,95};
            int[] processingTimes = {9,2,16,3,29,198,7,170,180,178,73,8};

            while (!done)
            {
                if (currentJob < jobArray.length)
                {
                    // used when doing random
                    jobArray[currentJob] = new Job(rand.nextInt(500), currentTime);
                    currentJob++;

                    // used when testing on provided sample
//                    if (arrivalTimes[currentJob] <= currentTime) {
//                        jobArray[currentJob] = new Job(processingTimes[currentJob], currentTime);
//                        currentJob++;
//                    }
                }

                int firstJobTaken = currentProcessingJob;
                for (int j = 0; j < processors.length; j++)
                {
                    if (currentJob <= 0)
                    {
                        break;
                    }
                    else if (processors[j].isFree())
                    {
                        boolean looping = true;
                        while (looping) {
                            if (!jobArray[currentProcessingJob].isDone())
                            {
                                //System.out.println("Getting new job");
                                processors[j].newJob(jobArray[currentProcessingJob]);
                                looping = false;
                            }
                            currentProcessingJob = (currentProcessingJob + 1) % currentJob;
                            if (currentProcessingJob == firstJobTaken)
                            {
                                looping = false;
                            }
                        }
                    }
                    else
                    {
                        //System.out.println("Running job");
                        processors[j].runJob(currentTime);
                    }
                }

                if (currentJob >= jobArray.length) {
                    boolean allDone = true;
                    for (int k = 0; k < jobArray.length; k++) {
                        if (!jobArray[k].isDone()) {
                            allDone = false;
                            //System.out.println(k);
                            break;
                        }
                    }

                    if (allDone) {
                        done = allDone;
                    }
                }

                currentTime++;
            }
            System.out.println(currentTime);
        }
    }
}
