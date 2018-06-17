# bnk-txns
shows transactions between accounts


Endpoints
- GET: http://localhost:8082/bnk-txns/api/v1.0
- GET: http://localhost:8082/bnk-txns/api/v1.0/max?val=10 (transactions with max value)
- GET: http://localhost:8082/bnk-txns/api/v1.0/min?val=10 (transactions with min value)
- GET: http://localhost:8082/bnk-txns/api/v1.0/{id} (get a transaction by id)
- DELETE: http://localhost:8082/bnk-txns/api/v1.0/{id} (DELETE a transaction by id)
- POST: http://localhost:8082/bnk-txns/api/v1.0/ (Create a new transaction, needs a trxn as payload without the id)
- PUT: http://localhost:8082/bnk-txns/api/v1.0/ (Updates a transaction, needs a trxn as payload with the id)

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

