create database CNPM;
use CNPM;

--Cơ sở dữ liệu chung cho nhân viên
--Nhân viên
create table Employee
(
	ID int identity(1, 1) not null,
	[EmployeeID] as ('EMP' + right(replicate('0', 4) + cast(ID as varchar(4)), 4)) persisted not null,
	EmployeeName nvarchar(30) not null,
	EmployeePhone varchar(12) not null,
	WorkPositionID varchar(5) not null,
	WorkTypeID varchar(5) not null
);

--Tài khoản
create table Account
(
	AccountUsername varchar(20) not null,
	AccountPassword varchar(20) not null,
	EmployeeID varchar(7) not null
);

--Vị trí làm việc của nhân viên
create table WorkPosition
(
	ID int identity(1, 1) not null,
	[WorkPositionID] as ('WP' + right(replicate('0', 3) + cast(ID as varchar(3)), 3)) persisted not null,
	WorkPositionName nvarchar(30) not null
);

--Loại nhân viên
create table WorkType
(
	ID int identity(1, 1) not null,
	[WorkTypeID] as ('WT' + right(replicate('0', 3) + cast(ID as varchar(3)), 3)) persisted not null,
	WorkTypeName nvarchar(30) not null
);

--Chi tiết vị trí việc làm của nhân viên
create table PositionType
(
	WorkPositionID varchar(5) not null,
	WorkTypeID varchar(5) not null,
	SalaryPerHour int not null
);

--Giờ giấc làm việc của nhân viên
create table DailyWork
(
	DailyDate date not null,
	EmployeeID varchar(7) not null,
	Checkin time not null,
	Checkout time not null,
	WorkingHour float not null
);

--Tạo khóa chính, khóa ngoại cho bảng WorkPosition
alter table WorkPosition add constraint PK_WorkPosition primary key (WorkPositionID);

--Tạo khóa chính, khóa ngoại cho bảng WorkType
alter table WorkType add constraint PK_WorkType primary key (WorkTypeID);

--Tạo khóa chính, khóa ngoại cho bảng Employee
alter table Employee add constraint PK_Employee primary key (EmployeeID),
					     constraint FK_Employee_WorkPosition foreign key (WorkPositionID) references WorkPosition (WorkPositionID),
                         constraint FK_Employee_WorkType foreign key (WorkTypeID) references WorkType (WorkTypeID);

--Tạo khóa chính, khóa ngoại cho bảng Account
alter table Account add constraint PK_Account primary key (AccountUsername),
					    constraint FK_Account_Employee foreign key (EmployeeID) references Employee (EmployeeID);

--Tạo khóa chính, khóa ngoại cho bảng PositionType
alter table PositionType add constraint PK_WorkPosition_WorkType primary key (WorkPositionID, WorkTypeID),
							 constraint FK_PositionType_WorkPosition foreign key (WorkPositionID) references WorkPosition (WorkPositionID),
							 constraint	FK_PositionType_WorkType foreign key (WorkTypeID) references WorkType (WorkTypeID);

--Tạo khóa chính, khóa ngoại cho bảng DailyWork
alter table DailyWork add constraint PK_DailyWork_Employee primary key (DailyDate, EmployeeID),
						  constraint FK_DailyWork_Employee foreign key (EmployeeID) references Employee (EmployeeID);
						 
					 
--Cơ sở dữ liệu chung cho sản phẩm
--Sản phẩm
create table Product
(
	ID int identity(1, 1) not null,
	[ProductID] as ('PD' + right(replicate('0', 3) + cast(ID as varchar(3)), 3)) persisted not null,
	ProductName nvarchar(30) not null,
	CategoryID varchar(6) not null 
);

--Loại
create table Category
(
	ID int identity(1, 1) not null,
	[CategoryID] as ('CAT' + right(replicate('0', 3) + cast(ID as varchar(3)), 3)) persisted not null,
	CategoryName nvarchar(30) not null
);

--Size và giá
create table ProductPrice
(
	ProductID varchar(5) not null,
	ProductSize varchar(2) not null,
	ProductPrice int not null
);

--Tạo khóa chính, khóa ngoại cho bảng loại
alter table Category add constraint PK_Category primary key (CategoryID);

--Tạo khóa chính, khóa ngoại cho bảng sản phẩm
alter table Product add constraint PK_Product primary key (ProductID),
				        constraint FK_Product_Category foreign key (CategoryID) references Category (CategoryID);

--Tạo khóa chính, khóa ngoại cho bảng size và giá
alter table ProductPrice add constraint PK_ProductPrice primary key (ProductID, ProductSize),
							 constraint FK_ProductPrice_Product foreign key (ProductID) references Product (ProductID);

--Cơ sở dữ liệu chung cho hóa đơn
--Hóa đơn
create table Orders
(
	ID int identity(1, 1) not null,
	[OrderID] as ('ODR' + right(replicate('0', 7) + cast(ID as varchar(7)), 7)) persisted not null,
	TotalPrice int not null,
	OrderDate date not null,
	OrderTime time not null,
	DailySalesDate date not null,
);

--Chi tiết hóa đơn
create table OrderDetails
(
	OrderID varchar(10) not null,
	ProductID varchar(5) not null,
	Quantity int not null
);

--Tạo khóa chính, khóa ngoại cho bảng hóa đơn
alter table Orders add constraint PK_Orders primary key (OrderID),
					   constraint FK_Orders_DailySales foreign key (DailySalesDate) references DailySales (DailySalesDate);

--Tạo khóa chính, khóa ngoại cho bảng chi tiết hóa đơn
alter table OrderDetails add constraint PK_OrderDetails primary key (OrderID, ProductID),
						     constraint FK_OrderDetails_Orders foreign key (OrderID) references Orders (OrderID),
						     constraint FK_OrderDetails_Product foreign key (ProductID) references Product (ProductID)

--Cơ sở dữ liệu chung cho báo cáo
--Tổng bán trong ngày
create table DailySales
(
	DailySalesDate date not null,
	Total int not null
)

--Tạo khóa chính, khóa ngoại cho bảng tổng bán trong ngày
alter table DailySales add constraint PK_DailySales primary key (DailySalesDate);




