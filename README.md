# bnk-txns
shows transactions between accounts


*Endpoints*
- GET: http://localhost:8082/bnk-txns/api/v1.0
- GET: http://localhost:8082/bnk-txns/api/v1.0/max?val=10 (transactions with max value)
- GET: http://localhost:8082/bnk-txns/api/v1.0/min?val=10 (transactions with min value)
- GET: http://localhost:8082/bnk-txns/api/v1.0/{id} (get a transaction by id)
- DELETE: http://localhost:8082/bnk-txns/api/v1.0/{id} (DELETE a transaction by id)
- POST: http://localhost:8082/bnk-txns/api/v1.0/ (Create a new transaction, needs a trxn as payload without the id)
- PUT: http://localhost:8082/bnk-txns/api/v1.0/ (Updates a transaction, needs a trxn as payload with the id)

- GET: http://localhost:8082/bnk-txns/api/ping

JSON structure for a transaction:
{
	"id": 1,
	"value": 100.5,
	"currency": "CAD",
	"from_acct": "acct-01-2523",
	"to_acct": "acct-01-2141",
	"from_cust_id": "cust-id-01",
	"to_cust_id": "cust-id-02"
}

## Using SonarQube
### 1) Running the commands from the command line
Usually SonarQube runs on port 9000. 
The usual user/password: _admin/admin_

First add the two dependencies in the pom.xml (sonar scanner , Java Code Coverage - JaCoCo) 

In order to get into the SonarQube DB (and visible in the UI) the code coverage the following need to be run from the command line:
** mvn org.jacoco:jacoco-maven-plugin:prepare-agent package **
this will generate a jacoco.exec file in the /target directory

In order to load the SonarQube, run the:
**  mvn sonar:sonar **

### 2) Running the commands by executing tasks attached to the test lifecycle

