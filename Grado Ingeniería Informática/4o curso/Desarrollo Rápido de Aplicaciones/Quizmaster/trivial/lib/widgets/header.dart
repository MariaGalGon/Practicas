import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';

class Header extends StatelessWidget implements PreferredSizeWidget {
  late bool showProfileButton;
  late bool isGamePage;

  Header({bool showProfileButton = false, bool isGamePage = false}) {
    this.showProfileButton = showProfileButton;
    this.isGamePage = isGamePage;
  }

  @override
  Widget build(BuildContext context) {
    return AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        leading: GestureDetector(
            onTap: () {
              if (isGamePage) {
                _gameBack(context);
              } else {
                _normalBack(context);
              }
            },
            child: Image.asset("assets/logo/Trivial_S.png")),
        title: Text(
          "QUIZMASTER",
          style: TextStyle(fontWeight: FontWeight.bold, color: Colors.black),
        ),
        actions: (showProfileButton)
            ? [
                Padding(
                  padding: EdgeInsets.fromLTRB(0, 15, 20, 0),
                  child: CircleAvatar(
                    radius: 30,
                    backgroundColor: ColorsApp.orangeButton,
                    child: IconButton(
                        icon: Icon(Icons.person, color: Colors.white),
                        onPressed: () => _profile(context)),
                  ),
                )
              ]
            : []);
  }

  @override
  Size get preferredSize => Size.fromHeight(70);

  void _profile(BuildContext context) {
    Navigator.pushNamed(context, '/profile', arguments: true);
  }

  void _normalBack(BuildContext context) {
    // Navigator.pop(context);
    // Navigator.pushNamed(context, "/home");
    Navigator.popUntil(context, (route) => route.isFirst);
  }

  void _gameBack(BuildContext context) async {
    final exit = await showDialog(
        context: context,
        builder: (BuildContext context) {
          return AlertDialog(
            shape:
                RoundedRectangleBorder(borderRadius: BorderRadius.circular(20)),
            title: Text("Leaving the game"),
            content: Text("Do you want to leave the actual game?"),
            actions: [
              TextButton(
                  child: Text("No",
                      style:
                          TextStyle(fontSize: 15, color: ColorsApp.blueButton)),
                  onPressed: () => Navigator.pop(context, false)),
              TextButton(
                  child: Text("Yes",
                      style:
                          TextStyle(fontSize: 15, color: ColorsApp.blueButton)),
                  onPressed: () => Navigator.pop(context, true))
            ],
          );
        });

    if (exit ?? false) {
      _normalBack(context);
    }
  }
}
