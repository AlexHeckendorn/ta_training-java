package org.epam.training.Alexander_Heckendorn.sprint_planning.tickets;


import java.util.Arrays;

public class UserStory extends Ticket {

    private final UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependencies) {
        super(id, name, estimate);
        this.dependencies = dependencies.clone();
    }

    public UserStory[] getDependencies() {
        return dependencies.clone();
    }

    @Override
    public void complete() {
        boolean allDependenciesCompleted = true;
        for (UserStory dependency : dependencies) {
            if (!dependency.isCompleted()) {
                allDependenciesCompleted = false;
                break;
            }
        }
        if (allDependenciesCompleted) {
            super.complete();
        }
    }

    @Override
    public String toString() {
        return "[US " + getId() + "] " + getName();
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserStory other = (UserStory) obj;
        return super.equals(obj) && Arrays.equals(dependencies, other.dependencies);
    }
}

