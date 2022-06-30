class EditionsData {
  String _name = "";
  String? _year = "";

  EditionsData(this._name, this._year);

  String get name => this._name;
  set name(String value) => this._name = value;

  String? get year => this._year;
  set year(String? value) => this._year = value;

  factory EditionsData.fromJson(Map<String, dynamic> json) {
    return EditionsData(json['name'], json['year']);
  }
}
