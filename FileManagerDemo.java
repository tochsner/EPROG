import java.util.LinkedList;


public class FileManagerDemo {

	public static void main(String[] args) {

		FileSystem fileSystem = new FileSystem();
				
		fileSystem.setRootDirectory(new Directory("Dokumente"));
		
		fileSystem.addDirectory(new String[] { "Dokumente" }, new Directory("Finanzen"));
		fileSystem.addDirectory(new String[] { "Dokumente" }, new Directory("ETH"));
		fileSystem.addDirectory(new String[] { "Dokumente", "ETH" }, new Directory("EPROG"));
		
		fileSystem.addFile(new String[] { "Dokumente", "Finanzen" }, new File("Budget 2020.txt"));
		fileSystem.addFile(new String[] { "Dokumente", "ETH", "EPROG" }, new File("Übung 01.java"));

		File budget = fileSystem.getFile(new String[] { "Dokumente", "Finanzen" }, "Budget 2020.txt" );
		System.out.println(budget.getName());
		
	}

}

class FileSystem {

	private Directory rootDirectory;

	public Directory getRootDirectory() {
		return this.rootDirectory;
	}

	public void setRootDirectory(Directory rootDirectory) {
		this.rootDirectory = rootDirectory;
	}

	public void addFile(String[] path, File file) {
		Directory current = this.rootDirectory;
		
		for (int i = 1; i < path.length; i++) {
			current = current.getDirectory(path[i]);
		}
		
		current.addFile(file);
	}
	
	public void addDirectory(String[] path, Directory directory) {
		Directory current = this.rootDirectory;
		
		for (int i = 1; i < path.length; i++) {
			current = current.getDirectory(path[i]);
		}
		
		current.addDirectory(directory);
	}

	public File getFile(String[] path, String fileName) {
		Directory current = this.rootDirectory;
		
		for (int i = 1; i < path.length; i++) {
			current = current.getDirectory(path[i]);
		}
		
		return current.getFile(fileName);
	}

}

class Directory {

	private String name;

	private LinkedList<Directory> subDirectories = new LinkedList<Directory>();
	private LinkedList<File> subFiles = new LinkedList<File>();

	public Directory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public LinkedList<Directory> getSubDirectories() {
		return subDirectories;
	}

	public LinkedList<File> getSubFiles() {
		return subFiles;
	}

	public void addDirectory(Directory directory) {
		this.subDirectories.add(directory);
	}

	public void addFile(File file) {
		this.subFiles.add(file);
	}

	public Directory getDirectory(String name) {
		for (int i = 0; i < this.subDirectories.size(); i++) {
			if (this.subDirectories.get(i).getName().equals(name)) {
				return this.subDirectories.get(i);
			}
		}		
		
		return null;
	}
	
	public File getFile(String name) {
		for (int i = 0; i < this.subFiles.size(); i++) {
			if (this.subFiles.get(i).getName().equals(name)) {
				return this.subFiles.get(i);
			}
		}		
		
		return null;
	}
	
}

class File {

	private String name;

	public File(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}