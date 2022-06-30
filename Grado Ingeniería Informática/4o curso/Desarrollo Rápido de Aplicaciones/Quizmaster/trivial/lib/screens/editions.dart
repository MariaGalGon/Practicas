import 'package:flutter/material.dart';
import 'package:lottie/lottie.dart';
import 'package:trivial/colors_app.dart';
import 'package:trivial/models/editions_data.dart';
import 'package:trivial/services/bd_operations.dart';
import 'package:trivial/widgets/custom_button.dart';
import 'package:trivial/widgets/header.dart';
import 'package:trivial/widgets/edition_tile.dart';

class Editions extends StatelessWidget {
  List<EditionsData> _editions = [];

  @override
  Widget build(BuildContext context) {
    bool parameter = ModalRoute.of(context)!.settings.arguments as bool;

    return Scaffold(
      backgroundColor: ColorsApp.pinkBackground,
      appBar: Header(),
      body: Center(
        child: SingleChildScrollView(
          child: SizedBox(
            width: double.maxFinite,
            child: Column(children: [
              Padding(
                padding: EdgeInsets.symmetric(vertical: 20, horizontal: 20),
                child: SizedBox(
                  width: 500,
                  child: Card(
                    elevation: 4,
                    shape: OutlineInputBorder(
                        borderRadius: BorderRadius.circular(10),
                        borderSide: BorderSide(color: Colors.white)),
                    child: StreamBuilder<List<EditionsData>>(
                        stream: BDOperations.getEditions(),
                        builder: (context, snapshot) {
                          if (snapshot.hasError) {
                            return _showError(context);
                          } else if (snapshot.hasData) {
                            _editions = snapshot.data!;
                            return (_editions.isNotEmpty)
                                ? _showEditions(context)
                                : _showError(context);
                          } else {
                            return Center(
                                child: Lottie.asset(
                                    "assets/lottie/loading.json",
                                    height: 200,
                                    width: 200));
                          }
                        }),
                  ),
                ),
              ),
              CustomButton(
                  () => _goHome(context), "RETURN HOME", ColorsApp.pinkButton)
            ]),
          ),
        ),
      ),
    );
  }

  Widget _showEditions(BuildContext context) {
    return ListView.separated(
        shrinkWrap: true,
        itemCount: _editions.length,
        separatorBuilder: (BuildContext context, int index) {
          return Divider();
        },
        itemBuilder: (BuildContext context, int index) {
          return EditionTile(_editions[index]);
        });
  }

  Widget _showError(BuildContext context) {
    return Text("An error occurred");
  }

  void _goHome(BuildContext context) {
    Navigator.pop(context);
  }
}
