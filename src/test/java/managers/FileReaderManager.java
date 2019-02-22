/**
 *  @Author - Rohit Patil
 * 
 * File Reader Manager is a Singleton Design Pattern
 * In order to have global point of access, FileReaderManager is created above all the file Readers.
 * For this below approach is used - 
 * Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
 * 
 */

package managers;

import dataProviders.ConfigFileReader;

public class FileReaderManager {
	
	private static FileReaderManager fileReaderManager=new FileReaderManager();
	private static ConfigFileReader configFileReader;
	
	public FileReaderManager() {
		
	}
	
	public static FileReaderManager getInstance( ) {
	       return fileReaderManager;
	 }
	 
	 public ConfigFileReader getConfigReader() {
	 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }

}
