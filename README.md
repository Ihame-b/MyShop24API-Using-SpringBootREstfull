Thank you for this Time of presenting my Shop24API

for me I am using Swagger UI through(http://localhost:9050/swagger-ui.html#/), but is available also for those who us like postman, insomia or Thunder Client


CARGO

Get a list of all cargo companies
http://localhost:9050/api/getAllCargo

Get a specific cargo company by ID
http://localhost:9050/api/getCargoById/cargoId/

For a specific cargo company, get a list of drinks transported by date range
??????


CLIENT


Q. Get a list of all clients
http://localhost:9050/api/getAllClient/

Q. Get a specific client by ID
http://localhost:9050/api/getClientById/ClientId/

Q. For a specific retailer client/hotel, get a list of the 3 closest cargo companies
????????


DRINK

Q. Get a list of all drinks
http://localhost:9050/api/getAllDrink

Q. Get a list of most consumed drinks and quantity
http://localhost:9050/api/getMostConsumedDrink/{number}/?number=drinkId

Q. Get a specific drink by ID
http://localhost:9050/api/getDrinkById/drinkId/

Q. Get a list of all available drinks and nearest cargo company to the client within 3km based on the client’s location

??????




ORDER


Q. Create a new ‘order’ request by assigning a list of drinks to a specific client


Assign order to client
http://localhost:9050/api/CreateOrderForSpecificClient/clientId

Then Add to that order a drink bcs it have a client
http://localhost:9050/api/addDrinkToOrder/clientId/orderId


Q. Choose top five orders that were requested by different clients
http://localhost:9050/api/getTop5Order/


Q. Get top 10 paid orders, their client details, and transporter details
?????????


Q. Complete an order

before to complete order you have to first calculate total amount to pay
http://localhost:9050/api/calculateTotalCost/orderId/

and Then you complete order
http://localhost:9050/api/payed/orderId/




