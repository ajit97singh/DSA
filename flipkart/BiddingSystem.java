package src.src.flipkart;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BiddingSystem {

    private final Map<Integer, Buyer> buyers;
    private final Map<Integer, Seller> sellers;
    private final Map<Integer, Auction> auctions;

    public BiddingSystem() {
        buyers = new HashMap<>();
        sellers = new HashMap<>();
        auctions = new HashMap<>();
    }

    public int addBuyer(String name) {
        Buyer newBuyer = new Buyer(name);
        System.out.println(name + "is added as a buyer with id --> " + newBuyer.getBuyerId());
        buyers.put(newBuyer.getBuyerId(), newBuyer);
        return newBuyer.getBuyerId();
    }

    public int addSeller(String name) {
        Seller newSeller = new Seller(name);
        System.out.println(name + "is added as a seller with id --> " + newSeller.getSellerId());
        sellers.put(newSeller.getSellerId(), newSeller);
        return newSeller.getSellerId();
    }

    public int createAuction(String itemName, int lowestBidLimit, int highestBidLimit, int participationCost, int sellerId) {
        Seller seller = sellers.get(sellerId);
        if (seller != null) {
            Auction newAuction = new Auction(itemName, lowestBidLimit, highestBidLimit, participationCost, seller);
            if(Objects.nonNull(newAuction.getSeller())){
                auctions.put(newAuction.getId(), newAuction);
                return newAuction.getId();
            }
        }
        return -1;
    }

    public void placeBid(int buyerId, int auctionId, int amount) {
        Buyer buyer = buyers.get(buyerId);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            if (auction.placeBid(buyer, amount)){
                System.out.println("Bid placed successfully");
            }else {
                System.out.println("Bid was not placed");
            }
        }
    }

    public void updateBid(int buyerId, int auctionId, int newAmount) {
        Buyer buyer = buyers.get(buyerId);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            if( auction.updateBid(buyer, newAmount)){
                System.out.println("Bid updated successfully");
            }else {
                System.out.println("Bid was not placed");
            }
        }
    }

    public void withdrawBid(int buyerId, int auctionId) {
        Buyer buyer = buyers.get(buyerId);
        Auction auction = auctions.get(auctionId);
        if (buyer != null && auction != null) {
            auction.withdrawBid(buyer);
        }
    }

    public void closeAuction(int auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null) {
            auction.closeAuction();
        }
    }

    public void printWinner(int auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null && auction.getAuctionWinner() != null) {
            System.out.println("Winner: " + auction.getAuctionWinner().getName() + ", Bid: " + auction.getWinningBid());
        } else {
            System.out.println("No winner for auction: " + auctionId);
        }
    }

    public void printProfit(int auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction != null) {
            Seller seller = auction.getSeller();
            System.out.println("Profit/Loss for Seller " + seller.getName() + ": " + auction.calculateProfitOrLoss());
        }
    }

    public static void main(String[] args) {
        BiddingSystem system = new BiddingSystem();

        int A = system.addBuyer("A");
        int B = system.addBuyer("B");
        int C = system.addBuyer("C");
        int D = system.addBuyer("D");
        int E = system.addBuyer("E");
        int F = system.addBuyer("F");

        int S = system.addSeller("S");

        int auction1Id = system.createAuction("A1", 10, 50, 1, S);
//        int auction2Id = system.createAuction("A2", 15, 500, 10, S);

        system.placeBid(A, auction1Id, 50);
        system.placeBid(B, auction1Id, 90);
        system.placeBid(D, auction1Id, 100);

        system.updateBid(D, auction1Id, 19);

        system.closeAuction(1);
        system.printWinner(1);
        system.printProfit( 1);
    }
}