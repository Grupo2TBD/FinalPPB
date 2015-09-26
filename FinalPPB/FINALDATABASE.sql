SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `pass_user` VARCHAR(45) NULL,
  `fecha_creacion_cuenta` DATETIME NULL,
  `alias_user` VARCHAR(45) NULL,
  `nombre_real_user` VARCHAR(45) NULL,
  `direccion_foto_perfil_user` VARCHAR(50) NULL,
  `apellido_user` VARCHAR(45) NULL,
  `sexo_user` VARCHAR(10) NULL,
  `direccion_foto_portada_user` VARCHAR(45) NULL,
  `fecha_cumpleaños_user` DATETIME NULL,
  `email_user` VARCHAR(45) NULL,
  `fecha_ultima_actualizacion` DATETIME NULL,
  `cantidad_fotografias_subidas` INT NULL,
  `cantidad_albumes_creados` INT NULL,
  `cantidad_seguidores` INT NULL,
  `cantidad_seguidos` INT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tipo_Clasificacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tipo_Clasificacion` (
  `id_tipo_clasificacion` INT NOT NULL AUTO_INCREMENT,
  `tipo_clasificacion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_clasificacion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Tag` (
  `id_tag` INT NOT NULL AUTO_INCREMENT,
  `nombre_tag` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tag`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Seguidor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Seguidor` (
  `Usuario_id_user` INT NOT NULL,
  `Usuario_id_user1` INT NOT NULL,
  `fecha_follow` DATETIME NULL,
  PRIMARY KEY (`Usuario_id_user`, `Usuario_id_user1`),
  INDEX `fk_Seguidor_Usuario1_idx` (`Usuario_id_user1` ASC),
  CONSTRAINT `fk_Seguidor_Usuario`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Seguidor_Usuario1`
    FOREIGN KEY (`Usuario_id_user1`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Privacidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Privacidad` (
  `id_privacidad` INT NOT NULL AUTO_INCREMENT,
  `tipo_privacidad` VARCHAR(45) NULL,
  PRIMARY KEY (`id_privacidad`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permiso_Fotografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permiso_Fotografia` (
  `id_permiso_fotografia` INT NOT NULL AUTO_INCREMENT,
  `cancommentphoto` TINYINT(1) NULL,
  `candownloadphoto` TINYINT(1) NULL,
  `canfavoritephoto` TINYINT(1) NULL,
  PRIMARY KEY (`id_permiso_fotografia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Permiso_Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Permiso_Album` (
  `id_permiso_album` INT NOT NULL AUTO_INCREMENT,
  `cancommentalbum` TINYINT(1) NULL,
  `canfavoritealbum` TINYINT(1) NULL,
  PRIMARY KEY (`id_permiso_album`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Exif`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Exif` (
  `id_exif` INT NOT NULL AUTO_INCREMENT,
  `apertura_exif` VARCHAR(20) NULL,
  `largo_foco` VARCHAR(20) NULL,
  `flash_exif` TINYINT(1) NULL,
  PRIMARY KEY (`id_exif`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Camara`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Camara` (
  `id_camara` INT NOT NULL AUTO_INCREMENT,
  `megapixeles_camara` VARCHAR(20) NULL,
  `zoom_camara` VARCHAR(20) NULL,
  `tamano_pantalla_camara` VARCHAR(20) NULL,
  `nombre_camara` VARCHAR(20) NULL,
  `peso_camara` VARCHAR(10) NULL,
  `cantidad_fotografias_camara` INT NULL,
  `marca_camara` VARCHAR(20) NULL,
  `direccion_imagen_camara` VARCHAR(50) NULL,
  PRIMARY KEY (`id_camara`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fotografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fotografia` (
  `id_photo` INT NOT NULL AUTO_INCREMENT,
  `fecha_subida_photo` DATETIME NULL,
  `fecha_tomada_photo` DATETIME NULL,
  `cantidad_visitas_photo` INT NULL,
  `titulo_photo` VARCHAR(45) NULL,
  `descripcion_photo` VARCHAR(45) NULL,
  `cantidad_favoritos_photo` INT NULL,
  `formato_photo` VARCHAR(45) NULL,
  `direccion_fisica_photo` VARCHAR(45) NULL,
  `ultima_actualizacion_photo` DATETIME NULL,
  `cantidad_descargas` INT NULL,
  `cantidad_comentarios` INT NULL,
  `cantidad_comentarios_positivos` INT NULL,
  `cantidad_comentarios_negativos` INT NULL,
  `cantidad_comentarios_neutros` INT NULL,
  `Exif_id_exif` INT NOT NULL,
  `Camara_id_camara` INT NOT NULL,
  `Usuario_id_user` INT NOT NULL,
  `Privacidad_id_privacidad` INT NOT NULL,
  `Permiso_Fotografia_id_permiso_fotografia` INT NOT NULL,
  `Tipo_Clasificacion_id_tipo_clasificacion` INT NOT NULL,
  `punto` VARCHAR(50) NULL,
  PRIMARY KEY (`id_photo`),
  INDEX `fk_Fotografia_Exif1_idx` (`Exif_id_exif` ASC),
  INDEX `fk_Fotografia_Camara1_idx` (`Camara_id_camara` ASC),
  INDEX `fk_Fotografia_Usuario1_idx` (`Usuario_id_user` ASC),
  INDEX `fk_Fotografia_Privacidad1_idx` (`Privacidad_id_privacidad` ASC),
  INDEX `fk_Fotografia_Permiso_Fotografia1_idx` (`Permiso_Fotografia_id_permiso_fotografia` ASC),
  INDEX `fk_Fotografia_Tipo_Clasificacion1_idx` (`Tipo_Clasificacion_id_tipo_clasificacion` ASC),
  CONSTRAINT `fk_Fotografia_Exif1`
    FOREIGN KEY (`Exif_id_exif`)
    REFERENCES `mydb`.`Exif` (`id_exif`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Camara1`
    FOREIGN KEY (`Camara_id_camara`)
    REFERENCES `mydb`.`Camara` (`id_camara`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Privacidad1`
    FOREIGN KEY (`Privacidad_id_privacidad`)
    REFERENCES `mydb`.`Privacidad` (`id_privacidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Permiso_Fotografia1`
    FOREIGN KEY (`Permiso_Fotografia_id_permiso_fotografia`)
    REFERENCES `mydb`.`Permiso_Fotografia` (`id_permiso_fotografia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Tipo_Clasificacion1`
    FOREIGN KEY (`Tipo_Clasificacion_id_tipo_clasificacion`)
    REFERENCES `mydb`.`Tipo_Clasificacion` (`id_tipo_clasificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Fotografia_Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Fotografia_Tag` (
  `Fotografia_id_photo` INT NOT NULL,
  `Tag_id_tag` INT NOT NULL,
  PRIMARY KEY (`Fotografia_id_photo`, `Tag_id_tag`),
  INDEX `fk_Fotografia_Tag_Tag1_idx` (`Tag_id_tag` ASC),
  CONSTRAINT `fk_Fotografia_Tag_Fotografia1`
    FOREIGN KEY (`Fotografia_id_photo`)
    REFERENCES `mydb`.`Fotografia` (`id_photo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Fotografia_Tag_Tag1`
    FOREIGN KEY (`Tag_id_tag`)
    REFERENCES `mydb`.`Tag` (`id_tag`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Album` (
  `id_album` INT NOT NULL AUTO_INCREMENT,
  `nombre_album` VARCHAR(45) NULL,
  `fecha_creacion_album` DATETIME NULL,
  `descripcion_album` VARCHAR(45) NULL,
  `direccion_foto_portada_album` VARCHAR(45) NULL,
  `cantidad_fotografias_album` INT NULL,
  `cantidad_favoritos` INT NULL,
  `ultima_actualizacion_album` DATETIME NULL,
  `Usuario_id_user` INT NOT NULL,
  `Permiso_Album_id_permiso_album` INT NOT NULL,
  `Privacidad_id_privacidad` INT NOT NULL,
  PRIMARY KEY (`id_album`),
  INDEX `fk_Album_Usuario1_idx` (`Usuario_id_user` ASC),
  INDEX `fk_Album_Permiso_Album1_idx` (`Permiso_Album_id_permiso_album` ASC),
  INDEX `fk_Album_Privacidad1_idx` (`Privacidad_id_privacidad` ASC),
  CONSTRAINT `fk_Album_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Album_Permiso_Album1`
    FOREIGN KEY (`Permiso_Album_id_permiso_album`)
    REFERENCES `mydb`.`Permiso_Album` (`id_permiso_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Album_Privacidad1`
    FOREIGN KEY (`Privacidad_id_privacidad`)
    REFERENCES `mydb`.`Privacidad` (`id_privacidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Favorito_Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Favorito_Album` (
  `fecha_favorito_album` DATETIME NULL,
  `Usuario_id_user` INT NOT NULL,
  `Album_id_album` INT NOT NULL,
  PRIMARY KEY (`Usuario_id_user`, `Album_id_album`),
  INDEX `fk_Favorito_Album_Usuario1_idx` (`Usuario_id_user` ASC),
  INDEX `fk_Favorito_Album_Album1_idx` (`Album_id_album` ASC),
  CONSTRAINT `fk_Favorito_Album_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Favorito_Album_Album1`
    FOREIGN KEY (`Album_id_album`)
    REFERENCES `mydb`.`Album` (`id_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Etiqueta_Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Etiqueta_Usuario` (
  `Usuario_id_user` INT NOT NULL,
  `Fotografia_id_photo` INT NOT NULL,
  PRIMARY KEY (`Usuario_id_user`, `Fotografia_id_photo`),
  INDEX `fk_Etiqueta_Usuario_Fotografia1_idx` (`Fotografia_id_photo` ASC),
  CONSTRAINT `fk_Etiqueta_Usuario_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Etiqueta_Usuario_Fotografia1`
    FOREIGN KEY (`Fotografia_id_photo`)
    REFERENCES `mydb`.`Fotografia` (`id_photo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Comentario_Fotografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Comentario_Fotografia` (
  `id_comentario_photo` INT NOT NULL AUTO_INCREMENT,
  `descripcion_comentario` VARCHAR(150) NULL,
  `fecha_publicacion_comentario` DATETIME NULL,
  `Usuario_id_user` INT NOT NULL,
  `Fotografia_id_photo` INT NOT NULL,
  `Tipo_Clasificacion_id_tipo_clasificacion` INT NOT NULL,
  PRIMARY KEY (`id_comentario_photo`),
  INDEX `fk_Comentario_Fotografia_Usuario1_idx` (`Usuario_id_user` ASC),
  INDEX `fk_Comentario_Fotografia_Fotografia1_idx` (`Fotografia_id_photo` ASC),
  INDEX `fk_Comentario_Fotografia_Tipo_Clasificacion1_idx` (`Tipo_Clasificacion_id_tipo_clasificacion` ASC),
  CONSTRAINT `fk_Comentario_Fotografia_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Fotografia_Fotografia1`
    FOREIGN KEY (`Fotografia_id_photo`)
    REFERENCES `mydb`.`Fotografia` (`id_photo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Comentario_Fotografia_Tipo_Clasificacion1`
    FOREIGN KEY (`Tipo_Clasificacion_id_tipo_clasificacion`)
    REFERENCES `mydb`.`Tipo_Clasificacion` (`id_tipo_clasificacion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Album_Fotografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Album_Fotografia` (
  `fecha_agregado_album` DATETIME NULL,
  `Album_id_album` INT NOT NULL,
  `Fotografia_id_photo` INT NOT NULL,
  PRIMARY KEY (`Album_id_album`, `Fotografia_id_photo`),
  INDEX `fk_Album_Fotografia_Fotografia1_idx` (`Fotografia_id_photo` ASC),
  CONSTRAINT `fk_Album_Fotografia_Album1`
    FOREIGN KEY (`Album_id_album`)
    REFERENCES `mydb`.`Album` (`id_album`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Album_Fotografia_Fotografia1`
    FOREIGN KEY (`Fotografia_id_photo`)
    REFERENCES `mydb`.`Fotografia` (`id_photo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Favorito_Fotografia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Favorito_Fotografia` (
  `fecha_favorito` DATETIME NULL,
  `Usuario_id_user` INT NOT NULL,
  `Fotografia_id_photo` INT NOT NULL,
  PRIMARY KEY (`Usuario_id_user`, `Fotografia_id_photo`),
  INDEX `fk_Favorito_Fotografia_Fotografia1_idx` (`Fotografia_id_photo` ASC),
  CONSTRAINT `fk_Favorito_Fotografia_Usuario1`
    FOREIGN KEY (`Usuario_id_user`)
    REFERENCES `mydb`.`Usuario` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Favorito_Fotografia_Fotografia1`
    FOREIGN KEY (`Fotografia_id_photo`)
    REFERENCES `mydb`.`Fotografia` (`id_photo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Mapa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Mapa` (
  `id_mapa` INT NOT NULL AUTO_INCREMENT,
  `nombre_pais` VARCHAR(45) NULL,
  `coordenadas` VARCHAR(8000) NULL,
  PRIMARY KEY (`id_mapa`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
