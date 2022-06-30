import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';
import 'package:trivial/models/relation_data.dart';
import 'package:trivial/services/bd_operations.dart';

class QuestionCardResult extends StatefulWidget {
  final QuestionData _question;
  final String? _answerSelected;
  final ValueChanged<SavedValue> _initialStateChanged;
  final ValueChanged<SavedValue> _actualStateChanged;
  final int _questionIndex;

  QuestionCardResult(this._question, this._answerSelected,
      this._initialStateChanged, this._actualStateChanged, this._questionIndex);

  @override
  State<QuestionCardResult> createState() => _QuestionCardResultState();
}

class _QuestionCardResultState extends State<QuestionCardResult> {
  bool save = false;

  @override
  void initState() {
    super.initState();

    isSaved();
  }

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
            _answersList()
          ],
        ));
  }

  Future isSaved() async {
    RelationData? relation;
    String? questionId =
        await BDOperations.getQuestionId(widget._question.question);

    if (questionId == null) {
      save = false;
    } else {
      relation = await BDOperations.getRelation(
          questionId, FirebaseAuth.instance.currentUser!.uid);
      if (relation == null) {
        save = false;
      } else {
        save = true;
      }
    }

    widget._initialStateChanged(
        SavedValue(widget._questionIndex, save, relation: relation));
  }

  void _changeSave() {
    setState(() {
      save = !save;
      widget._actualStateChanged(SavedValue(widget._questionIndex, save));
    });
  }

  Widget _answersList() {
    return Padding(
      padding: EdgeInsets.fromLTRB(20, 10, 0, 10),
      child: Column(
          children: widget._question.answers.map((value) {
        return ListTile(
          leading: _getResultIcon(value),
          title: Row(
            children: [
              Text(value),
              SizedBox(width: 5),
              Text(
                (value == widget._question.correctAnswer &&
                        value == widget._answerSelected)
                    ? "+1"
                    : "",
                style: TextStyle(color: Colors.green),
              )
            ],
          ),
        );
      }).toList()),
    );
  }

  Widget? _getResultIcon(String value) {
    if (value == widget._question.correctAnswer) {
      return Icon(Icons.done_rounded, color: Colors.green);
    } else if (value == widget._answerSelected) {
      return Icon(Icons.clear_rounded, color: Colors.red);
    } else {
      return Icon(Icons.done_rounded, color: Colors.white);
    }
  }
}
