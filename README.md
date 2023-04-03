# OpenApiDemo

First init the API:

	mvn clean install	
	mvn spring-boot:run

Now, it can be called as needed
![alt text](https://darthian-sketchs.s3.amazonaws.com/Screenshot+2023-04-03+at+4.16.00+PM.png)

For the id 4 it returns an id 5 which returns a not found error, in this case the API just return the founded data

```bash
curl --location --request GET 'http://localhost:5000/product/4/similar'
```

![alt text](https://darthian-sketchs.s3.amazonaws.com/Screenshot+2023-04-03+at+4.20.49+PM.png)

It could be changed in order to clarify the data, removing the null result but this depends on the definition

Feel free to run the tests

Test result:
![alt text](https://darthian-sketchs.s3.amazonaws.com/Screenshot+2023-04-03+at+3.18.27+PM.png)

Grafana:
![alt text](https://darthian-sketchs.s3.amazonaws.com/Screenshot+2023-04-03+at+3.18.48+PM.png)