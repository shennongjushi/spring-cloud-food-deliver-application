# Spring Cloud Food Deliver
## Functionality
```
1. Restaurant Information Upload, delete and query by name.
2. User can order food by choosing different menu item, quantity, can also fills the delivery address. User can also add note about diet restrictions.
3. User pay his/her order by providing credit card number infomation.
4. Use Spring cloud to handle service discovery and circuit breaker.
5. Use MQ to decouple the backend services.
```
## Architecture Design
```
It consists of four microservices, data base is MongoDB.
restaurant-service : upload restaurant & menu
order-service : create order, change order status, view order information
payment-upload : upload payment and send them to MQ.
payment-service : There is a MQ between payment-upload and payment-service. payment-service is used to search/view payment, validate the card info and send order status to order-service.
```
## API Design
| Method | URL                             | Description                      | 
|--------|---------------------------------|----------------------------------|
|CREATE  | /restaurant                     | Upload a Restaurant& Menu        |
|GET     | /restaurant                     | Get all Restaurants              |
|DELETE  | /restaurant/purge               | Delete all Restaurant            |
|GET     | /restaurant/{name}              | Get Restaurant by name           |
|GET     | /restaurant/menu/{restaurantId} | Get Menu by restaurant Id        |
|GET     | /order                          | Get all orders                   |
|GET     | /order/{id}                     | Get order by id                  |
|POST    | /order                          | Place an order                   |
|POST    | /order/{id}                     | Update order status              |
|DELETE  | /order                          | Delete all orders                |
|POST    | /api/payments                   | make a payment                   |
|GET     | /api/payment/{orderId}          | Get payment by orderId           |
|DELETE  | /api/payment/purge              | Delete all payment               |
|GET     | /api/payment                    | Get all payments                 |

## port
```
eureka: 18762
restaurant-service: 8000
payload-upload: 8002
payment-service: 8003
order-service: 8004
```
## Step
1.in the root folder
```
mvn clean install
docker-compose up
```
2.open a new terminal, go to platform/eureka/target
```
java -jar eureka-1.0.0-BUILD-SNAPSHOT.jar
```
3.open a new terminal, go to restaurant-service/target
```
java -jar restaurant-service-1.0.0-BUILD-SNAPSHOT.jar
```
4.open a new terminal, go to order-service/target
```
java -jar order-service-1.0.0-BUILD-SNAPSHOT.jar
```
5.open a new terminal, go to payment-upload/target
```
java -jar payment-upload-1.0.0-BUILD-SNAPSHOT.jar
```
6.open a new terminal, go to payment-service/target
```
java -jar payment-service-1.0.0-BUILD-SNAPSHOT.jar
```
7.upload restaurant&meno info
```
open postman, copy content of restaurants.json, send a post request to "http://localhost:8000/restaurant"
```
8.create order
```
copy content of order.json, modify the restaurantId and send a post request to "http://localhost:8004/order"
```
9.upload payment
```
copy content of payment.json, modify the orderId and send a post request to "http://localhost:8002/api/payments"
```
10.check order status
```
send get request to "http://localhost:8004/order", check the order status, in the current validate function of payment-service, it will randomly send failure or success order status to order service.
```
