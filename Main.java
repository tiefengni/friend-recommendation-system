import java.util.Set;

public class Main {
    public static void main(String[] args) {
        FriendGraph network = new FriendGraph();

        network.addFriendship("Alice", "Bob");
        network.addFriendship("Alice", "David");
        network.addFriendship("Bob", "Charlie");
        network.addFriendship("Bob", "Emma");
        network.addFriendship("David", "Frank");

        System.out.println("Social Network:");
        network.printNetwork();

        System.out.println();

        Set<String> recommendations = network.recommendFriends("Alice");

        System.out.println("Friend recommendations for Alice:");
        for (String recommendation : recommendations) {
            System.out.println(recommendation);
        }
    }
}
