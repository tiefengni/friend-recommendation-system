import java.util.*;

public class FriendGraph {
    private Map<String, Set<String>> graph;

    public FriendGraph() {
        graph = new HashMap<>();
    }

    public void addUser(String user) {
        graph.putIfAbsent(user, new HashSet<>());
    }

    public void addFriendship(String user1, String user2) {
        addUser(user1);
        addUser(user2);

        graph.get(user1).add(user2);
        graph.get(user2).add(user1);
    }

    public Set<String> recommendFriends(String user) {
        Set<String> recommendations = new HashSet<>();

        if (!graph.containsKey(user)) {
            return recommendations;
        }

        Set<String> directFriends = graph.get(user);

        for (String friend : directFriends) {
            for (String friendOfFriend : graph.get(friend)) {
                if (!friendOfFriend.equals(user) && !directFriends.contains(friendOfFriend)) {
                    recommendations.add(friendOfFriend);
                }
            }
        }

        return recommendations;
    }

    public void printNetwork() {
        for (String user : graph.keySet()) {
            System.out.println(user + " -> " + graph.get(user));
        }
    }
}
