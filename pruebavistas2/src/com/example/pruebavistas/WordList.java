package com.example.pruebavistas;

public class WordList {
	
	
	//word selected
    private String Word = "";
    //type of word, noun(1), adjective(2), adverb(3), verb(4)
    private String Type = "";
    //id of the word
    private String IDnumber = "";
    //translated word
    private String WordDest ="";
    //its the type of the word
    private String TypeName="";
    // phrase asociated to the word translated
    private String Description="";
    //description id
    private String iddesc="";
    //
    private String typeNumber="";
    
    
    
    public String getiddesc() {
        return iddesc;
    }
    public String gettypeNumber() {
        return  typeNumber;
    }
    
    public String getWord() {
        return Word;
    }
    public String getWordDest() {
        return  WordDest;
    }
    public String getIDnumber() {
        return IDnumber;
    }

    public String getType() {
        return Type;
    }
    
    public String getDescription() {
        return Description;
    }
    
    public String getTypeName() {
        return TypeName;
    }
    
    

    public void setiddesc(String iddesc) {
    	this.iddesc = iddesc;
    }
    
    public void settypeNumber(String typeNumber) {
    	this.typeNumber = typeNumber;
    }
    
    public void setWord(String word) {
    	Word = word;
    }
    
    public void setWordDest(String wordDest) {
    	WordDest = wordDest;
    }

    public void setIDnumber(String IDnum) {
    	this.IDnumber = IDnum;
    }
    
    public void setType(String type) {
    	Type = type;
    }
    
    public void setTypeName(String typeName) {
    	TypeName = typeName;
    }
    public void setDescription(String Description) {
    	this.Description = Description;
    }
}
