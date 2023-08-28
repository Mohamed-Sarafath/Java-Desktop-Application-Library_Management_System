-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 27, 2023 at 08:41 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `book_ID` int(11) NOT NULL,
  `book_name` varchar(250) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_ID`, `book_name`, `author`, `quantity`) VALUES
(1, 'JAVA', 'P.Pradeep Kumaar', 17),
(2, 'Python', 'RM. Sarafath', 6),
(3, 'C#', 'ANF. Sajana', 7),
(4, 'PHP', 'M.Rumaan', 9),
(5, 'HTML', 'V. Kanaha', 20),
(6, 'DBMS', 'K. Kannan Bala', 12),
(7, 'Computer Harware', 'L. Lalitha', 11),
(8, 'JS', 'K.Malar', 4),
(9, 'Harry Potter ', 'JK. Rowling', 7),
(10, 'Mother', 'K. Leela', 2),
(11, 'DEATH', 'John Steve', 2),
(12, 'The Ghost', 'S. Steven', 0),
(13, 'Naruto', 'Luffy', 12),
(14, 'Titanic', 'Joseph', 3),
(15, 'ABC', 'PQRS', 4),
(16, 'LMN', 'Kumaran Khan', 5);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(100) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(1, 1, 'JAVA', 1, 'AM. Soooojath', '2023-06-17', '2023-06-19', 'Returned'),
(2, 1, 'JAVA', 5, 'AH. Sharjoon', '2023-06-15', '2023-06-20', 'Returned'),
(3, 5, 'HTML', 5, 'A. Sharjoon', '2023-06-18', '2023-06-22', 'Returned'),
(4, 1, 'JAVA', 2, 'AF. Riftha', '2023-06-14', '2023-06-17', 'Pending'),
(5, 2, 'Python', 9, 'ANF. Sajana', '2023-06-18', '2023-06-22', 'Pending'),
(6, 11, 'DEATH', 5, 'A. Sharjoon', '2023-06-19', '2023-06-21', 'Pending'),
(7, 7, 'Computer Harware', 14, 'BF. Shimla', '2023-06-19', '2023-06-23', 'Pending'),
(8, 5, 'HTML', 13, 'AJF. Anha', '2023-06-16', '2023-06-18', 'Returned'),
(9, 4, 'PHP', 7, 'M. Inshath', '2023-06-19', '2023-06-24', 'Pending'),
(10, 14, 'Titanic', 8, 'RM. Sarafath', '2023-07-03', '2023-07-06', 'Returned');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `course` varchar(5) DEFAULT NULL,
  `year` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `course`, `year`) VALUES
(1, 'AM. Soooojath', 'HNDIT', 2020),
(2, 'AF. Riftha', 'HNDIT', 2020),
(3, 'K. Zifan', 'HNDIT', 2020),
(4, 'M. Rumaan', 'HNDIT', 2020),
(5, 'A. Sharjoon', 'HNDIT', 2020),
(6, 'AL. Nustha Begum', 'HNDIT', 2020),
(7, 'M. Inshath', 'HNDIT', 2020),
(8, 'RM. Sarafath', 'HNDIT', 2020),
(9, 'ANF. Sajana', 'HNDIT', 2020),
(10, 'D. Afsir', 'HNDIT', 2020),
(11, 'AJ. Ajith Kumar', 'HNDA', 2019),
(12, 'Joseph Vijay', 'HNDIT', 2021);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `contact` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(2, 'sarafath', '123456', 'sar@gmail.com', '0768345321'),
(3, 'sadasd', '54523151', 'dsfsdgdfg', '453245'),
(4, 'sar', '12345', 'sar@gmail.com', '1234567'),
(5, 'sar', '12345', 'sar@gmail.com', '1234567'),
(6, 'sajana', '12345', 'saju@gmail.com', '4356543678'),
(7, 'Sajana', 'sajana1234', 'sajana@gmail.com', '0763686309'),
(8, 'SJN', '12454', 'saju@gmail.com', '1234567890'),
(9, 'SajuZaino', '12345', 'sajuzaino@gmail.com', '0765760556'),
(10, 'Sarrr', '1314', 'sar@gmail.com', '0765760556'),
(11, 'fathima', '1234', 'fathi@gmail.com', '029838192');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_ID`);

--
-- Indexes for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_details`
--
ALTER TABLE `book_details`
  MODIFY `book_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `issue_book_details`
--
ALTER TABLE `issue_book_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
