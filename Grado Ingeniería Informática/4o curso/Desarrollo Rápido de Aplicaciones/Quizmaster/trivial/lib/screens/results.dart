import 'dart:async';
import 'package:confetti/confetti.dart';
import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';
import 'package:trivial/services/bd_operations.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_popup.dart';
import 'package:trivial/widgets/header.dart';
import 'package:trivial/widgets/question_card_result.dart';

class Results extends StatefulWidget {
  @override
  State<Results> createState() => _ResultsState();
}

class _ResultsState extends State<Results> {
  late List<QuestionData> questions;
  late List<String?> selectedAnswers;
  bool isFirstTime = true;
  late ValueChanged<SavedValue> initialStateChanged;
  late ValueChanged<SavedValue> actualStateChanged;
  late List<SavedAnswers> savedQuestions;
  int points = 0;
  bool confettiPlaying = true;
  final confettiController = ConfettiController();

  @override
  void initState() {
    super.initState();

    confettiController.play();

    initialStateChanged = (value) {
      savedQuestions[value.indexQuestion].isSavedInitial = value.value;
      savedQuestions[value.indexQuestion].isSavedActual = value.value;
      savedQuestions[value.indexQuestion].relation = value.relation;
    };
    actualStateChanged = (value) {
      savedQuestions[value.indexQuestion].isSavedActual = value.value;
    };
  }

  @override
  void dispose() {
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    if (isFirstTime) {
      ResultsParameters parameters =
          ModalRoute.of(context)!.settings.arguments as ResultsParameters;
      questions = parameters.questions;
      selectedAnswers = parameters.selectedAnswers;
      savedQuestions = List<SavedAnswers>.generate(
          questions.length, (index) => SavedAnswers());

      for (int i = 0; i < questions.length; i++) {
        if (selectedAnswers[i] == questions[i].correctAnswer) {
          points++;
        }
      }

      isFirstTime = false;
    }

    Timer(Duration(seconds: 2), () {
      confettiController.stop();
    });

    return Stack(alignment: Alignment.topCenter, children: [
      Scaffold(
          backgroundColor: ColorsApp.blueBackground,
          appBar: Header(),
          body: Column(
            children: [
              Flexible(
                child: ListView.builder(
                    shrinkWrap: true,
                    itemCount: questions.length,
                    itemBuilder: (BuildContext context, int index) {
                      return QuestionCardResult(
                          questions[index],
                          selectedAnswers[index],
                          initialStateChanged,
                          actualStateChanged,
                          index);
                    }),
              ),
              Padding(
                padding: EdgeInsets.symmetric(vertical: 15),
                child: Text("POINTS: $points/${questions.length}",
                    style: TextStyle(
                        fontSize: 20,
                        fontWeight: FontWeight.bold,
                        color: Colors.white)),
              ),
              CustomButton(_goHome, "RETURN HOME", ColorsApp.blueButton)
            ],
          )),
      ConfettiWidget(
        confettiController: confettiController,
        shouldLoop: true,
        blastDirectionality: BlastDirectionality.explosive,
        emissionFrequency: 0.2,
        gravity: 1,
        colors: const [
          Colors.blue,
          Colors.yellow,
          Colors.green,
          Colors.orange,
          Colors.purple,
          Colors.pink
        ],
      )
    ]);
  }

  void _goHome() {
    CustomPopup popup = CustomPopup(
        "Save questions",
        "Do you want to return to the home page? All the questions marked will be saved",
        context,
        false,
        ColorsApp.blueButton,
        "No",
        rightButtonText: "Yes",
        action: _saveQuestions);
    popup.showPopup();
  }

  void _saveQuestions() {
    for (int i = 0; i < questions.length; i++) {
      if (savedQuestions[i].isSavedInitial != savedQuestions[i].isSavedActual) {
        if (savedQuestions[i].isSavedInitial!) {
          //Delete relation between question and user
          BDOperations.deleteRelation(savedQuestions[i].relation!);
        } else {
          //Create relation between question and user
          BDOperations.saveQuestion(
              questions[i], FirebaseAuth.instance.currentUser!.uid);
        }
      }
    }
    Navigator.popUntil(context, (route) => route.isFirst);
  }
}
