package week2.codingbat.java;

public String makeTags(String tag, String word) {
    String tag1= "<"+ tag + ">"; // make sure the things are enclosed with seperate ""
    String tag2 = "<" + "/" + tag + ">";
    return tag1 + word + tag2;
    }
    
}
