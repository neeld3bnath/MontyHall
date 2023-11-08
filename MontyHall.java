public class MontyHall {
    int chosenDoor;
    int winningDoor;
    int revealedDoor;
    private boolean switchDoors;

    public MontyHall(int chosenDoor) {
        this.chosenDoor = chosenDoor;
        this.winningDoor = (int) (Math.random() * 3) + 1;
        this.switchDoors = false;
    }

    public void revealDoor() {
        int randomDoor = (int) (Math.random() * 3) + 1;
        if (randomDoor != chosenDoor && randomDoor != winningDoor) {
            revealedDoor = randomDoor;
            System.out.println("One of the goats is behind door number " + revealedDoor + ".");
        } else {
            revealDoor();
        }
    }

    public void switchDoors() {
        if (chosenDoor != revealedDoor) {
            this.switchDoors = true;
            this.chosenDoor = 6 - chosenDoor - revealedDoor;
        }
    }

    public boolean checkWin() {
        return chosenDoor == winningDoor;
    }

    public boolean isSwitched() {
        return switchDoors;
    }
}
