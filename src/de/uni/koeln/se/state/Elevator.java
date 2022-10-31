package de.uni.koeln.se.state;


public class Elevator{

    public static int current_Floor=5;
    int dest_Floor;

    private Elv_States State = new Elv_States();

    public Elevator (int dest_floor)
    {
        this.dest_Floor=dest_floor;
        System.out.println("*** Destination floor is: "+ dest_Floor);
            arrive_atFloor();
    }

    private void arrive_atFloor() {
        State.current_state = State.idle;
        if (current_Floor < dest_Floor) {
            move_up();
        } else if (current_Floor > dest_Floor) {
            move_down();
        } else if (current_Floor == dest_Floor){
            System.out.println("Arrival at destination, goodbye");
        } else {
            System.out.println("Something went wrong...");
        }

    }

    private void move_up() {
        State.current_state = State.Moving_up;
        System.out.println("Current State:" + State.current_state);
        current_Floor = current_Floor+1;
        System.out.println("Your current floor is " + current_Floor);
        if (current_Floor < dest_Floor) {
            move_up();
        } else if (current_Floor == dest_Floor) {
            arrive_atFloor();
        } else {
            System.out.println("Something went wrong...");
        }

    }

    private void move_down() {
        State.current_state = State.Moving_down;
        System.out.println("Current State:" + State.current_state);
        current_Floor = current_Floor-1;
        System.out.println("Your current floor is " + current_Floor);
        if (current_Floor > dest_Floor) {
            move_down();
        } else if (current_Floor == dest_Floor) {
            arrive_atFloor();
        } else {
            System.out.println("Something went wrong...");
        }
    }


}