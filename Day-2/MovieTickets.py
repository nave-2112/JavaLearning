class MovieTheater:
    def __init__(self):
        self.movies = {}
        self.customers = {}
        self.reservations = {}

    def Movie(self, movie_id, name, seats, price):
        self.movies[movie_id] = {"name": name, "seats": seats, "price": price}

    def customer(self, customer_id, name):
        self.customers[customer_id] = name

    def reservation(self, movie_id, customer_id, seats):
        if movie_id not in self.movies or customer_id not in self.customers:
            print("Invalid Movie or Customer ID.")
        movie = self.movies[movie_id]
        if seats > movie["seats"]:
            return f"Only {movie['seats']} seats available for {movie['name']}."
        movie["seats"] -= seats
        cost = seats * movie["price"]
        self.reservations.setdefault(customer_id, []).append(
            {"movie": movie["name"], "seats": seats, "cost": cost}
        )
        return f"Booked {seats} seats for {self.customers[customer_id]} in {movie['name']}. Total: {cost}."

    def displayreservations(self):
        for cid, bookings in self.reservations.items():
            for b in bookings:
                print(f"{self.customers[cid]}: {b['movie']} - {b['seats']} seats, {b['cost']}")

if __name__ == "__main__":
    movietheater = MovieTheater()
    movietheater.Movie(1, "Devara", 50, 300)
    movietheater.Movie(2, "RRR", 40, 250)
    movietheater.Movie(3, "Aravindha Sametha", 30, 150)
    movietheater.Movie(4, "Nannaku premathoo", 40, 250)
    movietheater.Movie(5, "Brindavanam", 60, 200)
    movietheater.Movie(6, "Usaravelli", 50, 100)
    movietheater.Movie(7, "Temper", 40, 250)

    movietheater.customer("1", "naveen")
    movietheater.customer("2", "dinesh")
    movietheater.customer("3", "teja")
    movietheater.customer("4", "leela")
    movietheater.customer("5", "daya")
    movietheater.customer("6", "ajay")
    movietheater.customer("7", "mava")
    movietheater.customer("8", "guru")
    movietheater.customer("9", "dada")
    movietheater.customer("10", "jaja")
    movietheater.customer("11", "nunu")
    movietheater.customer("12", "dodo")
    movietheater.customer("13", "haha")

    while True:
        print("\n Movies:")
        for mid, m in movietheater.movies.items():
            print(f"[{mid}. {m['name']} - {m['seats']} seats, {m['price']} per seat]")
        movie_id = int(input("Enter Movie ID to book : "))
        customer_id = input("Enter Customerid: ")
        seats = int(input("Enter number of seats: "))
        print(movietheater.reservation(movie_id, customer_id, seats))

        if input("Want to continue or go back to payment: ").lower()=="no":
            movietheater.displayreservations()
            break
        else: 
            print("Invalid input")