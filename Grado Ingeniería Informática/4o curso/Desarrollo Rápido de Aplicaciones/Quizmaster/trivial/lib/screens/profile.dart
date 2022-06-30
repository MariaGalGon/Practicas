import 'package:firebase_auth/firebase_auth.dart';
import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/main.dart';
import 'package:trivial/models/user_data.dart';
import 'package:trivial/services/bd_operations.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/custom_popup.dart';
import 'package:trivial/widgets/custom_snackbar.dart';
import 'package:trivial/widgets/custom_textfield.dart';
import 'package:trivial/widgets/header_profile.dart';
import 'package:trivial/widgets/password_field.dart';

class Profile extends StatefulWidget {
  @override
  State<Profile> createState() => _ProfileState();
}

class _ProfileState extends State<Profile> {
  final formKey = GlobalKey<FormState>();
  TextEditingController name = TextEditingController();
  TextEditingController mail = TextEditingController();
  TextEditingController password1 = TextEditingController();
  TextEditingController password2 = TextEditingController();
  late UserData user;
  bool firstTime = true;

  @override
  void initState() {
    super.initState();
  }

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
    if (firstTime) {
      bool parameter = ModalRoute.of(context)!.settings.arguments as bool;
      _getUserData();
      firstTime = false;
    }

    return Scaffold(
        backgroundColor: ColorsApp.orangeBackground,
        appBar: HeaderProfile(),
        body: Center(
          child: SingleChildScrollView(
            child: SizedBox(
              width: double.maxFinite,
              child: Column(
                children: [
                  Padding(
                    padding: EdgeInsets.symmetric(vertical: 20, horizontal: 20),
                    child: SizedBox(
                      width: 500,
                      child: Card(
                        elevation: 4,
                        shape: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(10),
                            borderSide: BorderSide(color: Colors.white)),
                        child: Column(
                          children: [
                            Padding(
                              padding: EdgeInsets.symmetric(vertical: 40),
                              child: Text(
                                "PROFILE",
                                style: TextStyle(
                                    fontWeight: FontWeight.bold, fontSize: 25),
                              ),
                            ),
                            Form(
                                key: formKey,
                                child: Column(
                                  children: [
                                    CustomTextField(name, "Name", 20),
                                    CustomTextField(mail, "Email", 20),
                                    PasswordField(
                                        password1, "Actual password", true, 20),
                                    PasswordField(
                                        password2, "New password", false, 20)
                                  ],
                                )),
                            SizedBox(height: 20),
                            Row(
                              mainAxisAlignment: MainAxisAlignment.center,
                              children: [
                                CustomButton(
                                    _saveData, "SAVE", ColorsApp.orangeButton),
                                CustomButton(_deleteAccount, "DELETE ACCOUNT",
                                    Colors.red),
                              ],
                            ),
                            SizedBox(height: 40)
                          ],
                        ),
                      ),
                    ),
                  ),
                ],
              ),
            ),
          ),
        ));
  }

  void _getUserData() async {
    user = await BDOperations.getUser(FirebaseAuth.instance.currentUser!.uid)
        as UserData;

    setState(() {
      name.text = user.name;
      mail.text = user.mail;
    });
  }

  Future _saveData() async {
    if (formKey.currentState!.validate()) {
      showDialog(
          context: context,
          barrierDismissible: false,
          builder: (context) {
            return Center(
                child: Lottie.asset("assets/lottie/loading.json",
                    height: 200, width: 200));
          });

      UserData newUser = UserData(user.id, name.text.trim(), mail.text.trim(),
          password: password2.text.trim());

      bool saveDone = await BDOperations.updateUser(newUser, password1.text);

      keyNavigator.currentState!.pop(context);

      if (saveDone) {
        user = newUser;
        password1.clear();
        password2.clear();

        CustomSnackbar snackbar =
            CustomSnackbar(Icons.done, "The account was updated");
        ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
      } else {
        CustomSnackbar snackbar = CustomSnackbar(Icons.warning_outlined,
            "An error occurred. Check that the actual password is correct");
        ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
      }
    } else {
      CustomSnackbar snackbar = CustomSnackbar(Icons.warning_outlined,
          "Some data is missing. Check the text fields");
      ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
    }
  }

  void _deleteAccount() {
    CustomPopup popup = CustomPopup(
        "Do you want to delete your account?",
        "Once you delete it you won't be able to access your data",
        context,
        false,
        ColorsApp.orangeButton,
        "Cancel",
        rightButtonText: "Delete", action: () async {
      if (formKey.currentState!.validate()) {
        showDialog(
            context: context,
            barrierDismissible: false,
            builder: (context) {
              return Center(
                  child: Lottie.asset("assets/lottie/loading.json",
                      height: 200, width: 200));
            });

        bool deleteDone = await BDOperations.deleteUser(password1.text.trim());

        keyNavigator.currentState!.popUntil((route) => route.isFirst);

        if (deleteDone) {
          Navigator.of(context)
              .pushNamedAndRemoveUntil('/', (route) => false);
          CustomSnackbar snackbar =
              CustomSnackbar(Icons.done, "The account was deleted");
          ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
        } else {
          CustomSnackbar snackbar = CustomSnackbar(
              Icons.warning_outlined, "An error occurred while deleting");
          ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
        }
      } else {
        Navigator.pop(context);
        CustomSnackbar snackbar = CustomSnackbar(
            Icons.warning_outlined, "Insert your actual password");
        ScaffoldMessenger.of(context).showSnackBar(snackbar.getSnackbar());
      }
    });
    popup.showPopup();
  }
}
