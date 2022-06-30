import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/widgets/custom_button.dart';

class PageError extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    double height = MediaQuery.of(context).size.height;
    double width = MediaQuery.of(context).size.width;

    return Scaffold(
        backgroundColor: ColorsApp.orangeBackground,
        body: (height > 600 && width >= 1320)
            ? _maxWindow(context)
            : _minWindow(context));
  }

  Widget _maxWindow(BuildContext context) {
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
              Lottie.asset("assets/lottie/lock.json", height: 300, width: 300),
              Padding(
                padding: EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                child: Text(
                  "You can't access this route like that! \n Go to the home page and use the section buttons",
                  style: TextStyle(fontSize: 30, color: Colors.black),
                  textAlign: TextAlign.center,
                ),
              ),
              CustomButton(() => _goBack(context), "GO TO LOGIN OR HOME PAGE",
                  ColorsApp.orangeButton)
            ],
          ),
        ),
      ),
    );
  }

  Widget _minWindow(BuildContext context) {
    return Center(
      child: SingleChildScrollView(
        child: Column(
          children: [
            Padding(
              padding: EdgeInsets.symmetric(vertical: 20, horizontal: 20),
              child: Card(
                elevation: 4,
                shape: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(10),
                    borderSide: BorderSide(color: Colors.white)),
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: [
                    Lottie.asset("assets/lottie/lock.json",
                        height: 300, width: 300),
                    Padding(
                      padding: EdgeInsets.symmetric(vertical: 10, horizontal: 10),
                      child: Text(
                        "You can't access this route like that! \n Go to the home page and use the section buttons",
                        style: TextStyle(fontSize: 30, color: Colors.black),
                        textAlign: TextAlign.center,
                      ),
                    ),
                    CustomButton(() => _goBack(context),
                        "GO TO LOGIN OR HOME PAGE", ColorsApp.orangeButton)
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }

  void _goBack(BuildContext context) {
    Navigator.popUntil(context, (route) => route.isFirst);
  }
}
