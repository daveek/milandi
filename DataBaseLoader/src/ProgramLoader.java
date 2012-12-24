import java.sql.SQLException;
import java.util.List;


public class ProgramLoader {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		Loader miloader = new Loader();
		
		List<Word> milist01=miloader.LoadColum(2, 0,0,1);
		List<Word> milist11=miloader.LoadColum(2, 0,1,1);
		List<Word> milist21=miloader.LoadColum(2, 0,2,1);
		List<Word> milist31=miloader.LoadColum(2, 0,3,1);
		miloader.InsertWords(milist01,1);
		miloader.InsertWords(milist11,1);
		miloader.InsertWords(milist21,1);
		miloader.InsertWords(milist31,1);
		
		List<Description> milistDescription01=miloader.LoadColumDescription(2, 1, 0, 1);
		List<Description> milistDescription11=miloader.LoadColumDescription(2, 1, 1, 1);
		List<Description> milistDescription21=miloader.LoadColumDescription(2, 1, 2, 1);
		List<Description> milistDescription31=miloader.LoadColumDescription(2, 1, 3, 1);
		miloader.InsertDescriptions(milistDescription01, 1);	
		miloader.InsertDescriptions(milistDescription11, 1);		
		miloader.InsertDescriptions(milistDescription21, 1);
		miloader.InsertDescriptions(milistDescription31, 1);
		
		
		
		List<Word> milist04=miloader.LoadColum(2, 2,0,4);
		List<Word> milist14=miloader.LoadColum(2, 2,1,4);
		List<Word> milist24=miloader.LoadColum(2, 2,2,4);
		List<Word> milist34=miloader.LoadColum(2, 2,3,4);
		miloader.InsertWords(milist04,4);
		miloader.InsertWords(milist14,4);
		miloader.InsertWords(milist24,4);
		miloader.InsertWords(milist34,4);
		
		List<Description> milistDescription04=miloader.LoadColumDescription(2, 10, 0, 4);
		List<Description> milistDescription14=miloader.LoadColumDescription(2, 10, 1, 4);
		List<Description> milistDescription24=miloader.LoadColumDescription(2, 10, 2, 4);
		List<Description> milistDescription34=miloader.LoadColumDescription(2, 10, 3, 4);
		miloader.InsertDescriptions(milistDescription04, 4);	
		miloader.InsertDescriptions(milistDescription14, 4);		
		miloader.InsertDescriptions(milistDescription24, 4);
		miloader.InsertDescriptions(milistDescription34, 4);
		
		List<Word> milist02=miloader.LoadColum(2, 2,0,2);
		List<Word> milist12=miloader.LoadColum(2, 2,1,2);
		List<Word> milist22=miloader.LoadColum(2, 2,2,2);
		List<Word> milist32=miloader.LoadColum(2, 2,3,2);
		miloader.InsertWords(milist02,2);
		miloader.InsertWords(milist12,2);
		miloader.InsertWords(milist22,2);
		miloader.InsertWords(milist32,2);
		
		List<Description> milistDescription02=miloader.LoadColumDescription(2, 3, 0, 2);
		List<Description> milistDescription12=miloader.LoadColumDescription(2, 3, 1, 2);
		List<Description> milistDescription22=miloader.LoadColumDescription(2, 3, 2, 2);
		List<Description> milistDescription32=miloader.LoadColumDescription(2, 3, 3, 2);
		miloader.InsertDescriptions(milistDescription02, 2);	
		miloader.InsertDescriptions(milistDescription12, 2);		
		miloader.InsertDescriptions(milistDescription22, 2);
		miloader.InsertDescriptions(milistDescription32, 2);
		
		
		
		
		List<Word> milist03=miloader.LoadColum(2, 4,0,3);
		List<Word> milist13=miloader.LoadColum(2, 4,1,3);
		List<Word> milist23=miloader.LoadColum(2, 4,2,3);
		List<Word> milist33=miloader.LoadColum(2, 4,3,3);
		miloader.InsertWords(milist03,3);
		miloader.InsertWords(milist13,3);
		miloader.InsertWords(milist23,3);
		miloader.InsertWords(milist33,3);
		
		List<Description> milistDescription03=miloader.LoadColumDescription(2, 5, 0, 3);
		List<Description> milistDescription13=miloader.LoadColumDescription(2, 5, 1, 3);
		List<Description> milistDescription23=miloader.LoadColumDescription(2, 5, 2, 3);
		List<Description> milistDescription33=miloader.LoadColumDescription(2, 5, 3, 3);
		miloader.InsertDescriptions(milistDescription03, 3);	
		miloader.InsertDescriptions(milistDescription13, 3);		
		miloader.InsertDescriptions(milistDescription23, 3);
		miloader.InsertDescriptions(milistDescription33, 3);
		
		
		
		List<Word> milist05=miloader.LoadColum(2, 6,0,5);
		List<Word> milist15=miloader.LoadColum(2, 6,1,5);
		List<Word> milist25=miloader.LoadColum(2, 6,2,5);
		List<Word> milist35=miloader.LoadColum(2, 6,3,5);
		miloader.InsertWords(milist05,5);
		miloader.InsertWords(milist15,5);
		miloader.InsertWords(milist25,5);
		miloader.InsertWords(milist35,5);
		
		List<Description> milistDescription05=miloader.LoadColumDescription(2, 8, 0, 5);
		List<Description> milistDescription15=miloader.LoadColumDescription(2, 8, 1, 5);
		List<Description> milistDescription25=miloader.LoadColumDescription(2, 8, 2, 5);
		List<Description> milistDescription35=miloader.LoadColumDescription(2, 8, 3, 5);
		miloader.InsertDescriptions(milistDescription05, 5);	
		miloader.InsertDescriptions(milistDescription15, 5);		
		miloader.InsertDescriptions(milistDescription25, 5);
		miloader.InsertDescriptions(milistDescription35, 5);
		//List<Description> milistDescription=miloader.LoadColumDescription(2, 1, 0, 1);
		//miloader.InsertDescriptions(milistDescription, 1);*/
		
		
		//LoadColumDescription(int row, int column, int sheetnum, int IDLanguage) throws SQLException{

		/*String strin = "\"I'm so tired,\"she said, yawning and strenching.";
		strin=miloader.validateWord1(strin);
		strin=miloader.validateWord2(strin);
		System.out.println(strin);*/
	
	}

	

}
