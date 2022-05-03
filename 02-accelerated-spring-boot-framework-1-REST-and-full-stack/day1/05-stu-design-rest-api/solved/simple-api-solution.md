# We Do: Design a Simple REST API

Answers should look something like this:

- Retrieve all Records
  - URI /records
  - HTTP method: GET
  - Request body: None
  - Response body: List of Records
  - Status code: 200 (OK)
- Add a Record
  - URI /records
  - HTTP method: POST
  - Request body: Record information
  - Response body: Record information with generated ID
  - Status code: 201 (Created)
- Retrieve a Record
  - URI /records/{id}
  - HTTP method: GET
  - Request body: None
  - Response body: Record information
  - Status code: 200 (OK)
- Update a Record
  - URI /records/{id}
  - HTTP method: PUT
  - Request body: Record information
  - Response body: None
  - Status code: 204 (No Content)
- Delete a Record
  - URI /records/{id}
  - HTTP method: DELETE
  - Request body: None
  - Response body: None
  - Status code: 204 (No Content)