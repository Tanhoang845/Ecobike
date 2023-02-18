-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 07, 2023 lúc 05:24 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET
SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET
time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ecobike`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `bike`
--

USE ECOBIKE;
CREATE TABLE `bike`
(
    `ID`           char(6) NOT NULL,
    `Name`         varchar(50) DEFAULT NULL,
    `LicensePlate` varchar(50) DEFAULT NULL,
    `Status`       varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `bike`
--

INSERT INTO `bike` (`ID`, `Name`, `LicensePlate`, `Status`)
VALUES ('b00001', 'xe dap thong nhat', '29-123.45', 'free'),
       ('b00002', 'xe dap thong nhat', '29-123.23', 'free'),
       ('b00003', 'xe dap thong nhat', '29-134.78', 'free'),
       ('b00004', 'xe dap hoang ha', '29-123.12', 'free'),
       ('b00005', 'xe dap hoang ha', '29-123.24', 'free'),
       ('b00006', 'xe dap hoang ha', '29-123.32', 'free'),
       ('b00007', 'xe dap galaxy', '29-123.21', 'free'),
       ('b00008', 'xe dap galaxy', '29-123.43', 'free'),
       ('b00009', 'xe dap galaxy', '29-123.89', 'free'),
       ('b00010', 'xe dap hai au', '29-123.98', 'free'),
       ('b00011', 'xe dap hai au', '29-123.87', 'free'),
       ('b00012', 'xe dap hai au', '29-123.76', 'free'),
       ('b00013', 'xe dap thong nhat', '29-123.14', 'free'),
       ('b00014', 'xe dap thong nhat', '29-123.41', 'free'),
       ('b00015', 'xe dap hoang ha', '29-123.15', 'free'),
       ('b00016', 'xe dap hai au', '29-123.51', 'free'),
       ('b00017', 'xe dap galaxy', '29-123.16', 'free'),
       ('b00018', 'xe dap galaxy', '29-123.61', 'free'),
       ('b00019', 'xe dap thong nhat', '29-123.17', 'free'),
       ('b00020', 'xe dap hai au', '29-123.71', 'free'),
       ('b00021', 'xe dap hai au', '29-123.18', 'free'),
       ('b00022', 'xe dap galaxy', '29-123.81', 'free'),
       ('b00023', 'xe dap dien thong nhat', '29-123.19', 'free'),
       ('b00024', 'xe dap hoang ha', '29-123.91', 'free'),
       ('b00025', 'xe dap hoang ha', '29-123.20', 'free'),
       ('b00026', 'xe dap hai au', '29-123.02', 'free'),
       ('b00027', 'xe dap galaxy', '29-123.01', 'free'),
       ('b00028', 'xe dap galaxy', '29-123.10', 'free'),
       ('b00029', 'xe dap dien hai au', '29-123.25', 'free'),
       ('b00030', 'xe dap hai au', '29-123.52', 'free'),
       ('b00031', 'xe dap hai au', '29-123.42', 'free'),
       ('b00032', 'xe dap dien galaxy', '29-123.26', 'free'),
       ('b00033', 'xe dap hoang ha', '29-123.62', 'free'),
       ('b00034', 'xe dap hai au', '29-123.27', 'free'),
       ('b00035', 'xe dap hoang ha', '29-123.28', 'free'),
       ('b00036', 'xe dap dien thong nhat', '29-123.82', 'free'),
       ('b00037', 'xe dap hai au', '29-123.29', 'free'),
       ('b00038', 'xe dap galaxy', '29-123.30', 'free'),
       ('b00039', 'xe dap galaxy', '29-123.03', 'free'),
       ('b00040', 'xe dap dien hai au', '29-123.35', 'free'),
       ('b00041', 'xe dap thong nhat', '29-123.53', 'free'),
       ('b00042', 'xe dap hoang ha', '29-123.36', 'free'),
       ('b00043', 'xe dap galaxy', '29-123.63', 'free'),
       ('b00044', 'xe dap dien thong nhat', '29-123.37', 'free'),
       ('b00045', 'xe dap hai au', '29-123.73', 'free'),
       ('b00046', 'xe dap hai au', '29-123.38', 'free'),
       ('b00047', 'xe dap thong nhat', '29-123.83', 'free'),
       ('b00048', 'xe dap galaxy', '29-123.39', 'free'),
       ('b00049', 'xe dap thong nhat', '29-123.93', 'free'),
       ('b00050', 'xe dap dien galaxy', '29-123.46', 'free'),
       ('b00051', 'xe dap galaxy', '29-123.64', 'free'),
       ('b00052', 'xe dap dien galaxy', '29-123.47', 'free'),
       ('b00053', 'xe dap thong nhat', '29-123.74', 'free'),
       ('b00054', 'xe dap dien hai au', '29-123.48', 'free'),
       ('b00055', 'xe dap thong nhat', '29-123.84', 'free'),
       ('b00056', 'xe dap dien hoang ha', '29-123.49', 'free'),
       ('b00057', 'xe dap dien hai au', '29-123.94', 'free'),
       ('b00058', 'xe dap dien thong nhat', '29-123.40', 'free'),
       ('b00059', 'xe dap dien galaxy', '29-123.04', 'free'),
       ('b00060', 'xe dap dien hoang ha', '29-123.57', 'free'),
       ('b00061', 'xe dap dien hai au', '29-123.75', 'free'),
       ('b00062', 'xe dap dien thong nhat', '29-123.58', 'free');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `card`
--

CREATE TABLE `card`
(
    `ID`             char(6) NOT NULL,
    `CardHolderName` varchar(50) DEFAULT NULL,
    `CardNumber`     varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `parking`
--

CREATE TABLE `parking`
(
    `ID`      char(6) NOT NULL,
    `Name`    varchar(50) DEFAULT NULL,
    `Address` varchar(50) DEFAULT NULL,
    `Area`    int(11) DEFAULT NULL,
    `MaxHost` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `parking`
--

INSERT INTO `parking` (`ID`, `Name`, `Address`, `Area`, `MaxHost`)
VALUES ('p00001', 'Bai xe Bach Khoa', 'so 1 Ta Quang Buu, Bach Khoa, Hai Ba Trung, Ha Noi', 200, 15),
       ('p00002', 'Bai xe Tran Dai Nghia', 'so 10 Tran Dai Nghia, Hai Ba Trung, Ha Noi', 250, 15),
       ('p00003', 'Bai xe Giai Phong', 'so 1 Giai Phong, Hai Ba Trung, Ha Noi ', 250, 15),
       ('p00004', 'Bai xe Bach Mai', 'so 5 Bach Mai, Hai Ba Trung, Ha Noi', 230, 13),
       ('p00005', 'Bai xe Ba Trieu', 'So 3 Ba Trieu, Hoan Kiem, Ha Noi', 250, 15),
       ('p00006', 'Bai xe Pho Hue', '20 Pho Hue, Hoan Kiem, Ha Noi', 200, 15);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `paymenttransaction`
--

CREATE TABLE `paymenttransaction`
(
    `ID`          char(6) NOT NULL,
    `CardID`      char(10)    DEFAULT NULL,
    `RentBikeID`  INT     DEFAULT NULL,
    `PaymentType` varchar(50) DEFAULT NULL,
    `Amount`      int(11) DEFAULT NULL,
    `Content`     varchar(50) DEFAULT NULL,
    `Method`      varchar(50) DEFAULT NULL,
    `CreatedAt`   date        DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `place`
--

CREATE TABLE `place`
(
    `ParkingID`  char(10) NOT NULL,
    `BikeID`     char(10) NOT NULL,
    `HostNumber` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `place`
--

INSERT INTO `place` (`ParkingID`, `BikeID`, `HostNumber`)
VALUES ('p00001', 'b00001', 1),
       ('p00001', 'b00002', 7),
       ('p00001', 'b00003', 2),
       ('p00001', 'b00004', 3),
       ('p00001', 'b00005', 8),
       ('p00001', 'b00006', 4),
       ('p00001', 'b00008', 9),
       ('p00001', 'b00011', 10),
       ('p00001', 'b00023', 5),
       ('p00001', 'b00029', 6),
       ('p00002', 'b00007', 7),
       ('p00002', 'b00009', 8),
       ('p00002', 'b00010', 9),
       ('p00002', 'b00012', 10),
       ('p00002', 'b00013', 1),
       ('p00002', 'b00015', 2),
       ('p00002', 'b00016', 3),
       ('p00002', 'b00032', 4),
       ('p00002', 'b00036', 5),
       ('p00002', 'b00040', 6),
       ('p00003', 'b00014', 2),
       ('p00003', 'b00017', 9),
       ('p00003', 'b00018', 1),
       ('p00003', 'b00019', 10),
       ('p00003', 'b00020', 3),
       ('p00003', 'b00021', 11),
       ('p00003', 'b00022', 12),
       ('p00003', 'b00024', 4),
       ('p00003', 'b00026', 5),
       ('p00003', 'b00044', 6),
       ('p00003', 'b00050', 7),
       ('p00003', 'b00052', 8),
       ('p00004', 'b00025', 1),
       ('p00004', 'b00027', 6),
       ('p00004', 'b00028', 2),
       ('p00004', 'b00030', 3),
       ('p00004', 'b00031', 7),
       ('p00004', 'b00033', 8),
       ('p00004', 'b00037', 9),
       ('p00004', 'b00054', 4),
       ('p00004', 'b00056', 5),
       ('p00005', 'b00034', 5),
       ('p00005', 'b00035', 6),
       ('p00005', 'b00038', 1),
       ('p00005', 'b00039', 7),
       ('p00005', 'b00041', 2),
       ('p00005', 'b00042', 3),
       ('p00005', 'b00043', 4),
       ('p00005', 'b00057', 8),
       ('p00005', 'b00058', 9),
       ('p00005', 'b00059', 10),
       ('p00006', 'b00045', 1),
       ('p00006', 'b00046', 5),
       ('p00006', 'b00047', 2),
       ('p00006', 'b00048', 3),
       ('p00006', 'b00049', 6),
       ('p00006', 'b00051', 7),
       ('p00006', 'b00053', 4),
       ('p00006', 'b00055', 8),
       ('p00006', 'b00060', 9),
       ('p00006', 'b00061', 10),
       ('p00006', 'b00062', 11);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rentbike`
--

CREATE TABLE `rentbike`
(
    `ID`         int      NOT NULL primary key AUTO_INCREMENT,
    `UserID`     char(10) NOT NULL,
    `BikeID`     char(10) not NULL,
    `RentedAt`   DATETIME not null DEFAULT CURRENT_TIMESTAMP,
    `isReturned` boolean  not null default false
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `standardbike`
--

CREATE TABLE `standardbike`
(
    `ID` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `standardbike`
--

INSERT INTO `standardbike` (`ID`)
VALUES ('b00001'),
       ('b00003'),
       ('b00004'),
       ('b00006'),
       ('b00007'),
       ('b00009'),
       ('b00010'),
       ('b00012'),
       ('b00014'),
       ('b00018'),
       ('b00020'),
       ('b00024'),
       ('b00026'),
       ('b00027'),
       ('b00031'),
       ('b00033'),
       ('b00037'),
       ('b00038'),
       ('b00041'),
       ('b00042'),
       ('b00043'),
       ('b00046'),
       ('b00049'),
       ('b00051'),
       ('b00055');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `standardebike`
--

CREATE TABLE `standardebike`
(
    `ID`      char(10) NOT NULL,
    `Battery` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `standardebike`
--

INSERT INTO `standardebike` (`ID`, `Battery`)
VALUES ('b00023', 80),
       ('b00029', 85),
       ('b00032', 90),
       ('b00036', 91),
       ('b00040', 70),
       ('b00044', 78),
       ('b00050', 79),
       ('b00052', 89),
       ('b00054', 88),
       ('b00056', 86),
       ('b00057', 80),
       ('b00058', 90),
       ('b00059', 85),
       ('b00060', 90),
       ('b00061', 89),
       ('b00062', 70);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `twinbike`
--

CREATE TABLE `twinbike`
(
    `ID` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `twinbike`
--

INSERT INTO `twinbike` (`ID`)
VALUES ('b00002'),
       ('b00005'),
       ('b00008'),
       ('b00011'),
       ('b00013'),
       ('b00015'),
       ('b00016'),
       ('b00017'),
       ('b00019'),
       ('b00021'),
       ('b00022'),
       ('b00025'),
       ('b00028'),
       ('b00030'),
       ('b00034'),
       ('b00035'),
       ('b00039'),
       ('b00045'),
       ('b00047'),
       ('b00048'),
       ('b00053');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user`
(
    `ID`       char(6) NOT NULL,
    `Name`     varchar(50) DEFAULT NULL,
    `UserName` varchar(50) DEFAULT NULL,
    `Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`ID`, `Name`, `UserName`, `Password`)
VALUES ('u00001', 'luong thi tam', 'tam tam xinh dep', '12345678'),
       ('u00002', 'le duc son', 'son yama', '12345678'),
       ('u00003', 'hoang trong tan', 'trong tan', '12345678');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `bike`
--
ALTER TABLE `bike`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `card`
--
ALTER TABLE `card`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `parking`
--
ALTER TABLE `parking`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `paymenttransaction`
--
ALTER TABLE `paymenttransaction`
    ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_PaymentTransaction_0` (`CardID`),
  ADD KEY `FK_PaymentTransaction_1` (`RentBikeID`);

--
-- Chỉ mục cho bảng `place`
--
ALTER TABLE `place`
    ADD PRIMARY KEY (`ParkingID`, `BikeID`),
  ADD KEY `FK_Place_1` (`BikeID`);

--
-- Chỉ mục cho bảng `rentbike`
--
ALTER TABLE `rentbike`
    ADD KEY `FK_RentBike_0` (`UserID`),
    ADD KEY `FK_RentBike_1` (`BikeID`);

--
-- Chỉ mục cho bảng `standardbike`
--
ALTER TABLE `standardbike`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `standardebike`
--
ALTER TABLE `standardebike`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `twinbike`
--
ALTER TABLE `twinbike`
    ADD PRIMARY KEY (`ID`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
    ADD PRIMARY KEY (`ID`);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `paymenttransaction`
--
ALTER TABLE `paymenttransaction`
    ADD CONSTRAINT `FK_PaymentTransaction_0` FOREIGN KEY (`CardID`) REFERENCES `card` (`ID`),
  ADD CONSTRAINT `FK_PaymentTransaction_1` FOREIGN KEY (`RentBikeID`) REFERENCES `rentbike` (`ID`);

--
-- Các ràng buộc cho bảng `place`
--
ALTER TABLE `place`
    ADD CONSTRAINT `FK_Place_0` FOREIGN KEY (`ParkingID`) REFERENCES `parking` (`ID`),
  ADD CONSTRAINT `FK_Place_1` FOREIGN KEY (`BikeID`) REFERENCES `bike` (`ID`);

--
-- Các ràng buộc cho bảng `rentbike`
--
ALTER TABLE `rentbike`
    ADD CONSTRAINT `FK_RentBike_0` FOREIGN KEY (`UserID`) REFERENCES `user` (`ID`),
  ADD CONSTRAINT `FK_RentBike_1` FOREIGN KEY (`BikeID`) REFERENCES `bike` (`ID`);

--
-- Các ràng buộc cho bảng `standardbike`
--
ALTER TABLE `standardbike`
    ADD CONSTRAINT `FK_StandardBike_0` FOREIGN KEY (`ID`) REFERENCES `bike` (`ID`);

--
-- Các ràng buộc cho bảng `standardebike`
--
ALTER TABLE `standardebike`
    ADD CONSTRAINT `FK_StandardEBike_0` FOREIGN KEY (`ID`) REFERENCES `bike` (`ID`);

--
-- Các ràng buộc cho bảng `twinbike`
--
ALTER TABLE `twinbike`
    ADD CONSTRAINT `FK_TwinBike_0` FOREIGN KEY (`ID`) REFERENCES `bike` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
