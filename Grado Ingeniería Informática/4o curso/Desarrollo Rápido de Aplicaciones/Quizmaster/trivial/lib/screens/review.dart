import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/models/aux_class.dart';
import 'package:trivial/models/question_data.dart';
import 'package:trivial/models/relation_data.dart';
import 'package:trivial/services/bd_operations.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_popup.dart';
import 'package:trivial/widgets/header.dart';
import 'package:trivial/widgets/question_card_review.dart';

class Review extends StatefulWidget {
  @override
  State<Review> createState() => _ReviewState();
}

class _ReviewState extends State<Review> {
  List<QuestionData> questions = [];
  late ValueChanged<SavedValue> savedStateChanged;
  List<bool?> savedStates = [];
  bool firstTime = true;

  @override
  void initState() {
    super.initState();

    savedStateChanged = (value) {
      savedStates[value.indexQuestion] = value.value;
    };
  }

  @override
  Widget build(BuildContext context) {
    if (firstTime) {
      bool parameter = ModalRoute.of(context)!.settings.arguments as bool;
      firstTime = false;
    }

    return Scaffold(
        backgroundColor: ColorsApp.greenBackground,
        appBar: Header(),
        body: FutureBuilder(
            future: _getQuestions(),
            builder: (context, snapshot) {
              if (snapshot.connectionState == ConnectionState.done) {
                return (questions.isEmpty) ? _noDataWidget() : _questionsList();
              } else {
                return Center(
                    child: Lottie.asset("assets/lottie/loading.json",
                        height: 200, width: 200));
              }
            }));
  }

  Future _getQuestions() async {
    questions =
        await BDOperations.getQuestions(FirebaseAuth.instance.currentUser!.uid);

    savedStates = List<bool?>.generate(questions.length, (index) => null);
  }

  Widget _noDataWidget() {
    return Center(
      child: SizedBox(
        height: 550,
        width: MediaQuery.of(context).size.width * 0.4,
        child: Card(
          elevation: 4,
          shape: OutlineInputBorder(
              borderRadius: BorderRadius.circular(10),
              borderSide: BorderSide(color: Colors.white)),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              Lottie.asset("assets/lottie/astronaut.json",
                  height: 350, width: 350),
              Padding(
                padding: EdgeInsets.fromLTRB(10, 0, 10, 10),
                child: Text(
                  "There is a lot of space but no questions",
                  style: TextStyle(fontSize: 25, color: Colors.black),
                  textAlign: TextAlign.center,
                ),
              ),
              CustomButton(
                  () => Navigator.popUntil(context, (route) => route.isFirst),
                  "RETURN HOME",
                  ColorsApp.greenButton)
            ],
          ),
        ),
      ),
    );
  }

  Widget _questionsList() {
    return Column(
      children: [
        Flexible(
          child: ListView.builder(
              shrinkWrap: true,
              itemCount: questions.length,
              itemBuilder: (BuildContext context, int index) {
                return QuestionCardReview(
                    questions[index], index, savedStateChanged);
              }),
        ),
        CustomButton(_goHome, "RETURN HOME", ColorsApp.greenButton)
      ],
    );
  }

  void _goHome() {
    CustomPopup popup = CustomPopup(
        "Save questions",
        "Do you want to return to the home page? All the questions unchecked will be deleted",
        context,
        false,
        ColorsApp.greenButton,
        "No",
        rightButtonText: "Yes",
        action: _deleteQuestions);
    popup.showPopup();
  }

  Future<void> _deleteQuestions() async {
    RelationData? relation;
    String? questionId;

    for (int i = 0; i < questions.length; i++) {
      if (savedStates[i] != null && !(savedStates[i]!)) {
        questionId = await BDOperations.getQuestionId(questions[i].question);
        relation = await BDOperations.getRelation(
            questionId!, FirebaseAuth.instance.currentUser!.uid);
        //Delete relation between question and user
        BDOperations.deleteRelation(relation!);
      }
    }
    Navigator.popUntil(context, (route) => route.isFirst);
  }
}
