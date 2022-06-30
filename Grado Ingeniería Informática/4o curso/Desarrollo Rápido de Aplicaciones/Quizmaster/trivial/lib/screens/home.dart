import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/widgets/header.dart';
import 'package:trivial/widgets/number_field.dart';
import 'package:trivial/widgets/section_button.dart';

class Home extends StatefulWidget {
  @override
  State<Home> createState() => _HomeState();
}

class _HomeState extends State<Home> {
  final formKey = GlobalKey<FormState>();
  TextEditingController numberQuestions = TextEditingController();

  @override
  void dispose() {
    numberQuestions.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    double height = MediaQuery.of(context).size.height;
    double width = MediaQuery.of(context).size.width;

    return Scaffold(
        appBar: Header(showProfileButton: true),
        body: (height > 550 && width >= 1100) ? _maxWindow() : _minWindow());
  }

  Widget _maxWindow() {
    return Center(
      child: SizedBox(
        height: 225,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SectionButton(
                _startGame, Icons.emoji_events, "Play", ColorsApp.blueButton),
            SectionButton(
                _goReview, Icons.help_center, "Review", ColorsApp.greenButton),
            SectionButton(_goEditions, Icons.menu_book, "Trivial editions",
                ColorsApp.pinkButton),
          ],
        ),
      ),
    );
  }

  Widget _minWindow() {
    return Center(
      child: SingleChildScrollView(
        child: SizedBox(
          width: double.maxFinite,
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              SectionButton(
                  _startGame, Icons.emoji_events, "Play", ColorsApp.blueButton),
              SectionButton(_goReview, Icons.help_center, "Review",
                  ColorsApp.greenButton),
              SectionButton(_goEditions, Icons.menu_book, "Trivial's rules",
                  ColorsApp.pinkButton),
            ],
          ),
        ),
      ),
    );
  }

  void _startGame() {
    showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
              shape: RoundedRectangleBorder(
                  borderRadius: BorderRadius.circular(20)),
              title: Text("Game configuration"),
              content: Form(
                  key: formKey,
                  child: NumberField(numberQuestions, "Number of questions")),
              actions: [
                TextButton(
                    child: Text("Cancel",
                        style: TextStyle(
                            fontSize: 15, color: ColorsApp.orangeButton)),
                    onPressed: () => Navigator.pop(context)),
                TextButton(
                    child: Text("Start",
                        style: TextStyle(
                            fontSize: 15, color: ColorsApp.orangeButton)),
                    onPressed: () {
                      if (formKey.currentState!.validate()) {
                        formKey.currentState!.save();

                        int number = int.parse(numberQuestions.text);

                        Navigator.pop(context);
                        Navigator.pushNamed(context, "/game",
                            arguments: number);
                      }
                    })
              ]);
        });
  }

  void _goReview() {
    Navigator.pushNamed(context, "/review", arguments: true);
  }

  void _goEditions() {
    Navigator.pushNamed(context, "/editions", arguments: true);
  }
}
