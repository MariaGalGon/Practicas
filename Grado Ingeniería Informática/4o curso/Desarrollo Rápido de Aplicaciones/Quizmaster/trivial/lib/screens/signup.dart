import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/main.dart';
import 'package:trivial/models/user_data.dart';
import 'package:trivial/services/bd_operations.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_snackbar.dart';
import 'package:trivial/widgets/custom_textfield.dart';
import 'package:trivial/widgets/password_field.dart';

class Signup extends StatefulWidget {
  @override
  State<Signup> createState() => _SignupState();
}

class _SignupState extends State<Signup> {
  final formKey = GlobalKey<FormState>();
  TextEditingController name = TextEditingController();
  TextEditingController mail = TextEditingController();
  TextEditingController password1 = TextEditingController();
  TextEditingController password2 = TextEditingController();

  @override
  void dispose() {
    name.dispose();
    mail.dispose();
    password1.dispose();
    password2.dispose();
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
                        "SIGN UP",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 25),
                      ),
                    ),
                    Form(
                        key: formKey,
                        child: Column(
                          children: [
                            CustomTextField(name, "Name", 50),
                            CustomTextField(mail, "Email", 50),
                            PasswordField(password1, "Password", true, 50),
                            PasswordField(
                                password2, "Repeat password", true, 50)
                          ],
                        )),
                    Spacer(),
                    CustomButton(_signup, "SIGN UP", ColorsApp.orangeButton),
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
      child: Column(children: [
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
                      "SIGN UP",
                      style:
                          TextStyle(fontWeight: FontWeight.bold, fontSize: 25),
                    ),
                  ),
                  Form(
                      key: formKey,
                      child: Column(
                        children: [
                          CustomTextField(name, "Name", 20),
                          CustomTextField(mail, "Email", 20),
                          PasswordField(password1, "Password", true, 20),
                          PasswordField(password2, "Repeat password", true, 20)
                        ],
                      )),
                  SizedBox(height: 20),
                  CustomButton(_signup, "SIGN UP", ColorsApp.orangeButton),
                  SizedBox(height: 20)
                ],
              ),
            ),
          ),
        )
      ]),
    );
  }

  Future _signup() async {
    bool creationDone = true;
    late UserCredential userAuthentication;

    if (formKey.currentState!.validate()) {
      if (password1.text != password2.text) {
        CustomSnackbar snackbar = CustomSnackbar(
            Icons.warning_outlined, "Passwords aren't the same. Review them");
        ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
      } else {
        showDialog(
            context: context,
            barrierDismissible: false,
            builder: (context) {
              return Center(
                  child: Lottie.asset("assets/lottie/loading.json",
                      height: 200, width: 200));
            });

        try {
          userAuthentication = await FirebaseAuth.instance
              .createUserWithEmailAndPassword(
                  email: mail.text.trim(), password: password1.text.trim());
        } on FirebaseAuthException catch (e) {
          creationDone = false;
        }

        if (creationDone) {
          String id = userAuthentication.user!.uid;
          UserData newUser = UserData(id, name.text.trim(), mail.text.trim());
          BDOperations.createUser(newUser);

          keyNavigator.currentState!.popUntil((route) => route.isFirst);
          Navigator.of(context)
              .pushNamedAndRemoveUntil('/home', (route) => false);

          CustomSnackbar snackbar =
              CustomSnackbar(Icons.done, "The account was created");
          ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
        } else {
          keyNavigator.currentState!.popUntil((route) => route.isFirst);
          CustomSnackbar snackbar = CustomSnackbar(Icons.warning_outlined,
              "The mail isn't valid or is already registered");
          ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
        }
      }
    } else {
      CustomSnackbar snackbar = CustomSnackbar(
          Icons.warning_outlined, "Data is incorrect. Review it");
      ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
    }
  }
}
