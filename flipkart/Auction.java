package src.src.flipkart;

import lombok.Getter;

import java.util.*;

class Auction {
    private static int id = 0;
    private static final HashSet<String> auctionItems = new HashSet<>();
    private int auctionId;
    private int lowestBidLimit;
    private int highestBidLimit;
    private double participationCost;
    @Getter
    private Seller seller;
    private Map<Buyer, Integer> bids;
    private boolean isClosed;
    @Getter
    private Buyer auctionWinner;
    @Getter
    private int winningBid;
    private String itemName;

    public Auction(String itemName, int lowestBidLimit, int highestBidLimit, int participationCost, Seller seller) {
        if (!auctionItems.contains(itemName)) {
            auctionItems.add(itemName);
            id++;
            this.auctionId = id;
            this.lowestBidLimit = lowestBidLimit;
            this.highestBidLimit = highestBidLimit;
            this.participationCost = participationCost;
            this.seller = seller;
            this.bids = new HashMap<>();
            this.isClosed = false;
            this.auctionWinner = null;
            this.winningBid = 0;
            this.itemName = itemName;
        }else {
            System.out.println("This item is already in an auction");
        }


    }

    public int getId() {
        return this.auctionId;
    }

    public boolean placeBid(Buyer buyer, int amount) {
        if (amount < lowestBidLimit || amount > highestBidLimit || isClosed) {
            return false;
        }
        bids.put(buyer, amount);
        buyer.incrementAuctionsParticipated();
        return true;
    }

    public boolean updateBid(Buyer buyer, int newAmount) {
        if (!bids.containsKey(buyer) || newAmount < lowestBidLimit || newAmount > highestBidLimit || isClosed) {
            return false;
        }
        bids.put(buyer, newAmount);
        return true;
    }

    public boolean withdrawBid(Buyer buyer) {
        if (!bids.containsKey(buyer) || isClosed) {
            return false;
        }
        bids.remove(buyer);
        return true;
    }

    public Buyer closeAuction() {
        isClosed = true;
        Map<Integer, Integer> bidCounts = new HashMap<>();

        for (int amount : bids.values()) {
            bidCounts.put(amount, bidCounts.getOrDefault(amount, 0) + 1);
        }

        int highestUniqueBid = -1;
        for (int amount : bidCounts.keySet()) {
            if (bidCounts.get(amount) == 1) {
                highestUniqueBid = Math.max(highestUniqueBid, amount);
            }
        }

        Buyer winner = null;
        if (highestUniqueBid != -1) {
            for (Map.Entry<Buyer, Integer> entry : bids.entrySet()) {
                if (entry.getValue() == highestUniqueBid) {
                    winner = entry.getKey();
                }
            }

        }
        auctionWinner = winner;
        return winner;
    }

    public double calculateProfitOrLoss() {
        // add closei
        double avgBidLimit = (lowestBidLimit + highestBidLimit) / 2.0;
        double participationRevenue = bids.size() * participationCost;
        double sellerCommission = participationRevenue * 0.2;

        double profitMadeBySeller = 0;

        if (isClosed && Objects.nonNull(auctionWinner)) {
            int winningBid = bids.get(auctionWinner);
            profitMadeBySeller += winningBid - avgBidLimit;
        }

        profitMadeBySeller += sellerCommission;
        this.seller.addProfit(profitMadeBySeller);
        return profitMadeBySeller;
    }
}


