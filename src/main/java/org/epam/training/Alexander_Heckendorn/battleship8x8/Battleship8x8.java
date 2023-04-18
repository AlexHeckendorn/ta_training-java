package org.epam.training.Alexander_Heckendorn.battleship8x8;

public class Battleship8x8 {
    private final long ships;
    private long shots = 0L;

    public Battleship8x8(final long ships) {
        this.ships = ships;
    }

    public boolean shoot(String shot) {
        int col = shot.charAt(0) - 'A';
        int row = Integer.parseInt(shot.substring(1)) - 1;
        int index = row * 8 + col;
        long mask = 1L << (63 - index);
        boolean hit = (ships & mask) != 0;
        shots |= mask;
        return hit;
    }

    public String state() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int index = i * 8 + j;
                long mask = 1L << (63 - index);
                if ((shots & mask) != 0) {
                    sb.append((ships & mask) != 0 ? "☒" : "×");
                } else {
                    sb.append((ships & mask) != 0 ? "☐" : ".");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
