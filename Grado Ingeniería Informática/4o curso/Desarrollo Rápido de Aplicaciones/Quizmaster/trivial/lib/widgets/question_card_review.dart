import 'package:flutter/material.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';

class QuestionCardReview extends StatefulWidget {
  final QuestionData _question;
  final ValueChanged<SavedValue> _savedStateChanged;
  final int _questionIndex;

  QuestionCardReview(
    this._question,
    this._questionIndex,
    this._savedStateChanged,
  );

  @override
  State<QuestionCardReview> createState() => _QuestionCardReviewState();
}

class _QuestionCardReviewState extends State<QuestionCardReview> {
  bool save = true;

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
                trailing: IconButton(
                    onPressed: _changeSave,
                    icon: Icon(
                        save
                            ? Icons.bookmark_outlined
                            : Icons.bookmark_border_outlined,
                        color: Colors.red)),
              ),
            ),
            Padding(
              padding: EdgeInsets.only(left: 110),
              child: ListTile(title: Text(widget._question.correctAnswer)),
            )
          ],
        ));
  }

  void _changeSave() {
    setState(() {
      save = !save;
      widget._savedStateChanged(SavedValue(widget._questionIndex, save));
    });
  }
}
