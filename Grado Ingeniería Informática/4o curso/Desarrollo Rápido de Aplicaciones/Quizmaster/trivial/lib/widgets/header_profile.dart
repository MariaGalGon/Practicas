import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/main.dart';

class HeaderProfile extends StatelessWidget implements PreferredSizeWidget {
  @override
  Widget build(BuildContext context) {
    return AppBar(
        backgroundColor: Colors.transparent,
        elevation: 0,
        leading: GestureDetector(
            onTap: () {
              Navigator.of(context)
                  .pushNamedAndRemoveUntil('/home', (route) => false);
            },
            child: Image.asset("assets/logo/Trivial_S.png")),
        title: Text(
          "QUIZMASTER",
          style: TextStyle(fontWeight: FontWeight.bold, color: Colors.black),
        ),
        actions: [
          Padding(
            padding: EdgeInsets.fromLTRB(0, 15, 20, 0),
            child: CircleAvatar(
              radius: 30,
              backgroundColor: ColorsApp.orangeButton,
              child: IconButton(
                  icon: Icon(Icons.logout_outlined, color: Colors.white),
                  onPressed: () => _logOut(context)),
            ),
          )
        ]);
  }

  @override
  Size get preferredSize => Size.fromHeight(70);

  Future _logOut(BuildContext context) async {
    showDialog(
        context: context,
        barrierDismissible: false,
        builder: (context) {
          return Center(
              child: Lottie.asset("assets/lottie/loading.json",
                  height: 200, width: 200));
        });

    await FirebaseAuth.instance.signOut();

    keyNavigator.currentState!.popUntil((route) => route.isFirst);

    Navigator.of(context).pushNamedAndRemoveUntil('/', (route) => false);
  }
}
