<<<<<<< HEAD
CREATE DATABASE RentCar;
=======
﻿CREATE DATABASE RentCar;
>>>>>>> f4087c42ecab40a866bd0e76ef9b6be1c8b99084
GO
USE RentCar;
GO

-- Inserting into account table
INSERT INTO [dbo].[account]
           ([auth_id]
           ,[auth_type]
           ,[password]
           ,[user_name])
     VALUES
           (0, 0, '123', 'chihieu2402'),
           (0, 1, '123', 'ben123'),
           (0, 2, '123', 'teo123');
GO

-- Inserting into role table
INSERT INTO [dbo].[role]
           ([id]
           ,[name])
     VALUES
           (0, 'ADMIN'),
           (1, 'OWNER'),
           (2, 'USER');
GO

-- Inserting into user_role table
INSERT INTO [dbo].[user_role]
           ([user_id]
           ,[role_id])
     VALUES
           (1, 0),
           (2, 1),
           (3, 2);
GO

-- Inserting into customer table
INSERT INTO [dbo].[customer]
           ([accountid]
           ,[address]
           ,[customer_name]
           ,[gender]
           ,[idcard]
           ,[phone_number])
     VALUES
           (1, 'chihieu2402@gmail.com', N'Phan Chí Hiếu', N'Nam', '083204012510', '0378194280'),
           (2, 'minhben12@gmail.com', N'Bùi Minh Ben', N'Nam', '098427821313', '0878417123'),
           (3, 'thanntps2xx@gmail.com', N'Nguyễn Trần Thân', N'Nam', '09289742723', '0763570007');
GO

-- Inserting into review table
INSERT INTO [dbo].[review]
           ([carid]
           ,[rating]
           ,[review_date]
           ,[review_text]
           ,[customerid])
     VALUES
           (1, 4, '2024-07-30', N'Thiên lý ơi em có thể ở lại đây không', 1),
           (2, 5, '2024-08-01', N'Xe rất tuyệt vời!', 1),
           (3, 5, '2024-08-01', N'Quá đã!', 2),
           (4, 4, '2024-08-01', N'Chạy êm và mạnh mẽ.', 3),
           (5, 5, '2024-08-01', N'Đáng tiền.', 1);
GO

-- Inserting into car_owner table
INSERT INTO [dbo].[car_owner]
           ([customerid])
     VALUES
           (1);
GO
<<<<<<< HEAD
USE [RentCar]
GO

INSERT INTO [dbo].[car_brand]
           ([brand_name])
     VALUES
=======

<<<<<<< HEAD
--them du lieu carbrand
INSERT INTO car_brand(brand_name) VALUES
>>>>>>> 9af980044d9d737df844c1d85e775ace38b374d3
('Toyota'),
('Honda'),
('Ford'),
('Mazda'),
('Nissan'),
('Hyundai'),
('Kia'),
('Mitsubishi'),
('Subaru'),
<<<<<<< HEAD
('Chevrolet'),
('Aston Martin'),
('Bugatti'),
('Ferrari'),
('Koenigsegg');
GO
	USE [RentCar]
GO

INSERT INTO [dbo].[car]
           ([address]
           ,[car_brand]
=======
('Chevrolet');


=======
-- Inserting into car_brand table
INSERT INTO [dbo].[car_brand]
           ([brand_name])
     VALUES
           ('Ferrari'),
           ('Lamborghini'),
           ('Porsche'),
           ('McLaren'),
           ('Bugatti'),
           ('Aston Martin'),
           ('Pagani'),
           ('Koenigsegg'),
           ('Bentley'),
           ('Rolls-Royce'),
           ('Maserati'),
           ('Lotus'),
           ('Rimac'),
           ('Tesla'),
           ('Spyker'),
           ('SSC North America'),
           ('W Motors'),
           ('Zenvo'),
           ('Hennessey'),
           ('Alfa Romeo');
GO
>>>>>>> 9b00d7f7de0a71864d9ed0bc65e618832aef6dc1

-- Inserting into car table
INSERT INTO [dbo].[car]
           ([car_brandid]
>>>>>>> 9af980044d9d737df844c1d85e775ace38b374d3
           ,[car_name]
           ,[color]
<<<<<<< HEAD
           ,[discountid]
           ,[image]
           ,[price_hours_car]
           ,[status]
           ,[ownerid]
<<<<<<< HEAD
           ,[reviewid]
           ,[ownership_document]
           ,[car_brandid])
     VALUES
           (N'21 To Ky'
           ,<car_brand, varchar(255),>
           ,<car_name, nvarchar(255),>
           ,<color, varchar(255),>
           ,<discountid, int,>
           ,<image, varchar(255),>
           ,<price_hours_car, float,>
           ,<status, bit,>
           ,<ownerid, int,>
           ,<reviewid, int,>
           ,<ownership_document, varchar(255),>
           ,<car_brandid, int,>)
GO


=======
           ,[reviewid],
			[image])
     VALUES
           (1,'Aston Martin',N'112 Tô Ký',N'Đen',1,10.0,1,1,1,'hinh-sieu-xe-32.jpg')
>>>>>>> 9af980044d9d737df844c1d85e775ace38b374d3
=======
           ,[price_hours_car]
           ,[status]
           ,[ownerid]
           ,[reviewid]
           ,[image])
     VALUES
           (1, 'Ferrari LaFerrari', N'112 Tô Ký', N'Đỏ', 15.0, 1, 1, 2, 'ferrari-laferrari.jpg'),
           (2, 'Lamborghini Aventador', N'112 Tô Ký', N'Vàng', 18.0, 1, 1, 3, 'lamborghini-aventador.jpg'),
           (3, 'Porsche 911 Turbo S', N'112 Tô Ký', N'Xanh', 12.0, 1, 1, 4, 'porsche-911.jpg'),
           (4, 'McLaren P1', N'112 Tô Ký', N'Cam', 20.0, 1, 1, 5, 'mclaren-p1.jpg'),
           (5, 'Bugatti Chiron', N'112 Tô Ký', N'Xanh Đen', 25.0, 1, 1, 6, 'bugatti-chiron.jpg');
>>>>>>> 9b00d7f7de0a71864d9ed0bc65e618832aef6dc1
GO

-- Inserting into bill table
INSERT INTO [dbo].[bill]
           ([customer_name]
           ,[rental_day]
           ,[return_day]
           ,[status]
           ,[total_price]
           ,[customerid])
     VALUES
           (N'Phan Chí Hiếu', '2024-07-30', '2024-07-31', 1, 10000.0, 1);
GO

-- Inserting into bill_detail table
INSERT INTO [dbo].[bill_detail]
           ([address]
           ,[carid]
           ,[phone_number]
           ,[price_hours_bill_detail]
           ,[rental_hour]
           ,[billid])
     VALUES
           (N'20 Lê Quang Định, Quận Bình Thạnh, Tp. Hồ Chí Minh', 1, '0378194280', 10.0, 2.0, 1);
GO
select * from car
-- Inserting into payment table
INSERT INTO [dbo].[payment]
           ([amount]
           ,[billid]
           ,[payment_date])
     VALUES
<<<<<<< HEAD
           (10.0,1,'2024-09-30')
GO
=======
           (10.0, 1, '2024-09-30');
GO

<<<<<<< HEAD

<<<<<<< HEAD
=======



>>>>>>> 9af980044d9d737df844c1d85e775ace38b374d3
-- test
=======
-- Selecting data to verify
SELECT * FROM [dbo].[account];
SELECT * FROM [dbo].[review];
SELECT * FROM [dbo].[customer];
SELECT * FROM [dbo].[pending_car_post];
SELECT * FROM [dbo].[car_brand];
>>>>>>> 9b00d7f7de0a71864d9ed0bc65e618832aef6dc1
select * from car
>>>>>>> f4087c42ecab40a866bd0e76ef9b6be1c8b99084
