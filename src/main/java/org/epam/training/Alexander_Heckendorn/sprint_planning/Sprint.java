package org.epam.training.Alexander_Heckendorn.sprint_planning;

import org.epam.training.Alexander_Heckendorn.sprint_planning.tickets.*;
import java.util.Arrays;

public class Sprint {

    private final int timeCapacity;
    private final int ticketLimit;
    private final Ticket[] tickets;
    private int ticketCount = 0;
    private int totalEstimate = 0;

    public Sprint(int timeCapacity, int ticketLimit) {
        this.timeCapacity = timeCapacity;
        this.ticketLimit = ticketLimit;
        this.tickets = new Ticket[ticketLimit];
    }

    public boolean addUserStory(UserStory userStory) {
        if (userStory == null || userStory.isCompleted() || contains(userStory)) {
            return false;
        }

        UserStory[] dependencies = userStory.getDependencies();
        for (UserStory dependency : dependencies) {
            if (!contains(dependency) || !dependency.isCompleted()) {
                return false;
            }
        }

        for (UserStory dependency : dependencies) {
            dependency.complete();
        }

        return addTicket(userStory);
    }

    private boolean containsUserStory(UserStory userStory) {
        for (int i = 0; i < ticketCount; i++) {
            Ticket ticket = tickets[i];
            if (ticket instanceof UserStory && ticket.getId() == userStory.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean addBug(Bug bugReport) {
        if (bugReport == null || bugReport.isCompleted()) {
            return false;
        }
        UserStory relatedUserStory = bugReport.getRelatedUserStory();
        if (relatedUserStory != null && !relatedUserStory.isCompleted()) {
            return false;
        }
        return addTicket(bugReport);
    }


    public Ticket[] getTickets() {
        return Arrays.copyOf(tickets, ticketCount);
    }

    public int getTotalEstimate() {
        return totalEstimate;
    }

    private boolean addTicket(Ticket ticket) {
        if (ticket.getEstimate() + totalEstimate > timeCapacity || ticketCount >= ticketLimit) {
            return false;
        }
        tickets[ticketCount] = ticket;
        ticketCount++;
        totalEstimate += ticket.getEstimate();
        return true;
    }

    public boolean contains(UserStory userStory) {
        for (Ticket ticket : tickets) {
            if (ticket instanceof UserStory) {
                UserStory us = (UserStory) ticket;
                if (us.equals(userStory)) {
                    return true;
                }
            }
        }
        return false;
    }
}

