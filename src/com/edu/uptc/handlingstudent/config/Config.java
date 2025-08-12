package com.edu.uptc.handlingstudent.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

/**
 * <b>Descripción:</b> Clase que determina la información de configuración de la aplicación<br>
 * @author jcharris
 */
public class Config {
	
	/** Atributo que determina las propiedades de configuración */
	private static Config config;
	
	private Properties properties;
	
	private String pathFile;
	
	private String nameFile;
	
	private Config() {
		this.properties= new Properties();
		try (FileInputStream entrada = new FileInputStream("resources/conf/appconf.properties")) {
			properties.load(entrada);
            this.pathFile = properties.getProperty("student.path.file.plain");
            this.nameFile =  properties.getProperty("student.name.file");
        } catch (IOException ex) {
            System.err.println("Error al cargar el archivo properties de configuraciÃ³n: " + ex.getMessage());
        }
	}
	
	public static Config getInstance() {
		if(Objects.isNull(config)) {
			config = new Config();
		}
		return config;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
	
	
}
