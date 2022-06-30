import 'package:flutter/material.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/widgets/custom_button.dart';

class Page404 extends StatefulWidget {
  @override
  State<Page404> createState() => _Page404State();
}

class _Page404State extends State<Page404> with TickerProviderStateMixin {
  late final AnimationController _controller = AnimationController(
    duration: const Duration(seconds: 2),
    vsync: this,
  )..repeat(reverse: true);
  late final Animation<double> _animation = CurvedAnimation(
    parent: _controller,
    curve: Curves.decelerate,
  );

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        backgroundColor: ColorsApp.orangeBackground,
        body: Center(
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
                    child: Padding(
                      padding:
                          EdgeInsets.symmetric(vertical: 90, horizontal: 20),
                      child: Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        crossAxisAlignment: CrossAxisAlignment.center,
                        children: [
                          FadeTransition(
                              opacity: _animation,
                              child: Image.asset("assets/images/404.png",
                                  width: 400)),
                          Padding(
                            padding: EdgeInsets.symmetric(vertical: 10),
                            child: Text("Page not found!",
                                style: TextStyle(
                                    fontSize: 35, color: Colors.black)),
                          ),
                          CustomButton(() => _goBack(context), "GO BACK",
                              ColorsApp.orangeButton)
                        ],
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ));
  }

  void _goBack(BuildContext context) {
    Navigator.popUntil(context, (route) => route.isFirst);
  }
}
