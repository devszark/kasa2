# Kasa2 Application

List of endpoints:
- GET /test - just test, returns 1
- GET /title - displays HTML title page
- GET /api/products/new?name=apple&price=12.4 - adds a new products from requestpath
- POST /api/products/new - adds a new products from request body (JSON)
- GET /api/products - returns list of all products in JSON
- GET /api/products/{id} - return only one product in JSON
- GET /api/products/sum - returns sum of all products
