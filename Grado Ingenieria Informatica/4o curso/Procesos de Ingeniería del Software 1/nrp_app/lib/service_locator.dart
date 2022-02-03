import 'package:get_it/get_it.dart';
import 'package:nrp_app/data/moor_database.dart';

GetIt locator = GetIt.instance;

Future setupLocator() async {
  locator.registerSingleton(AppDatabase(openConnection()));
}
