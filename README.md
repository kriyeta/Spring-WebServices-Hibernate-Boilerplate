Pre-Requisites
================
**--** Create Mysql Database eg. 'spare_parts'

**--** Update database name, user and password in applications.properties in resource folder


Run Application
==============
**--** Run application.java

Test Application
==============
**--** Download RESTClient and install

**--** Give auth user kamal and password kamal

**--** put urls to test

   * http://localhost:8080/product/save with method **post** data *{"name":"tyre", "price":20,"quantity":10,"description":"a rubber covering, typically inflated or surrounding an inflated inner tube, placed round a wheel to form a soft contact with the road."}* as application/json utf-8

   * http://localhost:8080/product/all

   * http://localhost:8080/product/get?id=6

   * http://localhost:8080/product/get-by-name?name=tyre