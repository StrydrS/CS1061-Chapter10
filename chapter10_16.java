import java.util.*;

public class chapter10_16 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Community community;

        Map<Integer, Citizen> citizens;
        Set<Integer> informedCitizens;

        // Create the network
        System.out.print("Enter citizen and relation quantities: ");
        int citizenQuantity = stdIn.nextInt();
        int relationQuantity = stdIn.nextInt();

        System.out.print("Enter seed number for randomization: ");
        int seedNumber = stdIn.nextInt();

        community = new Community(citizenQuantity, relationQuantity, seedNumber);
        citizens = community.getCitizens();
        System.out.println("Citizens\tFriends");

        for (Integer id : citizens.keySet()) {
            // Use citizen's toString method to display citizen info
            System.out.println(citizens.get(id));
        }

        // Propagate a message through it
        System.out.println("Enter information source ID: ");
        informedCitizens = community.spreadWord(stdIn.nextInt());
        System.out.println("Citizen\tDelay");
        for (Integer citizenID : informedCitizens) {
            System.out.printf("%d\t%d\n", citizenID, citizens.get(citizenID).getDelay());
        }
    }
}

class Community {
    private Map<Integer, Citizen> citizens = new HashMap<>();

    public Community(int citizenQuantity, int relationQuantity, int seedNumber) {
        Random random = new Random(seedNumber);
        Citizen citizen;

        int self, other;

        for (int i = 0; i < citizenQuantity; i++) {
            citizen = new Citizen();
            citizens.put(citizen.ID, citizen);
        }

        for (int j = 0; j < relationQuantity; j++) {
            self = random.nextInt(citizens.size());
            do {
                other = random.nextInt(citizens.size());
            } while (other == self || citizens.get(self).getFriends().contains(other));
            citizens.get(self).addFriend(other);
            citizens.get(self).addFriend(self);
        }
    } // End constructor

    public Map<Integer, Citizen> getCitizens() {
        return this.citizens;
    }

    public Set<Integer> spreadWord(int sender) {
        Set<Integer> informedCitizens = new LinkedHashSet<>();
        Queue<Integer> sendersQueue = new ArrayDeque<>();

        citizens.get(sender).setDelay(0);
        informedCitizens.add(sender);
        sendersQueue.add(sender);
        do {
            sender = sendersQueue.remove();
            for (Integer friend : citizens.get(sender).getFriends()) {
                if (!informedCitizens.contains(friend)) {
                    citizens.get(friend).setDelay(citizens.get(sender).getDelay() + 1);
                    informedCitizens.add(friend);
                    sendersQueue.add(friend);
                }
            }
        } while (!sendersQueue.isEmpty());
        return informedCitizens;
    }
}

class Citizen {
    private static int nextID = 0;
    public final int ID = nextID++;
    private Set<Integer> friends = new TreeSet<>();
    private int delay;

    public void addFriend(int friendID) {
        this.friends.add(friendID);
    }

    public Set<Integer> getFriends() {
        return this.friends;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getDelay() {
        return this.delay;
    }

    public String toString() {
        return String.format("%d\t%s", ID, friends);
    }
}
