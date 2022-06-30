import 'package:flutter/material.dart';
import 'package:html_unescape/html_unescape.dart';
import 'package:trivial/colors_app.dart';

class QuestionData {
  String _id = "";
  String _question = "";
  String _category = "";
  String _correctAnswer = "";
  List<String> _answers = [];

  QuestionData(String question, String category, String correctAnswer,
      {List<String>? answers, String? id}) {
    this._id = id ?? "";
    this._question = question;
    this._category = category;
    this._correctAnswer = correctAnswer;
    this._answers = answers ?? [];
  }

  String get id => this._id;
  set id(String value) => this._id = value;

  String get question => this._question;
  set question(String value) => this._question = value;

  String get category => this._category;
  set category(String value) => this._category = value;
  
  String get correctAnswer => this._correctAnswer;
  set correctAnswer(String value) => this._correctAnswer = value;
  
  List<String> get answers => this._answers;
  set answers(List<String> value) => this._answers = value;

  factory QuestionData.fromJsonAPI(Map<String, dynamic> json) {
    var unescape = HtmlUnescape();
    final question = unescape.convert(json['question']);
    final category = json['category'];
    final correctAnswer = unescape.convert(json['correct_answer']);

    List<String> answers = [correctAnswer];
    List incorrectAnswersJson = List<String>.from(json['incorrect_answers']);
    incorrectAnswersJson.forEach(((element) {
      answers.add(unescape.convert(element));
    }));

    answers.shuffle();

    return QuestionData(question, category, correctAnswer, answers: answers);
  }

  factory QuestionData.fromJsonFirestore(Map<String, dynamic> json) {
    return QuestionData(json["question"], json["category"], json["answer"], id: json["id"]);
  }

  Map<String, dynamic> toJson() {
    return {
      "id": this._id,
      "question": this._question,
      "category": this._category,
      "answer": this._correctAnswer
    };
  }

  Widget getIcon() {
    String imageRoute;
    Color backgroundColor;

    if (_category.contains("Entertainment")) {
      imageRoute = "assets/categories/categoria3.png";
      backgroundColor = ColorsApp.entertainment;
    } else if (_category.contains("Science") || _category == "Animals") {
      imageRoute = "assets/categories/categoria4.png";
      backgroundColor = ColorsApp.science;
    } else if (_category == "Mythology" ||
        _category == "History" ||
        _category == "Politics") {
      imageRoute = "assets/categories/categoria5.png";
      backgroundColor = ColorsApp.history;
    } else if (_category == "Sports") {
      imageRoute = "assets/categories/categoria2.png";
      backgroundColor = ColorsApp.sports;
    } else if (_category == "Geography") {
      imageRoute = "assets/categories/categoria6.png";
      backgroundColor = ColorsApp.geography;
    } else if (_category == "Art") {
      imageRoute = "assets/categories/categoria7.png";
      backgroundColor = ColorsApp.art;
    } else {
      imageRoute = "assets/categories/categoria1.png";
      backgroundColor = ColorsApp.general;
    }

    return Container(
      height: 110,
      width: 110,
      decoration: BoxDecoration(
        color: backgroundColor,
        shape: BoxShape.circle,
        border: Border.all(color: Colors.grey.shade600),
      ),
      child: ClipOval(
        child: Image.asset(imageRoute, width: 110, height: 110),
      ),
    );
  }
}
