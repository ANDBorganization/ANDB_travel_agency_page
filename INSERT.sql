INSERT INTO Customers (Name, Email, Phone, Address, DateOfBirth)
VALUES
('John Doe', 'johndoe@example.com', '123-456-7890', '123 Main St, Cityville', '1985-05-15'),
('Jane Smith', 'janesmith@example.com', '987-654-3210', '456 Elm St, Townsville', '1990-08-25'),
('Alice Johnson', 'alicej@example.com', '555-666-7777', '789 Oak St, Villagetown', '1992-12-05');

INSERT INTO Employees (Name, Role, Email, Phone, HireDate)
VALUES
('Emily Carter', 'Travel Agent', 'emily.carter@example.com', '444-555-6666', '2020-01-10'),
('Michael Brown', 'Manager', 'michael.brown@example.com', '333-444-5555', '2018-03-15');

INSERT INTO Destinations (Location, Country, Description, Price)
VALUES
('Paris', 'France', 'The City of Light with iconic landmarks and romantic atmosphere.', 1500.00),
('Maldives', 'Maldives', 'Tropical paradise with white sandy beaches and crystal-clear water.', 2500.00),
('Tokyo', 'Japan', 'A vibrant city blending modernity with traditional culture.', 1800.00);

INSERT INTO TravelPackages (Name, DestinationID, EmployeeID, StartDate, EndDate, Price)
VALUES
('Romantic Paris Getaway', 1, 1, '2024-03-01', '2024-03-07', 3000.00),
('Maldives Honeymoon Special', 2, 2, '2024-06-15', '2024-06-22', 5000.00),
('Tokyo Adventure', 3, 1, '2024-09-10', '2024-09-20', 4000.00);

INSERT INTO Bookings (CustomerID, PackageID, EmployeeID, BookingDate, Travelers, TotalCost)
VALUES
(1, 1, 1, '2023-12-01', 2, 6000.00),
(2, 2, 2, '2023-12-15', 1, 5000.00),
(3, 3, 1, '2023-12-20', 3, 12000.00);

INSERT INTO Payments (BookingID, EmployeeID, PaymentDate, Amount, PaymentMethod)
VALUES
(1, 1, '2023-12-02', 6000.00, 'Credit Card'),
(2, 2, '2023-12-16', 5000.00, 'Bank Transfer'),
(3, 1, '2023-12-21', 12000.00, 'Credit Card');

INSERT INTO Feedback (CustomerID, PackageID, Rating, Comments, FeedbackDate)
VALUES
(1, 1, 5, 'Amazing trip! Highly recommended.', '2024-03-10'),
(2, 2, 4, 'Beautiful destination, but the package was a bit expensive.', '2024-06-25'),
(3, 3, 5, 'Incredible experience! Worth every penny.', '2024-09-25');
