-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-12-2022 a las 21:33:38
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
  `id_city` bigint(20) NOT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `route`
--

INSERT INTO `route` (`id`, `name`, `dificulty`, `time`, `id_city`, `id_user`) VALUES
(1, 'route one', 'hard', '38:36:25', 1, 1);

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
(1, 'patinate', '2022-12-13 23:02:45', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `surname1` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `surname2` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `datebirth` datetime NOT NULL,
  `gender` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT 'rollinter2022',
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_usertype` bigint(20) NOT NULL DEFAULT 2,
  `id_team` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `surname1`, `surname2`, `datebirth`, `gender`, `username`, `password`, `email`, `id_usertype`, `id_team`) VALUES
(1, 'raimon', 'vilar', 'morera', '1999-01-17 00:00:00', 'M', 'raivi', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, 1),
(2, 'alvaro', 'talaya', 'romance', '1999-01-17 00:00:00', 'M', 'alta', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, 1),
(3, 'mario', 'tomas', 'zanon', '1999-01-17 00:00:00', 'M', 'mato', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(4, 'aitana', 'collado', 'soler', '1999-01-17 00:00:00', 'F', 'aico', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(5, 'carlos', 'merlos', 'pilar', '1999-01-17 00:00:00', 'M', 'came', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(6, 'luis', 'perez', 'derecho', '1999-01-17 00:00:00', 'M', 'lupe', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(7, 'estefania', 'boriko', 'izquierdo', '1999-01-17 00:00:00', 'F', 'esbo', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 1, NULL),
(8, 'quique', 'aroca', 'garcia', '1999-01-17 00:00:00', 'M', 'quiga', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(9, 'adrian', 'duyang', 'liang', '1999-01-17 00:00:00', 'M', 'adu', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL),
(10, 'rafael', 'aznar', 'aparici', '1999-01-17 00:00:00', 'M', 'raza', '73ec8dee81ea4c9e7515d63c9e5bbb707c7bc4789363c5afa401d3aa780630f6', 'test@email.com', 2, NULL);

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
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_ibfk_1` (`id_team`),
  ADD KEY `id_usertype` (`id_usertype`);

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
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `team`
--
ALTER TABLE `team`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_team`) REFERENCES `group` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `user_ibfk_2` FOREIGN KEY (`id_usertype`) REFERENCES `usertype` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
