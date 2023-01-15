-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 13-01-2023 a las 17:28:43
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rollinter`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinates`
--

CREATE TABLE `coordinates` (
  `id` bigint(20) NOT NULL,
  `x` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `y` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_route` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `coordinates`
--

INSERT INTO `coordinates` (`id`, `x`, `y`, `id_route`) VALUES
(1, '7687687', '87987987', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `route`
--

CREATE TABLE `route` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `dificulty` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `time` time NOT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `team`
--

CREATE TABLE `team` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `creationdate` datetime NOT NULL,
  `id_user` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `team`
--

INSERT INTO `team` (`id`, `name`, `creationdate`, `id_user`) VALUES
(1, 'not team yet', '2023-01-10 20:01:48', 1),
(2, 'Rollinteros', '2023-01-13 16:32:52', 227),
(3, 'Rolleame', '2023-01-13 16:32:52', 228),
(4, 'Rollinteros', '2023-01-13 16:32:52', 227),
(5, 'Rolleame', '2023-01-13 16:32:52', 228);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `surname1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `surname2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datebirth` date NOT NULL,
  `gender` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'rollinter2022',
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_usertype` bigint(20) NOT NULL DEFAULT 2,
  `id_team` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `surname1`, `surname2`, `datebirth`, `gender`, `username`, `password`, `email`, `id_usertype`, `id_team`) VALUES
(1, 'estefania', 'boriko', 'laenos', '1999-01-17', 'F', 'esborlan', 'rollinter2022', 'esborlan@rollinter.com', 1, 1),
(226, 'Ruben', 'Vilar', 'Mourad', '1989-02-12', 'M', 'rubenvilar', 'Rollinter2022', 'rubenvilar@rollinter.net', 2, 2),
(227, 'Jose Maria', 'Perez', 'Morera', '1997-08-10', 'F', 'josemariap', 'Rollinter2022', 'josemariaperez@rollinter.net', 2, 3),
(228, 'Ruben', 'Gyori', 'Patricio', '1937-03-31', 'M', 'rubengyori', 'Rollinter2022', 'rubengyori@rollinter.net', 2, 2),
(229, 'Luis Fernando', 'Vilar', 'Mourad', '1996-08-16', 'F', 'luisfernandovilar', 'Rollinter2022', 'luisfernandovilar@rollinter.net', 2, 1),
(230, 'Nerea', 'Talaya', 'Hurtado', '1963-09-28', 'F', 'nereatalaya', 'Rollinter2022', 'nereatalaya@rollinter.net', 2, 1),
(231, 'Ruben', 'Soler', 'Bañuls', '1961-02-14', 'F', 'rubensoler', 'Rollinter2022', 'rubensoler@rollinter.net', 2, 1),
(232, 'Lucas Ezequiel', 'Blanco', 'Sanchez', '2003-09-26', 'M', 'lucasezequielblanco', 'Rollinter2022', 'lucasezequielblanco@rollinter.net', 2, 1),
(233, 'Ainhoa', 'Rodríguez', 'Castello', '2008-04-08', 'F', 'ainhoarodríguez', 'Rollinter2022', 'ainhoarodríguez@rollinter.net', 2, 1),
(234, 'Raimon', 'Guerrero', 'Castello', '1938-08-14', 'M', 'raimonguerrero', 'Rollinter2022', 'raimonguerrero@rollinter.net', 2, 1),
(235, 'Kevin', 'Carrascosa', 'Luz', '1997-02-15', 'M', 'kevincarrascosa', 'Rollinter2022', 'kevincarrascosa@rollinter.net', 2, 1),
(236, 'Carlos', 'Perez', 'Hurtado', '1951-03-03', 'F', 'carlosperez', 'Rollinter2022', 'carlosperez@rollinter.net', 2, 1),
(237, 'Raimon', 'Soler', 'Castello', '1941-09-08', 'M', 'raimonsoler', 'Rollinter2022', 'raimonsoler@rollinter.net', 2, 1),
(238, 'Lucas Ezequiel', 'Lazaro', 'Luz', '1990-10-31', 'M', 'lucasezequiellazaro', 'Rollinter2022', 'lucasezequiellazaro@rollinter.net', 2, 1),
(239, 'Luis', 'Soler', 'Torres', '1977-06-23', 'F', 'luissoler', 'Rollinter2022', 'luissoler@rollinter.net', 2, 1),
(240, 'Luis Fernando', 'Blanco', 'Hurtado', '1998-09-04', 'F', 'luisfernandoblanco', 'Rollinter2022', 'luisfernandoblanco@rollinter.net', 2, 1),
(241, 'Karim', 'Perez', 'Gyori', '1972-01-10', 'F', 'karimperez', 'Rollinter2022', 'karimperez@rollinter.net', 2, 1),
(242, 'Ximo', 'Rodríguez', 'Romance', '1993-10-04', 'F', 'ximorodríguez', 'Rollinter2022', 'ximorodríguez@rollinter.net', 2, 1),
(243, 'Lucas Ezequiel', 'Tomas', 'Romance', '1948-03-31', 'M', 'lucasezequieltomas', 'Rollinter2022', 'lucasezequieltomas@rollinter.net', 2, 1),
(244, 'Estefania', 'Soler', 'Blayimir', '2005-05-11', 'M', 'estefaniasoler', 'Rollinter2022', 'estefaniasoler@rollinter.net', 2, 1),
(245, 'Jose David', 'Perez', 'Blayimir', '1983-11-01', 'F', 'josedavidperez', 'Rollinter2022', 'josedavidperez@rollinter.net', 2, 1),
(246, 'Cristina', 'Perez', 'Luz', '1952-12-28', 'F', 'cristinaperez', 'Rollinter2022', 'cristinaperez@rollinter.net', 2, 1),
(247, 'Elliot', 'Luque', 'Fernández', '1931-09-11', 'M', 'elliotluque', 'Rollinter2022', 'elliotluque@rollinter.net', 2, 1),
(248, 'Kevin', 'Benito', 'Zanon', '1998-02-09', 'M', 'kevinbenito', 'Rollinter2022', 'kevinbenito@rollinter.net', 2, 1),
(249, 'Mario', 'Soler', 'Castello', '1944-04-01', 'F', 'mariosoler', 'Rollinter2022', 'mariosoler@rollinter.net', 2, 1),
(250, 'Ruben', 'Lazaro', 'Torres', '2004-02-03', 'M', 'rubenlazaro', 'Rollinter2022', 'rubenlazaro@rollinter.net', 2, 1),
(251, 'Estefania', 'Suay', 'Blayimir', '1953-09-15', 'M', 'estefaniasuay', 'Rollinter2022', 'estefaniasuay@rollinter.net', 2, 1),
(252, 'Estefania', 'Blanco', 'Luz', '1953-03-16', 'M', 'estefaniablanco', 'Rollinter2022', 'estefaniablanco@rollinter.net', 2, 1),
(253, 'Iris', 'Soler', 'Blayimir', '1957-08-28', 'F', 'irissoler', 'Rollinter2022', 'irissoler@rollinter.net', 2, 1),
(254, 'Jose Maria', 'Benito', 'Zanon', '1960-06-14', 'F', 'josemariabenito', 'Rollinter2022', 'josemariabenito@rollinter.net', 2, 1),
(255, 'Elliot', 'Blanco', 'Laenos', '1988-04-21', 'M', 'elliotblanco', 'Rollinter2022', 'elliotblanco@rollinter.net', 2, 1),
(256, 'Elliot', 'Rezgaoui', 'Gyori', '1971-11-15', 'F', 'elliotrezgaoui', 'Rollinter2022', 'elliotrezgaoui@rollinter.net', 2, 1),
(257, 'Mario', 'Lazaro', 'Castello', '1961-06-01', 'M', 'mariolazaro', 'Rollinter2022', 'mariolazaro@rollinter.net', 2, 1),
(258, 'Jose Maria', 'Talaya', 'Mourad', '1932-03-14', 'M', 'josemariatalaya', 'Rollinter2022', 'josemariatalaya@rollinter.net', 2, 1),
(259, 'Luis Fernando', 'Rosales', 'Patricio', '2007-05-26', 'M', 'luisfernandorosales', 'Rollinter2022', 'luisfernandorosales@rollinter.net', 2, 1),
(260, 'Iris', 'Tomas', 'Hurtado', '2008-11-27', 'F', 'iristomas', 'Rollinter2022', 'iristomas@rollinter.net', 2, 1),
(261, 'Luis Fernando', 'Rodríguez', 'Pascual', '1934-10-25', 'F', 'luisfernandorodríguez', 'Rollinter2022', 'luisfernandorodríguez@rollinter.net', 2, 1),
(262, 'Estefania', 'Perez', 'Benavent', '1962-07-24', 'M', 'estefaniaperez', 'Rollinter2022', 'estefaniaperez@rollinter.net', 2, 1),
(263, 'Kevin', 'Guerrero', 'Luz', '1985-06-23', 'F', 'kevinguerrero', 'Rollinter2022', 'kevinguerrero@rollinter.net', 2, 1),
(264, 'Kevin', 'Talaya', 'Mourad', '1973-06-21', 'F', 'kevintalaya', 'Rollinter2022', 'kevintalaya@rollinter.net', 2, 1),
(265, 'Mario', 'Luque', 'Pascual', '1923-01-22', 'M', 'marioluque', 'Rollinter2022', 'marioluque@rollinter.net', 2, 1),
(266, 'Ainhoa', 'Carrascosa', 'Benavent', '1962-07-10', 'F', 'ainhoacarrascosa', 'Rollinter2022', 'ainhoacarrascosa@rollinter.net', 2, 1),
(267, 'Luis', 'Carrascosa', 'Luz', '1996-08-30', 'M', 'luiscarrascosa', 'Rollinter2022', 'luiscarrascosa@rollinter.net', 2, 1),
(268, 'Ainhoa', 'Carrascosa', 'Morera', '1924-12-25', 'F', 'ainhoacarrascosa', 'Rollinter2022', 'ainhoacarrascosa@rollinter.net', 2, 1),
(269, 'Alvaro', 'Perez', 'Bañuls', '1969-12-30', 'M', 'alvaroperez', 'Rollinter2022', 'alvaroperez@rollinter.net', 2, 1),
(270, 'Estefania', 'Carrascosa', 'Torres', '1938-05-31', 'M', 'estefaniacarrascosa', 'Rollinter2022', 'estefaniacarrascosa@rollinter.net', 2, 1),
(271, 'Nerea', 'Soler', 'Laenos', '1970-02-05', 'M', 'nereasoler', 'Rollinter2022', 'nereasoler@rollinter.net', 2, 1),
(272, 'Lucas Ezequiel', 'Rezgaoui', 'Laenos', '1934-12-08', 'F', 'lucasezequielrezgaoui', 'Rollinter2022', 'lucasezequielrezgaoui@rollinter.net', 2, 1),
(273, 'Lucas Ezequiel', 'Luque', 'Zanon', '1930-05-02', 'M', 'lucasezequielluque', 'Rollinter2022', 'lucasezequielluque@rollinter.net', 2, 1),
(274, 'Raimon', 'Rosales', 'Patricio', '1962-02-12', 'F', 'raimonrosales', 'Rollinter2022', 'raimonrosales@rollinter.net', 2, 1),
(275, 'Alvaro', 'Soler', 'Gyori', '1976-11-13', 'M', 'alvarosoler', 'Rollinter2022', 'alvarosoler@rollinter.net', 2, 1),
(276, 'eeeeee', 'vhfchdfhfh', 'cfjhcgjgc', '1999-12-15', 'M', 'elrafa', 'Rollinter2022', 'vamos@rollinter.com', 2, 1),
(277, 'cocherito', 'lere', 'ledije', '1999-12-15', 'F', 'quesiqueri', 'Rollinter2022', 'anoche@lere.com', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usertype`
--

CREATE TABLE `usertype` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usertype`
--

INSERT INTO `usertype` (`id`, `name`) VALUES
(1, 'Admin'),
(2, 'Rolluser');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `coordinates`
--
ALTER TABLE `coordinates`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `route`
--
ALTER TABLE `route`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `team`
--
ALTER TABLE `team`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=278;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
