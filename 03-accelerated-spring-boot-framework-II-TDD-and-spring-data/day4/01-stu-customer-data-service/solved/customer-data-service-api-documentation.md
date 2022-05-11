# Customer Data Service API

```
openapi: 3.0.3
info:
  title: Api Documentation
  description: Api Documentation
  termsOfService: 'urn:tos'
  contact: {}
  license:
    name: Apache 2.0
    url: 'http://www.apache.org/licenses/LICENSE-2.0'
  version: '1.0'
servers:
  - url: 'http://localhost:8080'
    description: Inferred Url
tags:
  - name: customer-controller
    description: Customer Controller
  - name: data-loader-controller
    description: Data Loader Controller
paths:
  /customers:
    put:
      tags:
        - customer-controller
      summary: updateCustomer
      operationId: updateCustomerUsingPUT
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Customer'
      responses:
        '200':
          description: OK
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - customer-controller
      summary: addCustomer
      operationId: addCustomerUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Customer'
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Customer'
        '201':
          description: Created
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/customers/level/{level}':
    get:
      tags:
        - customer-controller
      summary: getCustomersByLevel
      operationId: getCustomersByLevelUsingGET
      parameters:
        - name: level
          in: path
          description: level
          required: true
          style: simple
          schema:
            type: string
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Customer'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/customers/state/{state}':
    get:
      tags:
        - customer-controller
      summary: getCustomersByState
      operationId: getCustomersByStateUsingGET
      parameters:
        - name: state
          in: path
          description: state
          required: true
          style: simple
          schema:
            type: string
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                type: array
                items:
                  $ref: '#/components/schemas/Customer'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/customers/{id}':
    get:
      tags:
        - customer-controller
      summary: getRating
      operationId: getRatingUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Customer'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - customer-controller
      summary: deleteCustomer
      operationId: deleteCustomerUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int64
      responses:
        '200':
          description: OK
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
  /load-data:
    get:
      tags:
        - data-loader-controller
      summary: loadData
      operationId: loadDataUsingGET
      responses:
        '200':
          description: OK
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
components:
  schemas:
    Customer:
      title: Customer
      type: object
      properties:
        city:
          type: string
        customerId:
          type: integer
          format: int64
        firstName:
          type: string
        lastName:
          type: string
        level:
          type: string
        state:
          type: string
        street:
          type: string
        zipcode:
          type: string

```

