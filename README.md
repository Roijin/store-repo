#Configuration
adjust values in application.properties to your database

ensure that the table mst_store is present in your database

ensure that the table mst_store contain the columns id, name, address, phone_number, siup, npwp (all must be lowercase)


#Endpoints
##Store API
POST "/store" save request body in database

GET "/store" return paginated list of stores (optional parameters: page, size. defaults are page:1,size:5)

DELETE "/store" delete store with given id via request parameter "id"

PUT "/store" update store data that is already in the database, pushed through request body

GET "/store/name" search stores by exact name via request parameter "name"

GET "/store/address" search stores by exact address via request parameter "address"

GET "/store/phone" search stores by exact phone number via request parameter "phoneNumber"

##Stock API

GET "/stock" search through database (optional parameters: searchName, searchMinPrice, searchMaxPrice)

POST "/stock" insert new stock item (storeId needs to be validated)

DELETE "/stock" delete item by inserting id in Request Param

PUT "/stock" update existing item