public class AirportSim {
    public static void main(String[] args) {
        //Initializing runway queues
        Queue<Airplane> runway1 = new CircularArrayQueue<>();
        Queue<Airplane> runway2 = new CircularArrayQueue<>();

        //Performing all tests
        System.out.println("Initializing test 1:" + "\n");
        test1(runway1, runway2);
        airportSimulator(runway1, runway2);

        System.out.println("Initializing test 2:" + "\n");
        test2(runway1, runway2);
        airportSimulator(runway1, runway2);

        System.out.println("Initializing test 3:" + "\n");
        test3(runway1, runway2);
        airportSimulator(runway1, runway2);
    }

    private static void airportSimulator(Queue<Airplane> runway1, Queue<Airplane> runway2) {
        System.out.println("Loading Airplane Queues...");
        System.out.println("Planes are ready for take off!");
        System.out.println();

        //Dequeue while both runways contain Airplanes
        while (!runway1.isEmpty() && !runway2.isEmpty()) {
            displayRunways(runway1, runway2);

            System.out.println(runway1.peek() + " is taking off on runway 1");
            System.out.println();
            runway1.dequeue();

            //Give priority by allowing runway1 to dequeue 2 Airplanes consecutively
            if (!runway1.isEmpty()) {
                System.out.println(runway1.peek() + " is taking off on runway 1");
                System.out.println();
                runway1.dequeue();
            }

            displayRunways(runway1, runway2);

            System.out.println(runway2.peek() + " is taking off on runway 2");
            System.out.println();
            runway2.dequeue();

        }

        //Dequeue while one runway is empty, but not both.
        while (runway1.isEmpty() ^ runway2.isEmpty()) {
            if (runway1.isEmpty()) {
                displayRunways(runway1, runway2);

                System.out.println(runway2.peek() + " is taking off on runway 2");
                System.out.println();
                runway2.dequeue();
            } else {
                if (runway2.isEmpty()) {
                    displayRunways(runway1, runway2);

                    System.out.println(runway1.peek() + " is taking off on runway 1");
                    System.out.println();
                    runway1.dequeue();

                    if (!runway1.isEmpty()) {
                        System.out.println(runway1.peek() + " is taking off on runway 1");
                        System.out.println();
                        runway1.dequeue();
                    }
                }
            }
        }


        displayRunways(runway1, runway2);
        System.out.println("Simulation concluded. All queues cleared." + "\n");
    }

    //Display runway queues
    static void displayRunways(Queue<Airplane> runway1, Queue<Airplane> runway2) {
        System.out.println("Currently waiting in runways:");
        System.out.println("Runway 1:");
        System.out.println(runway1.toString());
        System.out.println("Runway 2:");
        System.out.println(runway2.toString());
        System.out.println();
    }

    //one runway is empty
    static void test1(Queue<Airplane> runway1, Queue<Airplane> runway2) {
        runway1.enqueue(new Airplane(140, "AA", "American Airlines"));
        runway1.enqueue(new Airplane(130, "UA", "United Airlines"));
        runway1.enqueue(new Airplane(313, "DL", "Delta Airlines"));
        runway1.enqueue(new Airplane(4167, "QR", "Quatar Airways"));
        runway1.enqueue(new Airplane(1401, "HA", "Hawaiian Airlines"));
    }

    //equal runways
    static void test2(Queue<Airplane> runway1, Queue<Airplane> runway2) {
        runway1.enqueue(new Airplane(658, "AA", "American Airlines"));
        runway1.enqueue(new Airplane(4142, "AY", "Finnair"));
        runway2.enqueue(new Airplane(587, "B", "JetBlue Airways"));
        runway2.enqueue(new Airplane(879, "AA", "American Airlines"));
    }

    //unequal runways
    static void test3(Queue<Airplane> runway1, Queue<Airplane> runway2) {
        runway1.enqueue(new Airplane(518, "D", "Delta Airlines"));
        runway1.enqueue(new Airplane(7495, "WS", "WestJet"));
        runway1.enqueue(new Airplane(2158, "VS", "Virgin Atlantic"));
        runway2.enqueue(new Airplane(3158, "EK", "Emirates"));
        runway2.enqueue(new Airplane(8795, "AA", "American Airlines"));
    }
}