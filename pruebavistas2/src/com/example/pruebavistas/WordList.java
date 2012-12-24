package com.example.pruebavistas;

public class WordList {
    private String Word = "";
    private String Tipo = "";
    private String IDnumber = "";
    private String WordDest ="";
    private String TypeName="";
    private String Description="";
    
    
    private String iddesc="";
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
        return Tipo;
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
    
    public void setType(String tipo) {
    	Tipo = tipo;
    }
    
    public void setTypeName(String typeName) {
    	TypeName = typeName;
    }
    public void setDescription(String Description) {
    	this.Description = Description;
    }
}
