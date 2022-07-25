# Use below service url with in memory db


Please run below query http://localhost:9006/h2-console/

insert into customer(customer_id,customer_name,Customer_Entrolled_Date) values (123,'Rambabu Bikumandla', '2022-04-22 09:45:23' );

insert into Customer_Rewards(Transaction_Date, Earned_Rewards,Transcation_Amount,Customer_Id) values ( '2022-04-24 09:45:23',0, 0,123 );

insert into Customer_Rewards(Transaction_Date, Earned_Rewards,Transcation_Amount,Customer_Id) values ( '2022-04-24 09:45:24',10, 0,123 );



select * from Customer_Rewards;

select * from customer;;


POST: http://localhost:9006/getCustomerRewards-db

BODY:
{
    "customerName" :"Rama",
    "customerId" : 123,
    "purchaseAmount" : 50.95
}

# Below service Without db
 
POST: http://localhost:9006/getCustomerRewards

BODY:

{
    "customerName" :"Rama",
    "customerId" : 123,
    "purchaseAmount" : 50.95
}

# If customer not found we are throwing
Customer Not found <customer_id>