﻿CREATE DATABASE RentCar;
GO
USE RentCar;

GO

INSERT INTO [dbo].[account]
           ([password]
           ,[user_name])
     VALUES
           ('123','chihieu2402'),
		   ('123','minhben12'),
		   ('123','tranti12'),
		   ('123','hungheo69')
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
		   (3,'thanntps2xx@gmail.com',N'Nguyễn Trần Thân',N'Nam','09289742723','0763570007'),
		   (4,'hungheohuuhu@gmail.com',N'Võ Hoài Heo',N'Nam','09286642723','0900964729')
GO


INSERT INTO [dbo].[discount]
           ([create_date]
		   ,[carid]
           ,[end_date]
           ,[percent_discount])
     VALUES
           ('2024-09-24',1,'2024-10-1','10')
GO

INSERT INTO [dbo].[review]
           ([rating]
           ,[review_date]
           ,[review_text]
           ,[customerid])
     VALUES
           (4,'2024-07-30','Thiên lý ơi em có thể ở lại đây không',1)
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
		   ,[image]
           ,[price_hours_car]
           ,[status]
           ,[ownerid]
           ,[reviewid])
     VALUES
           ('Aston Martin','Aston Martin DB11',N'112 Tô Ký',N'Đen',1,NULL,10.0,1,1,1)
GO

INSERT INTO [dbo].[bill]
           ([customer_name]
           ,[rental_day]
           ,[return_day]
           ,[total_price]
           ,[customerid])
     VALUES
           (N'Phan Chí Hiếu','30','31',10000.0,1)
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












