-----Steps to configur project-------

1- Run the script file os sql server DB  :
i. creation of data base an database
ii. inserting data as described in the task ( run step by step , it may take some minutes as it 2 million records)

2- open the project in Eclipse tool :

i.  change the Database configuation in application.properties with your own DB configuation
ii. Run the project as springboot 


3-test the Rest api url :

- i ) post service --> http://localhost:8080/devices/getWaitingForActivationDevices

with body : {

    "limit":50,  //any number of devices per page
    "pageNumber":0 // pages number starting from page 0
}


ii)  update Endpoint with body :

{

    "status":"not Ready",
    "temp":-900
}