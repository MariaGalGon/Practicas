import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:trivial/models/question_data.dart';

class DataService {
  static Future<List<QuestionData>> getQuestionsGame(
      int numberQuestions) async {
    List<QuestionData> questions = [];

    //https://opentdb.com/api.php?amount=numberQuestions
    final uri =
        Uri.parse('https://opentdb.com/api.php?amount=$numberQuestions');
    final result = await http.get(uri);
    final json = jsonDecode(result.body);

    if (json['response_code'] == 0) {
      List questionsJson = List<Map<String, dynamic>>.from(json['results']);
      questionsJson.forEach(((element) {
        questions.add(QuestionData.fromJsonAPI(element));
      }));
    }

    return questions;
  }
}
