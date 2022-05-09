# Record Store Service API Documentation

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
  - name: record-store-controller
    description: Record Store Controller
paths:
  /records:
    get:
      tags:
        - record-store-controller
      summary: getAllRecords
      operationId: getAllRecordsUsingGET
      parameters:
        - name: artist
          in: query
          description: artist
          required: false
          style: form
          schema:
            type: string
        - name: year
          in: query
          description: year
          required: false
          style: form
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
                  $ref: '#/components/schemas/Record'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    post:
      tags:
        - record-store-controller
      summary: createRecord
      operationId: createRecordUsingPOST
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Record'
      responses:
        '201':
          description: Created
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Record'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
  '/records/{id}':
    get:
      tags:
        - record-store-controller
      summary: getRecordById
      operationId: getRecordByIdUsingGET
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '200':
          description: OK
          content:
            '*/*':
              schema:
                $ref: '#/components/schemas/Record'
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    put:
      tags:
        - record-store-controller
      summary: updateRecordById
      operationId: updateRecordByIdUsingPUT
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      requestBody:
        content:
          application/json:
            schema:
              $ref: '#/components/schemas/Record'
      responses:
        '201':
          description: Created
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
        '404':
          description: Not Found
    delete:
      tags:
        - record-store-controller
      summary: deleteRecordById
      operationId: deleteRecordByIdUsingDELETE
      parameters:
        - name: id
          in: path
          description: id
          required: true
          style: simple
          schema:
            type: integer
            format: int32
      responses:
        '204':
          description: No Content
        '401':
          description: Unauthorized
        '403':
          description: Forbidden
components:
  schemas:
    Record:
      title: Record
      type: object
      properties:
        album:
          type: string
        artist:
          type: string
        id:
          type: integer
          format: int32
        year:
          maxLength: 4
          minLength: 4
          type: string

```

