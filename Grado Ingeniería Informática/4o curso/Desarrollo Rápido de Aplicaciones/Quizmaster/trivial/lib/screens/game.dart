import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';
import 'package:trivial/services/data_service.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_popup.dart';
import 'package:trivial/widgets/header.dart';
import 'package:trivial/widgets/question_card.dart';

class Game extends StatefulWidget {
  @override
  State<Game> createState() => _GameState();
}

class _GameState extends State<Game> {
  bool isFirstTime = true;
  List<QuestionData> questions = [];
  int number = 0;
  late ValueChanged<SelectedAnswers> answerChanged;
  List<String?> selectedAnswers = [];

  @override
  void initState() {
    super.initState();

    answerChanged = (value) {
      selectedAnswers[value.indexQuestion] = value.answerSelected;
    };
  }

  @override
  Widget build(BuildContext context) {
    if (isFirstTime) {
      number = ModalRoute.of(context)!.settings.arguments as int;
      selectedAnswers = List<String?>.generate(number, (index) => null);
      isFirstTime = false;
    }

    return Scaffold(
      backgroundColor: ColorsApp.blueBackground,
      appBar: Header(isGamePage: true),
      body: FutureBuilder(
          future: _getQuestions(),
          builder: (context, snapshot) {
            if (snapshot.connectionState == ConnectionState.done) {
              return Column(
                children: [
                  Flexible(
                    child: ListView.builder(
                        shrinkWrap: true,
                        itemCount: questions.length,
                        itemBuilder: (BuildContext context, int index) {
                          return QuestionCard(
                              questions[index], index, answerChanged);
                        }),
                  ),
                  CustomButton(
                      _goResults, "CHECK ANSWERS", ColorsApp.blueButton)
                ],
              );
            } else {
              return Center(
                  child: Lottie.asset("assets/lottie/loading.json",
                      height: 200, width: 200));
            }
          }),
    );
  }

  Future _getQuestions() async {
    questions = await DataService.getQuestionsGame(number);
  }

  void _goResults() {
    CustomPopup popup = CustomPopup(
        "Check answers?",
        "Are you sure that you want to check your answers?",
        context,
        false,
        ColorsApp.blueButton,
        "No, wait",
        rightButtonText: "Yeah!!", action: () {
      Navigator.pop(context);
      Navigator.pushNamed(context, "/results",
          arguments: ResultsParameters(questions, selectedAnswers));
    });
    popup.showPopup();
  }
}
