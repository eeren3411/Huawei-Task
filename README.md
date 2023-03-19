## Example GET request
localhost:8080/api/get?locale=OPTINOAL

Possible Locales = ["tr_TR", "en_US", "en_UK", "fr_FR", "jp_JP"]

Get request localizes the name and the price.

## Example POST request
localhost:8080/api/create

Creating product sets price in USD. Can be solved but I forget about.

If there is no product ID, returns HttpStatus BAD_REQUEST with requested product

If another product with same ID exists, returns HttpStatus CONFLICT with requested product

If product successfully created, returns HttpsStatus CREATED with requested product


Content-Type: application/json

{
    "product_id": 6,
    "stock_count": 5,
    "price": 9.99,
    "name": "testProduct212",
    "tr_TR": "tr_TRasd",
    "fr_FR": "fr_FafaR",
    "jp_JP": "jp_asdJP"
}

## Example PUT request
localhost:8080/api/update

Nearly the same as POST request. Just updates if exists.

If there is no product ID, returns HttpStatus BAD_REQUEST with requested product

If there is no product with given ID returns HttpStatus NO_CONTENT with requested product

If product successfully updated, returns HttpStatus OK with requested product

Content-Type: application/json

{
    "product_id": 6,
    "stock_count": 5,
    "price": 9.99,
    "name": "testProduct212",
    "tr_TR": "tr_TRasd",
    "fr_FR": "fr_FafaR",
    "jp_JP": "jp_asdJP"
}

## Final notes
This is a very basic spring boot implementation with PostgreSQL. Since PostgreSQL supports JSON as a type, localization could be done using it and it would be way better than this but I actually never used PostgreSQL JSON type so it didn't occur to me until the very end of the project.