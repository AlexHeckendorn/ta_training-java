package org.epam.training.Alexander_Heckendorn.task_Carousel;

import java.util.ArrayList;
import java.util.List;

public class TaskCarousel {
    private final List<Task> tasks;
    private int currentIndex;
    private final int capacity;
    public TaskCarousel(int capacity) {
        this.capacity = capacity;
        tasks = new ArrayList<>();
    }

    public boolean addTask(Task task) {
        if(task == null || task.isFinished() || isFull()){
            return false;
        }
        tasks.add(task);
        return true;
    }

    public boolean execute() {
        if (isEmpty()) {
            return false;
        }
        Task currentTask = tasks.get(currentIndex);
        currentTask.execute();
        if (currentTask.isFinished()) {
            tasks.remove(currentIndex);
            //currentIndex should only be updated if there are still tasks
            //in the list after the current task is removed
            if (tasks.size() == 0) {
                currentIndex = 0;
            } else {
                currentIndex = currentIndex % tasks.size();
            }
        } else {
            currentIndex = (currentIndex + 1) % tasks.size();
        }
        return true;
    }


    public boolean isFull() {
        return tasks.size() == capacity;
    }

    public boolean isEmpty() {
        return tasks.isEmpty();
    }

}
