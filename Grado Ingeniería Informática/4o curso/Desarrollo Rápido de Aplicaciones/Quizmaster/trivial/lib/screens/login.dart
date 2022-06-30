import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/main.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_snackbar.dart';
import 'package:trivial/widgets/custom_textfield.dart';
import 'package:trivial/widgets/password_field.dart';

class Login extends StatefulWidget {
  @override
  State<Login> createState() => _LoginState();
}

class _LoginState extends State<Login> {
  final formKey = GlobalKey<FormState>();
  TextEditingController mail = TextEditingController();
  TextEditingController password = TextEditingController();

  @override
  void dispose() {
    mail.dispose();
    password.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    double height = MediaQuery.of(context).size.height;
    double width = MediaQuery.of(context).size.width;

    return Scaffold(
        backgroundColor: ColorsApp.orangeBackground,
        body: (height > 550 && width >= 1320) ? _maxWindow() : _minWindow());
  }

  Widget _maxWindow() {
    return Center(
      child: SizedBox(
        height: 500,
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Column(
              mainAxisAlignment: MainAxisAlignment.center,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: [
                Image.asset("assets/logo/Trivial_L.png",
                    height: MediaQuery.of(context).size.width * 400 / 1920),
                Text(
                  "QUIZMASTER",
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30),
                )
              ],
            ),
            SizedBox(
              width: MediaQuery.of(context).size.width * 0.3,
              child: Card(
                elevation: 4,
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                    borderSide: BorderSide(color: Colors.white)),
                child: Column(
                  children: [
                    Padding(
                      padding: EdgeInsets.symmetric(vertical: 20),
                      child: Text(
                        "LOG IN",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 25),
                      ),
                    ),
                    Form(
                        key: formKey,
                        child: Column(
                          children: [
                            CustomTextField(mail, "Email", 50),
                            PasswordField(password, "Password", true, 50)
                          ],
                        )),
                    Spacer(),
                    CustomButton(_login, "LOG IN", ColorsApp.orangeButton),
                    CustomButton(_signup, "SIGN UP", ColorsApp.yellowButton),
                    Spacer()
                  ],
                ),
              ),
            )
          ],
        ),
      ),
    );
  }

  Widget _minWindow() {
    return SingleChildScrollView(
      child: Column(
        children: [
          Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Image.asset("assets/logo/Trivial_L.png", height: 150),
              Text(
                "QUIZMASTER",
                style: TextStyle(fontWeight: FontWeight.bold, fontSize: 30),
              )
            ],
          ),
          SizedBox(
            width: 400,
            child: Padding(
              padding: EdgeInsets.only(bottom: 10),
              child: Card(
                elevation: 4,
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                    borderSide: BorderSide(color: Colors.white)),
                child: Column(
                  children: [
                    Padding(
                      padding: EdgeInsets.symmetric(vertical: 20),
                      child: Text(
                        "LOG IN",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 25),
                      ),
                    ),
                    Form(
                        key: formKey,
                        child: Column(
                          children: [
                            CustomTextField(mail, "Email", 20),
                            PasswordField(password, "Password", true, 20)
                          ],
                        )),
                    SizedBox(height: 20),
                    CustomButton(_login, "LOG IN", ColorsApp.orangeButton),
                    CustomButton(_signup, "SIGN UP", ColorsApp.yellowButton),
                    SizedBox(height: 20)
                  ],
                ),
              ),
            ),
          )
        ],
      ),
    );
  }

  Future _login() async {
    if (formKey.currentState!.validate()) {
      showDialog(
          context: context,
          barrierDismissible: false,
          builder: (context) {
            return Center(
                child: Lottie.asset("assets/lottie/loading.json",
                    height: 200, width: 200));
          });

      try {
        await FirebaseAuth.instance.signInWithEmailAndPassword(
            email: mail.text.trim(), password: password.text.trim());
        keyNavigator.currentState!.popUntil((route) => route.isFirst);
        Navigator.of(context)
            .pushNamedAndRemoveUntil('/home', (route) => false);
      } on FirebaseAuthException catch (e) {
        keyNavigator.currentState!.popUntil((route) => route.isFirst);
        CustomSnackbar snackbar = CustomSnackbar(Icons.warning_outlined,
            "The mail or password introduced are incorrect");
        ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
      }
    }
  }

  void _signup() {
    mail.clear();
    password.clear();
    Navigator.pushNamed(context, '/signup');
  }
}
