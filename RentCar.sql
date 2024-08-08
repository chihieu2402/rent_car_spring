create database RentCar;
go
use RentCar;


INSERT INTO [dbo].[account]
           ([auth_id]
           ,[auth_type]
           ,[password]
           ,[user_name])
     VALUES
           (0,0,123,'chihieu2402'),
		   (0,1,123,'ben123'),
		   (0,2,123,'teo123')
GO


INSERT INTO [dbo].[role]
           ([id]
           ,[name])
     VALUES
           (0,'ADMIN'),
		   (1,'OWNER'),
		   (2,'USER')
GO


INSERT INTO [dbo].[user_role]
           ([user_id]
           ,[role_id])
     VALUES
           (1,0),
		   (2,1),
		   (3,2)
GO





INSERT INTO [dbo].[customer]
           ([accountid]
           ,[address]
           ,[customer_name]
           ,[gender]
           ,[idcard]
           ,[phone_number])
     VALUES
           (1,'chihieu2402@gmail.com',N'Phan Chí Hiếu',N'Nam','083204012510','0378194280'),
		   (2,'minhben12@gmail.com',N'Bùi Minh Ben',N'Nam','098427821313','0878417123'),
		   (3,'thanntps2xx@gmail.com',N'Nguyễn Trần Thân',N'Nam','09289742723','0763570007')
		  
GO
INSERT INTO [dbo].[discount]
           ([create_date]
           ,[end_date]
           ,[percent_discount])
     VALUES
           ('2024-09-24','2024-10-1','10')
GO
INSERT INTO [dbo].[review]
           ([carid]
		   ,[rating]
           ,[review_date]
           ,[review_text]
           ,[customerid])
     VALUES
           (1,4,'2024-07-30',N'Thiên lý ơi em có thể ở lại đây không',1)
GO
INSERT INTO [dbo].[car_owner]
           ([customerid])
     VALUES
           (1)
GO
INSERT INTO [dbo].[car]
           ([car_brand]
           ,[car_name]
           ,[address]
           ,[color]
           ,[discountid]
           ,[price_hours_car]
           ,[status]
           ,[ownerid]
           ,[reviewid],
		   [image])
     VALUES
           ('Aston Martin','Aston Martin DB11',N'112 Tô Ký',N'Đen',1,10.0,1,1,1,'hinh-sieu-xe-32.jpg')
GO
select * from car
INSERT INTO [dbo].[bill]
           ([customer_name]
           ,[rental_day]
           ,[return_day]
		   ,[status]
           ,[total_price]
           ,[customerid])
     VALUES
           (N'Phan Chí Hiếu','30','31',1,10000.0,1)
GO
INSERT INTO [dbo].[bill_detail]
           ([address]
           ,[carid]
           ,[phone_number]
           ,[price_hours_bill_detail]
           ,[rental_hour]
           ,[billid])
     VALUES
           (N'20 Lê Quang Địng, Quận Bình Thạnh, Tp. Hồ Chí Minh',1,'0378194280',10.0,2.0,1)
GO
INSERT INTO [dbo].[payment]
           ([amount]
           ,[billid]
           ,[payment_date])
     VALUES
           (10.0,1,'2024-09-30')
GO
-- test
select * from car
select * from account
select * from review
select * from customer
select * from booking
drop  table booking