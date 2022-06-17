# MySpringBootREstfullApi

# To access my Swagger Documentation http://localhost:9056/swagger-ui.html

#Ok you can use also insomia or postman



First you have to record same Cargo so that you can Order a drink the got to a client.


Order Entity
------------

Get all orders available
localhost:9056/api/allorder/

make an order
localhost:9056/api/addorder/

Search order by ID
localhost:9056//api/order/28/

Delete an Order
localhost:9056/api/daleteorder/28/

Search order by Id
localhost:9056/api/order/27/

Update order by Id
localhost:9056/api/updateorder/27/

Create order for specific Client and specific Drink
localhost:9056/api/createordertoclient/{client_id}/{drinks_ids}
eg: localhost:9056/api/createordertoclient/10/21/

Create order for specific Client
localhost:9056/api/createordertoclient/{client_id}/
eg: localhost:9056/api/createordertoclient/10/





Cargo Entity
------------

Get all Cargo available
localhost:9056/api/allcargo

Record a Cargo
localhost:9056/api/allcargo

Search Cargo by ID
localhost:9056/api/cargo/{id}/

Delete an Cargo by ID
localhost:9056/api/daletecargo/{id}/

Update Cargo by Id
localhost:9056/api/updatecargo/{id}/


Client Entity
-------------

Get all Client available
localhost:9056/api/allclient

Record a Client
localhost:9056/api/addclient/

Search Client by ID
localhost:9056/api/client/{id}/

Delete an Client by ID
localhost:9056/api/daleteclient/{id}/

Update Client by Id
localhost:9056/api/updateclient/{id}/


Drink Entity
-------------
Just Record a Drink
localhost:9056/api/addrink/

Record a Drink with Cargo
localhost:9056/api/addrink/{cargoId}/

Get all Drink available
localhost:9056/api/alldrinks

Search Drink by ID
localhost:9056/api/drink/{id}/

Get a Drink to a given cargo: here we have to pass time you have consumed it.
localhost:9056/api/mostconsumed/{timesofconsumed}/

Get a most consumed Drink
localhost:9056/api/getbycargo/{cargoId}/

Delete an Drink by ID
localhost:9056/api/deletedrink/{id}/

Update Drink by Id
localhost:9056/api/updatedrink/{id}/




