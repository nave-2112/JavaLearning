class Room {
    int roomNumber;
    String roomType;
    boolean isAvailable;
    double pricePerNight;
    public Room(int roomNumber, String roomType, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;  
        this.pricePerNight = pricePerNight;
    }

  
    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

   
    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been successfully booked");
        } else {
            System.out.println("Room " + roomNumber + " is already booked");
        }
    }
    public void checkAvailability() {
        if (isAvailable) {
            System.out.println("Room " + roomNumber + " is available.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void displayRoominfo() {
        System.out.println("Room Number: " + roomNumber + ", Type: " + roomType + ", Price per Night: " + pricePerNight + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}

class Hotel {
    private Room[] rooms;

    public Hotel(int numberOfRooms) {
        rooms = new Room[numberOfRooms];
        rooms[0] = new Room(101, "Single", 100.0);
        rooms[1] = new Room(102, "Double", 150.0);
        rooms[2] = new Room(103, "Suite", 200.0);
        rooms[3] = new Room(104, "Single", 100.0);
        rooms[4] = new Room(105, "Double", 150.0);
    }

    public void displayRooms() {
        System.out.println("Hotel Rooms:");
        for (Room room : rooms) {
            room.displayRoominfo();
        }
    }


    public void bookRoom(int roomNumber) {
        Room roomToBook = findRoomByNumber(roomNumber);
        if (roomToBook != null) {
            roomToBook.bookRoom();
        } else {
            System.out.println("Room " + roomNumber + " does not exist");
        }
    }

    public void checkRoomAvailability(int roomNumber) {
        Room roomToCheck = findRoomByNumber(roomNumber);
        if (roomToCheck != null) {
            roomToCheck.checkAvailability();
        } else {
            System.out.println("Room " + roomNumber + " does not exist");
        }
    }
    public double calculateTotalCharges(int roomNumber, int numberOfNights) {
        Room room = findRoomByNumber(roomNumber);
        if (room != null) {
            if (room.isAvailable()) {
                return room.getPricePerNight() * numberOfNights;
            } else {
                System.out.println("Room " + roomNumber + " is not available for booking.");
                return 0.0;
            }
        } else {
            System.out.println("Room " + roomNumber + " does not exist.");
            return 0.0;
        }
    }

    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }
}

public class HotelReservationSystem{
    public static void main(String[] args) {
  
        Hotel hotel = new Hotel(5);
        hotel.displayRooms();
        hotel.bookRoom(101);  
        hotel.bookRoom(103);  

        hotel.checkRoomAvailability(101);  
        hotel.checkRoomAvailability(102);  
        double totalCharges = hotel.calculateTotalCharges(102, 3);
        if (totalCharges > 0) {
            System.out.println("Total charges for Room 102 for 3 nights:" + totalCharges);
        }
        hotel.bookRoom(101);
        totalCharges = hotel.calculateTotalCharges(101, 2);
        if (totalCharges > 0) {
            System.out.println("Total charges for Room 101 for 2 nights: " + totalCharges);
        }
    }
}
