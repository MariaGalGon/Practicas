import 'dart:async';
import 'package:flutter/material.dart';
import 'package:trivial/screens/game.dart';
import 'package:trivial/screens/home.dart';
import 'package:trivial/screens/login.dart';
import 'package:trivial/screens/page_404.dart';
import 'package:trivial/screens/page_error.dart';
import 'package:trivial/screens/profile.dart';
import 'package:trivial/screens/results.dart';
import 'package:trivial/screens/review.dart';
import 'package:trivial/screens/editions.dart';
import 'package:trivial/screens/signup.dart';
import 'package:firebase_core/firebase_core.dart';

Future<void> main() async {
  WidgetsFlutterBinding.ensureInitialized();

  await Firebase.initializeApp();

  runApp(MyApp());
}

final keyNavigator = GlobalKey<NavigatorState>();

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        title: 'Quizmaster',
        debugShowCheckedModeBanner: false,
        theme: ThemeData(
            scaffoldBackgroundColor: Colors.white, fontFamily: "NotoSans"),
        navigatorKey: keyNavigator,
        initialRoute: '/',
        routes: {
          '/': (context) => Login(),
          '/signup': (context) => Signup(),
          '/home': (context) => Home(),
          '/game': (context) => Game(),
          '/results': (context) => Results(),
          '/review': (context) => Review(),
          '/profile': (context) => Profile(),
          '/editions': (context) => Editions()
        },
        onUnknownRoute: (settings) {
          return MaterialPageRoute(builder: (_) => Page404());
        },
        builder: (BuildContext context, Widget? widget) {
          Widget error =
              Scaffold(body: Center(child: Text('An error occurred')));
          if (widget is Scaffold || widget is Navigator) error = PageError();
          ErrorWidget.builder = (FlutterErrorDetails errorDetails) => error;
          return widget!;
        });
  }
}
