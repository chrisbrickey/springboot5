## Run this program
* Ensure that run.sh is executable: `chmod +x run.sh`
* Run the server: `./run.sh`  
* Open in browser: `http://localhost:8080/`
* Receive greetings: `http://localhost:8080/nihao?name=Sally`

## API Endpoints
|Endpoint                        | Description                      | Example
|--------------------------------|----------------------------------|------------
| GET /api/greeting/             | returns default greeting as json | http://localhost:8080/api/greetings/
| GET /api/greeting?name=:name   | returns custom greeting as json  | http://localhost:8080/api/greetings?name=Sally




