package nl.alexvanmanen.iad1.algorithms;

public class LZW2 {

	
	public static void main(String[] args){
		String text = "Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo Hallo";
		new LZW2().compress(text);		
	}

	public void compress(String text) {

		StringBuffer result = new StringBuffer();
		StringBuffer result2 =  new StringBuffer();
		
		CodeTable codeTable = new CodeTable();
		StringBuffer p = new StringBuffer();
		for(Character c: text.toCharArray()){
			if(codeTable.contains(p.toString() + c.toString())){
				p.append(c);
			} else {
				result.append(p+",");
				result2.append(codeTable.findElement(p.toString()) +",");
				codeTable.add(p + c.toString());
				p.delete(0, p.length());
				p.append(c);
			}
		}
		System.out.println(result.toString());
		System.out.println(result2.toString());
	}	
}

class CodeTable{
	
	private String[] codeTable = new String[4096];
	private int codeTableIndex = 256;
	
	public CodeTable() {
		for (int i = 0; i <= 255; i++) {
			codeTable[i] = new Character((char) i).toString();
		}
	}
	
	public void add(String element){
		codeTable[codeTableIndex++] = element;
	}
	
	public boolean contains(String element){
		return findElement(element) != -1;
	}
	
	public int findElement(String element){
		for (int i = 0; i < codeTable.length; i++) {
			if(codeTable[i] == null){
				return -1;
			} else if(codeTable[i].equals(element)){
				return i;
			}
		}
		return -1;
	}
}
