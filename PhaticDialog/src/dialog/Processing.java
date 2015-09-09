package dialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;

import eu.hlavki.text.lemmagen.LemmatizerFactory;
import eu.hlavki.text.lemmagen.api.Lemmatizer;

public class Processing {

	Random randomizer = new Random();
	LibraryBase lbase = new LibraryBase();

	// lematize user message, return checked answer
	public String answer(String s1) {
		
		String s = s1.toLowerCase();

		String[] tokens = s.split(" ");

		Lemmatizer lm = null;

		for (int i = 0; i < tokens.length; i++) {
			try {
				lm = LemmatizerFactory.getPrebuilt("mlteast-uk");
			} catch (IOException e) {
				e.printStackTrace();
			}
			tokens[i] = (String) lm.lemmatize(tokens[i]);
			//System.out.println(tokens[i]);
		}

		return check(tokens);
	}

	//check message full and partial matching
	private String check(String[] tokens) {

		String message = "";
		for (int i = 0; i < tokens.length; i++) {
			message += tokens[i] + " ";
		}
		String answer = checkFull(message);
		if (answer == null) {
			answer = checkPartial(tokens);
		}
		if (answer == null) {
			List<String> result = new ArrayList<String>();
			result.add("Я Вас не дуже розумію.");
			result.add("Нічим не можу допомогти.");
			result.add("Висловлюйтесь конкретніше.");
			answer = (String) result.get(randomizer.nextInt(result.size()));
		}
		return answer;
	}

	//full matching
	private String checkFull(String message) {
		String result = null;
		for (Entry<String, String> entry : lbase.base.entrySet()) {
			if ((entry.getKey()).equals(message)) {
				result = entry.getValue();
				break;
			}
		}
		return result;
	}

	//partial matching
	private String checkPartial(String[] tokens) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].length() >= 4) {
				for (Entry<String, String> entry : lbase.base.entrySet()) {
					if ((entry.getKey()).contains(tokens[i]) || tokens[i].contains(entry.getKey())) {
						result.add(entry.getValue());
					}
				}
			}
		}
		return (!result.isEmpty()) ? (String) result.get(randomizer
				.nextInt(result.size())) : null;
	}
}