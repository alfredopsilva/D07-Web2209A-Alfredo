-- MariaDB dump 10.19-11.0.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: recipes_db
-- ------------------------------------------------------
-- Server version	11.0.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `image_path` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES
(1,'Sandwiches','images/categories/sandwiches.png'),
(2,'Soups','images/categories/soups.png'),
(3,'Desserts','images/categories/desserts.png');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `likes`
--

DROP TABLE IF EXISTS `likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `likes` (
  `username` varchar(255) NOT NULL,
  `recipe_id` int(11) NOT NULL,
  PRIMARY KEY (`username`,`recipe_id`),
  KEY `likes_recipes_FK` (`recipe_id`),
  CONSTRAINT `likes_recipes_FK` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`id`),
  CONSTRAINT `likes_users_FK` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `likes`
--

LOCK TABLES `likes` WRITE;
/*!40000 ALTER TABLE `likes` DISABLE KEYS */;
INSERT INTO `likes` VALUES
('catherine',100001),
('anna',100003),
('catherine',100004),
('anna',100006),
('catherine',100006),
('catherine',100008);
/*!40000 ALTER TABLE `likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipes`
--

DROP TABLE IF EXISTS `recipes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recipes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` mediumtext NOT NULL,
  `image_path` varchar(255) NOT NULL,
  `category_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `recipes_FK` (`category_id`),
  CONSTRAINT `recipes_FK` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100011 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipes`
--

LOCK TABLES `recipes` WRITE;
/*!40000 ALTER TABLE `recipes` DISABLE KEYS */;
INSERT INTO `recipes` VALUES
(100001,'Avocado Sandwich','<p>The Ultimate Avocado Sandwich. A healthy and nutritious sandwich filled with avocado, cheese, tomatoes and rocket for a juicy and unbeatable taste!</p>\r\n<p>Make this egg and avocado sandwich for a delicious restaurant-style breakfast at home! It is quick, easy, and delicious. The sliced avocado is what makes this sandwich pop and gives it a unique flavor. It is chock-full of protein, as well, so this sandwich will keep you full until lunchtime.</p>','images/recipes/avocado-sandwich.png',1),
(100002,'Banh Mi Sandwich','<p>This Vietnamese sandwich is typically a combination of meat (usually pork) and vegetables, but our take here is plant-based and calls for crispy marinated tofu and a combination of fresh and picked vegetables. A swipe of sriracha mayonnaise adds a layer of creamy richness.</p>\r\n<p>Don\'t be intimidated by the ingredient list! All of the items are easy to find at well-stocked grocery stores and once you prep your ingredients, the sandwiches come together very easily.</p>','images/recipes/banh-mi-sandwich.png',1),
(100003,'Breakfast Sandwich','<p>A breakfast sandwich on a French baguette loaded with eggs, bacon, arugula, tomatoes, cheese, and sun-dried tomato pesto.</p>\r\n<p>Breakfast is hard sometimes. Fight that early morning hunger with make ahead baguette breakfast sandwiches. Breakfast sandwiches full of eggs, bacon, cheese, arugula, and sun-dried tomato pesto. A sandwich that will keep you satisfied all morning long.</p>','images/recipes/breakfast-sandwich.png',1),
(100004,'Butternut Squash Soup','<p>This top-rated butternut squash soup is basically fall in a bowl! Smooth and creamy, it\'s sure to warm you up from the inside on a brisk autumn day. This recipe uses a handful of simple, affordable ingredients to create a standout soup that\'s more than the sum of its parts.</p>\r\n<p>This soup makes a great fall or winter appetizer, but can also be served as a main dish with a side of corn muffins, crusty bread, roasted vegetables, or a side salad.</p>','images/recipes/butternut-squash-soup.png',2),
(100005,'Chocolate Chip Cookie','<p>This is the best chocolate chip cookies recipe ever! No funny ingredients, no chilling time, etc. Just a simple, straightforward, amazingly delicious, doughy yet still fully cooked, chocolate chip cookie that turns out perfectly every single time!</p>\r\n<p>These are everything a chocolate chip cookie should be. Crispy and chewy. Doughy yet fully baked. Perfectly buttery and sweet.</p>','images/recipes/chocolate-chip-cookie.png',3),
(100006,'Chocolate Cupcake','<p>These super moist chocolate cupcakes pack tons of chocolate flavor in each cupcake wrapper! Made from simple everyday ingredients, this easy cupcake recipe will be your new favorite. For best results, use natural cocoa powder and buttermilk. These chocolate cupcakes taste completely over-the-top with chocolate buttercream!</p>\r\n<p>Made from simple everyday ingredients, these chocolate cupcakes with vanilla frosting will be your new favorite. For best results, use natural cocoa powder and buttermilk.</p>','images/recipes/chocolate-cupcake.png',3),
(100007,'Grilled Cheese Sandwich','<p>Bread, butter and Cheddar cheese... here\'s a way to make this classic sandwich in a nonstick pan.</p>\r\n<p>No matter the hour (or your age), a grilled cheese sandwich is the pinnacle of crave-worthiness. This rendition doesn\'t attempt to reinvent the classic. It just guides you toward making the best-ever version of it.</p>','images/recipes/grilled-cheese-sandwich.png',1),
(100008,'Ice Cream Cone','<p>This is the easiest homemade ice cream recipe because you only need 2 ingredients and no ice cream machine. Plus, you\'ll find 50+ ice cream flavor ideas!</p>\r\n<p>Whether you\'re a fan of classic vanilla in a dish or all about a mile-high cone with scoops in a variety of flavors, nothing beats ice cream.</p>','images/recipes/ice-cream-cone.png',3),
(100009,'Roasted Red Pepper Soup','<p>A rich and intensely flavoured Roasted Red Pepper Soup made with sweet, charred red peppers, garlic, sun dried tomatoes for an extra flavour kick and topped with  homemade basil pesto and a creme fraiche swirl. Warm, comforting and easy!</p>\r\n<p>This roasted red pepper soup has a rich, thick and creamy consistency that you could eat it at room temperature during the summer months or nice and hot when the weather turns chilly.</p>','images/recipes/roasted-red-pepper-soup.png',2),
(100010,'Tomato Soup','<p>This Creamy Tomato Soup is easy, comforting, and has a rich flavor profile. Watch the easy video tutorial and you\'ll be craving a bowl of tomato soup paired with a gooey Grilled Cheese Sandwich.</p>\r\n<p>You can make this tomato soup creamy or chunky if you prefer, but we love creamy soup recipes from Creamy Sweet Potato Soup to our velvety Carrot Soup and definitely Creamy Potato Soup.</p>','images/recipes/tomato-soup.png',2);
/*!40000 ALTER TABLE `recipes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password_salt` varbinary(255) NOT NULL,
  `password_hash` varbinary(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES
('admin',0xED22E77F41CE200E119B79430A58434F3530BD45C4AE3864878D460A4E2B0707,0x364FF3977A6169BCD362EAAFB87A46D1222E7C03A6E0854D69D91B1DB92E5304,'Administrator'),
('anna',0x112544771D058617895CBF60C15A3AD17C46EA137874FD30ED6E2C576B7B09E7,0xE92F1DEE17B5397CD802834EB7F76FE6E7EBDD9B700F19E2293C79A23D4F5C61,'Anna Brown'),
('catherine',0xB103B97857F822592FCCF196FBA0E09922BA3251F4361EB3356F1418F671FA9F,0x53B4E96B824ECC0B29C2F2576DAE008BCD070A6B03CB91F3ECA75923B1FCCF56,'Catherine Dubois');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'recipes_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-07 14:59:43
