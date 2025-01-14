package src.src.flipkart;

import lombok.Getter;

class Buyer {
    private static int id = 0;
    @Getter
    private final String name;
    @Getter
    private final int buyerId;
    @Getter
    private int auctionsParticipated;
    private boolean isPreferred;

    public Buyer(String name) {
        id++;
        this.name = name;
        this.auctionsParticipated = 0;
        this.isPreferred = false;
        this.buyerId = id;
    }

    public boolean isPreferred() {
        return isPreferred;
    }

    public void incrementAuctionsParticipated() {
        auctionsParticipated++;
        if (auctionsParticipated > 2) {
            isPreferred = true;
        }
    }

}
