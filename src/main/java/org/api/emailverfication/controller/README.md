# Follow these Status code's

###### 1. GET

 200 OK: The request was successful, and the response body contains the requested data.
 404 Not Found: The resource was not found.

###### 2. POST

201 Created: The resource was successfully created.
400 Bad Request: The request was malformed or invalid.
409 Conflict: The request could not be completed due to a conflict with the current state of the resource.

###### 3. PUT

200 OK: The resource was successfully updated, and the response body contains the updated data.
204 No Content: The resource was successfully updated, and there is no response body.
404 Not Found: The resource was not found.

###### 4. PATCH

200 OK: The resource was successfully updated, and the response body contains the updated data.
204 No Content: The resource was successfully updated, and there is no response body.
404 Not Found: The resource was not found.

###### 5. DELETE

200 OK: The resource was successfully deleted, and the response body contains confirmation.
204 No Content: The resource was successfully deleted, and there is no response body.
404 Not Found: The resource was not found.

###### 6. Headers

100 Continue: The server has received the request headers and the client should proceed to send the request body.
401 Unauthorized: The client must authenticate itself to get the requested response.
403 Forbidden: The client does not have access rights to the content.
500 Internal Server Error: The server encountered an unexpected condition that prevented it from fulfilling the request.
