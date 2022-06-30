import 'package:trivial/models/question_data.dart';
import 'package:trivial/models/relation_data.dart';

class SelectedAnswers {
  int indexQuestion;
  String? answerSelected;

  SelectedAnswers(this.indexQuestion, this.answerSelected);
}

class ResultsParameters {
  List<QuestionData> questions;
  List<String?> selectedAnswers;

  ResultsParameters(this.questions, this.selectedAnswers);
}

class SavedAnswers {
  bool? isSavedInitial;
  bool? isSavedActual;
  RelationData? relation;

  SavedAnswers(
      {bool? isSavedInitial, bool? isSavedActual, RelationData? relation}) {
    this.isSavedInitial = isSavedInitial;
    this.isSavedActual = isSavedActual;
    this.relation = relation;
  }
}

class SavedValue {
  int indexQuestion;
  bool value;
  RelationData? relation;

  SavedValue(this.indexQuestion, this.value, {this.relation});
}
