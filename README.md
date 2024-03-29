# Online Movie Ticket Booking

## Technology Stack
- Language: `Java`
- Framework: `Spring Boot`
- Database: `MySQL`
- Version Control/Code Hosting Tool: `GitHub`
- CI: `Jenkins`

## Architecture & Deployment
<img alt="Architecture" src="bms.png"> </img>


- Architecture: `Microservices`
- Cloud: `AWS`
- Container: `AWS EKS`
- Other AWS Service: `API Gateway`, `Load Balancer`

# Microservices:

## 1. Theater Service
Allows theatre partners to add, update, or remove information about their theatres.

DB Table: theatres

DB Columns: `id (Primary Key), user_id, name, location, seating_capacity`

APIs:
* `/ts/1.0/theatres`                    : [POST] Create a new theatre
* `/ts/1.0/theatres/{theatre_id}`       : [PUT] Update theatre information
* `/ts/1.0/theatres/{theatre_id}`       : [GET] Get theatre details
* `/ts/1.0/theatres/partners/{user_id}` : [GET] Get theatres of a specific partner

## 2. Movie Service
Enables theatre partners to onboard movies.
Manages information about movies, including titles, genres, and languages.

DB Table 1: movies

DB Columns 1:`id (Primary Key), title, genre, language`

DB Table 2: movie-theatre

DB Columns 2:`id (Primary Key), movie_id, theatre_id`

APIs:
* `/ms/1.0/movies`                         : [POST] Add a new movie
* `/ms/1.0/movies`                         : [GET] Get a list of all movies
* `/ms/1.0/movies/filter`                  : [GET] Filter movies by cities, languages, and genres
* `/ms/1.0/movies/{movie_id}`              : [GET] Get movie details
* `/ms/1.0/movies/theatres/{theatre_id}` : [GET] Get movies for a specific theatre

## 3. User Service:
Manages customer & partner profile.

DB Table: users

DB Columns:`id (Primary Key), name, password_hash, email, role`

APIs:
* `/us/1.0/users/register`                        : [POST] User registration
* `/us/1.0/users/login`                            : [POST] User login
* `/us/1.0/users/logout`                           : [POST] User logout
* `/us/1.0/users/customers/{user_id}/bookings` : [GET] Get customer's booking history

## 4. Booking Service
Handles the booking process for customers.
Manages seat availability, reservation, and booking transactions.
Sends confirmation and e-tickets to customers.

DB Table: Bookings

DB Columns:`id (Primary Key), user_id, movie_id, theatre_id, seats_booked`

APIs:
* `/bs/1.0/bookings`                          : [POST] Create a new booking
* `/bs/1.0/bookings/{bookingID}`            : [GET] Get booking details
* `/bs/1.0/bookings/customer/{customerID}` : [GET] Get a customer's booking history

# Postman APIs
```
1. Get movies
curl --location 'localhost:8081/ms/1.0/movies'

2 Get movie by id
curl --location 'localhost:8081/ms/1.0/movies/2' \
--data ''

3 Add movie
curl --location 'localhost:8081/ms/1.0/movies' \
--header 'Content-Type: application/json' \
--data '{
    "title": "Gadar 1",
    "genre": "Action",
    "language": "Hindi"
}'

4 Get theatres
curl --location 'localhost:8082/ts/1.0/theatres'

5 Get theatre by id
curl --location 'localhost:8082/ts/1.0/theatres/1' \
--data ''

6 Add theatre
curl --location 'localhost:8082/ts/1.0/theatres' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Theatr1",
    "location": "Pune",
    "seatingCapacity": 100
}'

7 Register movie theatre
curl --location --request GET 'localhost:8081/ms/1.0/movies/1/theatre/2' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Inox",
    "location": "Pune",
    "seatingCapacity": 100
}'

8 Get theatres by movie id
curl --location --request GET 'localhost:8081/ms/1.0/movies/1/theatres' \
--header 'Content-Type: application/json' \
--data '{
    "name": "Inox",
    "location": "Pune",
    "seatingCapacity": 100
}'
```
`

# Use Cases

## Completed
1. Onboard theatres
2. View Theatres
3. Get theatre details
4. Add movies
5. Get movies
6. Get movie details
5. Register movie to a theatres
6. Get theatres of a particular movie

## Incomplete
1. User management - login, logout
2. Role management - customer and partner roles.
3. Bookings
4. Payment
5. Offers
6. Showtimes



