package org.epam.training.Alexander_Heckendorn.task_Carousel;

public class CompleteByRequestTask implements Task {
    private boolean completed;
    private boolean finished;

    @Override
    public void execute() {
        if(completed){
            finished = true;
        }
        completed = false;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void complete() {
        completed = true;
    }
}
