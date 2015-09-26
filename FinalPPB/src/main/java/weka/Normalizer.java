package weka;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Normalizer {
    
	private static String PATTERN_HASHTAG = "(?:\\s|\\A)[##]+([A-Za-z0-9-_]+)";
	private static String PATTERN_USERS = "(?:\\s|\\A)[@]+([A-Za-z0-9-_]+)";
        
	public Normalizer() {
		super();
	}

	private String normalizePattern(String strpattern, String text, String replace){
		Pattern pattern = Pattern.compile(strpattern);
		Matcher matcher = pattern.matcher(text);
		String result = "";
		while (matcher.find()) {
			result = matcher.group();
	        result = result.replace("#", "");
	        result = result.replace("@", "");
	        text = text.replace(result,replace);

		}
		return text;
	}
 
	public String normalizeComment(String comment){
		
		String normalizedComment = normalizePattern(PATTERN_HASHTAG, comment, "<HASHTAG>");
		normalizedComment = normalizePattern(PATTERN_USERS, normalizedComment, "<USER>");
		
		return normalizedComment;
			
	}
    
}
