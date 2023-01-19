
# Truck Satellites Position

A truck is on some road in the world, carries a cargo which is transporting, but what happens if the truck is in danger? In case the truck is in danger, it will provide a coded matrix, which if it meets certain factors will achieve a general distress alert. In order to know the position of the truck is known the distance that the truck has with certain satellites, by triangulating these distrancies it will be possible to have the position of the truck
## Tech Stack

**Server:** Java, Spring Boot

**Deploy:** AWS, EC2

## API Reference

#### Post truck distress signal

```http
  POST /tracking/
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `satelites` | `string` | **Required**. Names and distances of truck with the satellites |
| `message`    | `string`| **Required**. Encrypted message



Principal funtions

The program start with the controller `truckLocationController`

#### truckIsInDanger(RequestBody)
The program takes the request and sends it to the service in charge of decrypting the message

The service `truckLocationService` Receive the request and return a Boolean, in case of being in danger Responseta a state 200, showing us the position of the truck and the warning that it is in danger. In case of being `false` the service will return a status 404

How do I decrypt the message?

In the class `TruckMessage` we have the decryption methods, if the message has letters that are repeated at least 4 times either vertically, horzantal or diagonally, the danger alert will be generated

## Deployment

If you want run the application you must to go to  the next url

```bash
  http://54.219.16.187:8080/tracking/
```


## Try it

If you want to try the program you can use the next request:

{
    "satellites": [
        {
            "name": "Sputnik",
            "distance": 100.0
        },
        {
            "name": "Explorer",
            "distance": 115.5
        },
        {
            "name": "Asterix",
            "distance": 142.7
        }
    ],
    "message": [
        "ATGCGA",
        "CAGTGC",
        "TTATGT",
        "AGAAGG",
        "CCCCTA",
        "TCACTG"
    ]
}