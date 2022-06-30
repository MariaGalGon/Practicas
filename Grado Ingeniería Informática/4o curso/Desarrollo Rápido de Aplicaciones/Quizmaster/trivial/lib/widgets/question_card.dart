import 'package:flutter/material.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';

class QuestionCard extends StatefulWidget {
  final QuestionData _question;
  final int _questionIndex;
  final ValueChanged<SelectedAnswers> _answerChanged;

  QuestionCard(this._question, this._questionIndex, this._answerChanged);

  @override
  State<QuestionCard> createState() => _QuestionCardState();
}

class _QuestionCardState extends State<QuestionCard> {
  String? selectedValue;

  @override
  Widget build(BuildContext context) {
    return Card(
        elevation: 5,
        shape: OutlineInputBorder(
            borderRadius: BorderRadius.circular(10),
            borderSide: BorderSide(color: Colors.white)),
        margin: EdgeInsets.symmetric(vertical: 10, horizontal: 50),
        child: Column(
          children: [
            Padding(
              padding: EdgeInsets.only(top: 20),
              child: ListTile(
                leading: widget._question.getIcon(),
                title: Text(widget._question.question,
                    style: TextStyle(fontWeight: FontWeight.bold)),
              ),
            ),
            radioList()
          ],
        ));
  }

  Widget radioList() {
    return Padding(
      padding: EdgeInsets.fromLTRB(20, 10, 0, 10),
      child: Column(
          children: widget._question.answers.map((value) {
        return RadioListTile<String>(
            value: value,
            groupValue: selectedValue,
            toggleable: true,
            title: Text(value),
            onChanged: (valueChanged) => setState(() {
                  selectedValue = valueChanged;
                  widget._answerChanged(
                      SelectedAnswers(widget._questionIndex, valueChanged));
                }));
      }).toList()),
    );
  }
}
