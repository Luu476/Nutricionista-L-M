-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-11-2024 a las 11:37:44
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
-- Base de datos: `nutricionista_2024`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alimento`
--

CREATE TABLE `alimento` (
  `codComida` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoComida` varchar(50) NOT NULL,
  `caloriasPor100g` int(11) NOT NULL,
  `detalle` text NOT NULL,
  `baja` tinyint(1) NOT NULL,
  `aptoVegetariano` tinyint(1) NOT NULL,
  `libredeTACC` tinyint(1) NOT NULL,
  `lacteo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alimento`
--

INSERT INTO `alimento` (`codComida`, `nombre`, `tipoComida`, `caloriasPor100g`, `detalle`, `baja`, `aptoVegetariano`, `libredeTACC`, `lacteo`) VALUES
(1, 'Arroz a la marinera', 'almuerzo', 130, 'arroz, pescado, caldo, cebolla, ajo.', 0, 0, 1, 0),
(2, 'jugo de manzana', 'desayuno', 50, 'manzanas exprimidas, agua, azucar', 0, 1, 1, 0),
(3, 'snack de manzana', 'merienda', 80, 'rodajas de manzanas, azucar', 0, 1, 1, 0),
(4, 'Pollo a la plancha', 'almuerzo', 165, 'pollo, sal, aceite de oliva', 0, 0, 1, 0),
(5, 'ensalada de frutas', 'cena', 100, 'frutas mixtas, miel', 0, 1, 1, 0),
(6, 'sopa de verduras', 'almuerzo', 40, 'Zanahorias, calabaza, papa y sal', 0, 1, 1, 0),
(7, 'tarta de espinacas ', 'almuerzo', 180, 'Espinacas, harina, queso, huevo', 0, 1, 0, 0),
(8, 'bife de carne', 'cena', 250, 'Carne vacuna, sal, aceite', 0, 0, 1, 0),
(9, 'Cereal con leche', 'desayuno', 150, 'Cereal de maíz, leche', 0, 1, 0, 0),
(10, 'Torta de zanahoria', 'merienda', 300, 'Harina, zanahoria, azúcar, huevo', 0, 1, 0, 0),
(11, 'Pan integral', 'desayuno', 250, 'Harina integral, agua, levadura, sal', 0, 1, 0, 0),
(12, 'Arepas de maíz con queso y aguacate', 'almuerzo', 250, 'Harina de maíz, queso, aguacate, sal, agua.', 0, 0, 1, 0),
(13, 'Ensalada de quinoa con vegetales', 'cena', 180, 'Quinoa, pimiento, pepino, tomate, cebolla, aceite de oliva, sal, limón', 0, 0, 1, 0),
(14, 'Tacos de lechuga con pollo', 'almuerzo', 150, 'Hojas de lechuga, pechuga de pollo, cebolla, pimiento, especias', 0, 0, 1, 0),
(15, 'Tortilla de patatas', 'cena', 200, ' Papas, huevo, cebolla, sal, aceite de oliva', 0, 1, 1, 0),
(16, 'Paella de mariscos o de verduras', 'almuerzo', 300, 'Arroz, mariscos variados o vegetales (pimiento, guisantes), azafrán, ajo, caldo de pescado o verduras', 0, 0, 1, 0),
(17, 'Ensalada César con aderezo sin gluten', 'cena', 220, 'Lechuga, pechuga de pollo, queso parmesano, croutons sin gluten, aderezo César sin gluten', 0, 0, 1, 1),
(18, 'Arroz a la cubana', 'cena', 350, 'Arroz blanco, huevo, plátano maduro, salsa de tomate', 0, 1, 1, 0),
(19, 'Lasaña de berenjena con carne y queso ', 'almuerzo', 270, ' Berenjena, carne molida, queso, salsa de tomate, especias', 0, 0, 1, 1),
(20, 'Sopa de lentejas', 'cena', 180, ' Lentejas, zanahoria, cebolla, apio, especias, caldo de verduras', 0, 1, 1, 0),
(21, 'Ceviche de pescado', 'almuerzo', 120, 'Pescado blanco, cebolla morada, jugo de limón, cilantro, sal, chile (opcional)', 0, 0, 1, 0),
(22, 'Rollos de sushi', 'cena', 180, 'Arroz para sushi, alga nori, pepino, zanahoria, aguacate, pescado o camarón (sin salsa de soja con gluten)', 0, 0, 1, 0),
(23, 'Guiso de lentejas con calabaza y vegetales', 'almuerzo', 250, ' Lentejas, calabaza, zanahoria, cebolla, pimiento, caldo de verduras', 0, 1, 1, 0),
(24, 'Espaguetis de calabacín con pesto', 'cena', 150, 'Calabacín, albahaca, ajo, aceite de oliva, piñones, queso parmesano', 0, 1, 1, 1),
(25, 'Pizza con masa de coliflor', 'almuerzo', 200, ' Coliflor, queso mozzarella, salsa de tomate, orégano, tus ingredientes favoritos', 0, 1, 1, 1),
(26, 'Nuggets de pollo con harina de maíz', 'cena', 190, 'Pechuga de pollo, harina de maíz, huevo, sal, pimienta, especias', 0, 0, 1, 0),
(27, 'Ensalada caprese', 'almuerzo', 150, 'Tomate, mozzarella, albahaca fresca, aceite de oliva, sal.', 0, 1, 1, 0),
(28, 'Tortillas de maíz rellenas de vegetales y carne', 'almuerzo', 240, 'Tortillas de maíz, carne molida o pollo, lechuga, tomate, queso', 0, 0, 1, 1),
(29, 'Papas rellenas de atún y vegetales', 'cena', 200, 'Papas, atún en lata, pimiento, cebolla, mayonesa sin gluten', 0, 0, 1, 1),
(30, 'Hamburguesa con pan sin gluten', 'almuerzo', 300, 'Pan sin gluten, carne molida, lechuga, tomate, queso, condimentos', 0, 0, 1, 1),
(31, 'Sándwich de pepino, aguacate y queso crema en pan sin gluten', 'cena', 180, 'Pan sin gluten, pepino, aguacate, queso crema', 0, 0, 1, 1),
(32, 'Ensalada de garbanzos con atún', 'almuerzo', 175, 'Garbanzos, atún en lata, tomate, cebolla, perejil, aceite de oliva', 0, 0, 1, 0),
(33, 'Pollo al horno con limón y hierbas', 'almuerzo', 235, 'Pechuga de pollo, limón, ajo, romero, aceite de oliva, sal.', 0, 0, 1, 0),
(34, 'Falafel al horno', 'almuerzo', 210, 'Garbanzos, cebolla, ajo, perejil, comino, pan rallado sin gluten, aceite de oliva.', 0, 1, 1, 0),
(35, 'Ensalada de couscous con vegetales ', 'almuerzo', 180, ' Couscous sin gluten, pepino, pimiento, tomate, cebolla, perejil, menta, aceite de oliva, limón.', 0, 1, 1, 0),
(36, 'Curry de garbanzos y espinacas', 'cena', 250, 'Garbanzos, espinacas, cebolla, tomate, leche de coco, curry, ajo', 0, 1, 1, 0),
(37, 'Tarta de espinaca y ricota', 'almuerzo', 300, 'Masa sin gluten, espinaca, ricota, huevo, queso parmesano, sal, pimienta', 0, 1, 1, 1),
(38, 'Pimientos rellenos de arroz y vegetales', 'cena', 115, 'Pimientos, arroz, zanahoria, cebolla, tomate, especias', 0, 1, 1, 0),
(39, 'Moussaka de berenjenas', 'cena', 270, 'Berenjena, papa, tomate, queso, cebolla, ajo, especias', 0, 1, 1, 1),
(40, 'Wrap de vegetales y hummus', 'almuerzo', 180, 'Tortilla de maíz, hummus, zanahoria, pimiento, pepino, lechuga', 0, 1, 1, 0),
(41, 'Calabacines rellenos de quinoa y queso feta', 'cena', 205, 'Calabacín, quinoa, queso feta, tomate, ajo, hierbas', 0, 1, 1, 1),
(42, 'Sopa minestrone', 'almuerzo', 145, 'Zanahoria, apio, cebolla, tomate, calabacín, pasta sin gluten, caldo de vegetales', 0, 1, 1, 0),
(43, 'Risotto de calabaza', 'cena', 280, 'Arroz arborio, calabaza, cebolla, ajo, queso parmesano, caldo de vegetales', 0, 1, 1, 1),
(44, 'Frittata de espárragos y champiñones', 'almuerzo', 220, 'Huevo, espárragos, champiñones, cebolla, queso', 0, 1, 1, 1),
(45, 'Hamburguesas de lentejas', 'cena', 185, ' Lentejas, avena sin gluten, cebolla, ajo, especias, pan rallado sin gluten', 0, 1, 1, 0),
(46, 'Quesadillas de queso y espinaca', 'cena', 240, 'Tortilla de maíz, queso, espinaca, cebolla', 0, 1, 1, 1),
(47, 'Crema de calabaza y zanahoria', 'almuerzo', 115, 'Calabaza, zanahoria, cebolla, caldo de vegetales', 0, 1, 1, 0),
(48, 'Pasta al pesto con tomate cherry', 'almuerzo', 305, 'Pasta sin gluten, albahaca, ajo, piñones, aceite de oliva, tomate cherry, queso parmesano', 0, 1, 1, 1),
(49, 'Bruschettas de tomate y albahaca', 'cena', 150, 'Pan sin gluten, tomate, albahaca, ajo, aceite de oliva', 0, 1, 1, 0),
(50, 'Ensalada de tabule con coliflor', 'almuerzo', 140, 'Coliflor rallada, tomate, pepino, perejil, menta, limón, aceite de oliva', 0, 1, 1, 0),
(51, 'Berenjenas a la parmesana ', 'cena', 290, 'Berenjena, salsa de tomate, queso mozzarella, queso parmesano, albahaca', 0, 1, 1, 1),
(52, 'Huevo pochado con espinacas y aguacate', 'cena', 230, 'Huevo, espinacas, aguacate, sal, pimienta', 0, 1, 1, 0),
(53, 'Tortilla de vegetales al horno', 'almuerzo', 160, 'Huevo, calabacín, zanahoria, cebolla, espinaca, sal, pimienta', 0, 1, 1, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `codDieta` int(11) NOT NULL,
  `nombreD` varchar(100) NOT NULL,
  `fechaIni` date NOT NULL,
  `fechaFin` date NOT NULL,
  `pesoIni` float NOT NULL,
  `pesoFinal` float NOT NULL,
  `estado` int(11) NOT NULL,
  `totalCalorias` float NOT NULL,
  `nroPaciente` int(11) NOT NULL,
  `tipoDeDieta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`codDieta`, `nombreD`, `fechaIni`, `fechaFin`, `pesoIni`, `pesoFinal`, `estado`, `totalCalorias`, `nroPaciente`, `tipoDeDieta`) VALUES
(1, 'Dieta mediterránea', '2024-12-02', '2024-12-08', 85, 80, 1, 8600, 1, ''),
(2, 'Dieta Saludable', '2024-05-02', '2024-05-07', 68, 55, 1, 9000, 4, ''),
(3, 'Dieta Equilibrada', '2024-10-03', '2024-12-09', 70, 62, 1, 9200, 2, ''),
(4, 'Dieta Detox', '2024-02-02', '2024-02-08', 74, 65, 1, 8200, 5, ''),
(5, 'Dieta Sin Gluten', '2024-09-03', '2024-12-08', 97, 85, 1, 9500, 3, '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menudiario`
--

CREATE TABLE `menudiario` (
  `codMenu` int(11) NOT NULL,
  `dia` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `caloriasDelMenu` int(1) NOT NULL,
  `codDieta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `menudiario`
--

INSERT INTO `menudiario` (`codMenu`, `dia`, `estado`, `caloriasDelMenu`, `codDieta`) VALUES
(1, 1, 1, 2000, 1),
(2, 2, 1, 2200, 2),
(3, 3, 1, 1800, 3),
(4, 1, 1, 1850, 4),
(5, 2, 1, 1900, 5),
(6, 3, 1, 2000, 6),
(7, 1, 1, 1500, 7),
(8, 2, 1, 1700, 8),
(9, 1, 1, 1800, 9),
(10, 2, 1, 1500, 10),
(11, 1, 1, 2000, 11),
(12, 2, 1, 1400, 12),
(13, 3, 1, 1600, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `nroPaciente` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL,
  `altura` int(11) NOT NULL,
  `pesoActual` float NOT NULL,
  `pesoBuscado` float NOT NULL,
  `sexo` varchar(50) NOT NULL,
  `condicionEspecial` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`nroPaciente`, `nombre`, `apellido`, `edad`, `altura`, `pesoActual`, `pesoBuscado`, `sexo`, `condicionEspecial`) VALUES
(1, 'Maria ', 'Perez', 30, 200, 85, 80, '', ''),
(2, 'Juan', 'Lopez', 23, 178, 70, 62, '', ''),
(3, 'Luis', 'Garcia', 42, 167, 97, 85, '', ''),
(4, 'Sofia', 'Torres', 28, 182, 68, 55, '', ''),
(5, 'Brisa', 'Mendez', 24, 176, 75, 65, '', ''),
(6, 'Martin', 'Paez', 34, 180, 88, 80, '', ''),
(17, 'Luciano', 'Rodriguez', 22, 22, 22, 21, 'Hombre', ' / Intolerante a la lactosa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesional`
--

CREATE TABLE `profesional` (
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(50) NOT NULL,
  `telefono` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `renglondemenu`
--

CREATE TABLE `renglondemenu` (
  `nroRenglon` int(11) NOT NULL,
  `cantidadGrs` double NOT NULL,
  `subtotalCalorias` int(11) NOT NULL,
  `codMenu` int(11) NOT NULL,
  `codComida` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `renglondemenu`
--

INSERT INTO `renglondemenu` (`nroRenglon`, `cantidadGrs`, `subtotalCalorias`, `codMenu`, `codComida`) VALUES
(1, 200, 260, 1, NULL),
(2, 250, 125, 2, NULL),
(3, 150, 120, 3, NULL),
(4, 180, 300, 4, NULL),
(5, 300, 300, 5, NULL),
(6, 250, 200, 6, NULL),
(7, 220, 250, 7, NULL),
(8, 150, 100, 8, NULL),
(9, 200, 150, 9, NULL),
(10, 180, 300, 10, NULL),
(11, 150, 80, 11, NULL),
(12, 200, 260, 12, NULL),
(13, 250, 125, 13, NULL),
(14, 150, 120, 14, NULL),
(15, 180, 297, 15, NULL),
(16, 300, 300, 16, NULL),
(17, 250, 200, 17, NULL),
(18, 220, 250, 18, NULL),
(19, 150, 100, 19, NULL),
(20, 200, 150, 20, NULL),
(21, 180, 300, 21, NULL),
(22, 150, 80, 22, NULL),
(23, 200, 260, 23, NULL),
(24, 250, 125, 24, NULL),
(25, 150, 120, 25, NULL),
(26, 180, 290, 26, NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alimento`
--
ALTER TABLE `alimento`
  ADD PRIMARY KEY (`codComida`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`codDieta`),
  ADD UNIQUE KEY `nroPaciente` (`nroPaciente`);

--
-- Indices de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD PRIMARY KEY (`codMenu`),
  ADD UNIQUE KEY `codDieta` (`codDieta`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`nroPaciente`);

--
-- Indices de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD PRIMARY KEY (`nroRenglon`),
  ADD UNIQUE KEY `codMenu` (`codMenu`),
  ADD UNIQUE KEY `codComida` (`codComida`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alimento`
--
ALTER TABLE `alimento`
  MODIFY `codComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `codDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `menudiario`
--
ALTER TABLE `menudiario`
  MODIFY `codMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `nroPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  MODIFY `nroRenglon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `dieta_ibfk_1` FOREIGN KEY (`nroPaciente`) REFERENCES `paciente` (`nroPaciente`),
  ADD CONSTRAINT `dieta_ibfk_2` FOREIGN KEY (`codDieta`) REFERENCES `menudiario` (`codDieta`);

--
-- Filtros para la tabla `menudiario`
--
ALTER TABLE `menudiario`
  ADD CONSTRAINT `menudiario_ibfk_1` FOREIGN KEY (`codMenu`) REFERENCES `renglondemenu` (`codMenu`);

--
-- Filtros para la tabla `renglondemenu`
--
ALTER TABLE `renglondemenu`
  ADD CONSTRAINT `renglondemenu_ibfk_1` FOREIGN KEY (`codComida`) REFERENCES `alimento` (`codComida`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
