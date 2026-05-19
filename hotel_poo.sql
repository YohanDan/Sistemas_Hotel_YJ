-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-05-2026 a las 11:41:17
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `hotel poo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `ID_Administrador` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `documento` varchar(50) DEFAULT NULL,
  `cargo` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`ID_Administrador`, `nombre`, `telefono`, `documento`, `cargo`) VALUES
(1, 'Carlos Herrera', '3124567890', '1023456789', 1),
(2, 'Marta González', '3209876543', '1098765432', 1),
(3, 'Jorge Ramírez', '3151234567', '1012345678', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `ID_Cliente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `documento` varchar(50) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `tipoCliente` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`ID_Cliente`, `nombre`, `documento`, `telefono`, `tipoCliente`) VALUES
(2015, 'Pedro Lopez', '1001234567', '3109876543', 1),
(2016, 'Maria Torres', '1002234567', '3112345678', 1),
(2017, 'Carlos Ramirez', '1003234567', '3123456789', 1),
(2018, 'Jose Martinez', '1004234567', '3134567890', 1),
(2019, 'Luis Fernandez', '1005234567', '3145678901', 1),
(2020, 'Andres Suarez', '1006234567', '3156789012', 1),
(2021, 'Jorge Castillo', '1007234567', '3167890123', 1),
(2022, 'Sofia Herrera', '1008234567', '3178901234', 1),
(2023, 'Camilo Rojas', '1009234567', '3189012345', 1),
(2024, 'Daniel Gomez', '1010234567', '3190123456', 0),
(2105, 'Laura Mendoza', '1983746521', '3154827391', 1),
(2106, 'Andres Castillo', '1457283916', '3028475619', 1),
(2107, 'Sofia Herrera', '1765438291', '3182947563', 1),
(2108, 'Julian Vargas', '1348291756', '3116754829', 1),
(2109, 'Camila Rojas', '1657382940', '3209483756', 1),
(2110, 'Daniel Ortega', '1938475620', '3047561829', 1),
(2111, 'Valentina Cruz', '1283746591', '3193847562', 1),
(2112, 'Mateo Silva', '1574839201', '3019283746', 0),
(2113, 'Isabella Moreno', '1847562910', '3174658293', 1),
(2114, 'Sebastian Pineda', '1329485761', '3148293756', 1),
(2115, 'Gabriela Ruiz', '1675849302', '3008475612', 1),
(2116, 'Nicolas Castro', '1948573621', '3219384756', 1),
(2117, 'Paula Jimenez', '1263948570', '3165748392', 1),
(2118, 'Felipe Navarro', '1738495620', '3059384721', 1),
(2119, 'Daniela Gomez', '1492837561', '3138475629', 1),
(2120, 'Samuel Medina', '1864759203', '3229483751', 1),
(2121, 'Alejandra Leon', '1548392760', '3084756291', 1),
(2122, 'Juan Esteban Diaz', '1973648521', '3129384756', 1),
(2123, 'Natalia Fuentes', '1428573960', '3038475619', 1),
(2124, 'David Cardenas', '1683927451', '3184756293', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `ID_Habitacion` int(11) NOT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `habitacion`
--

INSERT INTO `habitacion` (`ID_Habitacion`, `numero`, `tipo`, `estado`, `precio`) VALUES
(57, '101', 'Individual', 'Reservado', 90000.00),
(58, '102', 'Individual', 'Disponible', 90000.00),
(59, '103', 'Individual', 'Disponible', 90000.00),
(60, '104', 'Individual', 'Disponible', 90000.00),
(61, '105', 'Doble', 'Disponible', 150000.00),
(62, '106', 'Doble', 'Reservado', 150000.00),
(63, '107', 'Doble', 'Disponible', 150000.00),
(64, '108', 'Doble', 'Disponible', 150000.00),
(65, '109', 'Familiar', 'Disponible', 200000.00),
(66, '110', 'Familiar', 'Disponible', 200000.00),
(67, '111', 'Familiar', 'Disponible', 200000.00),
(68, '112', 'Familiar', 'Disponible', 200000.00),
(69, '201', 'Individual', 'Disponible', 90000.00),
(70, '202', 'Individual', 'Disponible', 90000.00),
(71, '203', 'Individual', 'Reservado', 90000.00),
(72, '204', 'Individual', 'Reservado', 90000.00),
(73, '205', 'Doble', 'Disponible', 150000.00),
(74, '206', 'Doble', 'Disponible', 150000.00),
(75, '207', 'Doble', 'Disponible', 150000.00),
(76, '208', 'Doble', 'Disponible', 150000.00),
(77, '209', 'Familiar', 'Reservado', 200000.00),
(78, '210', 'Familiar', 'Disponible', 200000.00),
(79, '211', 'Familiar', 'Disponible', 200000.00),
(80, '212', 'Familiar', 'Disponible', 200000.00),
(81, '301', 'Individual', 'Disponible', 90000.00),
(82, '302', 'Individual', 'Disponible', 90000.00),
(83, '303', 'Individual', 'Disponible', 90000.00),
(84, '304', 'Individual', 'Reservado', 90000.00),
(85, '305', 'Doble', 'Disponible', 150000.00),
(86, '306', 'Doble', 'Disponible', 150000.00),
(87, '307', 'Doble', 'Disponible', 150000.00),
(88, '308', 'Doble', 'Disponible', 150000.00),
(89, '309', 'Familiar', 'Disponible', 200000.00),
(90, '310', 'Familiar', 'Reservado', 200000.00),
(91, '311', 'Familiar', 'Disponible', 200000.00),
(92, '312', 'Familiar', 'Disponible', 200000.00),
(93, '401', 'Individual', 'Disponible', 90000.00),
(94, '402', 'Individual', 'Disponible', 90000.00),
(95, '403', 'Individual', 'Disponible', 90000.00),
(96, '404', 'Individual', 'Disponible', 90000.00),
(97, '405', 'Doble', 'Disponible', 150000.00),
(98, '406', 'Doble', 'Disponible', 150000.00),
(99, '407', 'Doble', 'Disponible', 150000.00),
(100, '408', 'Doble', 'Disponible', 150000.00),
(101, '409', 'Familiar', 'Disponible', 200000.00),
(102, '410', 'Familiar', 'Disponible', 200000.00),
(103, '411', 'Familiar', 'Disponible', 200000.00),
(104, '412', 'Familiar', 'Disponible', 200000.00),
(105, '501', 'Individual', 'Disponible', 90000.00),
(106, '502', 'Individual', 'Disponible', 90000.00),
(107, '503', 'Individual', 'Reservado', 90000.00),
(108, '504', 'Individual', 'Disponible', 90000.00),
(109, '505', 'Doble', 'Disponible', 150000.00),
(110, '506', 'Doble', 'Disponible', 150000.00),
(111, '507', 'Doble', 'Disponible', 150000.00),
(112, '508', 'Doble', 'Disponible', 150000.00),
(113, '509', 'Familiar', 'Disponible', 200000.00),
(114, '510', 'Familiar', 'Disponible', 200000.00),
(115, '511', 'Familiar', 'Disponible', 200000.00),
(116, '512', 'Familiar', 'Disponible', 200000.00),
(117, '601', 'Individual', 'Disponible', 90000.00),
(118, '602', 'Individual', 'Disponible', 90000.00),
(119, '603', 'Individual', 'Disponible', 90000.00),
(120, '604', 'Individual', 'Disponible', 90000.00),
(121, '605', 'Doble', 'Disponible', 150000.00),
(122, '606', 'Doble', 'Disponible', 150000.00),
(123, '607', 'Doble', 'Disponible', 150000.00),
(124, '608', 'Doble', 'Disponible', 150000.00),
(125, '609', 'Familiar', 'Disponible', 200000.00),
(126, '610', 'Familiar', 'Disponible', 200000.00),
(127, '611', 'Familiar', 'Disponible', 200000.00),
(128, '612', 'Familiar', 'Disponible', 200000.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcionista`
--

CREATE TABLE `recepcionista` (
  `ID_Recepcionista` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `documento` varchar(50) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `turno` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recepcionista`
--

INSERT INTO `recepcionista` (`ID_Recepcionista`, `nombre`, `documento`, `telefono`, `turno`) VALUES
(12, 'Ana Torres', '1002345678', '3104567890', '1'),
(13, 'Luis Martínez', '1009876543', '3119876543', '0'),
(14, 'María López', '1012345679', '3121234567', '1'),
(15, 'Carlos Gómez', '1019876544', '3139876544', '0'),
(16, 'Sofía Ramírez', '1023456780', '3143456780', '1'),
(17, 'Jorge Herrera', '1029876545', '3159876545', '0'),
(18, 'Paula Fernández', '1032345671', '3162345671', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva`
--

CREATE TABLE `reserva` (
  `ID_Reserva` int(11) NOT NULL,
  `numHabitacion` varchar(25) NOT NULL,
  `nomcliente` varchar(25) NOT NULL,
  `nomRecepcionista` varchar(25) NOT NULL,
  `tipo` varchar(25) NOT NULL,
  `estado` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reserva`
--

INSERT INTO `reserva` (`ID_Reserva`, `numHabitacion`, `nomcliente`, `nomRecepcionista`, `tipo`, `estado`) VALUES
(1035, '106', 'Andres Suarez', 'Ana Torres', 'Doble', 'Reservado'),
(1036, '203', 'Sebastian Pineda ', 'Sofía Ramírez', 'Individual', 'Reservado'),
(1037, '209', 'Pedro Lopez', 'Sofía Ramírez', 'Familiar', 'Reservado'),
(1038, '101', 'Camilo Rojas', 'Luis Martínez', 'Individual', 'Reservado'),
(1039, '310', 'Valentina Cruz', 'Paula Fernández ', 'Familiar', 'Reservado'),
(1040, '304', 'Samuel Medina', 'Jorge Herrera', 'Individual', 'Reservado'),
(1041, '503', 'Alejandra Leon', 'Paula Fernández', 'Individual', 'Reservado'),
(1042, '204', 'Mateo Silva', 'Ana Torres', 'Individual', 'Reservado');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`ID_Administrador`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`ID_Cliente`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`ID_Habitacion`);

--
-- Indices de la tabla `recepcionista`
--
ALTER TABLE `recepcionista`
  ADD PRIMARY KEY (`ID_Recepcionista`);

--
-- Indices de la tabla `reserva`
--
ALTER TABLE `reserva`
  ADD PRIMARY KEY (`ID_Reserva`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `ID_Administrador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `ID_Cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2126;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `ID_Habitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=129;

--
-- AUTO_INCREMENT de la tabla `recepcionista`
--
ALTER TABLE `recepcionista`
  MODIFY `ID_Recepcionista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `reserva`
--
ALTER TABLE `reserva`
  MODIFY `ID_Reserva` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1043;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
