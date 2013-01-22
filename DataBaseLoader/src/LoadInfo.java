import java.sql.SQLException;
import java.util.List;


public class LoadInfo {
	
	String dataPath;
	String sqlPath;
	int column;
	int language;
	
	public LoadInfo(String DataPath, String SqlPath, int column, int language){
		this.dataPath=DataPath;
		this.sqlPath=SqlPath;
		this.column=column;
		this.language=language;
	}
	
	
	
	
	public void loadWords() throws SQLException{
		Loader miloader = new Loader(dataPath, sqlPath);
	List<Word> milist01=miloader.LoadColum(2, column,0,language);
	List<Word> milist11=miloader.LoadColum(2, column,1,language);
	List<Word> milist21=miloader.LoadColum(2, column,2,language);
	List<Word> milist31=miloader.LoadColum(2, column,3,language);
	miloader.InsertWords(milist01,language);
	miloader.InsertWords(milist11,language);
	miloader.InsertWords(milist21,language);
	miloader.InsertWords(milist31,language);
	}
	public void loadDescription() throws SQLException{
		Loader miloader = new Loader(dataPath, sqlPath);
	List<Description> milistDescription01=miloader.LoadColumDescription(2, column, 0, language);
	List<Description> milistDescription11=miloader.LoadColumDescription(2, column, 1, language);
	List<Description> milistDescription21=miloader.LoadColumDescription(2, column, 2, language);
	List<Description> milistDescription31=miloader.LoadColumDescription(2, column, 3, language);
	miloader.InsertDescriptions(milistDescription01, language);	
	miloader.InsertDescriptions(milistDescription11, language);		
	miloader.InsertDescriptions(milistDescription21, language);
	miloader.InsertDescriptions(milistDescription31,language);
	}
	
	public void insertLang(int id, String Name) throws SQLException{
		Loader miLoader = new Loader(dataPath, sqlPath);
		miLoader.insertLanguage(id, Name);
	}
	
	
	public void deleteLang(int id) throws SQLException{
		Loader miLoader = new Loader(dataPath, sqlPath);
		miLoader.DeleteLanguage(id);
	}
	
}
