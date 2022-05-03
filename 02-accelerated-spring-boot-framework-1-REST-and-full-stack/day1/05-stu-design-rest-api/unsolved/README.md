# MyRecordStore API Design

Retrieve a Single record
| Description | URI | HTTP Method | Request Status | Request Body | Response Body |
| ------ | ------ | ------ | ------ | ------ | ------ |
| Retrieve a Single Record | /records/{id} | GET | 200(OK) | None | Record Info |
| Create a Record | /records | POST | 201(Created) | Record info | Record Info |
| Update a Record | /records/{id} | PUT | 204(No Content) | Record info | None |
| Delete a Record | /records/{id} | DELETE | 204(No Content)) | None | None |
| Retrieve all Records | /records | GET | 200(OK) | None | Record Info |