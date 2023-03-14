-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost:3306
-- Tiempo de generación: 14-03-2023 a las 15:10:41
-- Versión del servidor: 8.0.23
-- Versión de PHP: 8.0.3

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
-- Estructura de tabla para la tabla `chatteam`
--

CREATE TABLE `chatteam` (
  `id` int NOT NULL,
  `textchat` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `creationdate` datetime NOT NULL,
  `id_user` int NOT NULL,
  `id_team` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `chatteam`
--

INSERT INTO `chatteam` (`id`, `textchat`, `creationdate`, `id_user`, `id_team`) VALUES
(1, 'Hi guys! What\'s going on?', '2023-02-09 21:34:36', 4802, 316),
(2, 'Hi, ready to take the roller-blade', '2023-02-10 00:03:45', 1, 316),
(3, 'probando andamos', '2023-02-10 00:04:23', 1, 316),
(5, 'hi', '2023-02-10 11:13:35', 1, 1),
(6, 'probando', '2023-02-10 11:13:45', 1, 1),
(7, 'probandochat', '2023-02-10 11:13:48', 1, 1),
(8, 'a ver si hacer scroll', '2023-02-10 11:13:54', 1, 1),
(9, 'parece ser que no', '2023-02-10 11:13:59', 1, 1),
(10, 'parece ser que si', '2023-02-10 11:14:06', 1, 1),
(18, 'hola', '2023-02-10 16:30:55', 1, 317),
(19, 'parece que no', '2023-02-10 17:11:14', 1, 1),
(20, 'parece que no', '2023-02-10 17:11:14', 1, 1),
(21, 'tararara', '2023-02-10 17:11:23', 1, 1),
(22, 'oleola', '2023-02-10 17:11:30', 1, 1),
(23, 'ser o no ser', '2023-02-10 17:11:44', 1, 1),
(24, 'ser o no ser', '2023-02-10 17:16:48', 1, 1),
(25, 'WJEHGFUEIWFG', '2023-02-10 19:33:38', 1, 1),
(26, 'HOLA', '2023-02-10 19:33:48', 1, 316),
(27, 'holi', '2023-02-12 21:31:16', 4714, 1),
(28, 'holi', '2023-02-12 21:32:22', 4714, 1),
(29, 'Welcome everybody :)', '2023-02-13 23:04:15', 4718, 336),
(31, 'hola', '2023-02-14 12:31:40', 4862, 316),
(32, 'hols', '2023-02-14 18:47:52', 4862, 316),
(34, 'seguimos viendo', '2023-02-18 13:27:36', 4862, 316),
(35, 'Todo bien todo correcto', '2023-02-18 13:27:48', 4862, 316),
(36, 'v', '2023-02-18 13:27:53', 4862, 316),
(37, 'a', '2023-02-18 13:27:53', 4862, 316),
(38, 'v', '2023-02-18 13:27:54', 4862, 316),
(39, 'e', '2023-02-18 13:27:55', 4862, 316),
(40, 'r', '2023-02-18 13:27:56', 4862, 316),
(41, 'm', '2023-02-18 13:28:01', 4862, 316),
(42, 'hhhh', '2023-02-18 13:36:32', 4862, 316),
(43, 'seguimos', '2023-02-18 13:41:39', 4862, 316),
(44, 'a ver', '2023-02-18 13:59:45', 4862, 316),
(45, 'Todo bien todo correcto', '2023-02-18 14:01:01', 4862, 316);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comment`
--

CREATE TABLE `comment` (
  `id` int NOT NULL,
  `text` varchar(500) COLLATE utf8mb4_unicode_ci NOT NULL,
  `creationdate` datetime NOT NULL,
  `id_user` int NOT NULL,
  `id_route` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `comment`
--

INSERT INTO `comment` (`id`, `text`, `creationdate`, `id_user`, `id_route`) VALUES
(47, 'Route with amazing views', '2023-02-13 23:03:29', 4718, 84),
(49, 'Super boring', '2023-02-14 11:24:47', 4714, 49),
(54, 'Good route', '2023-02-23 10:29:38', 4862, 48),
(56, 'muy chula', '2023-03-13 10:31:49', 4862, 47);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `coordinates`
--

CREATE TABLE `coordinates` (
  `id` bigint NOT NULL,
  `x` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `y` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `id_route` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `coordinates`
--

INSERT INTO `coordinates` (`id`, `x`, `y`, `id_route`) VALUES
(137, '39.472721395598064', '-0.3669573862712605', 47),
(138, '39.473698650788364', '-0.36487599207570387', 47),
(139, '39.4693003499046', '-0.3611852724712117', 47),
(140, '39.46504312311302', '-0.3589107592265828', 47),
(141, '39.46163052759519', '-0.35693665339162184', 47),
(142, '39.46054784616056', '-0.35300205334462875', 47),
(143, '39.45685338260072', '-0.35538385494985336', 47),
(144, '39.455540599487826', '-0.353404652634115', 47),
(145, '39.47967377612536', '-0.3721528296946186', 48),
(146, '39.477090039245304', '-0.36806109492571126', 48),
(147, '39.472783597843495', '-0.3699922854164339', 48),
(148, '39.470355515661005', '-0.3711234805791741', 48),
(149, '39.467357307901835', '-0.36792628743342215', 48),
(150, '39.468781886813176', '-0.36138169743708426', 48),
(151, '39.46407308058409', '-0.3587043456461947', 48),
(152, '39.46119629196725', '-0.3557671159673359', 48),
(153, '39.459705290352524', '-0.3530760433697555', 48),
(154, '39.45597764658212', '-0.34798584517774733', 48),
(155, '39.470273781894356', '-0.38440247370412184', 49),
(156, '39.46752404607096', '-0.3766777117412312', 49),
(157, '39.470157831373406', '-0.37041207148244215', 49),
(158, '39.473752207671836', '-0.3648330767314656', 49),
(159, '39.471549224871865', '-0.3546406824748738', 49),
(160, '39.46401217725926', '-0.35815974070241285', 49),
(161, '39.45952269066069', '-0.3422132184692428', 49),
(162, '39.45939015529042', '-0.3323856046386764', 49),
(163, '39.46169442831608', '-0.3279672759576546', 49),
(164, '39.46070043790242', '-0.3242550986810433', 49),
(165, '39.46822929558979', '-0.37977711745383225', 50),
(166, '39.46766608898698', '-0.37709490843893967', 50),
(167, '39.46972011459332', '-0.37091509886862717', 50),
(168, '39.46837506598687', '-0.3796054560768791', 51),
(169, '39.47230081244646', '-0.3796912867653557', 51),
(170, '39.47155543458463', '-0.38393990584494553', 51),
(194, '39.490421434253676', '-0.32550080408155546', 81),
(195, '39.48935001870959', '-0.32558127035200224', 81),
(196, '39.48795602629438', '-0.32575842030432955', 81),
(197, '39.4867406459044', '-0.3259203933984267', 81),
(198, '39.48418845707032', '-0.32641709062685376', 81),
(199, '39.48418038208805', '-0.32549518892687423', 81),
(200, '39.483360647838374', '-0.3248621875993596', 81),
(201, '39.48239180211663', '-0.3247688740355037', 81),
(202, '39.4812760761441', '-0.3247408453471734', 81),
(203, '39.47886399949966', '-0.32463519882082625', 81),
(204, '39.691612491431506', '-0.20422101574324447', 82),
(205, '39.69182714098376', '-0.2024400289573558', 82),
(206, '39.691909698326135', '-0.20104528026961166', 82),
(207, '39.691430864366', '-0.20020843105696517', 82),
(208, '39.46042608046424', '-0.3322103598518944', 83),
(209, '39.460691147007374', '-0.33515006093221666', 83),
(210, '39.46177625264353', '-0.33839491094266316', 83),
(211, '39.459595842547095', '-0.3423645802847042', 83),
(212, '39.45671994805879', '-0.3470148058144096', 83),
(213, '39.45615664831216', '-0.34836663915791544', 83),
(214, '39.45612351289098', '-0.3506840677467826', 83),
(215, '39.4567563208862', '-0.3523652272559863', 83),
(216, '39.455580013909575', '-0.3537277894355517', 83),
(217, '39.45315278246944', '-0.3529720351360899', 83),
(218, '39.46737174759045', '-0.3765368608774389', 84),
(219, '39.47178499146535', '-0.3687359842589899', 84),
(220, '39.47071037026852', '-0.36507480039375206', 84),
(221, '39.468937973757996', '-0.3638624419190206', 84),
(222, '39.46743885548668', '-0.3579079379059591', 84),
(223, '39.465510922515044', '-0.35135408954988234', 84),
(224, '39.45996412389207', '-0.33298287421815065', 84),
(225, '39.455440011525646', '-0.3281821307853039', 84),
(226, '39.45843990340274', '-0.3162203497849303', 84),
(227, '39.467544288405726', '-0.376817382427328', 85),
(228, '39.47183449013685', '-0.36877075538265025', 85),
(229, '39.473663007921154', '-0.364916099752044', 85),
(230, '39.48278068608013', '-0.3772596562447572', 85),
(231, '39.47902115382899', '-0.3912975912091188', 85),
(232, '39.477381470397816', '-0.3935291891095094', 85),
(284, '39.47827938931226', '-0.4191726953839403', 98),
(285, '39.477550638121144', '-0.41829293082705554', 98),
(286, '39.47774938920315', '-0.41651194404116687', 98),
(287, '39.477815639437644', '-0.41470949958315906', 98);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reaction`
--

CREATE TABLE `reaction` (
  `id` int NOT NULL,
  `likenumber` int NOT NULL,
  `id_user` int NOT NULL,
  `id_route` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `reaction`
--

INSERT INTO `reaction` (`id`, `likenumber`, `id_user`, `id_route`) VALUES
(1, 1, 4713, 50),
(2, 1, 1, 51),
(46, 1, 4714, 48),
(48, 1, 4714, 50),
(55, 1, 4718, 84),
(56, 1, 4714, 84),
(57, 1, 4714, 49),
(58, 1, 4714, 47),
(64, 1, 4862, 50),
(65, 1, 4862, 48),
(66, 1, 4862, 81);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `route`
--

CREATE TABLE `route` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `dificulty` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `time` time NOT NULL,
  `id_user` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `route`
--

INSERT INTO `route` (`id`, `name`, `dificulty`, `time`, `id_user`) VALUES
(47, 'defecto1', 'Easy', '00:30:00', 1),
(48, 'default2', 'Medium', '01:00:00', 1),
(49, 'default3', 'Hard', '01:30:00', 1),
(50, 'probandocards', 'Hard', '01:00:00', 4713),
(51, 'pruebahora', 'Easy', '00:30:00', 4715),
(81, 'Create user', 'Hard', '01:00:00', 4714),
(82, 'rogberjgbjer', 'Hard', '18:12:20', 4714),
(83, 'errorforms', 'Hard', '00:30:00', 4714),
(84, 'Enruteame', 'Hard', '01:00:00', 4718),
(85, 'Rutaprueba', 'Medium', '01:00:00', 4714),
(98, 'prueba1', 'Hard', '01:00:00', 4862);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `team`
--

CREATE TABLE `team` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `creationdate` datetime NOT NULL,
  `id_user` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `team`
--

INSERT INTO `team` (`id`, `name`, `creationdate`, `id_user`) VALUES
(1, 'Not Team Yet', '2023-01-10 20:01:48', 1),
(316, 'Rollmetal1767077', '2023-02-02 20:08:47', 4802),
(317, 'Rolldanger254658', '2023-02-02 20:08:47', 4764),
(318, 'Rollstar69431', '2023-02-02 20:08:47', 4768),
(326, 'Rollsimple252551', '2023-02-03 14:04:20', 4717),
(327, 'Rollazos263761', '2023-02-03 14:04:21', 4713),
(328, 'Rollazos265387', '2023-02-03 14:04:21', 4748),
(329, 'Rolldanger280564', '2023-02-03 14:04:21', 4760),
(330, 'Rolleros128666', '2023-02-03 14:04:21', 4767),
(331, 'Rollstar45685', '2023-02-03 14:04:21', 4796),
(332, 'Rollroll178509', '2023-02-03 14:04:21', 4751),
(333, 'Rollphisical259571', '2023-02-03 14:04:21', 4807),
(336, 'Rollstar220142', '2023-02-03 14:15:32', 4795),
(337, 'Rollphisical65947', '2023-02-03 14:15:32', 4719),
(338, 'Rollroll221170', '2023-02-03 14:15:32', 4783),
(339, 'Rollsimple217140', '2023-02-03 14:15:32', 4763),
(340, 'Rolleros17042', '2023-02-03 14:15:32', 4755),
(341, 'Rolldanger194494', '2023-02-03 14:15:32', 4810),
(342, 'Rollazos14414', '2023-02-03 14:15:32', 4809),
(343, 'Rollstar136231', '2023-02-03 14:15:32', 4762),
(345, 'Rollsimple96540', '2023-02-03 14:15:33', 4805);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `surname1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `surname2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `datebirth` date NOT NULL,
  `gender` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'rollinter2022',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `id_usertype` bigint NOT NULL DEFAULT '2',
  `id_team` bigint NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`id`, `name`, `surname1`, `surname2`, `datebirth`, `gender`, `username`, `password`, `email`, `id_usertype`, `id_team`) VALUES
(1, 'estefania', 'borikos', 'laenos', '1999-01-15', 'Woman', 'esborlan', 'rollinter2022', 'esborlan@rollinter.com', 1, 1),
(4713, 'Jose Maria', 'Rodríguez', 'Benavent', '1959-02-21', 'Woman', 'jose mariarodríguez108093', 'Rollinter2022', 'jose mariarodríguez108093@rollinter.net', 2, 327),
(4714, 'Ruben', 'Carrascosa', 'Castellosi', '1943-01-31', 'Man', 'rubencarrascosa10010', 'Rollinter2022', 'rubencarrascosa10010@rollinter.net', 2, 1),
(4715, 'Kevin', 'Soler', 'Morera', '1957-01-07', 'Woman', 'kevinsoler36684', 'Rollinter2022', 'kevinsoler36684@rollinter.net', 2, 336),
(4716, 'Karim', 'Blanco', 'Morera', '1962-09-20', 'Woman', 'karimblanco203478', 'Rollinter2022', 'karimblanco203478@rollinter.net', 2, 336),
(4717, 'Kevin', 'Talaya', 'Bañuls', '1946-10-12', 'Woman', 'kevintalaya12027', 'Rollinter2022', 'kevintalaya12027@rollinter.net', 2, 326),
(4718, 'Elliot', 'Lazaro', 'Castello', '2006-07-10', 'Woman', 'elliotlazaro152727', 'Rollinter2022', 'elliotlazaro152727@rollinter.net', 2, 1),
(4719, 'Jose Maria', 'Perez', 'Fernández', '2002-01-01', 'Man', 'jose mariaperez49617', 'Rollinter2022', 'jose mariaperez49617@rollinter.net', 2, 337),
(4720, 'Jose Maria', 'Tomas', 'Ríos', '1988-12-21', 'Man', 'jose mariatomas212244', 'Rollinter2022', 'jose mariatomas212244@rollinter.net', 2, 338),
(4721, 'Karim', 'Perez', 'Fernández', '1998-01-08', 'Man', 'karimperez284821', 'Rollinter2022', 'karimperez284821@rollinter.net', 2, 338),
(4722, 'Estefania', 'Perez', 'Bañuls', '1985-12-05', 'Man', 'estefaniaperez200719', 'Rollinter2022', 'estefaniaperez200719@rollinter.net', 2, 337),
(4723, 'Estefania', 'Soler', 'Morera', '1992-02-02', 'Woman', 'estefaniasoler51178', 'Rollinter2022', 'estefaniasoler51178@rollinter.net', 2, 339),
(4724, 'Elliot', 'Soler', 'Ríos', '1947-09-26', 'Woman', 'elliotsoler147109', 'Rollinter2022', 'elliotsoler147109@rollinter.net', 2, 336),
(4725, 'Mario', 'Rodríguez', 'Morera', '1936-07-04', 'Man', 'mariorodríguez223557', 'Rollinter2022', 'mariorodríguez223557@rollinter.net', 2, 336),
(4726, 'Nerea', 'Luque', 'Mourad', '2002-12-19', 'Woman', 'nerealuque156159', 'Rollinter2022', 'nerealuque156159@rollinter.net', 2, 339),
(4727, 'Elliot', 'Suay', 'Castello', '1959-07-20', 'Man', 'elliotsuay211566', 'Rollinter2022', 'elliotsuay211566@rollinter.net', 2, 336),
(4728, 'Cristina', 'Perez', 'Zanon', '1993-02-24', 'Woman', 'cristinaperez264190', 'Rollinter2022', 'cristinaperez264190@rollinter.net', 2, 336),
(4729, 'Ximo', 'Vilar', 'Torres', '1959-07-23', 'Man', 'ximovilar221970', 'Rollinter2022', 'ximovilar221970@rollinter.net', 2, 338),
(4730, 'Jose Maria', 'Vilar', 'Patricio', '1991-07-19', 'Man', 'jose mariavilar181278', 'Rollinter2022', 'jose mariavilar181278@rollinter.net', 2, 336),
(4731, 'Karim', 'Rodríguez', 'Zanon', '1930-10-19', 'Man', 'karimrodríguez290333', 'Rollinter2022', 'karimrodríguez290333@rollinter.net', 2, 337),
(4732, 'Iris', 'Blanco', 'Laenos', '1936-04-29', 'Man', 'irisblanco295218', 'Rollinter2022', 'irisblanco295218@rollinter.net', 2, 337),
(4733, 'Raimon', 'Talaya', 'Patricio', '1963-01-10', 'Woman', 'raimontalaya237622', 'Rollinter2022', 'raimontalaya237622@rollinter.net', 2, 336),
(4734, 'Nerea', 'Boriko', 'Sanchis', '1982-02-01', 'Man', 'nereaboriko285385', 'Rollinter2022', 'nereaboriko285385@rollinter.net', 2, 336),
(4735, 'Karim', 'Suay', 'Benavent', '1943-10-18', 'Woman', 'karimsuay129694', 'Rollinter2022', 'karimsuay129694@rollinter.net', 2, 1),
(4736, 'Ximo', 'Soler', 'Sanchez', '1931-04-21', 'Woman', 'ximosoler286653', 'Rollinter2022', 'ximosoler286653@rollinter.net', 2, 338),
(4737, 'Estefania', 'Soler', 'Benavent', '1991-05-29', 'Man', 'estefaniasoler66930', 'Rollinter2022', 'estefaniasoler66930@rollinter.net', 2, 336),
(4738, 'Nerea', 'Suay', 'Zanon', '1932-06-28', 'Woman', 'nereasuay179486', 'Rollinter2022', 'nereasuay179486@rollinter.net', 2, 337),
(4739, 'Ximo', 'Rezgaoui', 'Gyori', '1996-01-10', 'Man', 'ximorezgaoui231656', 'Rollinter2022', 'ximorezgaoui231656@rollinter.net', 2, 336),
(4740, 'Karim', 'Guerrero', 'Laenos', '1989-11-08', 'Man', 'karimguerrero217471', 'Rollinter2022', 'karimguerrero217471@rollinter.net', 2, 339),
(4741, 'Iris', 'Boriko', 'Benavent', '1983-11-25', 'Man', 'irisboriko208998', 'Rollinter2022', 'irisboriko208998@rollinter.net', 2, 337),
(4742, 'Lucas Ezequiel', 'Lazaro', 'Morera', '1987-10-09', 'Man', 'lucas ezequiellazaro101238', 'Rollinter2022', 'lucas ezequiellazaro101238@rollinter.net', 2, 336),
(4743, 'Jose David', 'Perez', 'Benavent', '1986-12-24', 'Man', 'jose davidperez27566', 'Rollinter2022', 'jose davidperez27566@rollinter.net', 2, 336),
(4744, 'Elliot', 'Rezgaoui', 'Laenos', '1982-08-27', 'Man', 'elliotrezgaoui40483', 'Rollinter2022', 'elliotrezgaoui40483@rollinter.net', 2, 337),
(4745, 'Ainhoa', 'Carrascosa', 'Patricio', '1937-10-26', 'Woman', 'ainhoacarrascosa139036', 'Rollinter2022', 'ainhoacarrascosa139036@rollinter.net', 2, 342),
(4746, 'Cristina', 'Gyori', 'Ríos', '1951-02-23', 'Woman', 'cristinagyori135670', 'Rollinter2022', 'cristinagyori135670@rollinter.net', 2, 338),
(4747, 'Mario', 'Suay', 'Fernández', '1971-05-06', 'Woman', 'mariosuay3731', 'Rollinter2022', 'mariosuay3731@rollinter.net', 2, 338),
(4748, 'Kevin', 'Rodríguez', 'Pascual', '1933-05-29', 'Man', 'kevinrodríguez254212', 'Rollinter2022', 'kevinrodríguez254212@rollinter.net', 2, 328),
(4749, 'Jose David', 'Talaya', 'Hurtado', '1928-11-16', 'Woman', 'jose davidtalaya244527', 'Rollinter2022', 'jose davidtalaya244527@rollinter.net', 2, 338),
(4750, 'Luis Fernando', 'Perez', 'Benavent', '1963-05-10', 'Woman', 'luis fernandoperez30775', 'Rollinter2022', 'luis fernandoperez30775@rollinter.net', 2, 338),
(4751, 'Luis Fernando', 'Carrascosa', 'Ríos', '1929-06-07', 'Woman', 'luis fernandocarrascosa187084', 'Rollinter2022', 'luis fernandocarrascosa187084@rollinter.net', 2, 332),
(4752, 'Ruben', 'Rosales', 'Luz', '1924-03-11', 'Woman', 'rubenrosales134403', 'Rollinter2022', 'rubenrosales134403@rollinter.net', 2, 338),
(4753, 'Luis Fernando', 'Talaya', 'Torres', '1966-12-23', 'Woman', 'luis fernandotalaya184157', 'Rollinter2022', 'luis fernandotalaya184157@rollinter.net', 2, 338),
(4754, 'Ximo', 'Rezgaoui', 'Sanchis', '2006-09-25', 'Woman', 'ximorezgaoui56270', 'Rollinter2022', 'ximorezgaoui56270@rollinter.net', 2, 338),
(4755, 'Ainhoa', 'Vilar', 'Fernández', '1938-03-26', 'Man', 'ainhoavilar61718', 'Rollinter2022', 'ainhoavilar61718@rollinter.net', 2, 340),
(4756, 'Jose David', 'Tomas', 'Bañuls', '1927-09-15', 'Man', 'jose davidtomas209651', 'Rollinter2022', 'jose davidtomas209651@rollinter.net', 2, 338),
(4757, 'Iris', 'Soler', 'Bañuls', '1965-06-21', 'Woman', 'irissoler262931', 'Rollinter2022', 'irissoler262931@rollinter.net', 2, 341),
(4758, 'Estefania', 'Perez', 'Luz', '1970-01-05', 'Woman', 'estefaniaperez230788', 'Rollinter2022', 'estefaniaperez230788@rollinter.net', 2, 338),
(4759, 'Cristina', 'Perez', 'Ríos', '1958-01-10', 'Woman', 'cristinaperez14254', 'Rollinter2022', 'cristinaperez14254@rollinter.net', 2, 338),
(4760, 'Carlos', 'Perez', 'Pascual', '2008-06-17', 'Woman', 'carlosperez151631', 'Rollinter2022', 'carlosperez151631@rollinter.net', 2, 329),
(4761, 'Karim', 'Luque', 'Benavent', '1968-07-12', 'Woman', 'karimluque15599', 'Rollinter2022', 'karimluque15599@rollinter.net', 2, 339),
(4762, 'Alvaro', 'Vilar', 'Pascual', '1989-10-10', 'Man', 'alvarovilar91806', 'Rollinter2022', 'alvarovilar91806@rollinter.net', 2, 343),
(4763, 'Luis', 'Boriko', 'Benavent', '1973-09-30', 'Man', 'luisboriko281873', 'Rollinter2022', 'luisboriko281873@rollinter.net', 2, 339),
(4764, 'Karim', 'Rosales', 'Gyori', '1965-08-01', 'Man', 'karimrosales214563', 'Rollinter2022', 'karimrosales214563@rollinter.net', 2, 317),
(4765, 'Kevin', 'Vilar', 'Castello', '1978-05-06', 'Woman', 'kevinvilar174917', 'Rollinter2022', 'kevinvilar174917@rollinter.net', 2, 340),
(4766, 'Lucas Ezequiel', 'Perez', 'Sanchez', '1932-03-08', 'Man', 'lucas ezequielperez284418', 'Rollinter2022', 'lucas ezequielperez284418@rollinter.net', 2, 338),
(4767, 'Alexis', 'Soler', 'Romance', '1959-03-28', 'Man', 'alexissoler6392', 'Rollinter2022', 'alexissoler6392@rollinter.net', 2, 330),
(4768, 'Iris', 'Soler', 'Pascual', '1960-12-08', 'Man', 'irissoler298478', 'Rollinter2022', 'irissoler298478@rollinter.net', 2, 318),
(4769, 'Cristina', 'Gyori', 'Sanchis', '1967-07-31', 'Woman', 'cristinagyori118642', 'Rollinter2022', 'cristinagyori118642@rollinter.net', 2, 338),
(4770, 'Carlos', 'Talaya', 'Blayimir', '1975-03-08', 'Man', 'carlostalaya99159', 'Rollinter2022', 'carlostalaya99159@rollinter.net', 2, 338),
(4771, 'Carlos', 'Perez', 'Castello', '1946-02-22', 'Woman', 'carlosperez167422', 'Rollinter2022', 'carlosperez167422@rollinter.net', 2, 339),
(4772, 'Ruben', 'Luque', 'Hurtado', '1977-01-11', 'Woman', 'rubenluque94264', 'Rollinter2022', 'rubenluque94264@rollinter.net', 2, 339),
(4773, 'Estefania', 'Luque', 'Luz', '1986-10-08', 'Woman', 'estefanialuque228445', 'Rollinter2022', 'estefanialuque228445@rollinter.net', 2, 338),
(4774, 'Karim', 'Luque', 'Patricio', '1945-09-15', 'Man', 'karimluque235719', 'Rollinter2022', 'karimluque235719@rollinter.net', 2, 341),
(4775, 'Jose David', 'Rodríguez', 'Morera', '2008-10-05', 'Man', 'jose davidrodríguez103730', 'Rollinter2022', 'jose davidrodríguez103730@rollinter.net', 2, 338),
(4776, 'Ruben', 'Gyori', 'Torres', '1987-10-03', 'Man', 'rubengyori95937', 'Rollinter2022', 'rubengyori95937@rollinter.net', 2, 341),
(4777, 'Nerea', 'Perez', 'Ríos', '2008-05-18', 'Man', 'nereaperez24549', 'Rollinter2022', 'nereaperez24549@rollinter.net', 2, 339),
(4778, 'Kevin', 'Soler', 'Torres', '1936-01-22', 'Man', 'kevinsoler119756', 'Rollinter2022', 'kevinsoler119756@rollinter.net', 2, 338),
(4779, 'Raimon', 'Rezgaoui', 'Ríos', '1969-09-20', 'Woman', 'raimonrezgaoui83809', 'Rollinter2022', 'raimonrezgaoui83809@rollinter.net', 2, 338),
(4780, 'Elliot', 'Soler', 'Bañuls', '1925-03-29', 'Woman', 'elliotsoler153832', 'Rollinter2022', 'elliotsoler153832@rollinter.net', 2, 338),
(4781, 'Jose Maria', 'Soler', 'Luz', '1975-06-01', 'Man', 'jose mariasoler272299', 'Rollinter2022', 'jose mariasoler272299@rollinter.net', 2, 338),
(4782, 'Ruben', 'Soler', 'Romance', '1996-12-27', 'Man', 'rubensoler55631', 'Rollinter2022', 'rubensoler55631@rollinter.net', 2, 340),
(4783, 'Carlos', 'Rosales', 'Castello', '1931-05-14', 'Man', 'carlosrosales210526', 'Rollinter2022', 'carlosrosales210526@rollinter.net', 2, 338),
(4784, 'Jose Maria', 'Soler', 'Hurtado', '1999-01-06', 'Woman', 'jose mariasoler46907', 'Rollinter2022', 'jose mariasoler46907@rollinter.net', 2, 339),
(4785, 'Nerea', 'Benito', 'Laenos', '1939-11-16', 'Woman', 'nereabenito47414', 'Rollinter2022', 'nereabenito47414@rollinter.net', 2, 343),
(4786, 'Alexis', 'Vilar', 'Torres', '1951-01-20', 'Woman', 'alexisvilar40857', 'Rollinter2022', 'alexisvilar40857@rollinter.net', 2, 340),
(4787, 'Iris', 'Soler', 'Blayimir', '1978-04-26', 'Man', 'irissoler92425', 'Rollinter2022', 'irissoler92425@rollinter.net', 2, 1),
(4788, 'Luis', 'Benito', 'Gyori', '1986-02-14', 'Woman', 'luisbenito126004', 'Rollinter2022', 'luisbenito126004@rollinter.net', 2, 339),
(4789, 'Iris', 'Luque', 'Benavent', '2001-09-20', 'Man', 'irisluque38059', 'Rollinter2022', 'irisluque38059@rollinter.net', 2, 340),
(4790, 'Alvaro', 'Guerrero', 'Blayimir', '1985-08-23', 'Man', 'alvaroguerrero115534', 'Rollinter2022', 'alvaroguerrero115534@rollinter.net', 2, 339),
(4791, 'Alvaro', 'Talaya', 'Sanchis', '2006-12-09', 'Man', 'alvarotalaya151589', 'Rollinter2022', 'alvarotalaya151589@rollinter.net', 2, 339),
(4792, 'Ximo', 'Rezgaoui', 'Hurtado', '1974-02-06', 'Man', 'ximorezgaoui129779', 'Rollinter2022', 'ximorezgaoui129779@rollinter.net', 2, 338),
(4793, 'Cristina', 'Vilar', 'Zanon', '2007-01-19', 'Woman', 'cristinavilar228570', 'Rollinter2022', 'cristinavilar228570@rollinter.net', 2, 343),
(4794, 'Alexis', 'Benito', 'Laenos', '1935-01-07', 'Woman', 'alexisbenito280183', 'Rollinter2022', 'alexisbenito280183@rollinter.net', 2, 339),
(4795, 'Lucas Ezequiel', 'Perez', 'Bañuls', '1947-05-12', 'Woman', 'lucas ezequielperez18786', 'Rollinter2022', 'lucas ezequielperez18786@rollinter.net', 2, 336),
(4796, 'Nerea', 'Tomas', 'Benavent', '1932-12-25', 'Man', 'nereatomas144594', 'Rollinter2022', 'nereatomas144594@rollinter.net', 2, 331),
(4797, 'Alvaro', 'Perez', 'Sanchis', '1976-07-15', 'Woman', 'alvaroperez67525', 'Rollinter2022', 'alvaroperez67525@rollinter.net', 2, 340),
(4798, 'Karim', 'Boriko', 'Sanchez', '1946-05-30', 'Woman', 'karimboriko192499', 'Rollinter2022', 'karimboriko192499@rollinter.net', 2, 1),
(4799, 'Luis Fernando', 'Vilar', 'Benavent', '1929-10-14', 'Man', 'luis fernandovilar272545', 'Rollinter2022', 'luis fernandovilar272545@rollinter.net', 2, 340),
(4800, 'Cristina', 'Soler', 'Morera', '1943-10-26', 'Man', 'cristinasoler98281', 'Rollinter2022', 'cristinasoler98281@rollinter.net', 2, 340),
(4801, 'Ximo', 'Soler', 'Romance', '1972-07-06', 'Woman', 'ximosoler8469', 'Rollinter2022', 'ximosoler8469@rollinter.net', 2, 340),
(4802, 'Alvaro', 'Suay', 'Bañuls', '1943-12-19', 'Man', 'alvarosuay10935', 'Rollinter2022', 'alvarosuay10935@rollinter.net', 2, 316),
(4803, 'Jose Maria', 'Perez', 'Benavent', '1941-11-01', 'Woman', 'jose mariaperez250956', 'Rollinter2022', 'jose mariaperez250956@rollinter.net', 2, 1),
(4804, 'Ruben', 'Perez', 'Blayimir', '1986-03-11', 'Man', 'rubenperez20661', 'Rollinter2022', 'rubenperez20661@rollinter.net', 2, 1),
(4805, 'Carlos', 'Perez', 'Pascual', '1969-04-05', 'Woman', 'carlosperez130630', 'Rollinter2022', 'carlosperez130630@rollinter.net', 2, 345),
(4806, 'Cristina', 'Talaya', 'Ríos', '1969-04-01', 'Man', 'cristinatalaya120469', 'Rollinter2022', 'cristinatalaya120469@rollinter.net', 2, 1),
(4807, 'Lucas Ezequiel', 'Boriko', 'Sanchis', '2005-06-18', 'Man', 'lucas ezequielboriko95704', 'Rollinter2022', 'lucas ezequielboriko95704@rollinter.net', 2, 333),
(4808, 'Lucas Ezequiel', 'Rodríguez', 'Blayimir', '1932-05-06', 'Man', 'lucas ezequielrodríguez70806', 'Rollinter2022', 'lucas ezequielrodríguez70806@rollinter.net', 2, 345),
(4809, 'Ruben', 'Boriko', 'Sanchez', '1926-12-21', 'Man', 'rubenboriko56705', 'Rollinter2022', 'rubenboriko56705@rollinter.net', 2, 342),
(4810, 'Iris', 'Soler', 'Benavent', '1951-09-29', 'Man', 'irissoler264251', 'Rollinter2022', 'irissoler264251@rollinter.net', 2, 341),
(4811, 'Jose Maria', 'Benito', 'Luz', '1961-12-26', 'Woman', 'jose mariabenito81580', 'Rollinter2022', 'jose mariabenito81580@rollinter.net', 2, 1),
(4812, 'Jose David', 'Rosales', 'Benavent', '1937-08-28', 'Man', 'jose davidrosales34556', 'Rollinter2022', 'jose davidrosales34556@rollinter.net', 2, 1),
(4813, 'Alexis', 'Tomas', 'Pascual', '1966-10-10', 'Woman', 'alexistomas83044', 'Rollinter2022', 'alexistomas83044@rollinter.net', 2, 317),
(4814, 'Lucas Ezequiel', 'Perez', 'Zanon', '1952-07-31', 'Woman', 'lucas ezequielperez189182', 'Rollinter2022', 'lucas ezequielperez189182@rollinter.net', 2, 345),
(4815, 'Elliot', 'Rosales', 'Ríos', '1958-03-31', 'Woman', 'elliotrosales109536', 'Rollinter2022', 'elliotrosales109536@rollinter.net', 2, 331),
(4816, 'Iris', 'Rezgaoui', 'Blayimir', '1996-09-14', 'Woman', 'irisrezgaoui62695', 'Rollinter2022', 'irisrezgaoui62695@rollinter.net', 2, 318),
(4817, 'Cristina', 'Blanco', 'Ríos', '2000-10-29', 'Woman', 'cristinablanco254710', 'Rollinter2022', 'cristinablanco254710@rollinter.net', 2, 318),
(4818, 'Nerea', 'Soler', 'Bañuls', '1990-04-09', 'Woman', 'nereasoler159229', 'Rollinter2022', 'nereasoler159229@rollinter.net', 2, 1),
(4819, 'Lucas Ezequiel', 'Suay', 'Benavent', '1925-04-23', 'Woman', 'lucas ezequielsuay291671', 'Rollinter2022', 'lucas ezequielsuay291671@rollinter.net', 2, 1),
(4820, 'Alvaro', 'Talaya', 'Benavent', '1975-08-08', 'Woman', 'alvarotalaya35894', 'Rollinter2022', 'alvarotalaya35894@rollinter.net', 2, 341),
(4821, 'Luis Fernando', 'Perez', 'Morera', '1934-12-28', 'Man', 'luis fernandoperez220047', 'Rollinter2022', 'luis fernandoperez220047@rollinter.net', 2, 331),
(4822, 'Ainhoa', 'Guerrero', 'Bañuls', '1952-04-14', 'Woman', 'ainhoaguerrero223746', 'Rollinter2022', 'ainhoaguerrero223746@rollinter.net', 2, 1),
(4823, 'Iris', 'Tomas', 'Castello', '1976-12-20', 'Woman', 'iristomas179629', 'Rollinter2022', 'iristomas179629@rollinter.net', 2, 342),
(4824, 'Nerea', 'Rosales', 'Hurtado', '1950-07-05', 'Man', 'nerearosales289738', 'Rollinter2022', 'nerearosales289738@rollinter.net', 2, 327),
(4825, 'Mario', 'Boriko', 'Pascual', '1947-10-29', 'Man', 'marioboriko131648', 'Rollinter2022', 'marioboriko131648@rollinter.net', 2, 1),
(4826, 'Mario', 'Soler', 'Benavent', '1930-12-13', 'Man', 'mariosoler147049', 'Rollinter2022', 'mariosoler147049@rollinter.net', 2, 338),
(4827, 'Cristina', 'Suay', 'Benavent', '2000-10-30', 'Man', 'cristinasuay263442', 'Rollinter2022', 'cristinasuay263442@rollinter.net', 2, 332),
(4828, 'Estefania', 'Perez', 'Zanon', '1938-04-10', 'Man', 'estefaniaperez179793', 'Rollinter2022', 'estefaniaperez179793@rollinter.net', 2, 340),
(4829, 'Alexis', 'Perez', 'Bañuls', '1930-04-01', 'Woman', 'alexisperez119697', 'Rollinter2022', 'alexisperez119697@rollinter.net', 2, 336),
(4830, 'Kevin', 'Perez', 'Zanon', '1971-09-30', 'Woman', 'kevinperez145438', 'Rollinter2022', 'kevinperez145438@rollinter.net', 2, 316),
(4831, 'Alvaro', 'Suay', 'Zanon', '1963-12-10', 'Man', 'alvarosuay128709', 'Rollinter2022', 'alvarosuay128709@rollinter.net', 2, 338),
(4832, 'Luis', 'Boriko', 'Hurtado', '2006-02-08', 'Man', 'luisboriko99562', 'Rollinter2022', 'luisboriko99562@rollinter.net', 2, 331),
(4833, 'Estefania', 'Rodríguez', 'Pascual', '2002-12-12', 'Woman', 'estefaniarodríguez79631', 'Rollinter2022', 'estefaniarodríguez79631@rollinter.net', 2, 317),
(4834, 'Iris', 'Benito', 'Benavent', '1934-10-01', 'Woman', 'irisbenito996', 'Rollinter2022', 'irisbenito996@rollinter.net', 2, 329),
(4835, 'Ruben', 'Soler', 'Morera', '1950-07-11', 'Woman', 'rubensoler69604', 'Rollinter2022', 'rubensoler69604@rollinter.net', 2, 333),
(4836, 'Alexis', 'Tomas', 'Mourad', '1967-10-03', 'Man', 'alexistomas222675', 'Rollinter2022', 'alexistomas222675@rollinter.net', 2, 337),
(4837, 'Nerea', 'Benito', 'Bañuls', '1925-12-19', 'Woman', 'nereabenito214772', 'Rollinter2022', 'nereabenito214772@rollinter.net', 2, 327),
(4838, 'Carlos', 'Suay', 'Hurtado', '1982-09-27', 'Man', 'carlossuay239486', 'Rollinter2022', 'carlossuay239486@rollinter.net', 2, 1),
(4839, 'Karim', 'Rezgaoui', 'Benavent', '1993-08-18', 'Man', 'karimrezgaoui209097', 'Rollinter2022', 'karimrezgaoui209097@rollinter.net', 2, 318),
(4840, 'Cristina', 'Lazaro', 'Gyori', '1987-05-12', 'Woman', 'cristinalazaro153580', 'Rollinter2022', 'cristinalazaro153580@rollinter.net', 2, 331),
(4841, 'Nerea', 'Perez', 'Torres', '1925-11-24', 'Man', 'nereaperez202576', 'Rollinter2022', 'nereaperez202576@rollinter.net', 2, 1),
(4842, 'Karim', 'Blanco', 'Torres', '2003-02-12', 'Woman', 'karimblanco125752', 'Rollinter2022', 'karimblanco125752@rollinter.net', 2, 330),
(4843, 'Estefania', 'Talaya', 'Bañuls', '2005-05-21', 'Woman', 'estefaniatalaya39438', 'Rollinter2022', 'estefaniatalaya39438@rollinter.net', 2, 340),
(4844, 'Kevin', 'Perez', 'Laenos', '1982-06-04', 'Man', 'kevinperez146971', 'Rollinter2022', 'kevinperez146971@rollinter.net', 2, 345),
(4845, 'Mario', 'Benito', 'Ríos', '1932-05-20', 'Woman', 'mariobenito284610', 'Rollinter2022', 'mariobenito284610@rollinter.net', 2, 332),
(4846, 'Ainhoa', 'Blanco', 'Fernández', '1925-12-18', 'Woman', 'ainhoablanco202766', 'Rollinter2022', 'ainhoablanco202766@rollinter.net', 2, 338),
(4847, 'Raimon', 'Rosales', 'Gyori', '2003-06-12', 'Man', 'raimonrosales96024', 'Rollinter2022', 'raimonrosales96024@rollinter.net', 2, 336),
(4848, 'Lucas Ezequiel', 'Lazaro', 'Torres', '1984-01-14', 'Man', 'lucas ezequiellazaro88324', 'Rollinter2022', 'lucas ezequiellazaro88324@rollinter.net', 2, 341),
(4849, 'Jose David', 'Rosales', 'Sanchis', '1960-02-18', 'Woman', 'jose davidrosales214085', 'Rollinter2022', 'jose davidrosales214085@rollinter.net', 2, 338),
(4850, 'Carlos', 'Rezgaoui', 'Laenos', '1946-02-04', 'Woman', 'carlosrezgaoui150852', 'Rollinter2022', 'carlosrezgaoui150852@rollinter.net', 2, 339),
(4851, 'Jose Maria', 'Luque', 'Mourad', '1966-03-07', 'Man', 'jose marialuque234253', 'Rollinter2022', 'jose marialuque234253@rollinter.net', 2, 330),
(4852, 'Estefania', 'Rosales', 'Bañuls', '1983-03-21', 'Woman', 'estefaniarosales41708', 'Rollinter2022', 'estefaniarosales41708@rollinter.net', 2, 326),
(4853, 'Ximo', 'Guerrero', 'Mourad', '1980-05-12', 'Man', 'ximoguerrero129500', 'Rollinter2022', 'ximoguerrero129500@rollinter.net', 2, 340),
(4854, 'Ainhoa', 'Soler', 'Patricio', '1924-03-29', 'Man', 'ainhoasoler11710', 'Rollinter2022', 'ainhoasoler11710@rollinter.net', 2, 340),
(4855, 'Elliot', 'Guerrero', 'Zanon', '1965-07-08', 'Woman', 'elliotguerrero66750', 'Rollinter2022', 'elliotguerrero66750@rollinter.net', 2, 332),
(4856, 'Jose Maria', 'Tomas', 'Fernández', '1933-09-01', 'Woman', 'jose mariatomas69835', 'Rollinter2022', 'jose mariatomas69835@rollinter.net', 2, 343),
(4857, 'Carlos', 'Talaya', 'Mourad', '1934-10-14', 'Man', 'carlostalaya246551', 'Rollinter2022', 'carlostalaya246551@rollinter.net', 2, 316),
(4858, 'Kevin', 'Soler', 'Benavent', '1942-05-08', 'Man', 'kevinsoler282382', 'Rollinter2022', 'kevinsoler282382@rollinter.net', 2, 337),
(4859, 'Elliot', 'Talaya', 'Hurtado', '1932-04-13', 'Man', 'elliottalaya118969', 'Rollinter2022', 'elliottalaya118969@rollinter.net', 2, 330),
(4860, 'Alexis', 'Guerrero', 'Morera', '1978-01-17', 'Woman', 'alexisguerrero110883', 'Rollinter2022', 'alexisguerrero110883@rollinter.net', 2, 336),
(4861, 'Estefania', 'Guerrero', 'Torres', '1927-05-25', 'Man', 'estefaniaguerrero78571', 'Rollinter2022', 'estefaniaguerrero78571@rollinter.net', 2, 327),
(4862, 'Rafael', 'Perez', 'Benavent', '1958-01-10', 'Woman', 'estefaniaperez204379', 'Rollinter2022', 'estefaniaperez204379@rollinter.net', 2, 345),
(4863, 'Jose Maria', 'Talaya', 'Luz', '1962-04-20', 'Man', 'jose mariatalaya133874', 'Rollinter2022', 'jose mariatalaya133874@rollinter.net', 2, 317),
(4864, 'Elliot', 'Carrascosa', 'Romance', '1950-06-29', 'Woman', 'elliotcarrascosa49935', 'Rollinter2022', 'elliotcarrascosa49935@rollinter.net', 2, 341),
(4865, 'Lucas Ezequiel', 'Perez', 'Mourad', '2002-04-22', 'Woman', 'lucas ezequielperez184968', 'Rollinter2022', 'lucas ezequielperez184968@rollinter.net', 2, 329),
(4866, 'Mario', 'Gyori', 'Patricio', '1962-10-15', 'Woman', 'mariogyori246597', 'Rollinter2022', 'mariogyori246597@rollinter.net', 2, 1),
(4867, 'Kevin', 'Lazaro', 'Torres', '1959-01-09', 'Man', 'kevinlazaro251092', 'Rollinter2022', 'kevinlazaro251092@rollinter.net', 2, 1),
(4868, 'Luis', 'Carrascosa', 'Ríos', '1929-03-03', 'Woman', 'luiscarrascosa25317', 'Rollinter2022', 'luiscarrascosa25317@rollinter.net', 2, 331),
(4869, 'Luis', 'Soler', 'Patricio', '1942-05-08', 'Man', 'luissoler197176', 'Rollinter2022', 'luissoler197176@rollinter.net', 2, 328),
(4870, 'Ximo', 'Gyori', 'Sanchis', '1967-08-08', 'Woman', 'ximogyori207287', 'Rollinter2022', 'ximogyori207287@rollinter.net', 2, 1),
(4871, 'Lucas Ezequiel', 'Boriko', 'Castello', '1991-03-02', 'Woman', 'lucas ezequielboriko298593', 'Rollinter2022', 'lucas ezequielboriko298593@rollinter.net', 2, 330),
(4872, 'Cristina', 'Guerrero', 'Torres', '1993-01-23', 'Woman', 'cristinaguerrero130420', 'Rollinter2022', 'cristinaguerrero130420@rollinter.net', 2, 331),
(4873, 'Luis', 'Boriko', 'Sanchez', '1962-11-30', 'Woman', 'luisboriko289069', 'Rollinter2022', 'luisboriko289069@rollinter.net', 2, 345),
(4874, 'Jose Maria', 'Soler', 'Gyori', '1986-12-21', 'Woman', 'jose mariasoler279339', 'Rollinter2022', 'jose mariasoler279339@rollinter.net', 2, 1),
(4875, 'Mario', 'Soler', 'Mourad', '1987-04-13', 'Woman', 'mariosoler26586', 'Rollinter2022', 'mariosoler26586@rollinter.net', 2, 330),
(4876, 'Nerea', 'Rosales', 'Morera', '2001-12-11', 'Woman', 'nerearosales214783', 'Rollinter2022', 'nerearosales214783@rollinter.net', 2, 341),
(4877, 'Cristina', 'Carrascosa', 'Laenos', '2001-03-17', 'Woman', 'cristinacarrascosa73337', 'Rollinter2022', 'cristinacarrascosa73337@rollinter.net', 2, 340),
(4878, 'Luis', 'Talaya', 'Laenos', '2006-10-05', 'Woman', 'luistalaya163254', 'Rollinter2022', 'luistalaya163254@rollinter.net', 2, 336),
(4879, 'Mario', 'Luque', 'Benavent', '1985-12-16', 'Woman', 'marioluque173407', 'Rollinter2022', 'marioluque173407@rollinter.net', 2, 1),
(4880, 'Elliot', 'Guerrero', 'Sanchez', '1943-09-10', 'Woman', 'elliotguerrero275764', 'Rollinter2022', 'elliotguerrero275764@rollinter.net', 2, 337),
(4881, 'Karim', 'Gyori', 'Benavent', '1949-03-15', 'Woman', 'karimgyori237104', 'Rollinter2022', 'karimgyori237104@rollinter.net', 2, 331),
(4882, 'Lucas Ezequiel', 'Perez', 'Laenos', '1939-09-09', 'Man', 'lucas ezequielperez237982', 'Rollinter2022', 'lucas ezequielperez237982@rollinter.net', 2, 343),
(4883, 'Carlos', 'Suay', 'Blayimir', '1997-12-22', 'Woman', 'carlossuay247605', 'Rollinter2022', 'carlossuay247605@rollinter.net', 2, 332),
(4884, 'Alexis', 'Vilar', 'Benavent', '1972-09-13', 'Man', 'alexisvilar71494', 'Rollinter2022', 'alexisvilar71494@rollinter.net', 2, 337),
(4885, 'Cristina', 'Benito', 'Sanchis', '1949-12-05', 'Man', 'cristinabenito16204', 'Rollinter2022', 'cristinabenito16204@rollinter.net', 2, 326),
(4886, 'Estefania', 'Soler', 'Patricio', '1951-01-28', 'Man', 'estefaniasoler107821', 'Rollinter2022', 'estefaniasoler107821@rollinter.net', 2, 316),
(4887, 'Mario', 'Gyori', 'Laenos', '1996-11-26', 'Woman', 'mariogyori3925', 'Rollinter2022', 'mariogyori3925@rollinter.net', 2, 333),
(4888, 'Mario', 'Soler', 'Romance', '1984-03-27', 'Man', 'mariosoler15690', 'Rollinter2022', 'mariosoler15690@rollinter.net', 2, 338),
(4889, 'Iris', 'Perez', 'Romance', '2004-12-11', 'Woman', 'irisperez78224', 'Rollinter2022', 'irisperez78224@rollinter.net', 2, 333),
(4890, 'Kevin', 'Gyori', 'Blayimir', '1939-04-12', 'Woman', 'kevingyori71112', 'Rollinter2022', 'kevingyori71112@rollinter.net', 2, 330),
(4891, 'Lucas Ezequiel', 'Luque', 'Ríos', '1938-04-23', 'Man', 'lucas ezequielluque149248', 'Rollinter2022', 'lucas ezequielluque149248@rollinter.net', 2, 338),
(4892, 'Nerea', 'Benito', 'Benavent', '1944-12-30', 'Man', 'nereabenito69380', 'Rollinter2022', 'nereabenito69380@rollinter.net', 2, 1),
(4893, 'Mario', 'Luque', 'Hurtado', '1997-02-11', 'Man', 'marioluque35025', 'Rollinter2022', 'marioluque35025@rollinter.net', 2, 1),
(4894, 'Luis', 'Perez', 'Pascual', '1979-12-27', 'Man', 'luisperez144607', 'Rollinter2022', 'luisperez144607@rollinter.net', 2, 1),
(4895, 'Jose David', 'Luque', 'Gyori', '1959-05-07', 'Man', 'jose davidluque220575', 'Rollinter2022', 'jose davidluque220575@rollinter.net', 2, 329),
(4896, 'Ximo', 'Perez', 'Romance', '2001-05-26', 'Woman', 'ximoperez167077', 'Rollinter2022', 'ximoperez167077@rollinter.net', 2, 331),
(4897, 'Ximo', 'Carrascosa', 'Sanchez', '1987-05-22', 'Woman', 'ximocarrascosa43483', 'Rollinter2022', 'ximocarrascosa43483@rollinter.net', 2, 1),
(4898, 'Alvaro', 'Soler', 'Castello', '1962-07-31', 'Woman', 'alvarosoler231372', 'Rollinter2022', 'alvarosoler231372@rollinter.net', 2, 329),
(4899, 'Kevin', 'Tomas', 'Fernández', '1972-06-18', 'Woman', 'kevintomas238183', 'Rollinter2022', 'kevintomas238183@rollinter.net', 2, 340),
(4900, 'Luis', 'Suay', 'Sanchis', '1959-04-11', 'Woman', 'luissuay155152', 'Rollinter2022', 'luissuay155152@rollinter.net', 2, 336),
(4901, 'Nerea', 'Perez', 'Morera', '1981-10-11', 'Woman', 'nereaperez155111', 'Rollinter2022', 'nereaperez155111@rollinter.net', 2, 333),
(4902, 'Mario', 'Talaya', 'Sanchez', '1975-10-05', 'Woman', 'mariotalaya82243', 'Rollinter2022', 'mariotalaya82243@rollinter.net', 2, 333),
(4903, 'Iris', 'Perez', 'Sanchis', '1994-10-31', 'Man', 'irisperez121995', 'Rollinter2022', 'irisperez121995@rollinter.net', 2, 332),
(4904, 'Jose David', 'Carrascosa', 'Ríos', '1990-07-28', 'Woman', 'jose davidcarrascosa14115', 'Rollinter2022', 'jose davidcarrascosa14115@rollinter.net', 2, 342),
(4905, 'Alexis', 'Lazaro', 'Torres', '1995-09-08', 'Man', 'alexislazaro6231', 'Rollinter2022', 'alexislazaro6231@rollinter.net', 2, 340),
(4906, 'Alexis', 'Lazaro', 'Castello', '2000-08-29', 'Woman', 'alexislazaro248649', 'Rollinter2022', 'alexislazaro248649@rollinter.net', 2, 338),
(4907, 'Alvaro', 'Rodríguez', 'Morera', '1935-03-23', 'Woman', 'alvarorodríguez278634', 'Rollinter2022', 'alvarorodríguez278634@rollinter.net', 2, 328),
(4908, 'Alexis', 'Vilar', 'Torres', '1978-04-25', 'Woman', 'alexisvilar239401', 'Rollinter2022', 'alexisvilar239401@rollinter.net', 2, 342),
(4909, 'Alexis', 'Perez', 'Patricio', '1958-11-23', 'Man', 'alexisperez177509', 'Rollinter2022', 'alexisperez177509@rollinter.net', 2, 1),
(4910, 'Jose David', 'Boriko', 'Blayimir', '1938-10-09', 'Woman', 'jose davidboriko251756', 'Rollinter2022', 'jose davidboriko251756@rollinter.net', 2, 341),
(4911, 'Carlos', 'Soler', 'Bañuls', '1976-04-28', 'Man', 'carlossoler207807', 'Rollinter2022', 'carlossoler207807@rollinter.net', 2, 340),
(4919, 'Lorena', 'Perez', '', '2003-01-17', 'Woman', 'lorperez', 'Rollinter2022', 'lorenaper@gmail.com', 2, 1),
(4920, 'Estefania', 'Onetwothree', '', '2000-02-18', 'Woman', 'enlacabeza', 'Rollinter2022', 'caramba@unamano.com', 2, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usertype`
--

CREATE TABLE `usertype` (
  `id` bigint NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL
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
-- Indices de la tabla `chatteam`
--
ALTER TABLE `chatteam`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `coordinates`
--
ALTER TABLE `coordinates`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `reaction`
--
ALTER TABLE `reaction`
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
-- AUTO_INCREMENT de la tabla `chatteam`
--
ALTER TABLE `chatteam`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT de la tabla `comment`
--
ALTER TABLE `comment`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `coordinates`
--
ALTER TABLE `coordinates`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=288;

--
-- AUTO_INCREMENT de la tabla `reaction`
--
ALTER TABLE `reaction`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;

--
-- AUTO_INCREMENT de la tabla `route`
--
ALTER TABLE `route`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=99;

--
-- AUTO_INCREMENT de la tabla `team`
--
ALTER TABLE `team`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=360;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4921;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
