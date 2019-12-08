-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 08 2019 г., 19:44
-- Версия сервера: 5.7.25
-- Версия PHP: 7.1.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `notes_app`
--

-- --------------------------------------------------------

--
-- Структура таблицы `cars`
--

CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `mark` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number_car` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `cars`
--

INSERT INTO `cars` (`id`, `mark`, `name`, `number_car`) VALUES
(1, 'Audi', 'Audi A4', 'a 111 aa 18'),
(2, 'Audi', 'Audi A4', 'a 111 aa 18'),
(3, 'BMW', 'BMW 320', 'a 222 aa 18'),
(4, 'BMW', 'BMW 320', 'a 222 aa 18');

-- --------------------------------------------------------

--
-- Структура таблицы `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `created_at` datetime NOT NULL,
  `rental_date_off` datetime DEFAULT NULL,
  `rental_date_on` datetime NOT NULL,
  `id_car` int(11) NOT NULL,
  `id_pointofsale` int(11) NOT NULL,
  `id_tanant` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `orders`
--

INSERT INTO `orders` (`id`, `amount`, `created_at`, `rental_date_off`, `rental_date_on`, `id_car`, `id_pointofsale`, `id_tanant`) VALUES
(1, 1000, '2019-12-04 00:00:00', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(28, 1000, '2019-12-08 13:52:15', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(30, 1000, '2019-12-08 13:52:16', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(31, 1000, '2019-12-08 13:52:16', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(32, 1000, '2019-12-08 14:08:48', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(33, 1000, '2019-12-08 14:16:52', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1),
(34, 1000, '2019-12-08 16:08:28', '2019-12-06 00:00:00', '2019-12-08 00:00:00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `pointofsale`
--

CREATE TABLE `pointofsale` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `pointofsale`
--

INSERT INTO `pointofsale` (`id`, `name`) VALUES
(1, 'Магазин 1'),
(2, 'Магазин 2'),
(3, 'Магазин 1'),
(4, 'Магазин 2');

-- --------------------------------------------------------

--
-- Структура таблицы `tenants`
--

CREATE TABLE `tenants` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `tenants`
--

INSERT INTO `tenants` (`id`, `name`) VALUES
(1, 'Арендатор 1');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `UK_eburj24l83n75td7cih3gg4oa` (`id_car`) USING BTREE,
  ADD KEY `UK_mqgvx0wtrqyi3s46b6hv7is8r` (`id_pointofsale`) USING BTREE,
  ADD KEY `UK_royka9b6f1aajmskfepbwib5k` (`id_tanant`) USING BTREE;

--
-- Индексы таблицы `pointofsale`
--
ALTER TABLE `pointofsale`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `tenants`
--
ALTER TABLE `tenants`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `cars`
--
ALTER TABLE `cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT для таблицы `pointofsale`
--
ALTER TABLE `pointofsale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT для таблицы `tenants`
--
ALTER TABLE `tenants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FK13jprf12fcta62wmymrrdveg` FOREIGN KEY (`id_pointofsale`) REFERENCES `pointofsale` (`id`),
  ADD CONSTRAINT `FK6niqncuc65bf8jyq4xouyolbe` FOREIGN KEY (`id_tanant`) REFERENCES `tenants` (`id`),
  ADD CONSTRAINT `FK7pw30wbfg09a6il0lf0qmji4x` FOREIGN KEY (`id_car`) REFERENCES `cars` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
